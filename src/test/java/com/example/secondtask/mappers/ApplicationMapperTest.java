package com.example.secondtask.mappers;

import com.example.secondtask.dto.ApplicationDto;
import com.example.secondtask.dto.ClientDto;
import com.example.secondtask.models.Application;
import com.example.secondtask.models.Client;
import com.example.secondtask.models.Phone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ApplicationMapperTest {
    /**
     * Тестирование Entity -> Dto
     */
    @Test
    public void convertApplicationEntityToApplicationDto() {
        Application application = new Application();

        application.setNumber(1200);
        application.setAmount(1_000_000);
        application.setCurrency("rub");
        application.setApplicant(null);
        application.setGuarantor(null);

        ApplicationDto applicationDto = ApplicationMapper.INSTANCE.applicationToApplicationDto(application);
        Assert.assertEquals(application.getNumber(), applicationDto.getNumber());
        Assert.assertEquals(application.getAmount(), applicationDto.getAmount());
        Assert.assertEquals(application.getCurrency(), applicationDto.getCurrency());
        Assert.assertEquals(application.getApplicant(), applicationDto.getApplicant());
        Assert.assertEquals(application.getGuarantor(), applicationDto.getGuarantor());
    }

    /**
     * Тестирование Dto -> Entity
     */
    @Test
    public void convertApplicationDtoToApplicationEntity(){
        ApplicationDto applicationDto = new ApplicationDto();

        applicationDto.setNumber(1200);
        applicationDto.setAmount(1_000_000);
        applicationDto.setCurrency("rub");
        applicationDto.setApplicant(null);
        applicationDto.setGuarantor(null);

        Application application = ApplicationMapper.INSTANCE.applicationDtoToApplication(applicationDto);
        Assert.assertEquals(application.getNumber(), applicationDto.getNumber());
        Assert.assertEquals(application.getAmount(), applicationDto.getAmount());
        Assert.assertEquals(application.getCurrency(), applicationDto.getCurrency());
        Assert.assertEquals(application.getApplicant(), applicationDto.getApplicant());
        Assert.assertEquals(application.getGuarantor(), applicationDto.getGuarantor());
    }
}
