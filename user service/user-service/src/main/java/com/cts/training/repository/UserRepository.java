package com.cts.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.bean.User;

public interface UserRepository extends JpaRepository<User ,Long>{
List<User>findByusername(String username);
}
