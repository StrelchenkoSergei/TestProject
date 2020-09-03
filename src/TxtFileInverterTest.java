import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TxtFileInverterTest {

    @Test
    void getLinesFromFile() throws FileNotFoundException {
        String fileFromName = "src/resourses/fileFromNameTest.txt";
        String fileToName = "src/resourses/fileToNameTest.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileFromName));
        TxtFileInverter txtFileInverter = new TxtFileInverter(fileFromName, fileFromName);

        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Hello");
        expResult.add("Greetings");
        List<String> result = txtFileInverter.getLinesFromFile(reader);
        assertEquals(expResult, result, "");
    }

    @Test
    void filterLinesByFibonacci() {
        String fileFromName = "";
        String fileToName = "";
        TxtFileInverter inverter = new TxtFileInverter(fileFromName, fileFromName);

        ArrayList<String> testList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            testList.add(i, "Hello" + i);
        }
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Hello0");
        expResult.add("Hello1");
        expResult.add("Hello2");
        expResult.add("Hello3");
        expResult.add("Hello5");
        expResult.add("Hello8");
        ArrayList<String> result = inverter.filterLinesByFibonacci(testList);
        assertEquals(expResult,result,"");
    }

    @Test
    void setLinesToFile() throws IOException {
        //Initializing resources
        String fileFromName = "src/resourses/fileFromNameTest.txt";
        String fileToName = "src/resourses/fileToNameTest.txt";
        TxtFileInverter inverter = new TxtFileInverter(fileFromName, fileToName);
        BufferedReader reader = new BufferedReader(new FileReader(fileToName));

        //Simulating data to write to a file
        ArrayList<String> listLine = new ArrayList<>();
        listLine.add("Hello");
        listLine.add("Greetings");
        inverter.setLinesToFile(listLine);

        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Hello");
        expResult.add("Greetings");
        ArrayList<String> result = inverter.getLinesFromFile(reader);
        assertEquals(expResult, result, "");
    }

    @Test
    void turnAllLinesAround() {
        String fileFromName = "";
        String fileToName = "";
        TxtFileInverter inverter = new TxtFileInverter(fileFromName, fileFromName);

        ArrayList<String> invertedLines = new ArrayList<>();
        invertedLines.add("olleH");
        invertedLines.add("sgniteerG");

        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Hello");
        expResult.add("Greetings");
        ArrayList<String> result = inverter.turnAllLinesAround(invertedLines);
        assertEquals(expResult, result, "");
    }
}