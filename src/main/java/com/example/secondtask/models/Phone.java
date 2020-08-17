package com.example.secondtask.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Phone {
    // ID телефона
    private @Id
    @GeneratedValue
    long id;

    // Тип телефона
    private String type;

    // Номер телефона
    private String number;

    // Связь с клиентов
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Client client;
}
