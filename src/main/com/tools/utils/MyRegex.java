package com.tools.utils;

public class MyRegex  {
    static String[] Braces(String[] values) {
        String[] results = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String line = values[i];
            int brace = 0 ;
            int square = 0;
            int bracket = 0;
            char[] chars =  line.toCharArray();
            for(int j = 0; j < chars.length; j++) {
                if (chars[j] == '{') {
                    brace++;
                } else if (chars[j] == '}') {
                    brace--;
                }
                if (chars[j] == '[') {
                    square++;
                } else if (chars[j] == ']') {
                    square--;
                }
                if (chars[j] == '(') {
                    bracket++;
                } else if (chars[j] == ')') {
                    bracket--;
                }
            }
            if (brace ==0 && square ==0 && bracket ==0) {
                results[i] = "YES";
            } else {
                results[i] = "NO";
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // "{}[]()", "{[}]}"
        String[] val = new String[3];
        val[0] = "{}[]()";
        val[1] ="{[}]}";
        val[2] ="{[()]}";
        String[] results = Braces(val);
        for(int i = 0 ; i < results.length; i++) {
            System.out.println("results = " + results[i]);
        }
    }
}
