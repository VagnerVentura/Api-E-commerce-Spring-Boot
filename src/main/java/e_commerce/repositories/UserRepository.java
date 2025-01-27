package e_commerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.entities.Cart;
import e_commerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<Cart> findCartByUser_Id(Long userId);


}
