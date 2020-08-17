package com.example.secondtask.services;

import com.example.secondtask.dto.ApplicationDto;
import com.example.secondtask.mappers.ApplicationMapper;
import com.example.secondtask.models.Application;
import com.example.secondtask.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    ApplicationImpl(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void createApplication(ApplicationDto applicationDto) {
        Application application = ApplicationMapper.INSTANCE.applicationDtoToApplication(applicationDto);
        applicationRepository.save(application);
    }

    @Override
    public List<ApplicationDto> getApplications() {
        return applicationRepository.findAll()
                .stream()  // сделали "стрим" из листа
                .map(ApplicationMapper.INSTANCE::applicationToApplicationDto) // преобразовали каждый элемент стрима,
                                                                              // применив функцию из маппера
                .collect(Collectors.toList()); // собрали стрим в лист
    }
}
