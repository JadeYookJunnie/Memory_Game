package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import android.widget.ImageView;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Context context = this;


        Intent intent = getIntent();

        boolean match = intent.getBooleanExtra("match", false);
        String stat = intent.getStringExtra("status");
        String name = intent.getStringExtra("face");

        ImageView card = (ImageView) findViewById(R.id.cardImg);

        Resources resource = this.getResources();
        String pack = this.getPackageName();
        int id = resource.getIdentifier(name, "drawable", pack);
        //int img_id = context.getResources().getIdentifier(name, "drawable",context.getPackageName());
//        Drawable drawable = this.getDrawable(img_id);
//        card.setBackground(drawable);
        card.setImageResource(id);

        TextView status = (TextView) findViewById(R.id.matchText);
        status.setText(stat);

        //status.setText(name);



    }
}