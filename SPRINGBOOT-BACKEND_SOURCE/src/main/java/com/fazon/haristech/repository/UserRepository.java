package com.fazon.haristech.repository;

import org.springframework.data.jpa.repository.*;

import com.fazon.haristech.Entity.*;

import java.util.*;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    Optional<UserEntity> findByEmail(String email);
}
