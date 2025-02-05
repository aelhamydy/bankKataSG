package com.example.bankkata.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private double balance = 0;

    public Transaction deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balance += amount;
        return new Transaction(java.time.LocalDateTime.now(), amount, balance, TransactionType.DEPOSIT);
    }

    public Transaction withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        return new Transaction(java.time.LocalDateTime.now(), amount, balance, TransactionType.WITHDRAWAL);
    }
}
