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

    TextView textView;
    int result = 0;
    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNumber(View view) {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        textView = (TextView) findViewById(R.id.textView);

        switch (view.getId()){
            case R.id.btn0:
                temp = temp + btn0.getText().toString();
                textView.setText(temp);
                int num0 = Integer.parseInt(temp);
                break;
            case R.id.btn1:
                temp = temp + btn1.getText().toString();
                textView.setText(temp);
                int num1 = Integer.parseInt(temp);
                break;
            case R.id.btn2:
                temp = temp + btn2.getText().toString();
                textView.setText(temp);
                int num2 = Integer.parseInt(temp);
                break;
            case R.id.btn3:
                temp = temp + btn3.getText().toString();
                textView.setText(temp);
                int num3 = Integer.parseInt(temp);
                break;
            case R.id.btn4:
                temp = temp + btn4.getText().toString();
                textView.setText(temp);
                int num4 = Integer.parseInt(temp);
                break;
            case R.id.btn5:
                temp = temp + btn5.getText().toString();
                textView.setText(temp);
                int num5 = Integer.parseInt(temp);
                break;
            case R.id.btn6:
                temp = temp + btn6.getText().toString();
                textView.setText(temp);
                int num6 = Integer.parseInt(temp);
                break;
            case R.id.btn7:
                temp = temp + btn7.getText().toString();
                textView.setText(temp);
                int num7 = Integer.parseInt(temp);
                break;
            case R.id.btn8:
                temp = temp + btn8.getText().toString();
                textView.setText(temp);
                int num8 = Integer.parseInt(temp);
                break;
            case R.id.btn9:
                temp = temp + btn9.getText().toString();
                textView.setText(temp);
                int num9 = Integer.parseInt(temp);
                break;
        }
    }

    public void onClickClear(View view) {
        textView.setText("0");
        temp = "";
        result = 0;
    }

    public void onClickEqual(View view) {

    }

    public void onClickOperator(View view) {
        Button btnMult = (Button) findViewById(R.id.btnMult);
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnEqual = (Button) findViewById(R.id.btnEqual);
        Button btnClear = (Button) findViewById(R.id.btnClear);

        switch (view.getId()){
            case R.id.btnPlus:
                int num1 = Integer.parseInt(temp);
                break;
            case R.id.btnMinus:
        }
    }
}
