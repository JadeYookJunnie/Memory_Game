package com.example.assignmenttwo;

public class Card {
    public int number;
    public String faceUp;
    public String faceDown;
    public boolean match;

    public Card(int number, String faceUp) {
        this.number = number;
        this.faceUp = faceUp;
        faceDown = "img_card_facedown.png";
        match = false;

    }
}