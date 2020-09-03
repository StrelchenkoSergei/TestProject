import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtFileInverter {

    private String fileFromName ;
    private String fileToName ;
    private BufferedReader txtRider;
    private BufferedWriter txtWriter;

    public TxtFileInverter(String fileFromName, String fileToName) {
        this.fileFromName = fileFromName;
        this.fileToName = fileToName;
    }

    public void invertLinesInTheFile() {
        setLinesToFile(turnAllLinesAround(filterLinesByFibonacci(getLinesFromFile(txtRider))));
    }

    private void setLinesToFile (ArrayList<String> fibonacciLines){
        try {
            txtWriter = new BufferedWriter(new FileWriter(fileToName));
            for (String line : fibonacciLines) {
                txtWriter.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Failed to write file");
        }finally {
            try {
                txtWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<String> getLinesFromFile(BufferedReader reader) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(fileFromName);
            reader= new BufferedReader(new FileReader(fileFromName));
            while (scanner.hasNextLine()) {
                String line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                } else break;
            }
        }catch (FileNotFoundException e) {
            System.out.println("Couldn't find file");
        }catch (IOException i){
            System.out.println("Failed to read the line");
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    private ArrayList<String> filterLinesByFibonacci(ArrayList<String> reversedLines) {
        ArrayList<String> filteredRows = new ArrayList<>();
        int[] mas = new int[reversedLines.size()];
        mas[0] = 0;
        mas[1] = 1;
        filteredRows.add(reversedLines.get(0));

        for (int i = 2; i < reversedLines.size(); ++i) {
            mas[i] = mas[i - 1] + mas[i - 2];
            if (mas[i] <= reversedLines.size()) {
                filteredRows.add(reversedLines.get(mas[i]));
            }
        }
        return filteredRows;
    }

    private ArrayList<String> turnAllLinesAround(ArrayList<String> lines) {
        ArrayList<String> reversedLines = new ArrayList<>();
        for (String line : lines) {
            char[] lineToChar = line.toCharArray();
            String reversedLine = "";
            for (int j = lineToChar.length - 1; j >= 0; j--) {
                reversedLine += lineToChar[j];
            }
            reversedLines.add(reversedLine);
        }
        return reversedLines;
    }

}
