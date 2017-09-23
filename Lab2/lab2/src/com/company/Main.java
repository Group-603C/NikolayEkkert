package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static int GetMin(int[] arrayFindMin)
    {
        if (arrayFindMin.length != 0 || arrayFindMin != null)
        {
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < arrayFindMin.length; i++)
            {
                minimum = Math.min(minimum, arrayFindMin[i]);
            }

            return minimum;
        }
        else
        {
            return Integer.MAX_VALUE;
        }
    }

    public static int GetMax(int[] arrayFindMax)
    {
        if (arrayFindMax.length != 0 && arrayFindMax != null)
        {
            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < arrayFindMax.length; i++)
            {
                maximum = Math.max(maximum, arrayFindMax[i]);
            }

            return maximum;
        }
        else
        {
            return Integer.MIN_VALUE;
        }
    }

    public static float ArithmeticMean(int[] arrayForAverage)
    {
        if (arrayForAverage.length != 0 && arrayForAverage != null)
        {
            int valueAverage = 0;
            for (int i = 0; i < arrayForAverage.length; i++)
            {
                valueAverage += arrayForAverage[i];
            }

            return (float) valueAverage / arrayForAverage.length;
        }
        else
        {
            return 0;
        }
    }

    public static float GetMedian(int[] arrayFindMedian)
    {
        if (arrayFindMedian.length != 0 && arrayFindMedian != null)
        {
            Arrays.sort(arrayFindMedian);
            if (arrayFindMedian.length % 2 == 0)
            {
                return ((arrayFindMedian[arrayFindMedian.length / 2] + arrayFindMedian[arrayFindMedian.length / 2 - 1]) / 2f);
            }

            return arrayFindMedian[arrayFindMedian.length / 2];
        }
        else
        {
            return 0;
        }
    }

    public static double GetGeometricMean(int[] arrayFindGeometricMean)
    {
        if (arrayFindGeometricMean.length != 0 || arrayFindGeometricMean != null)
        {
            if (arrayFindGeometricMean.equals(0))
            {
                return 0;
            }
            else
            {
                double multiplication = 1f;
                for (int i = 0; i < arrayFindGeometricMean.length; i++)
                {
                    multiplication *= (double) arrayFindGeometricMean[i];
                }

                return (Math.pow(multiplication, 1d / arrayFindGeometricMean.length));
            }
        }
        else
        {
            return 0;
        }
    }

    public static int[] InputArray()
    {
        while (true)
        {
            try
            {
                System.out.print("Введите количество цифр: ");
                Scanner input = new Scanner(System.in);
                int lengthArray = input.nextInt();
//                int lengthArray = 8;
                int[] array = new int[lengthArray];

                int i = 0;
                while (i < lengthArray)
                {
                    Scanner symInput = new Scanner(System.in);
                    System.out.print(i + "Введите значение: ");
                    String tempInput = symInput.nextLine();
                    try
                    {
                        int temp = Integer.parseInt(tempInput);
                        array[i] = temp;
                        i++;
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("\tОшибка, Введено не численное значение!");
                    }
                }

//                array[0] = 10;
//                array[1] = 1;
//                array[2] = 2;
//                array[3] = 3;
//                array[4] = 4;
//                array[5] = 5;
//                array[6] = 6;
//                array[7] = 7;

                return array;
            }
            catch (NegativeArraySizeException e)
            {
                System.out.println("\tОшибка, длина массива не может быть отрицательна!");
            }
            catch (InputMismatchException e)
            {
                System.out.println("\tОшибка, введён символ при указании длины массива!");
            }
        }
    }

    public static void main(String[] args)
    {
        int[] array = InputArray();

        System.out.println("\nМинимум: " + GetMin(array));
        System.out.println("Максимум: " + GetMax(array));

        System.out.println("\nСреднее арифметическое: " + ArithmeticMean(array));

        System.out.println("\nМедиана: " + GetMedian(array));

        System.out.println("\nСреднее геометрическое: " + GetGeometricMean(array));
    }
}