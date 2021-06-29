package com.educandoweb.projetospringjpahibernate.repositories;

import com.educandoweb.projetospringjpahibernate.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
