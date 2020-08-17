package com.example.secondtask.mappers;

import com.example.secondtask.dto.ClientDto;
import com.example.secondtask.models.Client;
import com.example.secondtask.models.Phone;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class ClientMapperTest {

    /**
     * Инициализируем исходные параметры для телефонов
     */
    public List<Phone> createPhones(Client client){
        Phone mobilePhone = new Phone();
        mobilePhone.setType("MOBILE");
        mobilePhone.setNumber("89035198753");
        mobilePhone.setClient(client);

        Phone homePhone = new Phone();
        homePhone.setType("HOME");
        homePhone.setNumber("89035198753");
        homePhone.setClient(client);

        return Arrays.asList(mobilePhone, homePhone);
    }

    /**
     * Тестирование Entity -> Dto
     */
    @Test
    public void convertClientEntityToClientDto(){
        Client client = new Client();
        client.setFirstName("Alexander");
        client.setLastName("Koritskiy");
        client.setPassportSeries(4515);
        client.setPassportNumber(123456);
        client.setPhones(createPhones(client));

        ClientDto clientDto = ClientMapper.INSTANCE.clientToClientDto(client);
        assertEquals(client.getFirstName(), clientDto.getFirstName());
        assertEquals(client.getLastName(), clientDto.getLastName());
        assertEquals(Integer.toString(client.getPassportSeries()) + Integer.toString(client.getPassportNumber()),
                clientDto.getPassport());
        assertEquals(client.getPhones(), createPhones(client));
    }

    /**
     * Тестирование Dto -> Entity
     */
    @Test
    public void convertClientDtoToClientEntity(){
        ClientDto clientDto = new ClientDto();

        clientDto.setFirstName("Alexander");
        clientDto.setLastName("Koritskiy");
        clientDto.setPassport("4515123456");
        clientDto.setHomePhone("89035198753");
        clientDto.setMobilePhone("89035198753");

        Client client = ClientMapper.INSTANCE.clientDtoToClient(clientDto);
        assertEquals(client.getFirstName(), clientDto.getFirstName());
        assertEquals(client.getLastName(), clientDto.getLastName());
        assertEquals(Integer.toString(client.getPassportSeries()) + Integer.toString(client.getPassportNumber()),
                clientDto.getPassport());
        assertEquals(client.getPhones(), createPhones(client));
    }
}
