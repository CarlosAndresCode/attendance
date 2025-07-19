package com.ancode.attendance.auth.repository;

import com.ancode.attendance.auth.emun.Role;
import com.ancode.attendance.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByRole(Role role);

    Optional<User> findByEmail(String email);
}
