package com.github.kubrabal;

public class BankAccount {

    private double balance = 1000.0; // varsayılan hesap bakiyesi

    public double checkBalance(int accountNumber) throws InvalidAccountException, InsufficientBalanceException, AccountFrozenException {
        // Hesap numarası doğrulama
        if (accountNumber != 123456) {
            throw new InvalidAccountException("Geçersiz hesap numarası");
        }

        // Hesap dondurulmuş mu kontrolü
        if (isAccountFrozen(accountNumber)) {
            throw new AccountFrozenException("Hesap dondurulmuş durumda");
        }

        // Bakiye kontrolü
        if (balance < 100) {
            throw new InsufficientBalanceException("Yetersiz bakiye");
        }

        return balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Yetersiz bakiye");
        }
        balance -= amount;
    }

    public void freezeAccount(int accountNumber) {

    }

    private boolean isAccountFrozen(int accountNumber) {
        // Hesap dondurulmuş mu kontrolü için varsayılan değer
        return false;
    }
}

