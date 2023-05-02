package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {//пополнение в интервале мин макс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15

        );

        account.add(3000);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldNotAddMoreThanMaxBalance() {//пополнение в интервале больше макс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15

        );

        account.add(9000);

        Assertions.assertEquals(2000, account.getBalance());

    }

    @Test
    public void shouldThrowExceptionMinBalanceAboveMaxBalance() {//минимальный баланс не может быть больше максимального
        SavingAccount account = new SavingAccount(
                2_000,
                10_000,
                1_000,
                15
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.add(300);
        });

    }

    @Test
    public void shouldThrowExceptionNegativeMinBalance() {//минимальный баланс не может быть отрицательным
        SavingAccount account = new SavingAccount(
                2_000,
                -1_000,
                10_000,
                15

        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.add(3000);
        });
    }

    @Test
    public void shouldPayInBorderMinBalance() {// нижняя граница при оплате
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15

        );
        account.pay(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfBalanceNegative() {//оплата не должна проходить, если баланс становится отрицательным

        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15

        );


        account.pay(1001);

        Assertions.assertEquals(2000, account.getBalance());

    }

    @Test
    public void shouldAddPercent() {//добавление процента
        SavingAccount account = new SavingAccount(
                2_00,
                1_00,
                10_000,
                15

        );


        Assertions.assertEquals(30, account.yearChange());
    }

    @Test
    public void shouldNotAddPercentIfIncorrectParams() {
        SavingAccount account = new SavingAccount(
                20_000,
                1_000,
                10_000,
                15

        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldThrowExceptionIfRateNegative() {
        SavingAccount account = new SavingAccount(
                4000,
                1_000,
                10_000,
                -15

        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.setRate(-15));
    }


}