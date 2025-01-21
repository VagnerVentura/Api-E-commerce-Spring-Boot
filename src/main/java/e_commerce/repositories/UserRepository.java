package e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
