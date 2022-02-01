package entities;

public class Account {

    public static Double DEPOSIT_FEE_PERCENTAGE = 0.02;

    private Long id;
    private Double balance;

    public Account() {}

    public Account(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double amount) {
        if (amount > 0) {
            amount-= amount * DEPOSIT_FEE_PERCENTAGE;
            this.balance+=amount;
        }
    }

    public void withdraw(Double amount) {
        if (amount > this.balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Double fullWithdraw() {
        Double aux = this.balance;
        this.balance = 0d;
        return aux;
    }


}
