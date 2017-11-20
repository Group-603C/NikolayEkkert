package com.company;

public class Main {

    public static void main(String[] args) {

        char[] temp = Integer.toBinaryString(43)
                             .toCharArray();

        StringBuilder result = new StringBuilder();
        for (char element : temp) {
            result.append(element == '0' ? "1" : "0");
        }

        System.out.println(Integer.parseInt(result.toString(), 2));

    }
}
