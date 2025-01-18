package e_commerce.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.dto.ProductDto;
import e_commerce.entities.Product;
import e_commerce.services.ProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	
	private  ProductService productService;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
		return ResponseEntity.ok(productService.createProduct(productDto));
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> listProducts(){
		return ResponseEntity.ok(productService.findAll());
	}
	
	
}
