package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
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

public class ListActivity extends AppCompatActivity {

    //generate random list of cards
    //start with basic manual entries for testing
    Card card1 = new Card(1,"img_card_1.png");
    Card card2 = new Card(2, "img_card_2.png");
    ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //update listview
        ListView listView = (ListView) findViewById(R.id.cardList);
        CustomAdapter adapterCustom = new CustomAdapter(this, cards);
        listView.setAdapter(adapterCustom);
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

            //move when match is found
            //ImageView card = (ImageView) findViewById(R.id.rowImg);
//            int img_id = getResources().getIdentifier(faceUp, "drawable", getPackageName());
//            Drawable drawable =getDrawable(img_id);
//            card.setImageDrawable(drawable);
            //card.setScaleType(ImageView.ScaleType.CENTER_CROP);

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
             TextView textView = (TextView) convertView.findViewById(R.id.rowText);
             textView.setText("card " + current.number);
             return convertView;
         }
    }
}