package com.isachenko.transferProject.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) throws DataFormatException {
        TransferService transferService = new TransferService();
        ReportFileReader reportFileReader = new ReportFileReader();
        Map<String, Double> accounts = new HashMap<>();
        List<File> fileList = new ArrayList<>();
        transferService.initialize(accounts);
        System.out.print("Enter the number - ");
        int choice = new Scanner(System.in).nextInt();
        if (choice == 1) {
            transferService.parseTransfers(fileList, accounts);
            transferService.rewriteAccInfo(accounts);
            ArchiveHandler.moveToArchive(fileList);
        } else if (choice == 2) {
            reportFileReader.readReportFile();
            reportFileReader.readReportFile("2023-07-08", "2023-07-10");
        } else {
            System.out.println("Please, enter either 1 or 2");
        }
    }
}