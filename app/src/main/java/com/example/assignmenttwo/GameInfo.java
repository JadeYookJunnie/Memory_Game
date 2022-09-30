package com.example.assignmenttwo;

import java.util.ArrayList;

public class GameInfo {
    private static GameInfo instance = new GameInfo();
    private Card firstPick;
    private Card secondPick;
    private ArrayList<Card> cardArrayList;

    private GameInfo() {
    }

    public static GameInfo getInstance() {
//        if(instance==null) {
//            instance = new GameInfo();
//        }
        return instance;
    }

    public Card getFirstPick() {
        return firstPick;
    }

    public String setFirst(Card first) {
        firstPick = first;
        return "success";
    }

    public Card getSecondPick() {
        return secondPick;
    }

    public String setSecond(Card second) {
        secondPick = second;
        return "success";
    }

    public String setCards(ArrayList<Card> list) {
        cardArrayList = list;
        return "success";
    }

    public ArrayList<Card> getList() {
        return cardArrayList;
    }




}
