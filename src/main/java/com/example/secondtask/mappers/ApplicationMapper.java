package com.example.secondtask.mappers;

import com.example.secondtask.dto.ApplicationDto;
import com.example.secondtask.models.Application;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClientMapper.class})
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper( ApplicationMapper.class );

    ApplicationDto applicationToApplicationDto(Application application);
    Application applicationDtoToApplication(ApplicationDto applicationDto);
}
