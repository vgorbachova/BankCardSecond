package com.example.bankcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddCardActivity extends AppCompatActivity implements View.OnClickListener {
    EditText cardNumber, ownerName, expires, pin;
    Button addCard, btCollor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        cardNumber = findViewById(R.id.cardNumber);
        ownerName = findViewById(R.id.ownerName);
        expires = findViewById(R.id.expires);
        pin = findViewById(R.id.pin);
        addCard = findViewById(R.id.addCardButton);
        addCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String ownerNameStr = ownerName.getText().toString();
        String numSrt = cardNumber.getText().toString();
        String dateStr = expires.getText().toString();
        String pinStr = pin.getText().toString();
        BankCard bankCard = new BankCard(ownerNameStr, numSrt, dateStr, pinStr, 0f);
        BankCardManager.addBankCard(bankCard);
        finish();
    }


}
