package com.bank.userservice.Repository;

import com.bank.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    // Implementation are not needed becoz automatically provides ..
}
