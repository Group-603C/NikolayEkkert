import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileAnalizer {

    private String linesFile;


    public FileAnalizer(String path) {

        try {

            linesFile = new String(Files.readAllBytes(Paths.get(path)));
            System.out.println(linesFile.length());
        }
        catch (IOException e) {

            System.out.println("Ошибка, файл не найден!");
            System.exit(1);
        }
    }


    public int countLetters() {

        return linesFile.replaceAll("[^a-zA-Zа-яА-Я]", "")
                        .length();
    }

    public int countWords() {

        return linesFile.replaceAll("([^A-Za-zА-Яа-я])([\\s\\W]+)", " ")
                        .split(" ").length;
    }

    public int countLines() {

        return linesFile.split("\n").length;
    }

    public Map<Character, Integer> countFrequencyCharacteristic() {

        Map<Character, Integer> countSymbol = new HashMap<Character, Integer>();

        StringBuilder formatLinesFile = new StringBuilder(linesFile);
        for (int i = 0; i < formatLinesFile.length(); i++) {

            char var = formatLinesFile.charAt(i);
            try {
                countSymbol.put(formatLinesFile.charAt(i), countSymbol.get(var) + 1);
            }
            catch (NullPointerException e) {
                countSymbol.put(formatLinesFile.charAt(i), 1);
            }

        }

        return countSymbol;
    }
}
