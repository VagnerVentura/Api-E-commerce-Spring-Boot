package e_commerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import e_commerce.dto.OrderDto;
import e_commerce.dto.PlaceOrderDto;
import e_commerce.entities.Order;
import e_commerce.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RequestMapping
@AllArgsConstructor
@NoArgsConstructor
public class OrderController {

	private OrderService orderService;
		
	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody PlaceOrderDto dto) {
		return ResponseEntity.ok(orderService.placeOrder(dto));
	}
	
}
