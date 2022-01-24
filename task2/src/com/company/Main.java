package com.company;

import java.math.*;
/*
Задание 2 "Стремится к нулю или к бесконечности?"
	(n! обозначает factorial(n))
	Будет ли выражение вида:
		un = (1 / n!) * (1! + 2! + 3! + ... + n!)
	стремится к 0 или к бесконечности?
	Реализуйте функцию, которая расчитывает значение un для целочисленных n > 1 (с точностью не хуже 6 знаков после запятой).
*/

public class Main {

    public static void main(String[] args) throws Exception {

        String res3 = mathFunc("20");
        System.out.print(res3);

    }

    public static String mathFunc(String n) {

        Integer num = 0;
        try {
            num = Integer.parseInt(n);
        } catch (Exception e) {
            System.out.print("Invalid data.");
            System.exit(0);
        }

        if (num <= 1) {
            System.out.print("Invalid data. Check n > 1");
            System.exit(0);
        }
        MathContext mc = new MathContext(10);

        //un = (1 / n!) * (1! + 2! + 3! + ... + n!)

        BigDecimal temp = BigDecimal.valueOf(0);

        // (1! + 2! + 3! + ... + n!)
        for (int j = 1; j <= num; j++) {
            temp = temp.add(BigDecimal.valueOf(getFactorial(j)), mc);
        }

        BigDecimal result = BigDecimal.valueOf(1);
        //un = (1 / n!)
        try {
            result = result.divide(BigDecimal.valueOf(getFactorial(num)), mc);
        } catch (Exception e) {
            System.out.print("(1 / n!) -> 0\n");
            System.exit(0);
        }

        result = result.multiply(temp, mc);
        return result.toString();
    }

    public static Long getFactorial(Integer f) {
        Long res = Long.valueOf(1);
        for (int i = 1; i <= f; i++) {
            res = res * i;
        }
        return res;
    }
}
