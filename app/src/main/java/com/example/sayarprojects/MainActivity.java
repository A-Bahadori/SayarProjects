package com.example.sayarprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "سلام به شما!", Toast.LENGTH_LONG).show();

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('+');
            }
        });

        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('-');
            }
        });

        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('*');
            }
        });

        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayResult('/');
            }
        });

        Button buttonNavigateToSecond = findViewById(R.id.buttonNavigateToSecond);
        buttonNavigateToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_second.class);
                startActivity(intent);
            }
        });

        Button buttonNavigateToInputData = findViewById(R.id.buttonNavigateToInputData);
        buttonNavigateToInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_input_data.class);
                startActivity(intent);
            }
        });
    }

    private void calculateAndDisplayResult(char operator) {
        String strNumber1 = editTextNumber1.getText().toString();
        String strNumber2 = editTextNumber2.getText().toString();

        if (strNumber1.isEmpty() || strNumber2.isEmpty()) {
            textViewResult.setText("لطفاً اعداد را وارد کنید.");
            return;
        }

        double number1 = Double.parseDouble(strNumber1);
        double number2 = Double.parseDouble(strNumber2);
        double result = 0;

        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    textViewResult.setText("تقسیم بر صفر ممنوع است.");
                    return;
                }
                break;
        }

        textViewResult.setText("نتیجه: " + result);
    }
}