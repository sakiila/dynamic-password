package me.baobo.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import lombok.experimental.UtilityClass;
import me.baobo.enums.TemplateEnum;

/**
 * @author Bob
 */
@UtilityClass
public class DateTimeService {
    
    private static final Map<TemplateEnum, BiFunction<String, LocalDateTime, String>> MAP = new HashMap<>();
    
    static {
        MAP.put(TemplateEnum.YEAR,
            (template, time) -> template.replace(template, CalculateService.parse(template, time.getYear())));
        MAP.put(TemplateEnum.MONTH,
            (template, time) -> template.replace(template, CalculateService.parse(template, time.getMonthValue())));
        MAP.put(TemplateEnum.DAY,
            (template, time) -> template.replace(template, CalculateService.parse(template, time.getDayOfMonth())));
        MAP.put(TemplateEnum.HOUR,
            (template, time) -> template.replace(template, CalculateService.parse(template, time.getHour())));
        MAP.put(TemplateEnum.MINUTE,
            (template, time) -> template.replace(template, CalculateService.parse(template, time.getMinute())));
        MAP.put(TemplateEnum.SECOND,
            (template, time) -> template.replace(template, CalculateService.parse(template, time.getSecond())));
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
}
