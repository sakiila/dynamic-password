package me.baobo.service;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import me.baobo.enums.TemplateEnum;

/**
 * @author Bob
 */
public class ParseDateTime {
    
    private static final Map<TemplateEnum, BiFunction<String, LocalDateTime, String>> MAP = new EnumMap<>(TemplateEnum.class);
    
    static {
        MAP.put(TemplateEnum.YEAR,
            (template, time) -> template.replace(template, ParseMath.parse(template, time.getYear())));
        MAP.put(TemplateEnum.MONTH,
            (template, time) -> template.replace(template, ParseMath.parse(template, time.getMonthValue())));
        MAP.put(TemplateEnum.DAY,
            (template, time) -> template.replace(template, ParseMath.parse(template, time.getDayOfMonth())));
        MAP.put(TemplateEnum.HOUR,
            (template, time) -> template.replace(template, ParseMath.parse(template, time.getHour())));
        MAP.put(TemplateEnum.MINUTE,
            (template, time) -> template.replace(template, ParseMath.parse(template, time.getMinute())));
        MAP.put(TemplateEnum.SECOND,
            (template, time) -> template.replace(template, ParseMath.parse(template, time.getSecond())));
    }
    
    public static String parse(String template) {
        LocalDateTime now = LocalDateTime.now();
        for (Entry<TemplateEnum, BiFunction<String, LocalDateTime, String>> entry : MAP.entrySet()) {
            if (template.contains(entry.getKey().getTemplate())) {
                template = entry.getValue().apply(template, now);
            }
        }
        return template;
    }
    
    public static String parseYear(String template) {
        LocalDateTime now = LocalDateTime.now();
        return template.replace(template, ParseMath.parse(template, now.getYear()));
    }
    
    public static String parseMonth(String template) {
        LocalDateTime now = LocalDateTime.now();
        return template.replace(template, ParseMath.parse(template, now.getMonthValue()));
    }
    
    public static String parseDay(String template) {
        LocalDateTime now = LocalDateTime.now();
        return template.replace(template, ParseMath.parse(template, now.getDayOfMonth()));
    }
    
    public static String parseHour(String template) {
        LocalDateTime now = LocalDateTime.now();
        return template.replace(template, ParseMath.parse(template, now.getHour()));
    }
    
    public static String parseMinute(String template) {
        LocalDateTime now = LocalDateTime.now();
        return template.replace(template, ParseMath.parse(template, now.getMinute()));
    }
    
    public static String parseSecond(String template) {
        LocalDateTime now = LocalDateTime.now();
        return template.replace(template, ParseMath.parse(template, now.getSecond()));
    }
    
    
}
