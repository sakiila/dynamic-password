package me.baobo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.baobo.service.DateTime;

/**
 * @author Bob
 */
public class Main {
    
    public static boolean match(String template, String inputPassword) {
        if (template == null || template.length() == 0) {
            return false;
        }
        if (inputPassword == null || inputPassword.length() == 0) {
            return false;
        }
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : template.toCharArray()) {
            if (c == '{') {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(c);
            if (c == '}') {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        
        // String collect = list.stream()
        //     .map(Main::generatePassword)
        //     .collect(Collectors.joining());
        // System.out.println("collect = " + collect);
        
        return list.stream()
            .map(Main::generatePassword)
            .collect(Collectors.joining())
            .equals(inputPassword);
    }
    
    private static String generatePassword(String template) {
        if (template.length() > 2
            && template.charAt(0) == '{'
            && template.charAt(template.length() - 1) == '}') {
            template = DateTime.parse(template);
        }
        return template;
    }
}
