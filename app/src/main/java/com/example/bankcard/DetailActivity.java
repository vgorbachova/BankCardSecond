package com.example.bankcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_KEY_POSITION = "extra_key_position";
    TextView cardNumber, ownerName, expires, pin, balance;
    BankCard bankCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        cardNumber = findViewById(R.id.cardNumber);
        ownerName = findViewById(R.id.ownerName);
        expires = findViewById(R.id.expires);
        pin = findViewById(R.id.pin);

        balance = findViewById(R.id.balance);

        int itemPosition = getIntent().getIntExtra(EXTRA_KEY_POSITION, -1);
        if (0>itemPosition)
            finish();
        bankCard = BankCardManager.getCard(itemPosition);

        cardNumber.setText(bankCard.getNum());
        ownerName.setText(bankCard.getOwnerName());
        expires.setText(bankCard.getDate());
        pin.setText(bankCard.getPin());
        balance.setText(String.format(Locale.getDefault(), "%.2f", bankCard.getAmount()));
    }
}
