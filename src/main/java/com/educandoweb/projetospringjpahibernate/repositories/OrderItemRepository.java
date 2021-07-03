package com.educandoweb.projetospringjpahibernate.repositories;

import com.educandoweb.projetospringjpahibernate.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
