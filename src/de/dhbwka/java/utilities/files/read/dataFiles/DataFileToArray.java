package de.dhbwka.java.utilities.files.read.dataFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

//TODO besseres catch-Management

public class DataFileToArray {
    public static String[][] getStringArrayOfDataFileWithDelimiter(String pathname, char delimiter){
        return getStringArrayOfDataFileWithDelimiter(new File(pathname), delimiter);
    }
    public static String[][] getStringArrayOfDataFileWithDelimiter(File file, char delimiter){
        if(!file.exists()){
            System.out.printf("File %s does not exist \n", file.getAbsolutePath());
            return null;
        }

        //Get numberOfRows and numberOfColumns
        int numberOfRows = 0;
        int numberOfColumns = 1;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = "";
            while (bufferedReader.ready()){
                line = bufferedReader.readLine();
                numberOfRows++;
            }
            for (int i = 0; i<line.length(); i++){
                if(line.charAt(i) == delimiter) numberOfColumns++;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

        String[][] result = new String[numberOfRows][numberOfColumns];

        //Get Data
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            int rowNumber = 0;
            while (bufferedReader.ready()){
                String oneRow = bufferedReader.readLine();
                result[rowNumber] = getOneRow(oneRow, delimiter);
                rowNumber++;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }

    /**
     * Get Data StringArray with Data from one String
     * @param rowContent String with Data
     * @param delimiter Delimiter char which separates the differend DataSets
     * @return StringArray with all DataSets in String
     */
    private static String[] getOneRow(String rowContent, char delimiter){
        ArrayList<String> rowData = new ArrayList<>();
        StringBuilder oneData = new StringBuilder();

        for(int i=0; i<rowContent.length(); i++){
            if(rowContent.charAt(i)==delimiter){
                rowData.add(oneData.toString());
                oneData.delete(0, oneData.length());
            } else {
                oneData.append(rowContent.charAt(i));
            }
        }
        //Area last ';' to end of String
        if(oneData.length()>0){
            rowData.add(oneData.toString());
        } else rowData.add("");

        return rowData.toArray(new String[0]);
    }
}
