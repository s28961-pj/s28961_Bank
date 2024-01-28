package com.pjatk.project.service;

import com.pjatk.project.model.Account;
import com.pjatk.project.model.Currency;
import com.pjatk.project.repository.AccountRepository;
import jakarta.xml.bind.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private static AccountRepository accountRepository;
    private static AccountService accountService;

    @BeforeAll
    static void setUp() {
        accountRepository = new AccountRepository();
        accountService = new AccountService(accountRepository);
    }

    @AfterEach
    void cleanUp() {
        accountRepository.clearAccountList();
    }

    @Test
    void shouldAddAccount() {
        Account account = new Account(0, 93042211111L, 100.0, Currency.PLN, "Roland", "Liedtke");

        Account result = assertDoesNotThrow(() -> accountService.addAccount(account));
        assertEquals(account.getFirstName(), result.getFirstName());
        assertNotNull(result.getId());
    }
}
