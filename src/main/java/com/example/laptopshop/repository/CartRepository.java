package com.example.laptopshop.repository;

import com.example.laptopshop.domain.Cart;
import com.example.laptopshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
