package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
         TextView txtResult;
         LinearLayout llMain;


         edtWeight = findViewById(R.id.edtWeight);
         edtHeightFt = findViewById(R.id.edtHeightFt);
         edtHeightIn = findViewById(R.id.edtHeightIn);

         btnCalculate = findViewById(R.id.btnCalculate);
         txtResult = findViewById(R.id.txtResult);
         llMain = findViewById(R.id.llMain);

         btnCalculate.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v){
             int wt = Integer.parseInt(edtWeight.getText().toString());
             int ft =Integer.parseInt(edtHeightFt.getText().toString());
             int in= Integer.parseInt(edtHeightIn.getText().toString());

             int totalIn= ft*12+in;

             double totalCm = totalIn*2.53;

             double totalM = totalCm/100;

             double bmi = wt/(totalM*totalM);


            if(bmi>25){
                txtResult.setText("You're over weight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
            }
            else if(bmi<18) {
                txtResult.setText("You're under weight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
            }
            else{
                txtResult.setText("You're Healthy");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
            }


             }

         });
    }
}