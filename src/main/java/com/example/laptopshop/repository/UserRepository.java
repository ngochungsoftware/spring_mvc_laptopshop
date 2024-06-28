package com.example.laptopshop.repository;

import com.example.laptopshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User save(User user);

    List<User> findAllByEmail(String email);

    User findById(long id);

    boolean existsByEmail(String email);

    User findByEmail(String email);

}
