package com.epam.dto;

import java.time.LocalDate;

public class Subscription {
    String bankCard;
    LocalDate startDate;

    public Subscription(String bankCard, LocalDate startDate) {
        this.bankCard = bankCard;
        this.startDate = startDate;
    }

    public String getBankCard() {
        return bankCard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "com.epam.dto.Subscription{" +
                "bankCard='" + bankCard + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
