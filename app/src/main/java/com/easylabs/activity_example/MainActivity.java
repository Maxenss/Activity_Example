package com.easylabs.activity_example;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etLogin;
    EditText etPassword;
    Button btSignIn;
    Button btShowPassword;
    Button btSignUp;
    boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btSignIn = (Button) findViewById(R.id.btSignIn);
        btSignUp = (Button) findViewById(R.id.btSignUp);
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

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = "";
                String password = "";

                // Считываем данные с полей для ввода
                login = etLogin.getText().toString();
                password = etPassword.getText().toString();

                if (login.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Введите логин для регистрации",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Введите пароль для регистрации",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    SharedPreferences sPref =
                            MainActivity.this.getSharedPreferences(Data.SP_KEY_USERS, MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString(Data.SP_KEY_LOGIN, login);
                    ed.commit();
                    ed.putString(Data.SP_KEY_PASSWORD, password);
                    ed.commit();
                    Toast.makeText(MainActivity.this, "Запись в файл прошла успешно", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Произошла ошибка при записи в файл", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isShow = !isShow;

                if (isShow)
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                else
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
    }

}
