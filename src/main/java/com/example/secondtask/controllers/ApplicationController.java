package com.example.secondtask.controllers;

import com.example.secondtask.dto.ApplicationDto;
import com.example.secondtask.mappers.ApplicationMapper;
import com.example.secondtask.models.Application;
import com.example.secondtask.services.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    /**
     * /api rest-controller, post method
     * @param applicationDto application-data
     * @return status of application
     */
    @PostMapping("/api")
    ResponseEntity<String> newApplication(@RequestBody ApplicationDto applicationDto){
        applicationService.createApplication(applicationDto);
        return new ResponseEntity<String>("Application is created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/api/applications")
    ResponseEntity<List<ApplicationDto>> allApplications(){
        return new ResponseEntity<List<ApplicationDto>>(applicationService.getApplications(), HttpStatus.OK);
    }
}
