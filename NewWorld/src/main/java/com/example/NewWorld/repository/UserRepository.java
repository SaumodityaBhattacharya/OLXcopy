package com.example.NewWorld.repository;

import com.example.NewWorld.entity.Role;
import com.example.NewWorld.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserEmail(String userEmail);
    Optional<User> findByUserPhoneNumber(String userPhoneNumber);
}
