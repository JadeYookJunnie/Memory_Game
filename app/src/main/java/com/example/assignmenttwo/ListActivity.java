package com.example.assignmenttwo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.lang.reflect.Array;
import java.util.*;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.AdapterView;
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
//    com.example.assignmenttwo.Card card1 = new com.example.assignmenttwo.Card(1,"img_card_1");
//    com.example.assignmenttwo.Card card2 = new com.example.assignmenttwo.Card(2, "img_card_2");
    //ArrayList<com.example.assignmenttwo.Card> cards = new ArrayList<>(Arrays.asList(card1, card2));

    GameInfo instance = GameInfo.getInstance();
    //Card fpick = instance.getFirstPick();
    //String first = instance.setFirst(new Card(9, "img"));
    Card card = new Card(9, "img");
    //instance.setFirst(card);





    //ArrayList<Card> cards = generate();
    String gen = instance.setCards(generate());
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //update listview
        listView = (ListView) findViewById(R.id.cardList);
        CustomAdapter adapterCustom = new CustomAdapter(this, instance.getList());
        listView.setAdapter(adapterCustom);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Card selected = instance.getList().get(position);


                //get first click, check if null
                //if so, set card to first click
                //if not, second pick
                //check match (second pick)
                //if match, change first and second to match

                //open intent with selection

                Intent intent = (new Intent(ListActivity.this, CardActivity.class));

                String up = selected.faceUp;
                intent.putExtra("status", getStatus(selected));
                intent.putExtra("match", selected.matched);
                intent.putExtra("face", up);
                startActivity(intent);

            }
        });
    }

    public String getStatus(Card selected) {
        if(instance.getFirstPick() == null) {
            instance.setFirst(selected);
            return "First Pick!";
        }
        else  {
            instance.setSecond(selected);
            if(checkMatch()) {
                reset();
                return "Second pick...it's a match!";
            }
            else {
                reset();
                return "Second pick... whoops, it's not a match";
            }
        }
    }

    public void reset() {
        instance.setFirst(null);
        instance.setSecond(null);
    }

    public boolean checkMatch() {
        if(instance.getFirstPick().faceUp == instance.getSecondPick().faceUp) {
            return true;
        }
        else {
            return false;
        }
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
        for (int i = 1; i <= 5; i++) {
            Cardlist.add(new Card(i, names.get(i)));
        }
        return Cardlist;


    }


//    public class com.example.assignmenttwo.Card {
//        public int number;
//        public String faceUp;
//        public String faceDown;
//        public boolean match;
//
//        public com.example.assignmenttwo.Card(int number, String faceUp) {
//            this.number = number;
//            this.faceUp = faceUp;
//            faceDown = "img_card_facedown.png";
//            match = false;
//
//
//        }


    //customadapter
    public class CustomAdapter extends ArrayAdapter<Card> {
        Context context;
        ArrayList<Card> cards;
//        GameInfo instance = GameInfo.getInstance();

        //Card card = instance.getFirstPick();
        //String first = instance.setFirst(new Card(9, "first"));


        public CustomAdapter(Context context, ArrayList<Card> cards) {
            super(context, R.layout.row_listview, cards);
            this.context = context;
            this.cards = cards;
        }
        //test
        //test2

        public View getView(int position, View convertView, ViewGroup parent) {
            Card current = cards.get(position);

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_listview, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.rowImg);
            TextView textView = (TextView) convertView.findViewById(R.id.rowText);
//             int id = getContext().getResources().getIdentifier(current.faceUp, "drawable", getContext().getPackageName());
//             imageView.setImageResource(id);
            String up = current.faceUp;
            int id = context.getResources().getIdentifier(up, "drawable", context.getPackageName());


//            Drawable drawable = context.getDrawable(id);
////
//            imageView.setBackground(drawable);
            imageView.setImageResource(id);
            textView.setText("card " + current.number);
            return convertView;
        }
    }
}

