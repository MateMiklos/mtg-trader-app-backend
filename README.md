# mtg-trader-app-backend

This is the backend project for MtgTrader application.
Mtg (Magic the Gathering) is the most popular trading card game in the world.
This application will be a site where Mtg players can upload their cards with a price, and they can sell them.

In this state of the project,
  -it can send data from all cards in JSON format to: http://localhost:8080/cards/
  -it can send data from cards, that filtered by name to: http://localhost:8080/cards/{name}
  -if a user is logged in, it can save a card to his/her ordered cards: http://localhost:8080/cards/save/{userId}/{cardId}
  -and it can list the ordered cards for the logged in user: http://localhost:8080/cards/orders/{userId}
  
# technologies

This project has been written in Java8 using Spring technologies.
-springboot-devtools
-springboot-security
-lombok
-h2
-jpa

# config

Run pom.xml to setup configurations.
