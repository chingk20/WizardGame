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
    private Hashtable<String, Integer>  bidNum = new Hashtable<~>();
    private Hashtable<String, Integer> deck = new Hashtable<String, Integer>();   //all the cards in the deck
    private Hashtable<String, Integer> playerHand = new Hashtable<String, Integer>(); //cards player has in their hand
    private ArrayList<String> cardsPlayed = new ArrayList<>();


    public int getPlayerTurn() {
        return playerTurn;
    }

    public int getBidNum() {
        return bidNum;
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

    public void setBidNum(int bidNum) {
        this.bidNum = bidNum;
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
        this.bidNum = 0;
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

        //dealDeck(deck, playerHand); //gives player a random card to start
    }

    //deals a card out to a player
    /*public void dealDeck(Hashtable deck, Hashtable playerHand){
        Random random = new Random();
        List<String> shuffleDeck = new ArrayList<String>(deck.keySet());
        String randomKey = shuffleDeck.get(random.nextInt(shuffleDeck.size()));
        String value = (String) deck.get(randomKey);
        Integer myValue = (Integer) deck.get(randomKey);
        deck.get(value);
        playerHand.put(value, myValue);
        deck.remove(value);
    }*/

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
        Hashtable<String, Integer> deck = new Hashtable<String, Integer>();
        deck = myState.deck;
        Hashtable<String, Integer> playerHand = new Hashtable<String, Integer>();
        playerHand = myState.playerHand;
    }

    @Override
    public String toString(){
        return "Player turn: " + this.playerTurn + "\n Bid: " + this.bidNum +
        "\n Card Played: " + this.cardPlayed + "\n Player Score: " + this.playerScore +
        "\n Game Stage: " + this.gameStage + "\n Trump Card: " + this.trumpCard +
        "\n Round Number: " + this.roundNum + "\n Current Deck: " + this.deck +
                "\n Player's Hand: " + this.playerHand;
    }


    public boolean placeBid(int player, int bid)
    {
        if (player != playerTurn || bid < 0 || bid > roundNum)
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
        if (player == playerTurn && playerHand.containsKey(card))
        {
            playerHand.remove(card);
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
