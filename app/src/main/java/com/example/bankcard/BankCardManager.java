package com.example.bankcard;

import java.util.ArrayList;
import java.util.List;

public class BankCardManager {
    private static List<BankCard> bankCards = new ArrayList<BankCard>() {{
       add(new BankCard("Danya", "1234 5678 9012 4578", "21.02.2017","1234", 1000f));
       add(new BankCard("Vanya", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
       add(new BankCard("Olya", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
       add(new BankCard("Kira", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
       add(new BankCard("Misha", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
       add(new BankCard("Masyanya", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
       add(new BankCard("Mikhalich", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
       add(new BankCard("Lesha", "1234 5678 9012 4578", "21.02.2017","1234", 1000f));
       add(new BankCard("Vitalik", "1234 5678 9012 4578", "21.02.2017", "1234", 1000f));
    }};
    public static void addBankCard (BankCard bankCard) {
        bankCards.add(bankCard);
    }
    public static BankCard getCard (int index) {
        return bankCards.get (index);
    }


    public static int getCardsCount() {
        return bankCards.size();
    }
}
