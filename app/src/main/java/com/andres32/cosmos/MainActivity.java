package com.andres32.cosmos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Получаем ссылку на кнопку открытия MessengerActivity
        Button messengerButton = (Button) findViewById(R.id.messenger_button);
        //Устанавливаем для этой кнопки слушателя для нажатия
        messengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Создаем Intent для открытия MessengerActivity
                Intent intent = new Intent(MainActivity.this, MessengerActivity.class);
                //Открываем
                startActivity(intent);
            }
        });
    }
}
