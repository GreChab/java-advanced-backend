package com.epam.service;

import com.epam.dto.BankCard;
import com.epam.dto.Subscription;
import com.epam.dto.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);
    List<User> getAllUsers();
    void createUser(User user);
    double getAverageUsersAge();
    static boolean isPayableUser(User user) {
        return LocalDate.now().getYear() - user.getBirthday().getYear() > 18;
    }
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);
}
