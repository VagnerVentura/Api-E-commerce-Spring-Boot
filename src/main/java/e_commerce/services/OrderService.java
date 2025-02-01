package e_commerce.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import e_commerce.dto.PlaceOrderDto;
import e_commerce.entities.Cart;
import e_commerce.entities.Order;
import e_commerce.entities.OrderItem;
import e_commerce.entities.Product;
import e_commerce.repositories.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private CartService cartService;
	
	public Order placeOrder (PlaceOrderDto dto) {
		Cart cart = cartService.FindCartByUserIdOrCreateCart(dto.userId());
		
		Order order = new Order();
		order.setUser(cart.getUser());
		order.setOrderDate(LocalDateTime.now());
		
		List<OrderItem> items = cart
				.getCartItems()
				.stream()
				.map(item-> {
					Product product = item.getProduct();
					product.setStock(item.getProduct().getStock()- item.getQuantity());
					
					return new OrderItem(null,
							item.getProduct(),
							order,
							item.getQuantity(),
							item.getPrice());
					
				}).collect(Collectors.toList());
		
		order.setOrderItems(items);
		
		order.setTotalAmount(
				items.stream()
				.map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add));
		
		orderRepository.save(order);
		cartService.deleteCart(cart);
		return order;
	}
	
}
