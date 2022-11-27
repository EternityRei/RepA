package com.example.repa.repository;

import com.example.repa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdIs(long id);
    User findByEmail(String email);

    List<User> findAll();
}
