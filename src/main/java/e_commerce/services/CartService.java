package e_commerce.services;

import org.springframework.stereotype.Service;

import e_commerce.dto.AddToCart;
import e_commerce.entities.Cart;
import e_commerce.entities.CartItem;
import e_commerce.entities.Product;
import e_commerce.entities.User;
import e_commerce.repositories.CartItemRepository;
import e_commerce.repositories.CartRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CartService {

	
	private UserService userService;
	private ProductService productService;
	private CartItemRepository cartItemRepository;
	private CartRepository cartRepository;
	
	public Cart addToCart(AddToCart dto) {
		Cart cart = FindCartByUserIdOrCreateCart(dto.userId());
		
		Product product = productService.findProductById(dto.productId());
		
		CartItem items = cart
				.getCartItems()
				.stream()
				.filter(cartItem -> cartItem.getProduct().getId().equals(dto.productId()))
						.findFirst()
						.orElseGet(() ->{
							CartItem newItem = new CartItem();
							newItem.setProduct(product);
							newItem.setCart(cart);
							newItem.setQuantity(0);						
							newItem.setPrice(product.getPrice());	
							cart.getCartItems().add(newItem);
							return newItem;
						});
		
	items.setQuantity(items.getQuantity() + dto.quantity());	
	cartItemRepository.save(items);
	cartRepository.save(cart);
		return cart;
	}

	public Cart FindCartByUserIdOrCreateCart(Long userId) {
		User user = userService.findById(userId);
		
		Cart cart = cartRepository.findByUser_id(userId)
				.orElseGet(()-> {
					Cart newCart = new Cart();
					newCart.setUser(user);
					return newCart;
				});
		return cart;
	}

	public void deleteCart(Cart cart) {
		cartRepository.delete(cart);		
	}

}
