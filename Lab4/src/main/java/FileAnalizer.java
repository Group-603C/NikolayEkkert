import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileAnalizer {

    private String nameFileCash;
    private String content;


    public FileAnalizer(String path) {

        nameFileCash = "dateModified.txt";

//        createFile();
//        double temp = getLastModified("file.txt");


//        try {
//
//
//            content = new String(Files.readAllBytes(Paths.get(path)));
//
//        }
//        catch (IOException e) {
//
//            throw new IllegalArgumentException("File not found!");
//        }
    }


    public int countLetters() {

        return content.replaceAll("[^a-zA-Zа-яА-Я]", "")
                      .length();
    }

    public int countWords() {

        return content.replaceAll("([^A-Za-zА-Яа-я])([\\s\\W]+)", " ")
                      .split(" ").length;
    }

    public int countLines() {

        return content.split("\n").length;
    }

    public Map<Character, Integer> countFrequencyCharacteristic() {

        Map<Character, Integer> countSymbol = new HashMap<Character, Integer>();

        char[] formatContent = content.toCharArray();
        for (char element : formatContent) {

            if (countSymbol.get(element) != null) {

                countSymbol.put(element, countSymbol.get(element) + 1);
            }
            else {

                countSymbol.put(element, 1);
            }
        }

        return countSymbol;
    }


    private void createFile() {

        String absolutePath = new File(".").getAbsolutePath();
        File newFile = new File(nameFileCash);
        try {

            newFile.createNewFile();
        }
        catch (IOException e) {

            throw new IllegalArgumentException("The file is not create!");
        }
    }

    private double getLastModified(String path) {

        File file = new File(path);
        if (file.exists()) {

            return file.lastModified();
        }
        else {

            throw new IllegalArgumentException("File not found!");
        }
    }

    private boolean isEqualityDate(double lastModified) {

        File file = new File(nameFileCash);
        if (file.exists()) {
            return file.lastModified() == lastModified ? true : false;
        }
        throw new IllegalArgumentException("File not found!");
    }
}