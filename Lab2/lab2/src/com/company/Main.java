package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{

    public static int GetMin(int[] arrayForFindingTheMinimum)
    {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < arrayForFindingTheMinimum.length; i++)
        {
            minimum = Math.min(minimum, arrayForFindingTheMinimum[i]);
        }

        return minimum;
    }

    public static int GetMax(int[] arrayForFindingTheMaximum)
    {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arrayForFindingTheMaximum.length; i++)
        {
            maximum = Math.max(maximum, arrayForFindingTheMaximum[i]);
        }

        return maximum;
    }

    public static float ArithmeticMean(int[] arrayForFindingTheArithmeticMean)
    {
        int valueArithmeticMean = 0;
        for (int i = 0; i < arrayForFindingTheArithmeticMean.length; i++)
        {
            valueArithmeticMean += arrayForFindingTheArithmeticMean[i];
        }

        return valueArithmeticMean / arrayForFindingTheArithmeticMean.length;
    }

    public static float GetMedianOfNumber(int[] arrayForFindingTheMedianOfNumber)
    {
        Arrays.sort(arrayForFindingTheMedianOfNumber);
        if (arrayForFindingTheMedianOfNumber.length % 2 == 0)
        {
            return ((arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2] + arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2 - 1]) / 2f);
        }

        return arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2];
    }

    public static double GetGeometricMean(int[] arrayForFindingTheGeometricMean)
    {
        double multiplicationOfNumber = 1f;
        for (int i = 0; i < arrayForFindingTheGeometricMean.length; i++)
        {
            multiplicationOfNumber *= (double) arrayForFindingTheGeometricMean[i];
        }
        return (Math.pow(multiplicationOfNumber, 1d / arrayForFindingTheGeometricMean.length));
    }

    public static void main(String[] args)
    {
        System.out.print("Введите количество цифр: ");
        Scanner input = new Scanner(System.in);
        int lengthArrayNumber = input.nextInt();

        int[] arrayNumber = new int[lengthArrayNumber];

        for (int i = 0; i < lengthArrayNumber; i++)
        {
            System.out.print("Введите значение: ");
            arrayNumber[i] = input.nextInt();
        }

        System.out.println("\nМинимум: " + GetMin(arrayNumber));
        System.out.println("Максимум: " + GetMax(arrayNumber));

        System.out.println("\nСреднее арифметическое: " + ArithmeticMean(arrayNumber));

        System.out.println("\nМедиана: " + GetMedianOfNumber(arrayNumber));

        System.out.println("\nСреднее геометрическое: " + GetGeometricMean(arrayNumber));
    }
}