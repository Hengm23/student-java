package edu.course.lab02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    @DisplayName("Успешное списание уменьшает баланс")
    void shouldWithdrawSuccessfully() {
        BankAccount account = new BankAccount(100);

        account.withdraw(40);

        assertEquals(60, account.getBalance());
    }

    @Test
    @DisplayName("Выброс исключения при попытке списать больше текущего баланса")
    void shouldThrowExceptionWhenWithdrawingMoreThanBalance() {
        BankAccount account = new BankAccount(50);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100));
    }

    @Test
    @DisplayName("Выброс исключения при списании нуля или отрицательной суммы")
    void shouldThrowExceptionWhenWithdrawingNonPositiveAmount() {
        BankAccount account = new BankAccount(50);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
    }

    @Test
    @DisplayName("Выброс исключения при создании счета с отрицательным балансом")
    void shouldThrowExceptionForNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-10));
    }

    @Test
    @DisplayName("Успешное пополнение увеличивает баланс")
    void shouldDepositSuccessfully() {
        BankAccount account = new BankAccount(50);

        account.deposit(50);

        assertEquals(100, account.getBalance());
    }

    @Test
    @DisplayName("Выброс исключения при пополнении на отрицательную сумму")
    void shouldThrowExceptionForNegativeDeposit() {
        BankAccount account = new BankAccount(50);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }
}