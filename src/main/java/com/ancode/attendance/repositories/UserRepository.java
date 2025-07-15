package com.ancode.attendance.repositories;

import com.ancode.attendance.emun.Role;
import com.ancode.attendance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(Role role);
}
