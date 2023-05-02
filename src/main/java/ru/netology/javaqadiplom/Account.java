package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;
   // public Account(int balance, int rate) {
       // this.balance = balance;
       // this.rate = rate;
   // }

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int newRate) {
        if (newRate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной, а у вас: " + rate
            );
        } else {
            rate = newRate;
        }
    }

}
