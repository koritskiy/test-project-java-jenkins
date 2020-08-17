package com.example.secondtask.dto;

import com.example.secondtask.models.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ApplicationDto {
    // Номер заявки на кредит
    private int number;

    // Сумма кредита в рублях
    private int amount;

    // Валюта
    private String currency;

    // Связь с данными заемщика
    private ClientDto applicant;

    // Связь с данными поручителя
    private ClientDto guarantor;
}
