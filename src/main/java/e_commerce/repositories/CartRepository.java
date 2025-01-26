package e_commerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByUserId(Long userId);

}
