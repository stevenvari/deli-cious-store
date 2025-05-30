package com.pluralsight.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ReceiptWriter {

    public static void saveReceipt(String message) {
        LocalDate currentDate = LocalDate.now();
        SimpleDateFormat format = new SimpleDateFormat("yyyMMdd-hhmmss");

        String date = format.format(new Date());
        String fileName = "receipts/" + date + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("Date: " + date);
            bufferedWriter.newLine();
            bufferedWriter.write(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
