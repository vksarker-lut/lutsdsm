package com.example.learnerkid;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        EditText editTextFirstNum = findViewById(R.id.editTextFirstNumber);
        EditText editTextSecondNum = findViewById(R.id.editTextSecondNumber);
        TextView textViewOperation = findViewById(R.id.textViewOperation);
        TextView textViewResult = findViewById(R.id.textViewResult);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        editTextFirstNum.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                textViewOperation.setText("");
                textViewResult.setText("");
            }
        });

        editTextSecondNum.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                textViewOperation.setText("");
                textViewResult.setText("");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewOperation.setText("+");
                textViewResult.setText(String.valueOf( doOperation("+")));
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewOperation.setText("-");
                textViewResult.setText(String.valueOf( doOperation("-")));
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewOperation.setText("x");
                textViewResult.setText(String.valueOf( doOperation("*")));
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewOperation.setText("/");
                textViewResult.setText(String.valueOf( doOperation("/")));
            }
        });

    }

    private float doOperation(String operation) {
        float result = 0;

        EditText editTextFirstNum = findViewById(R.id.editTextFirstNumber);
        EditText editTextSecondNum = findViewById(R.id.editTextSecondNumber);

        String textNum1 = "" + editTextFirstNum.getText();
        String textNum2 = "" + editTextSecondNum.getText();

        if ((textNum1 != "") && (textNum2 != "")) {
            float firstNum = Float.parseFloat(textNum1);
            float secondNum = Float.parseFloat(textNum2);

            switch (operation) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    if (secondNum != 0) {
                        result = firstNum / secondNum;
                    }
                    else {
                        // Optional: Show warning: cannot divide by zero!
                    }
                    break;
                default:
                    break;

            }
        }

        return result;
    }
}