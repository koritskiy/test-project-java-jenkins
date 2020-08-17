package com.example.secondtask.services;

import com.example.secondtask.dto.ApplicationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationService {
    void createApplication(ApplicationDto applicationDto);
    List<ApplicationDto> getApplications();
}
