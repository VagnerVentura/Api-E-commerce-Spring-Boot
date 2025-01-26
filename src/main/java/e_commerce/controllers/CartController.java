package e_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.dto.AddToCart;
import e_commerce.entities.Cart;
import e_commerce.services.CartService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping
	public ResponseEntity<Cart> addToCart (@RequestBody AddToCart dto){
		return ResponseEntity.ok(cartService.addToCart(dto));
	}
}
