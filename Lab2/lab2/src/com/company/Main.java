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

                int[] arrayNumber = new int[lengthArray];

                for (int i = 0; i < lengthArray; i++)
                {
                    System.out.print(i + "Введите значение: ");
                    arrayNumber[i] = input.nextInt();
                }


//                arrayNumber[0] = 10;
//                arrayNumber[1] = 1;
//                arrayNumber[2] = 2;
//                arrayNumber[3] = 3;
//                arrayNumber[4] = 4;
//                arrayNumber[5] = 5;
//                arrayNumber[6] = 6;
//                arrayNumber[7] = 7;

                return arrayNumber;
            }
            catch (NegativeArraySizeException e)
            {
                System.out.println("\tОшибка, длина массива отрицательна!");
            }
        }

    }

    public static void main(String[] args)
    {
        int[] arrayNumber = InputArray();

        System.out.println("\nМинимум: " + GetMin(arrayNumber));
        System.out.println("Максимум: " + GetMax(arrayNumber));

        System.out.println("\nСреднее арифметическое: " + ArithmeticMean(arrayNumber));

        System.out.println("\nМедиана: " + GetMedianOfNumber(arrayNumber));

        System.out.println("\nСреднее геометрическое: " + GetGeometricMean(arrayNumber));
    }
}