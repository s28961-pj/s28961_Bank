package com.pjatk.project.repository;

import com.pjatk.project.model.Account;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class AccountRepository {
    private List<Account> accountList = new ArrayList<>();

    public Account addAccount(Account account) {
        account.setId(accountList.size());
        accountList.add(account);
        return account;
    }

    public Account getAccountById(Integer id) {
        return accountList.get(id);
    }

    public List<Account> getAccountListByBalanceMoreThan(Double balance) {
        return accountList.stream().filter(account -> account.getBalance() >= balance).toList();
    }

    public void clearAccountList() {
        accountList = new ArrayList<>();
    }
}
