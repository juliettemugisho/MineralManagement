package com.julliet.mineralproductmngt_sys.repository;

import com.julliet.mineralproductmngt_sys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
