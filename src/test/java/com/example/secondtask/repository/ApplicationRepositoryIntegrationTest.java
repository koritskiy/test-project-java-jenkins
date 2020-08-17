package com.example.secondtask.repository;

import com.example.secondtask.models.Application;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ApplicationRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    public void FindApplicationById(){
        Application application = new Application();

        application.setNumber(1200);
        application.setAmount(1_000_000);
        application.setCurrency("rub");
        application.setApplicant(null);
        application.setGuarantor(null);

        entityManager.persist(application);
        entityManager.flush();

        Application resultFound = applicationRepository.findApplicationById(application.getId());

        Assert.assertEquals(resultFound.getNumber(), application.getNumber());
    }
}
