package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    float bmi;
    TextView text1, text2;
    ImageView img;
    String msg, gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bmi = getIntent().getFloatExtra("bmi", -1);
        gender = getIntent().getStringExtra("Gender");

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        img = findViewById(R.id.img);

        if(bmi < 18){
            msg = " You are under weighted " + gender;
            if(gender.equals("boy")){
                img.setBackgroundResource(R.drawable.slim_boy);
            }
            else{
                img.setBackgroundResource(R.drawable.slim_girl);
            }
        } else if(bmi > 19 && bmi < 24){
            msg = " You are fit " + gender;
            if(gender.equals("boy")){
                img.setBackgroundResource(R.drawable.slim_boy);
            }
            else{
                img.setBackgroundResource(R.drawable.slim_girl);
            }
        } else{
            msg = " You are over weighted " + gender;
            if(gender.equals("boy")){
                img.setBackgroundResource(R.drawable.fat_boy);
            }
            else{
                img.setBackgroundResource(R.drawable.fat_girl);
            }
        }

        text1.setText(msg);
        text2.setText(String.format("%.2f",bmi));


    }
}