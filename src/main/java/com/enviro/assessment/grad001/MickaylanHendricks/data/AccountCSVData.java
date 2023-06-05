package com.enviro.assessment.grad001.MickaylanHendricks.data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.*;


public class AccountCSVData implements FileParser {

    public AccountCSVData() {
        AccountCSVData data = new AccountCSVData();
        data.parseCSV(new File("src/main/resources/1672815113084-GraduateDev_AssessmentCsv_Ref003.csv"));
    }

    @Override
    public void parseCSV(File csvFile) {
        Set<String[]> store = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                store.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] a : store) {
            convertCSVDataToImage(a[2], a[3]);
        }
    }

    @Override
    public File convertCSVDataToImage(String fileType, String base64ImageData) {
        String ftype = fileType.split("/")[1];
        byte[] data = DatatypeConverter.parseBase64Binary(base64ImageData);
        String fileName;
        if (ftype.equals("jpeg")) {
            fileName = "file.jpg";
        } else if (ftype.equals("png")) {
            fileName = "file2.png";
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + ftype);
        }

        File file = new File("src/main/resources/" + fileName);

        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
            System.out.println("File saved successfully: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    @Override
    public URI createImageLink(File fileImage) {
        return fileImage.toURI();
    }


}
