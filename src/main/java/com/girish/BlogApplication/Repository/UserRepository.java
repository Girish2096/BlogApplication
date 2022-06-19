package com.girish.BlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girish.BlogApplication.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
