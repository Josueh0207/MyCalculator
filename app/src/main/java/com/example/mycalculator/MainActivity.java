package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DecimalFormat fmt = new DecimalFormat(".####");
    private Stack<Integer> myStack = new Stack<Integer>();
    private Stack<Float> myStack2 = new Stack<Float>();
    private char myOperator;
    private boolean checkOperator = false;
    private boolean checkType = false;
    private String numberText = "";
    private TextView textView;
    private Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9;
    private Button addButton, subtractButton, multiplyButton, divideButton, deleteButton, equalsButton;
    private Button decimalButton;

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
        equalsButton = findViewById(R.id.button_equals);
        equalsButton.setOnClickListener(this);
        decimalButton = findViewById(R.id.button__);
        decimalButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.button_0:
                if (!textView.getText().toString().equals("0") ) {
                    createText(number0.getText().toString());
                }
                break;
            case R.id.button_1:
                createText(number1.getText().toString());
                break;
            case R.id.button_2:
                createText(number2.getText().toString());
                break;
            case R.id.button_3:
                createText(number3.getText().toString());
                break;
            case R.id.button_4:
                createText(number4.getText().toString());
                break;
            case R.id.button_5:
                createText(number5.getText().toString());
                break;
            case R.id.button_6:
                createText(number6.getText().toString());
                break;
            case R.id.button_7:
                createText(number7.getText().toString());
                break;
            case R.id.button_8:
                createText(number8.getText().toString());
                break;
            case R.id.button_9:
                createText(number9.getText().toString());
                break;
            case R.id.button_add:
                if (numberText != "" && !checkOperator)
                    doOperation('+');
                else if (myOperator == '+' || myOperator == '-' || myOperator == '*' || myOperator == '/')
                    myOperator = '+';
                if (checkOperator) {
                    numberText = "";
                    checkOperator = false;
                    myOperator = '+';
                }
                break;
            case R.id.button_subtract:
                if (numberText != "" && !checkOperator)
                    doOperation('-');
                else if (myOperator == '+' || myOperator == '-' || myOperator == '*' || myOperator == '/')
                    myOperator = '-';
                if (checkOperator) {
                    numberText = "";
                    checkOperator = false;
                    myOperator = '-';
                }
                break;
            case R.id.button_multiply:
                if (numberText != "" && !checkOperator)
                    doOperation('*');
                else if (myOperator == '+' || myOperator == '-' || myOperator == '*' || myOperator == '/')
                    myOperator = '*';
                if (checkOperator) {
                    numberText = "";
                    checkOperator = false;
                    myOperator = '*';
                }
                break;
            case R.id.button_divide:
                if (numberText != "" && !checkOperator)
                    doOperation('/');
                else if (myOperator == '+' || myOperator == '-' || myOperator == '*' || myOperator == '/')
                    myOperator = '/';
                if (checkOperator) {
                    numberText = "";
                    checkOperator = false;
                    myOperator = '/';
                }
                break;
            case R.id.button_delete:
                myStack.removeAllElements();
                myStack2.removeAllElements();
                numberText = "";
                textView.setText("0");
                checkOperator = false;
                checkType = false;
                break;
            case R.id.button_equals:
                if (!myStack.isEmpty() || !myStack2.isEmpty()) {
                        doOperation('=');
                        checkOperator = true;
                    }
                break;
            case R.id.button__:
                createText(decimalButton.getText().toString());
                checkType = true;
                break;

        }




    }

    @SuppressLint("SetTextI18n")
    private void doOperation(char operator)
    {
        int i;
        float s;

        if(checkType) {
            s = Float.parseFloat(numberText);
            float result = 0;
            if (!myStack.isEmpty())
            {
                float y  = (float) myStack.pop();
                myStack2.push(y);
            }

            if (myStack2.isEmpty()) {
                myStack2.push(s);
            }
            else {


                if (myOperator == '+') {
                    result = myStack2.pop() + s;
                } else if (myOperator == '-')
                    result = myStack2.pop() - s;
                else if (myOperator == '*')
                    result = myStack2.pop() * s;
                else if (myOperator == '/' && !textView.getText().toString().equals("0"))
                    result = myStack2.pop() / s;
                else if (textView.getText().toString().equals("0")) {
                    myStack2.removeAllElements();
                    numberText = "";
                    textView.setText("Error");
                    return;
                }

                myStack2.push(result);

                numberText = fmt.format(result) + "";
                textView.setText(numberText);

                if (operator == '=') {
                    numberText = s + "";
                }
            }

            if (operator != '=') {
                myOperator = operator;
                numberText = "";
            }
        }
        else if (!checkType)
        {
            i = Integer.parseInt(numberText);
            int result = 0;
            if (myStack.isEmpty()) {

                myStack.push(i);
            } else {


                if (myOperator == '+') {
                    result = myStack.pop() + i;
                } else if (myOperator == '-')
                    result = myStack.pop() - i;
                else if (myOperator == '*')
                    result = myStack.pop() * i;
                else if (myOperator == '/' && !textView.getText().toString().equals("0"))
                    result = myStack.pop() / i;
                else if (textView.getText().toString().equals("0")) {
                    myStack.removeAllElements();
                    numberText = "";
                    textView.setText("Error");
                    return;
                }

                myStack.push(result);

                numberText = result + "";
                textView.setText(numberText);

                if (operator == '=') {
                    numberText = i + "";
                }
            }

            if (operator != '=') {
                myOperator = operator;
                numberText = "";
            }
        }

    }

    private void createText(String string)
    {

        if(!checkOperator) {
            numberText += string + "";
            textView.setText(numberText);
        }
        else
        {
            myStack.removeAllElements();
            myStack2.removeAllElements();
            numberText = string;
            textView.setText(numberText);
            checkOperator = false;
        }
    }
}

