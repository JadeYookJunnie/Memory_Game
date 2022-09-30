package com.example.assignmenttwo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.lang.reflect.Array;
import java.util.*;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    //generate random list of cards
    //start with basic manual entries for testing
//    Card card1 = new Card(1,"img_card_1");
//    Card card2 = new Card(2, "img_card_2");
    //ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2));
    ArrayList<Card> cards = generate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //update listview
        ListView listView = (ListView) findViewById(R.id.cardList);
        CustomAdapter adapterCustom = new CustomAdapter(this, cards);
        listView.setAdapter(adapterCustom);
    }

    //@RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Card> generate() {
        ArrayList<Card> Cardlist = new ArrayList<>();
//        String[] names = {"img_card_1", "img_card_1", "img_card_2", "img_card_2",
//                "img_card_3", "img_card_3", "img_card_4", "img_card_4", "img_card_5",
//                "img_card_5", "img_card_6", "img_card_6"};
        ArrayList<String> names = new ArrayList<>();

        names.add("img_card_1");
        names.add("img_card_1");
        names.add("img_card_2");
        names.add("img_card_2");
        names.add("img_card_3");
        names.add("img_card_3");
        names.add("img_card_4");
        names.add("img_card_4");
        names.add("img_card_5");
        names.add("img_card_5");
        names.add("img_card_6");
        names.add("img_card_6");

//        ArrayList<Integer> indexes = new ArrayList<Integer>();
        Collections.shuffle(names);
        for(int i = 1; i <= 5; i++) {
            Cardlist.add(new Card(i, names.get(i)));
        }
        return Cardlist;


    }


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
             ImageView imageView = (ImageView) convertView.findViewById(R.id.rowImg);
             TextView textView = (TextView) convertView.findViewById(R.id.rowText);
//             int id = getContext().getResources().getIdentifier(current.faceUp, "drawable", getContext().getPackageName());
//             imageView.setImageResource(id);
             String up = current.faceUp;
             int id = getResources().getIdentifier(up, "drawable", getPackageName());
             //error here
             Drawable drawable = getDrawable(id);
//
             imageView.setBackground(drawable);
             textView.setText("card " + current.number);
             return convertView;
         }
    }

    public class GameInfo {
        private static GameInfo instance = null;
        private Card firstPick;
        private Card secondPick;
        private ArrayList<Card> cardArrayList = generate();

        private GameInfo() {

        }

        public static GameInfo getInstance() {
            if(instance==null) {
                instance = new GameInfo();
            }
            return instance;
        }

        public ArrayList<Card> generate() {
            ArrayList<Card> Cardlist = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();

            names.add("img_card_1");
            names.add("img_card_1");
            names.add("img_card_2");
            names.add("img_card_2");
            names.add("img_card_3");
            names.add("img_card_3");
            names.add("img_card_4");
            names.add("img_card_4");
            names.add("img_card_5");
            names.add("img_card_5");
            names.add("img_card_6");
            names.add("img_card_6");

            Collections.shuffle(names);
            for(int i = 1; i <= 5; i++) {
                Cardlist.add(new Card(i, names.get(i)));
            }
            return Cardlist;

        }
    }
}