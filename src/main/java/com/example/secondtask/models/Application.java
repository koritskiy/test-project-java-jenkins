package com.example.secondtask.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Application {
    // ID заявки
    private
    @Id
    @GeneratedValue
    long id;

    // Номер заявки на кредит
    @NotNull
    private int number;

    // Сумма кредита в рублях
    private int amount;

    // Валюта
    private String currency;

    // Связь с данными заемщика
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id")
    private Client applicant;

    // Связь с данными поручителя
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guarantor_id")
    private Client guarantor;


}
