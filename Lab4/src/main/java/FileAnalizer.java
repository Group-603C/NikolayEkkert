import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileAnalizer {

    private Object[] arrayLinesFile;

    public FileAnalizer(String path) {

        try {

            arrayLinesFile = Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                                  .toArray();
        }
        catch (IOException e) {

            System.out.println("Ошибка, файл не найден!");
        }
    }

    public int CountLetters() {

        int countLetter = 0;
        if (arrayLinesFile == null) {

            return countLetter;
        }
        for (Object line : arrayLinesFile) {

            String tempLineForLetter = line.toString();
            if (tempLineForLetter.length() == 0) {
                continue;
            }

            String tempSymbol = tempLineForLetter.replaceAll("[^a-zA-Zа-яА-Я0-9]", "");
            countLetter += tempSymbol.length();
        }

        return countLetter;
    }

    public int CountWords() {

        int countWord = 0;
        if (arrayLinesFile == null) {

            return countWord;
        }
        for (Object line : arrayLinesFile) {

            String tempLineForWord = line.toString();
            if (tempLineForWord.length() != 0) {

                countWord += tempLineForWord.split("(^|\\A|\\s|\\-).*?(\\s|$|\\Z|\\-)").length;
            }
        }

        return countWord;
    }

    public int CountLines() {

        try {

            return arrayLinesFile.length;
        }
        catch (NullPointerException e) {

            System.out.println("Ошибка, массив строк получен не был!");
            return 0;
        }
    }

    public Map<Character, Integer> CountFrequencyCharacteristic() {
        Map<Character, Integer> countSymbol = new HashMap<Character, Integer>();

        if (arrayLinesFile == null) {
            return countSymbol;
        }
        for (Object line : arrayLinesFile) {

            String tempLineForLetter = line.toString();
            if (tempLineForLetter.length() != 0) {

                char[] tempSymbol = tempLineForLetter.toCharArray();
                for (char element : tempSymbol) {

                    if (countSymbol.get(element) != null) {
                        countSymbol.put(element, countSymbol.get(element) + 1);
                        continue;
                    }
                    countSymbol.put(element, 1);
                }
            }
        }

        return countSymbol;
    }
}
