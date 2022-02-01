package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {

        double amount = 200;
        double expectedValue = 196;
        Account acc = AccountFactory.createEmptyAccount();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());

    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {

        double expectedValue = 100;
        Account acc = AccountFactory.createAccount(100d);
        double amount = -200;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalance() {

        double expectedValue = 0;
        Account acc = AccountFactory.createAccount(800d);

        acc.fullWithdraw();

        Assertions.assertEquals(expectedValue, acc.getBalance());


    }

    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
        Account acc = AccountFactory.createAccount(800.0);
        acc.withdraw(500.0);
        Assertions.assertEquals(300.0,acc.getBalance());
    }

    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = AccountFactory.createAccount(800.0);
            acc.withdraw(900.0);
        });
    }


}
