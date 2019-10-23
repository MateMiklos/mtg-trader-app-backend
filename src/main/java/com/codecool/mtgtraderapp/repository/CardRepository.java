package com.codecool.mtgtraderapp.repository;

import com.codecool.mtgtraderapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("select c from Card c where c.name like %:name%")
    List<Card> getCardsByName(@Param("name") String name);

    List<Card> findAllByNameEquals(String name);

}
