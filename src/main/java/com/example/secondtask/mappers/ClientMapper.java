package com.example.secondtask.mappers;

import com.example.secondtask.dto.ClientDto;
import com.example.secondtask.models.Client;
import com.example.secondtask.models.Phone;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

@Mapper()
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );

    ClientDto clientToClientDto(Client client);

    @AfterMapping
    default void passportSeriesAndNumberMapper(Client client, @MappingTarget ClientDto clientDto){
        clientDto.setPassport(Integer.toString(client.getPassportSeries()) + Integer.toString(client.getPassportNumber()));

        List<Phone> phones = client.getPhones();
        for (Phone phone : phones)
            if (phone.getType().equals("HOME"))
                clientDto.setHomePhone(phone.getNumber());
            else
                clientDto.setMobilePhone(phone.getNumber());
    }

    @Mappings({
            @Mapping(source = "passport", target = "passportSeries", qualifiedByName = "passportSeriesMapper"),
            @Mapping(source = "passport", target = "passportNumber", qualifiedByName = "passportNumberMapper")
    })
    Client clientDtoToClient(ClientDto clientDto);

    @Named("passportSeriesMapper")
    default Integer passportSeriesMapper(String passport){
        int startSeries = 0, endSeries = 4;
        return Integer.parseInt(passport.substring(startSeries, endSeries));
    }

    @Named("passportNumberMapper")
    default Integer passportNumberMapper(String passport){
        int startNumber = 4, endNumber = 10;
        return Integer.parseInt(passport.substring(startNumber, endNumber));
    }

    // Работа с телефонами
    @Mappings({
            @Mapping(source = "mobilePhone", target = "number"),
            @Mapping(constant = "MOBILE", target = "type")
    })
    Phone mobilePhoneDtoToPhone(String mobilePhone);

    @Mappings({
            @Mapping(source = "homePhone", target = "number"),
            @Mapping(constant = "HOME", target = "type")
    })
    Phone homePhoneDtoToPhone(String homePhone);

    @AfterMapping
    default void afterMappingPhoneToEntity(ClientDto clientDto, @MappingTarget Client client){
        client.setPhones(Arrays.asList(
                mobilePhoneDtoToPhone(clientDto.getMobilePhone()),
                homePhoneDtoToPhone(clientDto.getHomePhone())
        ));

        List<Phone> phones = client.getPhones();
        for (Phone phone : phones)
            phone.setClient(client);
    }
}
