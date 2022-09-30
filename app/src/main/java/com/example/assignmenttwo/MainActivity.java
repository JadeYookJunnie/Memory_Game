package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void activateList(View v) {
        Button button = findViewById(R.id.startButton);
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}