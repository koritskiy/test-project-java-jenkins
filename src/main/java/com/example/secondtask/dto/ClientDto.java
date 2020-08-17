package com.example.secondtask.dto;

import lombok.Data;

@Data
public class ClientDto {
    // Имя
    private String firstName;

    // Фамилия
    private String lastName;

    // Номер паспорта
    private String passport;

    // Мобильный телефон
    private String mobilePhone;

    // Домашний телефон
    private String homePhone;
}
