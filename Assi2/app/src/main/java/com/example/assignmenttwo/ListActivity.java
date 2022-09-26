package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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

    //generate random list of cards
    //start with basic manual entries for testing

    //customadapter
    public class CustomAdapter extends ArrayAdapter<Card> {
         Context context;
         ArrayList<Card> cards;

         public CustomAdapter(Context context, ArrayList<Card> cards) {
             super(context, R.layout.row_listview, cards);
             this.context = context;
             this.cards = cards;
         }

         public View getView(int position, View convertView, ViewGroup parent) {
             Card current = cards.get(position);

             LayoutInflater inflater = LayoutInflater.from(getContext());
             convertView = inflater.inflate(R.layout.row_listview,parent,false);
             TextView textView = (TextView) convertView.findViewById(R.id.rowText);
             textView.setText("card " + current.number);
             return convertView;
         }
    }
}