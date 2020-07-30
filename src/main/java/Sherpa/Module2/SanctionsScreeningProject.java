package Sherpa.Module2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class SanctionsScreeningProject {

    public static ArrayList<String> CsvPass = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader crunchifyBuffer = null;

        try {

            crunchifyBuffer = new BufferedReader(new FileReader("src/main/resources/Test_Data.csv"));
            String crunchifyLine;
            //csv file directory posted above
            //reads csv line by line and prints it out to confirm read.
            while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
                System.out.println("Raw CSV data: " + crunchifyLine);
                System.out.println("Converted ArrayList data: " + crunchifyCSVtoArrayList(crunchifyLine) + "\n");
                CsvPass.addAll(crunchifyCSVtoArrayList(crunchifyLine));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (crunchifyBuffer != null) crunchifyBuffer.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        System.out.println("Finalized list of sanctions: " + CsvPass); //Prints a finalized list of all things sanctioned
        SpringApplication.run(SanctionsScreeningProject.class, args);
    }
    // Utility which converts CSV to ArrayList using Split Operation
    public static ArrayList<String> crunchifyCSVtoArrayList(String crunchifyCSV) {
        ArrayList<String> crunchifyResult = new ArrayList<>();
        if (crunchifyCSV != null) {
            String[] splitData = crunchifyCSV.split("\\s*,\\s*"); //will split on commas and consume any spaces either side
            for (String splitDatum : splitData) {
                if (!(splitDatum == null)) {
                    crunchifyResult.add(splitDatum.trim());

                }
            }
        }
        return crunchifyResult;
    }
}


