package com.erichgamma.api.user;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
