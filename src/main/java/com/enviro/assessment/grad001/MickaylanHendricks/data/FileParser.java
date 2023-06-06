package com.enviro.assessment.grad001.MickaylanHendricks.data;

import java.io.File;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile);
    File convertCSVDataToImage(String fileType, String base64ImageData);
    URI createImageLink(File fileImage);
}
