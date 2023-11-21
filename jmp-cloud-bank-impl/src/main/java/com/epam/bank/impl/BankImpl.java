package com.epam.bank.impl;

import com.epam.bank.Bank;
import com.epam.dto.*;

import java.util.Random;
import java.util.function.BiFunction;

public class BankImpl implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return switch (bankCardType) {
            case DEBIT -> createNewCard(DebitBankCard::new, user);
            case CREDIT -> createNewCard(CreditBankCard::new, user);
        };
    }

    private BankCard createNewCard(BiFunction<String, User, BankCard> function, User user) {
        return function.apply(createCardNumber(), user);
    }

    private String createCardNumber() {
        return String.valueOf(Math.abs(new Random().nextLong())).substring(0, 17);
    }
}
