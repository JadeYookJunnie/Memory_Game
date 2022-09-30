package com.example.assignmenttwo;

import java.util.ArrayList;

public class GameInfo {
    private static GameInfo instance = null;
    private Card firstPick;
    private Card secondPick;
    private ArrayList<Card> cardArrayList;

    private GameInfo() {
    }

    public static GameInfo getInstance() {
        if(instance==null) {
            instance = new GameInfo();
        }
        return instance;
    }

}
