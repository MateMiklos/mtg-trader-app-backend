package com.codecool.mtgtraderapp;

import com.codecool.mtgtraderapp.entity.*;
import com.codecool.mtgtraderapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
public class MtgTraderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MtgTraderApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {

            Location metaGame = Location.builder()
                    .name("Meta Game")
                    .address("Kádár utca 10.")
                    .city(City.BUDAPEST)
                    .build();

            Card card1 = Card.builder()
                    .name("Chandra, Awakened Inferno")
                    .price(4500L)
                    .condition(Condition.NEAR_MINT)
                    .location(Arrays.asList(metaGame))
                    .status(Status.ACTIVE)
                    .build();

            Card card2 = Card.builder()
                    .name("Doubling Season")
                    .price(15000L)
                    .condition(Condition.NEAR_MINT)
                    .status(Status.ACTIVE)
                    .build();

            Card card3 = Card.builder()
                    .name("Umezawa's Jitte")
                    .price(5000L)
                    .condition(Condition.NEAR_MINT)
                    .status(Status.ACTIVE)
                    .build();

            Card card4 = Card.builder()
                    .name("Doubling Season")
                    .price(12000L)
                    .condition(Condition.LIGHTLY_PLAYED)
                    .status(Status.ACTIVE)
                    .build();

            Card card5 = Card.builder()
                    .name("Umezawa's Jitte")
                    .price(4000L)
                    .condition(Condition.LIGHTLY_PLAYED)
                    .status(Status.ACTIVE)
                    .build();

            User mm = User.builder()
                    .name("Miklós Máté")
                    .email("miklos.mate.91@gmail.com")
                    .cards(Arrays.asList(card1, card2, card3, card4, card5))
                    .build();

            metaGame.setCard(card1);
            card1.setUser(mm);
            card2.setUser(mm);
            card3.setUser(mm);
            card4.setUser(mm);
            card5.setUser(mm);

            userRepository.save(mm);

        };
    }
}
