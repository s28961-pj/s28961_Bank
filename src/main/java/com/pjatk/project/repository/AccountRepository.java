package com.pjatk.project.repository;

import com.pjatk.project.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {
    private List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account) {
        account.setId(accountList.size());
        accountList.add(account);
    }

    public Account getAccountById(Integer id) {
        return accountList.get(id);
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
