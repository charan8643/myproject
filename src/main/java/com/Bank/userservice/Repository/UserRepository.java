package com.Bank.userservice.Repository;

import com.Bank.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
