package com.pjatk.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Account {
    private Integer id;
    private long pesel;
    private Double balance;
    private Currency currency;
    private String firstName;
    private String lastName;

}
