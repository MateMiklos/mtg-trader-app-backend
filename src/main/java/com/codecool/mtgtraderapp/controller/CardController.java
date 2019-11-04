package com.codecool.mtgtraderapp.controller;

import com.codecool.mtgtraderapp.entity.Card;
import com.codecool.mtgtraderapp.repository.CardRepository;
import com.codecool.mtgtraderapp.repository.UserRepository;
import com.codecool.mtgtraderapp.service.CardService;
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
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Card> getCardsByName(@PathVariable("name") String name) {
        List<Card> cardsByName = cardRepository.getCardsByName(name);
        return cardsByName;
    }

//    GET CARDS BY ANY TYPE OF SEARCH INPUT
//
//    @GetMapping("/search/{search}")
//    public List<Card> getCardsBySearch(@PathVariable("search") String search) {
//        List<Card> cardsBySearch = cardRepository.getCardsBySearch(search);
//        return cardsBySearch;
//    }

    @GetMapping("/orders/{userId}")
    public List<Card> getOrderedCards(@PathVariable("userId") Long userId) {
        return cardService.getOrderedCardsByUserId(userId);
    }

    @PostMapping("/save/{userId}/{cardId}")
    public void saveOrderedCardToUser(@PathVariable("userId") Long userId, @PathVariable("cardId") Long cardId) {
        cardService.saveOrderedCardsToUser(userId, cardId);
    }
}
