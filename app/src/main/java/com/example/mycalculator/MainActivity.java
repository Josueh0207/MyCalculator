package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Stack<Integer> myStack;
    private char myOperator;
    private Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number0 = findViewById(R.id.button_0);
        number0.setOnClickListener(this);

        number1 = findViewById(R.id.button_1);
        number1.setOnClickListener(this);

        number2 = findViewById(R.id.button_2);
        number2.setOnClickListener(this);

        number3 = findViewById(R.id.button_3);
        number3.setOnClickListener(this);

        number4 = findViewById(R.id.button_4);
        number4.setOnClickListener(this);

        number5 = findViewById(R.id.button_5);
        number5.setOnClickListener(this);

        number6 = findViewById(R.id.button_6);
        number6.setOnClickListener(this);

        number7 = findViewById(R.id.button_7);
        number7.setOnClickListener(this);

        number8 = findViewById(R.id.button_8);
        number8.setOnClickListener(this);

        number9 = findViewById(R.id.button_9);
        number9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



    }
}
