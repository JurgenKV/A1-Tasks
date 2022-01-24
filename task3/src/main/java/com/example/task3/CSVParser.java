package com.example.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CSVParser {

    public List<Login> readLogin(String fileName) throws Exception {
        List<Login> loginList = new ArrayList<Login>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(fileName))) {
            String row = "";
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",\t");

                loginList.add(new Login(data[0], data[1], data[2], data[3], data[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginList;
    }

    public List<Supply> readSupply(String fileName) throws Exception {
        List<Supply> supplyList = new ArrayList<Supply>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(fileName))) {
            String row = "";
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                if (row.equals("")) continue;
                String[] data = row.split(";\t");
                supplyList.add(new Supply(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return supplyList;

    }

}

