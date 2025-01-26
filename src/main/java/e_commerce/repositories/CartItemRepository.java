package e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
