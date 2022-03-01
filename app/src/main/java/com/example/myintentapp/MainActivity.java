package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        Button btnMoveActivityData = findViewById(R.id.btn_move_activity_data);
        btnMoveActivityData.setOnClickListener(this);
        Button btnMoveActivityObject = findViewById(R.id.btn_move_activity_object);
        btnMoveActivityObject.setOnClickListener(this);
        Button btnDialNumber= findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent MoveIntent  = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(MoveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("data1", "some string data 1");
                intent.putExtra("data2", "some string data 2");
                startActivity(intent);
                break;
            case R.id.btn_move_activity_object:
                Person manusia = new Person("Kevin","kevinbaw@gmail.com","Malang", 69);
                Intent intent_object = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                intent_object.putExtra(MoveWithObjectActivity.EXTRA_PERSON, manusia);
                startActivity(intent_object);
                break;
            case R.id.btn_dial_number:
                String phonenumber = "081249180170";
                Intent dialanumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phonenumber));
                startActivity(dialanumber);
                break;


        }
    }
}