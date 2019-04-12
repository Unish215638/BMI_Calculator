package com.example.miniassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BMIMainActivity extends AppCompatActivity {

    EditText weight, height, bmires;
    Button bmibtn;
    double weightval, heightval,heightinm, bmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_activity_main);

        initcomponents();

        bmibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight.getText().toString().trim().isEmpty()) {
                    weight.setError("Required");
                }
                else if(height.getText().toString().trim().isEmpty()){
                    height.setError("Required");
                }
                else {

                    displayBMI();

                }
            }
        });

    }


    public void initcomponents() {

        weight = findViewById(R.id.tweight);
        height = findViewById(R.id.theight);
        bmibtn = findViewById(R.id.btn);
        bmires = findViewById(R.id.bmiresult);


    }

    public void displayBMI(){

        weightval = Double.parseDouble(weight.getText().toString().trim());
        heightval = Double.parseDouble(height.getText().toString().trim());
        heightinm = heightval / 100;

       BMI bmic=new BMI(heightinm,weightval);
         bmi = bmic.getWeight() / (bmic.getHeight()*bmic.getHeight());


        bmires.setText(bmi + "");

        if(bmi<=18.55){
            Toast.makeText(BMIMainActivity.this, "UnderWeight", Toast.LENGTH_LONG).show();
           bmires.setTextColor(getResources().getColor(R.color.red));
        }
        else if(bmi>=18.55&&bmi<=24.9){
            Toast.makeText(BMIMainActivity.this, "Normal Weight", Toast.LENGTH_LONG).show();
            bmires.setTextColor(getResources().getColor(R.color.green));
        }

        else if(bmi>=25 && bmi<=29.9){
            Toast.makeText(BMIMainActivity.this, "Over Weight", Toast.LENGTH_LONG).show();
            bmires.setTextColor(getResources().getColor(R.color.red));
        }

        else if(bmi>=30){
            Toast.makeText(BMIMainActivity.this, "Obesity", Toast.LENGTH_LONG).show();
            bmires.setTextColor(getResources().getColor(R.color.maroon));
        }


//
    }


}
