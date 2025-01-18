package e_commerce.dto;

import java.math.BigDecimal;

public record ProductDto(
		String name,
		String description,
		BigDecimal price,
		Integer stock,
		String imageUrl,
		Long categoryId		
		) {

}
