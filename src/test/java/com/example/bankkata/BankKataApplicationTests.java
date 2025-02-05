package com.example.bankkata;

import com.example.bankkata.application.service.AccountService;
import com.example.bankkata.domain.model.Transaction;
import com.example.bankkata.domain.port.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BankKataApplicationTests {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void contextLoads() {
        assertNotNull(accountService, "AccountService should be autowired");
        assertNotNull(accountRepository, "AccountRepository should be autowired");
        
        double initialBalance = accountRepository.getAccount().getBalance();
        double depositAmount = 100.0;
        
        Transaction depositTransaction = accountService.deposit(depositAmount);
        
        assertNotNull(depositTransaction, "Deposit should return a transaction");
        assertEquals(depositAmount, depositTransaction.getAmount(), "Deposit amount should match");
        assertEquals(initialBalance + depositAmount, accountRepository.getAccount().getBalance(), "Balance should be updated after deposit");
    }
}
