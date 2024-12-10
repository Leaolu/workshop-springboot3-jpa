package com.EACH.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EACH.demo.entities.User;

//annotation @Repository isn't mandatory
public interface UserRepository extends JpaRepository<User, Long>{

}
