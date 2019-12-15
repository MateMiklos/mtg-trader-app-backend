package com.codecool.mtgtraderapp.service;

import com.codecool.mtgtraderapp.entity.Card;
import com.codecool.mtgtraderapp.entity.AppUser;
import com.codecool.mtgtraderapp.repository.CardRepository;
import com.codecool.mtgtraderapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    public void saveOrderedCardsToUser(Long userId, Long cardId) {
        AppUser user = userRepository.getUserById(userId);
        Card card = cardRepository.getCardById(cardId);

        user.getOrderedCards().add(card);
        card.setCustomerUsers(Arrays.asList(user));

        userRepository.save(user);
    }

    public List<Card> getOrderedCardsByUserId(Long userId) {
        AppUser user = userRepository.getUserById(userId);
        List<Card> orderedCards = user.getOrderedCards();
        return orderedCards;
    }

}
