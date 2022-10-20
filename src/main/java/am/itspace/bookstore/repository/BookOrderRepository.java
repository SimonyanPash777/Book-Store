package am.itspace.bookstore.repository;

import am.itspace.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<Order, Integer> {
}
