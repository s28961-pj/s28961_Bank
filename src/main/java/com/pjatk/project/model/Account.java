package com.pjatk.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

enum Waluta {
    PLN, EUR, USD
}
@NoArgsConstructor
@Data
public class Account {
    private Integer id;
    private Integer pesel;
    private Double saldo_poczatkowe;
    private Waluta waluta;
    private String imie;
    private String nazwisko;

}
