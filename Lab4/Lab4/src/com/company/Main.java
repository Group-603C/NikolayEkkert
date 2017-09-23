package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("file.txt");

        if (file.exists())
        {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            int countLetter = 0;
            int countWord = 0;
            int countLine = 0;

            String line = reader.readLine();
            while (line != null)
            {
                String[] word = line.split(" ");
                for (String element : word)
                {
                    char[] charArray = element.toCharArray();
                    countLetter += charArray.length;
                    countWord += 1;
                }

                countLine++;
                line = reader.readLine();
            }
            reader.close();

            System.out.println("Букв: " + countLetter);
            System.out.println("Слов: " + countWord);
            System.out.println("Строк: " + countLine);
        }
        else
        {
            System.out.println("Файл не найден!");
        }
    }
}
