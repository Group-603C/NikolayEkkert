package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileAnalizer
{
    private Object[] arrayLinesFile;

    public FileAnalizer(String path)
    {
        try
        {
            arrayLinesFile = Files.lines(Paths.get(path), StandardCharsets.UTF_8).toArray();

            System.out.println("Количество букв: " + CountLetters());
            System.out.println("Количество слов: " + CountWords());
            System.out.println("Количество строк: " + CountLines());
//            System.out.println("Частотный анализ: " + CountFrequencyCharacteristic(reader));

        }
        catch (IOException e)
        {
            System.out.println("Ошибка, файл не найден!");
        }


//
//        if (file.exists())
//        {
//            FileReader openFile = new FileReader(file);
//            BufferedReader reader = new BufferedReader(openFile);
//
//            System.out.println("Количество букв: " + CountLetters(reader));
//            System.out.println("Количество слов: " + CountWords(reader));
//            System.out.println("Количество строк: " + CountLines(reader));
//            System.out.println("Частотный анализ: " + CountFrequencyCharacteristic(reader));
//
//            reader.close();
//        }
    }

    public int CountLetters()
    {
        int countLetter = 0;

        for (Object line : arrayLinesFile)
        {
            String g = (String) line;
            if (g.length() != 0)
            {
                char[] k = g.toCharArray();
                for (char l : k)
                {
                    if (l != ' ')
                    {
                        countLetter++;
                    }
                }
            }
        }

        return countLetter;
    }

    public int CountWords()
    {
        int countWord = 0;

        for (Object line : arrayLinesFile)
        {
            String g = (String) line;
            if (g.length() != 0)
            {
                countWord += g.split(" +").length;
            }
        }

        return countWord;
    }

    public int CountLines()
    {
        try
        {
            return arrayLinesFile.length;
        }
        catch (NullPointerException e)
        {
            System.out.println("Ошибка, массив строк получен не был!");
            return 0;
        }
    }

    public Map<Character, Integer> CountFrequencyCharacteristic(BufferedReader reader) throws IOException
    {
        Map<Character, Integer> CountSymbol = new HashMap<Character, Integer>();

        String line = reader.readLine();
        while (line != null)
        {
            String[] word = line.split(" ");
            for (String element : word)
            {
                char[] charArray = element.toCharArray();
                for (Character symbol : charArray)
                {
                    if (CountSymbol.equals(symbol))
                    {
                        int tempCountSymbol = CountSymbol.get(symbol) + 1;
                        CountSymbol.put(symbol, tempCountSymbol);
                    }
                    else
                    {
                        CountSymbol.put(symbol, 1);
                    }
                }
            }

            line = reader.readLine();
        }
        return CountSymbol;
    }
}
