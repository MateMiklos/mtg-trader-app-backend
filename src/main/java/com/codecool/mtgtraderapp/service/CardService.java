package com.codecool.mtgtraderapp.service;

import com.codecool.mtgtraderapp.entity.Card;
import com.codecool.mtgtraderapp.entity.User;
import com.codecool.mtgtraderapp.repository.CardRepository;
import com.codecool.mtgtraderapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    public void saveOrderedCardsToUser(Long userId, Long cardId) {
        User user = userRepository.getUserById(userId);
        Card card = cardRepository.getCardById(cardId);

        user.getOrderedCards().add(card);
        card.setCustomerUser(user);

        userRepository.save(user);
    }

    public List<Card> getOrderedCardsByUserId(Long userId) {
        User user = userRepository.getUserById(userId);
        List<Card> orderedCards = user.getOrderedCards();
        return orderedCards;
    }

}
