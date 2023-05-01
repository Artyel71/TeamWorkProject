package ru.netology.javaqadiplom;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3000);

        Assertions.assertEquals(4000, account.getBalance());
    }
    @Test
    public void shouldAddIfBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }
    @Test
    public void shouldAddIfBalanceNegative() {
        CreditAccount account = new CreditAccount(
                -1000,
                5_000,
                15
        );

        account.add(3000);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldPayIfPositiveBalance() {
        CreditAccount account = new CreditAccount(
                5000,
                5000,
                15
        );
        account.pay(1000);
        Assertions.assertEquals(4000, account.getBalance());
    }
    @Test
    public void shouldPayIfBalanceZeroUnderCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );
        account.pay(1000);
        Assertions.assertEquals(-1000, account.getBalance());
    }
    @Test
    public void shouldPayIfOverCreditLimit() {
        CreditAccount account = new CreditAccount(
                1000,
                5000,
                15
        );
        account.pay(8000);
        Assertions.assertEquals(1000, account.getBalance());
    }
    @Test
    public void shouldPayIfEqualCreditLimit() {
        CreditAccount account = new CreditAccount(
                1000,
                5000,
                15
        );
        account.pay(6000);
        Assertions.assertEquals(-5000, account.getBalance());
    }
    @Test
    public void shouldThrowException(){
        CreditAccount account = new CreditAccount(
                -5000,
                5000,
                -23
        );

        Assertions.assertThrows(IllegalArgumentException.class,() -> account.getRate());
    }
    @Test
    public void shouldCalculateYearChange() {
        CreditAccount account = new CreditAccount(-200,
                5000,
                15
        );
        Assertions.assertEquals(-30,account.yearChange());
    }

    @Test
    public void shouldNotCalculateYearChangeIfPositiveBalance() {
        CreditAccount account = new CreditAccount(200,
                5000,
                15
        );
        Assertions.assertEquals(0,account.yearChange());
    }
    @Test
    public void shouldCalculateYearChangeIfZeroBalance() {
        CreditAccount account = new CreditAccount(0,
                5000,
                15
        );
        Assertions.assertEquals(0,account.yearChange());
    }
}
