package me.bob.service;

import java.time.LocalDateTime;
import me.bob.enums.TemplateEnum;

/**
 * @author Bob
 */
public class DateTimeService {
    
    public static String parse(String template) {
        LocalDateTime now = LocalDateTime.now();
        if (template.contains(TemplateEnum.YEAR.getTemplate())) {
            template = template.replace(TemplateEnum.YEAR.getTemplate(), String.valueOf(now.getYear()));
        }
        if (template.contains(TemplateEnum.MONTH.getTemplate())) {
            template = template.replace(TemplateEnum.MONTH.getTemplate(), String.valueOf(now.getMonthValue()));
        }
        if (template.contains(TemplateEnum.DAY.getTemplate())) {
            template = template.replace(TemplateEnum.DAY.getTemplate(), String.valueOf(now.getDayOfMonth()));
        }
        return template;
    }
}
