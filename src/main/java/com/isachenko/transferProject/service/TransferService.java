package com.isachenko.transferProject.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TransferService {

    public void initialize(Map<String, Double> accounts) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/isachenko/transferProject/files/AccsInfo"))) {
            String s;
            while ((s = br.readLine()) != null) {
                accounts.put(s.substring(0, 11), Double.parseDouble(s.substring(13)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseTransfers(List<File> fileList, Map<String, Double> accounts) {
        DirectoryParser.getFiles(new File("src/main/java/com/isachenko/transferProject/files/differentFiles"), fileList);
        for (File file : fileList)
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                String res = null;
                while ((line = br.readLine()) != null) {
                    if (line.matches("\\d{5}\\-\\d{5}\\|\\d{5}\\-\\d{5}\\: \\d+\\.?\\d*")) {
                        double cashOut = accounts.get(line.substring(0, 11)) - Double.parseDouble(line.substring(25));
                        double cashIn = accounts.get(line.substring(12, 23)) + Double.parseDouble(line.substring(25));
                        if (accounts.get(line.substring(0, 11)) > Double.parseDouble(line.substring(25))) {
                            accounts.replace(line.substring(0, 11), cashOut);
                            accounts.replace(line.substring(12, 23), cashIn);
                            res = " Successful transactions";
                        } else {
                            res = " Unsuccessfully, possibly invalid amount";
                        }
                    } else {
                        res = " File is not suitable, possibly incorrect data entered";
                    }
                }
                try (FileWriter reportFile =
                             new FileWriter("src/main/java/com/isachenko/transferProject/files/reportFile", true)) {
                    reportFile.write("Date: " + LocalDateTime.now() +
                            ". File name - " + file.getName() + ". Result - " + res + '\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void rewriteAccInfo(Map<String, Double> accounts) {
        try (FileWriter fileWriter = new FileWriter("src/main/java/com/isachenko/transferProject/files/AccsInfo")) {
            for (Map.Entry e : accounts.entrySet()) {
                fileWriter.write(e.getKey() + ": " + e.getValue() + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}