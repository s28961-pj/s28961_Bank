package com.pjatk.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

enum Currency {
    PLN, EUR, USD
}
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
