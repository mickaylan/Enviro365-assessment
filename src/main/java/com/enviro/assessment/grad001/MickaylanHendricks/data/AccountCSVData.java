package com.enviro.assessment.grad001.MickaylanHendricks.data;

import com.enviro.assessment.grad001.MickaylanHendricks.model.AccountProfile;
import com.enviro.assessment.grad001.MickaylanHendricks.repository.AccountProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;


@Component
public class AccountCSVData implements FileParser {

    private final AccountProfileRepository accountProfileRepository;

    @Autowired
    public AccountCSVData(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }

    @Override
    public void parseCSV(File csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                String accountHolderName = rowData[0];
                String accountHolderSurname = rowData[1];
                String fileType = rowData[2];
                String base64ImageData = rowData[3];

                File imageFile = convertCSVDataToImage(fileType, base64ImageData);
                URI imageLink = createImageLink(imageFile);

                accountProfileRepository.save(new AccountProfile(accountHolderName, accountHolderSurname, imageLink));


            }
        } catch (IOException e) {
            e.printStackTrace();
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
        try {
            return new URI(fileImage.getAbsolutePath());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}
