package com.epam.service.impl;

import com.epam.dto.BankCard;
import com.epam.dto.Subscription;
import com.epam.dto.User;
import com.epam.service.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ServiceImpl implements Service {
    private final List<Subscription> subscriptions = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        subscriptions.add(new Subscription(bankCard.getNumber(), LocalDate.now()));
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return subscriptions.stream()
                .filter(s -> bankCardNumber.equals(s.getBankCard()))
                .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public double getAverageUsersAge() {
        var allUsers = getAllUsers();
        var sumOfAge = allUsers.stream()
                .map(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()))
                .mapToLong(Long::valueOf)
                .sum();
        return (double) sumOfAge / allUsers.size();
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        return subscriptions.stream()
                .filter(predicate)
                .toList();
    }
}
