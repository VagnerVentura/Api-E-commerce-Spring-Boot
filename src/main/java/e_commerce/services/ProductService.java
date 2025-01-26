package e_commerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import e_commerce.dto.ProductDto;
import e_commerce.entities.Category;
import e_commerce.entities.Product;
import e_commerce.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryService categoryService;
	
	@PostMapping
	public Product createProduct(ProductDto productDto) {
 		Category entity = categoryService.findCategoryById(productDto.categoryId());

		Product product = new Product(
				null, 
				productDto.name(),
				productDto.description(), 
				productDto.price(),
				productDto.stock(), 
				productDto.imageUrl(),
				entity);
		
		return productRepository.save(product);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findProductById(Long productId) {
		
		var product = productRepository.findById(productId)
				.orElseThrow(()-> new RuntimeException("Product Not Found!"));		
		
		return product;
	}
	
}
