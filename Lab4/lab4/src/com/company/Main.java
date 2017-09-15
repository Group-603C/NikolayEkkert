package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner file;

        try
        {
            file = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\lab4\\src\\com\\company\\file.txt"));

            int countWord = 0;
            int countLetter = 0;
            int countLine = 0;

            final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\User\\IdeaProjects\\lab4\\src\\com\\company\\file.txt")));
            String line;

            while ((line = reader.readLine()) != null)
            {
                countLine++;
            }
            reader.close();

            Map<Character, Integer> dictionaryLetter = new HashMap<>();

            while (file.hasNext())
            {
                countWord++;
                String word = file.next();
                for (int i = 0; i < word.length(); i++)
                {
                    if (dictionaryLetter.containsKey(word.charAt(i)))
                    {
                        int tempFrequency = dictionaryLetter.get(word.charAt(i)) + 1;
                        dictionaryLetter.remove(word.charAt(i));
                        dictionaryLetter.put(word.charAt(i), tempFrequency);
                    }
                    else
                    {
                        dictionaryLetter.put(word.charAt(i), 1);
                    }
                }

                countLetter += word.length();
            }
            file.close();

            System.out.println("Количество слов: " + countWord);
            System.out.println("Количество букв: " + countLetter);
            System.out.println("Количество строк: " + countLine);
            System.out.println("Частотный анализ: " + dictionaryLetter);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка!");
        }
    }
}
