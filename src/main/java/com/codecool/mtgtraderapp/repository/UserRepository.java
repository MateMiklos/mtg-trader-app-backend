package com.codecool.mtgtraderapp.repository;

import com.codecool.mtgtraderapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
