module application {
    requires jmp.cloud.service.impl;
    requires jmp.cloud.bank.impl;
    requires jmp.dto;
    uses com.epam.service.Service;
    uses com.epam.bank.Bank;
}