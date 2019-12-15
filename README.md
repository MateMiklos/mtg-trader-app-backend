# mtg-trader-app-backend

This is the backend project for MtgTrader application.<br>
Mtg (Magic the Gathering) is the most popular trading card game in the world.<br>
This application will be a site where Mtg players can upload their cards with a price, and they can sell them.<br>

In this state of the project,<br>
  -it can send data from all cards in JSON format to: http://localhost:8080/cards/<br>
  -it can send data from cards, that filtered by name to: http://localhost:8080/cards/{name}<br>
  -if a user is logged in, it can save a card to his/her ordered cards: http://localhost:8080/cards/save/{userId}/{cardId}<br>
  -and it can list the ordered cards for the logged in user: http://localhost:8080/cards/orders/{userId}<br>
  
# technologies

This project has been written in Java8 using Spring technologies.<br>
-springboot-devtools<br>
-springboot-security<br>
-lombok<br>
-h2<br>
-jpa<br>

# config

Run pom.xml to setup configurations.
