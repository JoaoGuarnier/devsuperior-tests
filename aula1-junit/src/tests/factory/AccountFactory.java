package tests.factory;

import entities.Account;

public class AccountFactory {

    public static Account createEmptyAccount() {
        return new Account(1l,0d);
    }

    public static Account createAccount(double initialBalance) {
        return new Account(1l, initialBalance);
    }

}
