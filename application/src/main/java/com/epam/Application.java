package com.epam;

import com.epam.bank.Bank;
import com.epam.dto.*;
import com.epam.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ServiceLoader;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        var bank = ServiceLoader.load(Bank.class).findFirst().orElseThrow();
        var service = ServiceLoader.load(Service.class).findFirst().orElseThrow();

        var user1 = new User("John", "Grisham", LocalDate.of(1955, 2, 8));
        var user2 = new User("Tom", "Clancy", LocalDate.of(1965, 8, 15));
        var bankCards = new ArrayList<BankCard>();
        bankCards.add(bank.createBankCard(user1, BankCardType.CREDIT));
        bankCards.add(bank.createBankCard(user1, BankCardType.DEBIT));
        bankCards.add(bank.createBankCard(user2, BankCardType.DEBIT));
        bankCards.add(bank.createBankCard(user2, BankCardType.CREDIT));

        bankCards.forEach(service::subscribe);
        service.createUser(user1);
        service.createUser(user2);

        bankCards.stream()
                .map(BankCard::getNumber)
                .map(service::getSubscriptionByBankCardNumber)
                .forEach(System.out::println);

        service.getAllUsers().forEach(System.out::println);
        System.out.println("The average age of all users is: "+ service.getAverageUsersAge());

        service.getAllUsers().stream()
                .filter(Service::isPayableUser)
                .forEach(user -> System.out.println("com.epam.dto.User: " + user.getName() + " " + user.getSurname() + " is over 18 years old"));

        service.getSubscriptionByBankCardNumber("111").orElseThrow(() -> new NoSuchSubscriptionException("Subscription for this card does not exists"));

        Predicate<Subscription> isSubscriptionAfter2010 = subscription -> subscription.getStartDate().getYear() > 2010;

        service.getAllSubscriptionsByCondition(isSubscriptionAfter2010).forEach(System.out::println);
    }
}
