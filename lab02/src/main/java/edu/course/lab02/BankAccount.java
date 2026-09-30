package edu.course.lab02;

public class BankAccount {

    private int balance;

    public BankAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным.");
        }
        this.balance = initialBalance;
    }
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной.");
        }
        this.balance += amount;
    }
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма списания должна быть больше нуля.");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Сумма снятия не может превышать баланс.");
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }
}