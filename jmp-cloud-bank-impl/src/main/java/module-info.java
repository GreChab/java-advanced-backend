module jmp.cloud.bank.impl{
    requires transitive jmp.bank.api;
    requires jmp.dto;
    provides com.epam.bank.Bank with com.epam.bank.impl.BankImpl;
}