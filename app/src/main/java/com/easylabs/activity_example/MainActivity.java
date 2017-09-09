package com.easylabs.activity_example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etLogin;
    EditText etPassword;
    Button btSignIn;
    Button btShowPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btSignIn = (Button) findViewById(R.id.btSignIn);
        btShowPassword = (Button) findViewById(R.id.btShowPassword);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = "";
                String password = "";

                try {
                    // Считываем данные с полей для ввода
                    login = etLogin.getText().toString();
                    password = etPassword.getText().toString();

                    // Создаём намерение для запуска ProfileActivity
                    Intent intent = new Intent(MainActivity.this,
                            ProfileActivity.class);
                    // Помещаем данные в намерение
                    intent.putExtra(Data.KEY_LOGIN, login);
                    intent.putExtra(Data.KEY_PASSWORD, password);
                    // Запускаем Activity
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        btShowPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
                else
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
    }
}
