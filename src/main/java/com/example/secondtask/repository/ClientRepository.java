package com.example.secondtask.repository;

import com.example.secondtask.models.Application;
import com.example.secondtask.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientById(Long id);
}
