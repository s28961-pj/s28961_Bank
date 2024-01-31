package com.pjatk.project.model;

import com.pjatk.project.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private static Account account;

    @BeforeEach
    void setUp() {
        account = new Account(0, 93042299999L, 1000.0, Currency.USD, "Jan", "Kowalski");
    }

    @Test
    void shouldGetPesel() {
        long pesel = 93042299999L;
        assertEquals(account.getPesel(), pesel);
    }

    @Test
    void shouldGetBalance() {
        Double balance = 1000.0;
        assertEquals(account.getBalance(), balance);
    }

    @Test
    void shouldGetCurrency() {
        Currency currency = Currency.USD;
        assertEquals(account.getCurrency(), currency);
    }

    @Test
    void shouldGetFirstName() {
        String firstName = "Jan";
        assertEquals(account.getFirstName(), firstName);
    }

    @Test
    void shouldGetLastName() {
        String lastName = "Kowalski";
        assertEquals(account.getLastName(), lastName);
    }

    @Test
    void shouldSetPesel() {
        long pesel = 87654321987L;
        account.setPesel(pesel);
        assertEquals(account.getPesel(), pesel);
    }

    @Test
    void shouldSetBalance() {
        Double balance = 100.0;
        account.setBalance(balance);
        assertEquals(account.getBalance(), balance);
    }

    @Test
    void setCurrency() {
        Currency currency = Currency.PLN;
        account.setCurrency(currency);
        assertEquals(account.getCurrency(), currency);
    }

    @Test
    void setFirstName() {
        String firstName = "John";
        account.setFirstName(firstName);
        assertEquals(account.getFirstName(), firstName);
    }

    @Test
    void setLastName() {
        String lastName = "Rambo";
        account.setLastName(lastName);
        assertEquals(account.getLastName(), lastName);
    }
}