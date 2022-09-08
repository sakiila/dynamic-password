package me.bob.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import me.bob.enums.TemplateEnum;

/**
 * @author Bob
 */
public class DateTime {
    
    private static final Map<Predicate<String>, BiFunction<String, LocalDateTime, String>> MAP = new HashMap<>();
    
    static {
        MAP.put(template -> template.contains(TemplateEnum.YEAR.getTemplate()),
            (template, time) -> template.replace(template, Calculate.parse(template, time.getYear())));
        MAP.put(template -> template.contains(TemplateEnum.MONTH.getTemplate()),
            (template, time) -> template.replace(template, Calculate.parse(template, time.getMonthValue())));
        MAP.put(template -> template.contains(TemplateEnum.DAY.getTemplate()),
            (template, time) -> template.replace(template, Calculate.parse(template, time.getDayOfMonth())));
        MAP.put(template -> template.contains(TemplateEnum.HOUR.getTemplate()),
            (template, time) -> template.replace(template, Calculate.parse(template, time.getHour())));
        MAP.put(template -> template.contains(TemplateEnum.MINUTE.getTemplate()),
            (template, time) -> template.replace(template, Calculate.parse(template, time.getMinute())));
        MAP.put(template -> template.contains(TemplateEnum.SECOND.getTemplate()),
            (template, time) -> template.replace(template, Calculate.parse(template, time.getSecond())));
    }
    
    public static String parse(String template) {
        LocalDateTime now = LocalDateTime.now();
        for (Entry<Predicate<String>, BiFunction<String, LocalDateTime, String>> entry : MAP.entrySet()) {
            if (entry.getKey().test(template)) {
                template = entry.getValue().apply(template, now);
            }
        }
        return template;
    }
}
