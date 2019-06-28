package com.example.hellotoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnPlus;
    Button btnMinus;
    Button btnMult;
    Button btnDiv;
    Button btnEqual;
    Button btnClear;

    TextView textView;
    int result = 0;
    int op1 = 0;
    int op2 = 0;
    String temp = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText("0");
    }

    public void onClickNumber(View view) {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        switch (view.getId()){
            case R.id.btn0:
                if(!(textView.getText().toString().equals("0"))){
                    temp = temp + btn0.getText().toString();
                    textView.setText(temp);
                }
                break;
            case R.id.btn1:
                temp = temp + btn1.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn2:
                temp = temp + btn2.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn3:
                temp = temp + btn3.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn4:
                temp = temp + btn4.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn5:
                temp = temp + btn5.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn6:
                temp = temp + btn6.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn7:
                temp = temp + btn7.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn8:
                temp = temp + btn8.getText().toString();
                textView.setText(temp);
                break;
            case R.id.btn9:
                temp = temp + btn9.getText().toString();
                textView.setText(temp);
                break;
        }
    }

    public void onClickClear(View view) {
        btnClear = findViewById(R.id.btnClear);
        temp = "";
        textView.setText("0");
        result = 0;
    }

    public void onClickEqual(View view) {
        btnEqual = findViewById(R.id.btnEqual);
        op2 = Integer.parseInt(temp);
        switch (operator){
            case "+":
                result = op1 + op2;
                temp = String.valueOf(result);
                textView.setText(temp);
                break;
            case "-":
                result = op1 - op2;
                temp = String.valueOf(result);
                textView.setText(temp);
                break;
            case "*":
                result = op1 * op2;
                temp = String.valueOf(result);
                textView.setText(temp);
                break;
            case "/":
                if(op2 == 0){
                    textView.setText("Error");
                    break;
                }
                result = op1 / op2;
                temp = String.valueOf(result);
                textView.setText(temp);
                break;
        }
    }

    public void onClickOperator(View view) {
        btnMult = findViewById(R.id.btnMult);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDiv = findViewById(R.id.btnDiv);

        op1 = Integer.parseInt(temp);

//        In case you want to show the entire input sequence:
        switch (view.getId()){
            case R.id.btnPlus:
                operator = "+";
//                temp = temp + btnPlus.getText().toString();
//                textView.setText(temp);
                break;
            case R.id.btnMinus:
                operator = "-";
//                temp = temp + btnMinus.getText().toString();
//                textView.setText(temp);
                break;
            case R.id.btnMult:
                operator = "*";
//                temp = temp + btnPlus.getText().toString();
//                textView.setText(temp);
                break;
            case R.id.btnDiv:
                operator = "/";
//                temp = temp + btnPlus.getText().toString();
//                textView.setText(temp);
                break;
        }
        temp = "";
    }
}
