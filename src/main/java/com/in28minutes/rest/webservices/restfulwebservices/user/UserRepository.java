package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
