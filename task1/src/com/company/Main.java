package com.company;

/*
Задание 1 "IP-адреса"
        IpV4 адрес состоит из 4 октетов, значит его можно хранить в переменной типа int32.
        Реализуйте пару функций, которые однозначно преобразуют строковое представление IpV4 адрес (вида "127.0.0.1")
        в значение типа int32 и наоборот.

        Примеры:
        2149583360 ==> "128.32.10.0"
        255        ==> "0.0.0.255"
*/

public class Main {

    public static void main(String[] args) throws Exception {

        String res1 = toIPV4("255");
        String res2 = fromIPV4("0.0.0.255");
        System.out.print(res1);
        System.out.print("\n");
        System.out.print(res2);

    }

    // Функция преобразования к виду ipv4
    public static String toIPV4(String s) {

        String bitStr = Long.toBinaryString(Long.parseLong(s));

        if (bitStr.length() > 32) {
            System.out.print("Invalid data");
            System.exit(0);
        }

        while (bitStr.length() != 32) {
            bitStr = "0" + bitStr;
        }

        String resultIPV4 = "";

        for (int i = 32; i > 0; i -= 8) {

            Integer sub = Integer.parseInt(bitStr.substring(i - 8, i), 2);
            resultIPV4 = String.join(".", sub.toString(), resultIPV4);
        }

        return resultIPV4.substring(0, resultIPV4.length() - 1);
    }

    // Функция обратного преобразования из ipv4
    public static String fromIPV4(String s) {

        StringBuffer str = new StringBuffer(s + ".");
        String result = "";
        String sub = "";
        String num;
        int i = 0;
        Integer tr = 0;

        for (int j = 0; j < 4; j++) {

            int r = str.indexOf(".");
            sub = str.substring(i, str.indexOf("."));
            str.delete(0, str.indexOf(".") + 1);
            num = Integer.toBinaryString(Integer.parseInt(sub));

            if (Integer.parseInt(num, 2) > 255) {
                System.out.print("Invalid data");
                System.exit(0);
            }

            while (num.length() != 8) {
                num = "0" + num;
            }

            result += num;

        }

        Long res = Long.parseLong(result, 2);
        return res.toString();
    }
}
