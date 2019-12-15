package com.codecool.mtgtraderapp.repository;

import com.codecool.mtgtraderapp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("select u from AppUser u where u.id = :userId")
    AppUser getUserById(@Param("userId") Long userId);

    @Query("select u from AppUser u where u.name = :userName")
    AppUser getUserByName(@Param("userName") String userName);

    Optional<AppUser> findByName(String userName);
}
