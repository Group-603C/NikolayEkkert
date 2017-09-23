package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static int GetMin(int[] arrayForFindingTheMinimum)
    {
        if (arrayForFindingTheMinimum.length != 0 || arrayForFindingTheMinimum != null)
        {
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < arrayForFindingTheMinimum.length; i++)
            {
                minimum = Math.min(minimum, arrayForFindingTheMinimum[i]);
            }

            return minimum;
        }
        else
        {
            return Integer.MAX_VALUE;
        }
    }

    public static int GetMax(int[] arrayForFindingTheMaximum)
    {
        if (arrayForFindingTheMaximum.length != 0 && arrayForFindingTheMaximum != null)
        {
            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < arrayForFindingTheMaximum.length; i++)
            {
                maximum = Math.max(maximum, arrayForFindingTheMaximum[i]);
            }

            return maximum;
        }
        else
        {
            return Integer.MIN_VALUE;
        }
    }

    public static float ArithmeticMean(int[] arrayForFindingTheArithmeticMean)
    {
        if (arrayForFindingTheArithmeticMean.length != 0 && arrayForFindingTheArithmeticMean != null)
        {
            int valueArithmeticMean = 0;
            for (int i = 0; i < arrayForFindingTheArithmeticMean.length; i++)
            {
                valueArithmeticMean += arrayForFindingTheArithmeticMean[i];
            }

            return (float) valueArithmeticMean / arrayForFindingTheArithmeticMean.length;
        }
        else
        {
            return 0;
        }
    }

    public static float GetMedianOfNumber(int[] arrayForFindingTheMedianOfNumber)
    {
        if (arrayForFindingTheMedianOfNumber.length != 0 && arrayForFindingTheMedianOfNumber != null)
        {
            Arrays.sort(arrayForFindingTheMedianOfNumber);
            if (arrayForFindingTheMedianOfNumber.length % 2 == 0)
            {
                return ((arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2] + arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2 - 1]) / 2f);
            }

            return arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2];
        }
        else
        {
            return 0;
        }
    }

    public static double GetGeometricMean(int[] arrayForFindingTheGeometricMean)
    {
        if (arrayForFindingTheGeometricMean.length != 0 || arrayForFindingTheGeometricMean != null)
        {
            if (arrayForFindingTheGeometricMean.equals(0))
            {
                return 0;
            }
            else
            {
                double multiplicationOfNumber = 1f;
                for (int i = 0; i < arrayForFindingTheGeometricMean.length; i++)
                {
                    multiplicationOfNumber *= (double) arrayForFindingTheGeometricMean[i];
                }

                return (Math.pow(multiplicationOfNumber, 1d / arrayForFindingTheGeometricMean.length));
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

        System.out.println("\nМедиана: " + GetMedianOfNumber(array));

        System.out.println("\nСреднее геометрическое: " + GetGeometricMean(array));
    }
}