package com.example.gamestate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class GameState {
    private int playerTurn; //which players turn it is
    private int cardPlayed; //card number player chooses to play for round
    private int playerScore;    //players total score
    private int gameStage;  //which state of the game the player is in
    private int trumpCard;  //value of trump card
    private int roundNum;
    private int numberPlayers = 3;
    private Hashtable<String, Integer>  bidNum = new Hashtable<String, Integer>();
    private Hashtable<String, Integer> deck = new Hashtable<String, Integer>();   //all the cards in the deck
    private List<Hashtable<String, Integer>> playerArray = new ArrayList<Hashtable<String, Integer>>();
    private ArrayList<String> cardsPlayed = new ArrayList<>();


    public int getPlayerTurn() {
        return playerTurn;
    }

    public int getCardPlayed() {
        return cardPlayed;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getGameStage() {
        return gameStage;
    }

    public int getTrumpCard() {
        return trumpCard;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setCardPlayed(int cardPlayed) {
        this.cardPlayed = cardPlayed;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setGameStage(int gameStage) {
        this.gameStage = gameStage;
    }

    public void setTrumpCard(int trumpCard) {
        this.trumpCard = trumpCard;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    public GameState(){
        this.playerTurn = 0; //player 0 will go first
        this.cardPlayed = -1;    //player has no played card yet
        this.playerScore = 0;
        this.gameStage = 0;      //starts at game state 0: bidding phase
        this.trumpCard = -1;     //trump card is not decided yet?
        this.roundNum = 1;
        deck.put("heart zero", 0);    //joker
        deck.put("heart two", 2);
        deck.put("heart three", 3);
        deck.put("heart four", 4);
        deck.put("heart five", 5);
        deck.put("heart six", 6);
        deck.put("heart seven", 7);
        deck.put("heart eight", 8);
        deck.put("heart nine", 9);
        deck.put("heart ten", 10);
        deck.put("heart eleven", 11); //jack
        deck.put("heart twelve", 12); //queen
        deck.put("heart thirteen", 13);   //king
        deck.put("heart fourteen", 14);   //ace
        deck.put("heart fifteen", 15);  //wizard
        deck.put("spade zero", 0);    //joker
        deck.put("spade two", 2);
        deck.put("spade three", 3);
        deck.put("spade four", 4);
        deck.put("spade five", 5);
        deck.put("spade six", 6);
        deck.put("spade seven", 7);
        deck.put("spade eight", 8);
        deck.put("spade nine", 9);
        deck.put("spade ten", 10);
        deck.put("spade eleven", 11); //jack
        deck.put("spade twelve", 12); //queen
        deck.put("spade thirteen", 13);   //king
        deck.put("spade fourteen", 14);   //ace
        deck.put("spade fifteen", 15);  //wizard
        deck.put("diamond zero", 0);    //joker
        deck.put("diamond two", 2);
        deck.put("diamond three", 3);
        deck.put("diamond four", 4);
        deck.put("diamond five", 5);
        deck.put("diamond six", 6);
        deck.put("diamond seven", 7);
        deck.put("diamond eight", 8);
        deck.put("diamond nine", 9);
        deck.put("diamond ten", 10);
        deck.put("diamond eleven", 11); //jack
        deck.put("diamond twelve", 12); //queen
        deck.put("diamond thirteen", 13);   //king
        deck.put("diamond fourteen", 14);   //ace
        deck.put("diamond fifteen", 15);  //wizard
        deck.put("club zero", 0);    //joker
        deck.put("club two", 2);
        deck.put("club three", 3);
        deck.put("club four", 4);
        deck.put("club five", 5);
        deck.put("club six", 6);
        deck.put("club seven", 7);
        deck.put("club eight", 8);
        deck.put("club nine", 9);
        deck.put("club ten", 10);
        deck.put("club eleven", 11); //jack
        deck.put("club twelve", 12); //queen
        deck.put("club thirteen", 13);   //king
        deck.put("club fourteen", 14);   //ace
        deck.put("club fifteen", 15);  //wizard

        makePlayers(3);
        //dealDeck(deck, 1); //gives player a random card to start
        for (int currentHand = 0; currentHand < playerArray.size(); currentHand++){
            dealDeck(deck, playerArray.get(currentHand), roundNum);
        }
    }

    public void makePlayers(int numPlayers){
        switch (numPlayers){
            case 6:
                Hashtable<String, Integer> player6Hand = new Hashtable<String, Integer>(); //cards player has in their hand
                playerArray.add(player6Hand);
            case 5:
                Hashtable<String, Integer> player5Hand = new Hashtable<String, Integer>(); //cards player has in their hand
                playerArray.add(player5Hand);
            case 4:
                Hashtable<String, Integer> player4Hand = new Hashtable<String, Integer>(); //cards player has in their hand
                playerArray.add(player4Hand);
            case 3:
                Hashtable<String, Integer> player3Hand = new Hashtable<String, Integer>(); //cards player has in their hand
                Hashtable<String, Integer> player2Hand = new Hashtable<String, Integer>(); //cards player has in their hand
                Hashtable<String, Integer> player1Hand = new Hashtable<String, Integer>(); //cards player has in their hand
                playerArray.add(player1Hand);
                playerArray.add(player2Hand);
                playerArray.add(player3Hand);
        }
    }

    //deals a card out to a player
    public void dealDeck(Hashtable deck, Hashtable playerHand, int numTricks){
        Random random = new Random();
        String[] cardSuit = {"club", "diamond", "heart", "spade"};
        String[] cardValue = {"zero", "one", "two",
                                "three", "four", "five",
                                "six", "seven", "eight",
                                "nine", "ten", "eleven",
                                "twelve", "thirteen", "fourteen", "fifteen"};
        for (int round = 0; round < numTricks; round++) {
            //int randomSuit = random.nextInt(cardSuit.length);
            //int randomVal = random.nextInt(cardValue.length);
            //playerHand.put(cardSuit[randomSuuit], cardValue[randomVal]);
            //deck.remove(cardSuit[randomSuit]);
            playerHand.put("diamond five", 5);
            deck.remove("diamond five");
        }
    }

    //copy constructor
    public GameState(GameState myState){
        playerTurn = myState.playerTurn;
        bidNum = myState.bidNum;
        cardPlayed = myState.cardPlayed;
        playerScore = myState.playerScore;
        gameStage = myState.gameStage;
        trumpCard = myState.trumpCard;
        roundNum = myState.roundNum;

        //is this a deep copy?
        deck = myState.deck;
        playerArray = myState.playerArray;
    }

    @Override
    public String toString(){
        return "Player turn: " + this.playerTurn + "\n Bid: " +
        "\n Card Played: " + this.cardPlayed + "\n Player Score: " + this.playerScore +
        "\n Game Stage: " + this.gameStage + "\n Trump Card: " + this.trumpCard +
        "\n Round Number: " + this.roundNum + "\n Current Deck: " + this.deck +
                "\n Player's Hand: " + this.playerArray;
    }


    public boolean placeBid(int playerNum, int bid, String player)
    {
        if (playerNum != playerTurn || bid < 0 || bid > roundNum)
        {
            return false;
        }
        else
        {
            if(bidNum.containsKey(player))
            {
                bidNum.replace(player, 0, bid);
            }
            playerTurn++;
            return true;
        }
    }

    public boolean playCard(int player, String card)
    {
        Hashtable<String, Integer>  currentHand = playerArray.get(player);
        if (player == playerTurn && currentHand.containsKey(card))
        {
            playerArray.set(player, currentHand);
            cardsPlayed.add(card);
            playerTurn++;
            return true;
        }
        else
        {
            return false;
        }
    }


}
