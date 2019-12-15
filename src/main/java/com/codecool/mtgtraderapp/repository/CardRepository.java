package com.codecool.mtgtraderapp.repository;

import com.codecool.mtgtraderapp.entity.Card;
import com.codecool.mtgtraderapp.entity.Condition;
import com.codecool.mtgtraderapp.entity.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("select c from Card c where lower(c.name) like lower(concat('%', :name, '%'))")
    List<Card> getCardsByName(@Param("name") String name);

    @Query("select c from Card c where c.expansion = :expansion")
    List<Card> getCardsByExpansion(@Param("expansion") Expansion expansion);

    @Query("select c from Card c where c.condition = :condition")
    List<Card> getCardsByCondition(@Param("condition") Condition condition);

    @Query("select c from Card c where c.id = :cardId")
    Card getCardById(@Param("cardId") Long cardId);

}
