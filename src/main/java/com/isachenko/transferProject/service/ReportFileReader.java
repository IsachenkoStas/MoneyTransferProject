package com.isachenko.transferProject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.zip.DataFormatException;

public class ReportFileReader {

    public void readReportFile() {
        try (FileReader readReport = new FileReader("src/main/java/com/isachenko/transferProject/files/reportFile")) {
            int i;
            while ((i = readReport.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * format of String date should be yy-MM-dd
     */
    public void readReportFile(String fromDate, String dateBy) throws DataFormatException {
        if (fromDate.matches("\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])*")
                && dateBy.matches("\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])*")) {
            LocalDate dateFrom = LocalDate.parse(fromDate);
            LocalDate byDate = LocalDate.parse(dateBy);
            try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/isachenko/transferProject/files/reportFile"))) {
                String line;
                String date;
                while ((line = br.readLine()) != null) {
                    date = line.substring(6, 16);
                    if (dateFrom.isBefore(LocalDate.parse(date)) || dateFrom.isEqual(LocalDate.parse(date))) {
                        if (byDate.isAfter(LocalDate.parse(date)) || byDate.isEqual(LocalDate.parse(date))) {
                            System.out.println(line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new DataFormatException();
        }
    }
}
