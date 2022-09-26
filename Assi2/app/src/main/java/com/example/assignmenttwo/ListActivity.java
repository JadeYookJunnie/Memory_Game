package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public class Card {
        public int number;
        public String faceUp;
        public String faceDown;
        public boolean match;
    }
}