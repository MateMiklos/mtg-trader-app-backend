package com.codecool.mtgtraderapp.controller;

import com.codecool.mtgtraderapp.entity.Card;
import com.codecool.mtgtraderapp.repository.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/")
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Card> getCardsByName(@PathVariable("name") String name) {
        List<Card> cardsByName = cardRepository.getCardsByName(name);
        return cardsByName;
    }
}
