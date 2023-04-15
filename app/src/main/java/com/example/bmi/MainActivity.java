package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    RadioGroup genderrg;
    Button calbtn;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        calbtn = findViewById(R.id.calbtn);
        genderrg = findViewById(R.id.rg);

        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           String height_val = height.getText().toString().trim();
           String weight_val = weight.getText().toString().trim();

           float h = Float.parseFloat(height_val);
           float w = Float.parseFloat(weight_val);
           float bmi = BMI(h,w);

           Intent intent = new Intent(MainActivity.this,ResultActivity.class);
           intent.putExtra("bmi",bmi);
           intent.putExtra("Gender",gender);
           startActivity(intent);


            }
        });/* Toast.makeText(MainActivity.this, String.valueOf(bmi) + " " + gender,Toast.LENGTH_LONG ).show();*/

        genderrg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.brb){
                    gender = "boy";
                }
                else{
                    gender = "girl";
                }
            }
        });

    }

    public float BMI(float h, float w){

        float bmi = 0;
        float height_in_meter = h/100;
        bmi = w/(height_in_meter*height_in_meter);

        return bmi;

    }

}