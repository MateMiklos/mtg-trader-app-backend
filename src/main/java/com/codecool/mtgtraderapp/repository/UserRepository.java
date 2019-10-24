package com.codecool.mtgtraderapp.repository;

import com.codecool.mtgtraderapp.entity.Card;
import com.codecool.mtgtraderapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select distinct u.orderedCards from User u where(c.userId) = :userId")
//    List<Card> getCardsByUserId(@Param("userId") Long userId);

    @Query("select u from User u where u.id = :userId")
    User getUserById(@Param("userId") Long userId);
}
