package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Stack<Integer> myStack;
    private char myOperator;
    private String numberText = "";
    private TextView textView;
    private Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView_result);

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



        switch(v.getId())
        {
            case R.id.button_0:
                if(numberText.length() != 0){
                    numberText += number0.getText().toString() + "";
                    textView.setText(numberText);
                }
                break;
            case R.id.button_1:
                    numberText += number1.getText().toString() + "";
                    textView.setText(numberText);
                break;
            case R.id.button_2:
                numberText += number2.getText().toString() + "";
                textView.setText(numberText);
                break;
            case R.id.button_3:
                numberText += number3.getText().toString() + "";
                textView.setText(numberText);
                break;
            case R.id.button_4:
                numberText += number4.getText().toString() + "";
                textView.setText(numberText);
                break;
            case R.id.button_5:
                numberText += number5.getText().toString() + "";
                textView.setText(numberText);
                break;
            case R.id.button_6:
                numberText += number6.getText().toString() + "";
                textView.setText(numberText);
                break;
            case R.id.button_7:
                numberText += number7.getText().toString() + "";
                textView.setText(numberText);
                break;
            case R.id.button_8:
                numberText += number8.getText().toString() + "";
                textView.setText(numberText);
                break;
            case R.id.button_9:
                numberText += number9.getText().toString() + "";
                textView.setText(numberText);
                break;


        }




    }
}

