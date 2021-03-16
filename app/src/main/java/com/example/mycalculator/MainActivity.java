package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final DecimalFormat fmt = new DecimalFormat(".####");
    private final Stack<Integer> myStack = new Stack<>();
    private final Stack<Float> myStack2 = new Stack<>();
    private char myOperator;
    private boolean checkOperator = false;
    private boolean checkType = false;
    private String numberText = "";
    private TextView textView;
    private Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9;
    private Button decimalButton, changeOperator;

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

        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(this);
        Button subtractButton = findViewById(R.id.button_subtract);
        subtractButton.setOnClickListener(this);
        Button multiplyButton = findViewById(R.id.button_multiply);
        multiplyButton.setOnClickListener(this);
        Button divideButton = findViewById(R.id.button_divide);
        divideButton.setOnClickListener(this);
        Button deleteButton = findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(this);
        Button equalsButton = findViewById(R.id.button_equals);
        equalsButton.setOnClickListener(this);
        decimalButton = findViewById(R.id.button__);
        decimalButton.setOnClickListener(this);
        changeOperator = findViewById(R.id.button_changeOp);
        changeOperator.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.button_0:
                if (!textView.getText().toString().equals("0")) {
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
                if (!numberText.equals("") && !checkOperator)
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
                if (!numberText.equals("") && !checkOperator)
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
                if (!numberText.equals("") && !checkOperator)
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
                if (!numberText.equals("") && !checkOperator)
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
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    textView.setTextSize(60);
                } else {
                    textView.setTextSize(108);
                }
                break;
            case R.id.button_equals:
                if (!myStack.isEmpty() || !myStack2.isEmpty()) {
                    doOperation('=');
                    checkOperator = true;
                }
                break;
            case R.id.button__:
                if (numberText.equals(""))
                    numberText = "0";
                if (!numberText.contains("."))
                    createText(decimalButton.getText().toString());
                checkType = true;
                break;
            case R.id.button_changeOp:
                if(!myStack.isEmpty() || !numberText.equals(""))
                {
                    if(!myStack.isEmpty()){
                        int x = myStack.pop() * (-1);
                        myStack.push(x);
                        numberText = x + "";
                        textView.setText(numberText);
                    }
                    else{
                        int x = Integer.parseInt(numberText);
                        x *= -1;
                        numberText = x +"";
                        textView.setText(numberText);
                    }
                }
                else if (!myStack2.isEmpty() || !numberText.equals(""))
                {
                    if(!myStack2.isEmpty())
                    {
                        float x = myStack2.pop() * (-1);
                        myStack2.push(x);
                        numberText = x + "";
                        textView.setText(numberText);
                    }
                    else{
                        float x = Float.parseFloat(numberText);
                        x *= -1;
                        numberText = x +"";
                        textView.setText(numberText);
                    }
                }

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
                else if (myOperator == '/' && !textView.getText().toString().equals("0") && s!= 0.0)
                    result = myStack2.pop() / s;
                else if (textView.getText().toString().equals("0") || s == 0.0) {
                    myStack2.removeAllElements();
                    numberText = "";
                    textView.setText("Error");
                    return;
                }

                myStack2.push(result);

                numberText = fmt.format(result) + "";
                shrinkText();
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
        else
        {
            i = Integer.parseInt(numberText);
            int result = 0;
            if (myStack.isEmpty()) {
                myStack.push(i);
            } else {


                if (myOperator == '+')
                    result = myStack.pop() + i;
                else if (myOperator == '-')
                    result = myStack.pop() - i;
                else if (myOperator == '*')
                    result = myStack.pop() * i;
                else if (myOperator == '/' && !textView.getText().toString().equals("0")) {
                    int r = myStack.pop();
                    if(r % i != 0){
                        myStack2.push((float)r / i);
                        checkType = true;
                        myOperator = '/';
                        numberText = fmt.format(myStack2.peek()) + "";
                        shrinkText();
                        textView.setText(numberText);
                        if (operator == '=') {
                            numberText = i + "";
                        }
                        if (operator != '=') {
                            myOperator = operator;
                            numberText = "";
                        }
                        return;
                    }
                    else
                     result = r / i;

                }
                else if (textView.getText().toString().equals("0") ||textView.getText().toString().equals("-0")) {
                    myStack.removeAllElements();
                    numberText = "";
                    textView.setText("Error");
                    return;
                }

                myStack.push(result);

                numberText = result + "";
                shrinkText();
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

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if(numberText.length() > 15)
            return;
        } else {
            if(numberText.length() > 8)
                return;
        }


        shrinkText();

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
            checkType = false;
        }
    }

    private void shrinkText()
    {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            textView.setTextSize(60);
        } else {
            if(numberText.length() < 6)
                textView.setTextSize(108);
            else if(numberText.length() == 6){
                textView.setTextSize(98);
            }
            else if(numberText.length() == 7){
                textView.setTextSize(88);
            }
            else if(numberText.length() == 8){
                textView.setTextSize(78);
            }
        }


    }
}

