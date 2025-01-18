package e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}
