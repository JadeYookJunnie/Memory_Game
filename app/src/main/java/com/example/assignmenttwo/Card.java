package com.example.assignmenttwo;

//informastion about each card and status of the game
public class Card {
    public int number;
    public String faceUp;
    public String faceDown;
    public boolean matched;
    public boolean flipped;

    public Card(int number, String faceUp) {
        this.number = number;
        this.faceUp = faceUp;
        faceDown = "img_card_facedown";
        matched = false;
        flipped = false;

    }
}
