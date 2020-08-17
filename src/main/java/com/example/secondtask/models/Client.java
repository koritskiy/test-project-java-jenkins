package com.example.secondtask.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    // ID клиента
    private
    @Id
    @GeneratedValue
    long id;

    // Имя клиента
    private String firstName;

    // Фамилия клиента
    private String lastName;

    // Серия паспорта
    private int passportSeries;

    // Номер паспорта
    private int passportNumber;

    // Обратная сторона связи с заявкой
    @OneToMany(mappedBy = "applicant")
    @PrimaryKeyJoinColumn
    private List<Application> applications;

    @OneToMany(mappedBy = "guarantor")
    @PrimaryKeyJoinColumn
    private List<Application> applicationsAsGuarantor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Phone> phones;
}
