package com.example.idc;

import android.os.FileObserver;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    HashMap<String, Operators> operatorMap = new HashMap<>();
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);


        for(Operators operator:Operators.values()) {
            operatorMap.put(operator.getIcon(),operator);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,new ArrayList<>(operatorMap.keySet()));
        spinner.setAdapter(arrayAdapter);

        Button button = findViewById(R.id.button);
        //xml line 63 //1
        //button.setOnClickListener(listener); //4
        //button.setOnClickListener(this); //3
        /*button.setOnClickListener(new View.OnClickListener() { //2
            @Override
            public void onClick(View v) {
                Double result = calc(operatorMap.get(spinner.getSelectedItem().toString()));
                TextView textView = findViewById(R.id.textView5);
                textView.setText("Math error");
                if(!Double.isNaN(result)) { textView.setText(String.valueOf(result));}

            }
        });*/
    }

    private double calc(Operators operator) {
        Double n1 = null;
        Double n2 = null;
        try {
            EditText editText = findViewById(R.id.editTextNumber);
            n1 = Double.parseDouble(String.valueOf(editText.getText()));
            EditText editText2 = findViewById(R.id.editTextNumber2);
            n2 = Double.parseDouble(String.valueOf(editText2.getText()));
        }
        catch (Exception e) {return Double.NaN;}
        switch (operator) {
            case ADD: {
                return n1+n2;
                }
            case SUBTRACT: {
                return n1-n2;
                }
            case MULTIPLY: {
                return n1*n2;
               }
            case DIVIDE: {
                if(n2==0) {return Double.NaN;}
                return n1/n2;
               }
            case MODULO: {
                return n1%n2;
               }
            default: return Double.NaN;
        }
    }

    @Override
    public void onClick(View v) {
        System.out.println("idk");
        Double result = calc(operatorMap.get(spinner.getSelectedItem().toString()));
        TextView textView = findViewById(R.id.textView5);
        textView.setText("Math error");
        if(!Double.isNaN(result)) { textView.setText(String.valueOf(result));}
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println("idk");
            Double result = calc(operatorMap.get(spinner.getSelectedItem().toString()));
            TextView textView = findViewById(R.id.textView5);
            textView.setText("Math error");
            if(!Double.isNaN(result)) { textView.setText(String.valueOf(result));}
        }
    };
}