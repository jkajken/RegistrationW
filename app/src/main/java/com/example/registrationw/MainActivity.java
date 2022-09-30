package com.example.registrationw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button enter_button = findViewById(R.id.btn_enter);
        EditText editText1 = findViewById(R.id.Email_edit);
        EditText editText2 = findViewById(R.id.password);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText1.toString().trim().length() > 0) {
                    enter_button.setBackgroundColor(Color.YELLOW);
                } else {
                    enter_button.setBackgroundColor(Color.GRAY);

                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText2.toString().trim().length() > 0) {
                    enter_button.setBackgroundColor(Color.YELLOW);
                } else {
                    enter_button.setBackgroundColor(Color.GRAY);

                }
            }
        });
        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().toString().equals("admin") | editText2.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this,
                            "Вы успешно зарегистрировались!", Toast.LENGTH_SHORT).show();
                    editText1.setVisibility(View.GONE);
                    editText2.setVisibility(View.GONE);
                    enter_button.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}