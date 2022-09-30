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


    //get the instance of the game information
    GameInfo instance = GameInfo.getInstance();
    Card card = new Card(9, "img");





    //ArrayList<Card> cards = generate();
    String gen = instance.setCards(generate());
    ListView listView;


    //on creation of the list...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //update listview
        listView = (ListView) findViewById(R.id.cardList);
        CustomAdapter adapterCustom;
        //create adapter using list stored in game instance
        adapterCustom = new CustomAdapter(this, instance.getList());
        listView.setAdapter(adapterCustom);
        //when an item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Card selected = instance.getList().get(position);
                //if the card has not been selected
                if(selected.flipped == false) {






                    //create card intent
                    Intent intent = (new Intent(ListActivity.this, CardActivity.class));

                    //pass through matching status and image name
                    String up = selected.faceUp;
                    intent.putExtra("status", getStatus(selected));
                    intent.putExtra("face", up);
                    //open intent with selection
                    startActivity(intent);

                }
                //change flipped status as to not be selected again
                instance.getList().get(position).flipped = true;
                //adapterCustom.refresh();




            }
        });
    }

    public String getStatus(Card selected) {
        //has the first of the two been chosen?
        //if not, set card to first click
        if(instance.getFirstPick() == null) {
            instance.setFirst(selected);
            return "First Pick!";
        }
        //if so, set to second pick
        else  {
            //give response depending on first and second match
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

    //change first and second to null
    public void reset() {
        instance.setFirst(null);
        instance.setSecond(null);
    }

    //check iof first and second selection match
    public boolean checkMatch() {
        if(instance.getFirstPick().faceUp == instance.getSecondPick().faceUp) {
            return true;
        }
        else {
            return false;
        }
    }

    //@RequiresApi(api = Build.VERSION_CODES.N)
    //generate list of cards
    public ArrayList<Card> generate() {
        ArrayList<Card> Cardlist = new ArrayList<>();

        //create list containing all card sources
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
        //randomise
        Collections.shuffle(names);
        //give nmumber to each, add to new list
        for (int i = 1; i <= 5; i++) {
            Cardlist.add(new Card(i, names.get(i)));
        }
        return Cardlist;


    }




    //customadapter
    //could not make new class
    public class CustomAdapter extends ArrayAdapter<Card> {
        Context context;
        ArrayList<Card> cards;
        Card current;
        ImageView imageView;
        TextView textView;
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
            //for each card...
            current = cards.get(position);

            //populate each item in the list
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_listview, parent, false);
            imageView = (ImageView) convertView.findViewById(R.id.rowImg);
            textView = (TextView) convertView.findViewById(R.id.rowText);


            //attempt to change image based on flipped status
            //could not refresh so didn't completely work
            if(current.flipped == true) {
                String up = current.faceUp;
                int id = context.getResources().getIdentifier(up, "drawable", context.getPackageName());
                imageView.setImageResource(id);
            }
            else {
                String down = current.faceDown;
                int id = context.getResources().getIdentifier(down, "drawable", context.getPackageName());
                imageView.setImageResource(id);
            }
             int id = getContext().getResources().getIdentifier(current.faceUp, "drawable", getContext().getPackageName());
             imageView.setImageResource(id);


            //finalise display
            textView.setText("card " + current.number);
            return convertView;
        }



    }
}

