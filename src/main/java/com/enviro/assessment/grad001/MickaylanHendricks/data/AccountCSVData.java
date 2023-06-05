package com.enviro.assessment.grad001.MickaylanHendricks.data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AccountCSVData implements FileParser {

    ArrayList<String[]> store = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(AccountCSVData.class, args);
        AccountCSVData data = new AccountCSVData();
        data.parseCSV(new File("src/main/resources/1672815113084-GraduateDev_AssessmentCsv_Ref003.csv"));
    }

    @Override
    public void parseCSV(File csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                store.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] a:
             store) {
            System.out.println(Arrays.toString(a[0].split("\n")));
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        return null;
    }

    @Override
    public URI createImageLink(File fileImage) {
        return null;
    }
}
