package me.bob;

import me.bob.service.DateTimeService;

/**
 * @author Bob
 */
public class TemplateService {
    
    public static boolean match(String template, String inputPassword) {
        if (template == null || template.length() == 0) {
            return false;
        }
        if (inputPassword == null || inputPassword.length() == 0) {
            return false;
        }
        return generatePassword(template).equals(inputPassword);
    }
    
    private static String generatePassword(String template) {
        template = DateTimeService.parse(template);
        return template;
    }
}
