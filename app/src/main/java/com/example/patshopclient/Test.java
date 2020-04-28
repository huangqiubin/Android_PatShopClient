package com.example.patshopclient;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiubin on 2020-04-01.
 * Describe:
 */
public class Test {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("一个");
//        list.add("两个");
//        list.add("三个");
//        list.add("四个");
//        list = list.subList(0, 3);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));

//        String refundRate = String.format("%.2f", );
//        DecimalFormat df = new DecimalFormat(".#");
//        df.setRoundingMode(RoundingMode.DOWN);
//        String refundNumber = df.format(0.6);
//        System.out.println(refundNumber);
//        DecimalFormat decimalFormat = new DecimalFormat("0");
//        Double d = Double.parseDouble("12.4");
//        System.out.println(decimalFormat.format(d));
        int num1 = 4;
        int num2 = 8;
        System.out.println(num1 / num2);
        System.out.println((double) num1 / num2);
        System.out.println((double) num1 / (double) num2);
    }
}
