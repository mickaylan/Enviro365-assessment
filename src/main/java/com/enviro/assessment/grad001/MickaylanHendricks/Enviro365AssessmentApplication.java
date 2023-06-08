package com.enviro.assessment.grad001.MickaylanHendricks;

import com.enviro.assessment.grad001.MickaylanHendricks.data.AccountCSVData;
import com.enviro.assessment.grad001.MickaylanHendricks.repository.AccountProfileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

@SpringBootApplication
public class Enviro365AssessmentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(Enviro365AssessmentApplication.class, args);
        AccountProfileRepository accountRepository =
                configurableApplicationContext.getBean(AccountProfileRepository.class);
        AccountCSVData data = new AccountCSVData(accountRepository);
        data.parseCSV(new File("src/main/resources/1672815113084-GraduateDev_AssessmentCsv_Ref003.csv"));
    }



}

