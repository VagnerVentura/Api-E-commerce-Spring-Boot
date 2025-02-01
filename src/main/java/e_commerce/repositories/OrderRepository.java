package e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
