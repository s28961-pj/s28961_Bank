package com.pjatk.project.service;

import com.pjatk.project.model.Account;
import com.pjatk.project.repository.AccountRepository;
import jakarta.xml.bind.ValidationException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addAccount(Account account) throws ValidationException {
        if (account.getPesel() < 10000000000L || account.getPesel() > 99999999999L) {
            throw new ValidationException("Wrong PESEL!");
        } else if (account.getBalance() < 0) {
            throw new ValidationException("Wrong balance!");
        } else if (account.getFirstName().isBlank() || account.getFirstName().isEmpty()) {
            throw new ValidationException("FirstName field is EMPTY!");
        } else if (account.getLastName().isBlank() || account.getLastName().isEmpty()) {
            throw new ValidationException("FirstName field is EMPTY!");
        } else accountRepository.addAccount(account);
    }

    public Account getAccountById(Integer id) {
        return accountRepository.getAccountById(id);
    }

    public List<Account> getAccountListByBalanceMoreThan(Double balance) {
        List<Account> moreThan = accountRepository.getAccountListByBalanceMoreThan(balance);
        return moreThan;
    }

    public List<Account> getAccountList() throws ValidationException {
        if(accountRepository.getAccountList().isEmpty() || accountRepository.getAccountList() == null) {
            throw new ValidationException("Account List is EMPTY! ");
        } else return accountRepository.getAccountList();
    }
}
