package com.guvi.empmanage.repository;

import com.guvi.empmanage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //
    User findByEmail(String email);
}
