package me.baobo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bob
 */
public class ParseMath {
    
    private static final Pattern PATTERN = Pattern.compile("\\((.*)\\)");
    
    public static String parse(String template, int number) {
        Matcher matcher = PATTERN.matcher(template);
        if (matcher.find()) {
            String group = matcher.group(1);
            char c = group.charAt(0);
            int value = Integer.parseInt(group.substring(1));
            switch (c) {
                case '+':
                    number += value;
                    break;
                case '-':
                    number -= value;
                    break;
                case '*':
                    number *= value;
                    break;
                case '/':
                    if (value == 0) {
                        break;
                    }
                    number /= value;
                    break;
                case '%':
                    number %= value;
                    break;
                default:
                    break;
            }
        }
        return String.valueOf(number);
    }
    
}