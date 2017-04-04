package com.andres32.cosmos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessengerActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String EMPTY = ""; //константа содержащая пустую строку
    private static final String NEW_LINE = "\n"; //константа для символа перевода строки

    private TextView history; //поле класса, которое хранит ссылку на View, кото
    private EditText message; //поле класса для View, в которое можно вводить новое сообщение

    private StringBuilder stringBuilder = new StringBuilder(); //создаем StringBuilder, который будет хранить историю сообщений

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messanger); //устанавливаем layout для текущей Activity

        history = (TextView) findViewById(R.id.history); //получаем ссылку на View с историей сообщений
        history.setMovementMethod(new ScrollingMovementMethod()); //разрешаем скроллить историю

        message = (EditText) findViewById(R.id.message); //получаем ссылку на поле ввода сообщения
        Button send = (Button) findViewById(R.id.send); //Получаем ссылку на кнопку Отправить

        /*
        устанавливаем слушателем события нажатия
        на кнопку оправить текущий класс (MessengerActivity)
        */
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { //метод, который вызывается при нажатии на кнопку
        if (v.getId() == R.id.send) { //проверяем, что View, на которую нажали это наша кнопка Отправить
            String text = message.getText().toString(); //Получаем строку, которую пользователь ввел в поле ввода

            if (!TextUtils.isEmpty(text)) { //если пользователь ничего не ввел - не нужно добавлять перевод строки
                stringBuilder.append(NEW_LINE); //добавляется перевод строки
            }

            stringBuilder.append(text); //добавляем сообщение, которое ввел пользователь в конец истории
            message.setText(EMPTY); //удаляем введенное сообщение из поля ввода

            history.setText(stringBuilder); //обновляем историю сообщений
        }
    }
}
