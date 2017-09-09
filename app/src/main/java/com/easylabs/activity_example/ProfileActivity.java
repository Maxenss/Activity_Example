package com.easylabs.activity_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView tvCorrect;
    // Для теста
    String userLogin = "admin";
    String userPassword = "8888";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvCorrect = (TextView) findViewById(R.id.tvCorrect);

        // Получаем намерение, которое запустило данное Activity
        // и получаем все данные, которые пометсили в него
        Intent intent = getIntent();

        // Получаем данные из намерения
        String login = intent.getStringExtra(Data.KEY_LOGIN);
        String password = intent.getStringExtra(Data.KEY_PASSWORD);

        if (login.equals(userLogin) && password.equals(userPassword))
            tvCorrect.setText("Введен правильный логин и пароль");
        else
            tvCorrect.setText("Введен неправильный логин и пароль");
    }
}
