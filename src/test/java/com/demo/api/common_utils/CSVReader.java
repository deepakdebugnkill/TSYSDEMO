package com.demo.api.common_utils;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVReader {

    private static final String CSV_FILE_PATH = "src\\test\\resources\\Configuration.csv";
    private Map<String, String> configuration;
    public CSVReader() {
        this.configuration = readConfigFromCSV(CSV_FILE_PATH);
    }
    public String getConfigValue(String key) {
        return configuration.get(key);
    }
    private Map<String, String> readConfigFromCSV(String filePath) {
        Map<String, String> configMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] header = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (header == null) {
                    // Read the header row
                    header = data;
                } else {
                    // Read data rows
                    for (int i = 0; i < Math.min(header.length, data.length); i++) {
                        configMap.put(header[i], data[i]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configMap;
    }
}
