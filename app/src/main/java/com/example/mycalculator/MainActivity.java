package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Stack<Integer> myStack = new Stack<Integer>();
    private char myOperator;
    private String numberText = "";
    private TextView textView;
    private Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9;
    private Button addButton, subtractButton, multiplyButton, divideButton, deleteButton;

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

        addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(this);
        subtractButton = findViewById(R.id.button_subtract);
        subtractButton.setOnClickListener(this);
        multiplyButton = findViewById(R.id.button_multiply);
        multiplyButton.setOnClickListener(this);
        divideButton = findViewById(R.id.button_divide);
        divideButton.setOnClickListener(this);
        deleteButton = findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int i;

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
            case R.id.button_add:
                doOperation('+');
                break;
            case R.id.button_subtract:
                doOperation('-');
                break;
            case R.id.button_multiply:
                doOperation('*');
                break;
            case R.id.button_divide:
                doOperation('/');
                break;


        }




    }

    private void doOperation(char operator)
    {
        int i = Integer.parseInt(numberText);
        int result = 0;
        if(myStack.isEmpty())
        {
            myStack.push(i);
            numberText = "";
            textView.setText("");
        }
        else {

            if (myOperator == '+') {
                result = myStack.pop() + i;
            } else if (myOperator == '-')
                result = myStack.pop() - i;
            else if (myOperator == '*')
                result = myStack.pop() * i;
            else if (myOperator == '/')
                result = myStack.pop() / i;

            myStack.push(result);
            textView.setText("");

            numberText = result + "";
            textView.setText(numberText);
            numberText = "";
        }

        myOperator = operator;

    }
}

