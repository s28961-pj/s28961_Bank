package com.pjatk.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjatk.project.model.Account;
import com.pjatk.project.model.Currency;
import com.pjatk.project.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class AccountControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        accountRepository.clearAccountList();
    }

    @Test
    void shouldCreateNewAccount() throws JsonProcessingException {
        Account account = new Account(0, 93042299999L, 1000.0, Currency.USD, "Jan", "Kowalski");
        String json = objectMapper.writeValueAsString(account);

        Account result = webTestClient.post().uri("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(json)
                .exchange()
                .expectStatus().isEqualTo(201)
                .expectBody(Account.class)
                .returnResult().getResponseBody();

        assertEquals(result.getFirstName(), account.getFirstName());
        assertEquals(result.getLastName(), account.getLastName());
    }

    @Test
    void shouldReturnAllAccounts() {
        Account account1 = new Account(0, 93042299999L, 1000.0, Currency.USD, "Jan", "Kowalski");

        accountRepository.addAccount(account1);

        List<Account> result = webTestClient.get().uri("/accounts")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Account.class)
                .returnResult().getResponseBody();

        assertEquals(result.get(0).getFirstName(), account1.getFirstName());
        assertEquals(1, result.size());
    }

}