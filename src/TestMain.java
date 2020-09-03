
public class TestMain {
    public static void main(String[] args)  {
        String fileFromName = "src/resourses/fileFromName.txt";
        String fileToName = "src/resourses/fileToName.txt";

        TxtFileInverter file = new TxtFileInverter(fileFromName,fileToName);
        file.invertLinesInTheFile();



    }
}
