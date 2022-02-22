package giai_de.C10.utils;

import giai_de.C10.model.ExportProduct;
import giai_de.C10.model.ImportProduct;
import giai_de.C10.model.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileCSV {
    public static List<Products> readFileToCSV(String filePath) {
        List<Products> productsList = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] product;
            while ((line = bufferedReader.readLine()) != null) {
                product = line.split(",");
                if (product.length == 9) {
                    ImportProduct importProduct = new ImportProduct(Integer.parseInt(product[0]), product[1], product[2], Double.parseDouble(product[3]),
                            Integer.parseInt(product[4]), product[5], Double.parseDouble(product[6]), product[7], Double.parseDouble(product[8]));
                    productsList.add(importProduct);

                } else {
                    ExportProduct exportProduct = new ExportProduct(Integer.parseInt(product[0]), product[1], product[2], Double.parseDouble(product[3]),
                            Integer.parseInt(product[4]), product[5], Double.parseDouble(product[6]), product[7]);
                    productsList.add(exportProduct);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsList;
    }

    public static void writeFileProductsToCsv(Products products, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(products.writeToFileCsv());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("File not found or failure");
            e.printStackTrace();
        }
    }
    public static void writeListProductFile( List<Products> productsList,String filePath) {
        try {
            File file = new File(filePath);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Products products: productsList) {
                bufferedWriter.write(products.writeToFileCsv());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
