package com.example.secondtask.repository;

import com.example.secondtask.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findApplicationById(Long id);
}
