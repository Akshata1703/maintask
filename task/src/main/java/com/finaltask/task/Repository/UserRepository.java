package com.finaltask.task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finaltask.task.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
