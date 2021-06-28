package com.educandoweb.projetospringjpahibernate.repositories;

import com.educandoweb.projetospringjpahibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
