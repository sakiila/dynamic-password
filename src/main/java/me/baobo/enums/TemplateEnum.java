package me.baobo.enums;

import java.util.Arrays;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.baobo.service.ParseDateTime;

/**
 * @author Bob
 */
@AllArgsConstructor
public enum TemplateEnum {
    
    YEAR("year", ParseDateTime::parseYear),
    MONTH("month", ParseDateTime::parseMonth),
    DAY("day", ParseDateTime::parseDay),
    HOUR("hour", ParseDateTime::parseHour),
    MINUTE("minute", ParseDateTime::parseMinute),
    /**
     * do not recommend
     */
    SECOND("second", ParseDateTime::parseSecond),
    BRIGHT_DAY("bright_day", ParseDateTime::parse),
    BLACK_NIGHT("black_night", ParseDateTime::parse),
    ;
    
    @Getter
    String template;
    
    @Getter
    Function<String, String> function;
    
    public static String parse(String template) {
        return Arrays.stream(TemplateEnum.values())
            .filter(templateEnum -> template.contains(templateEnum.getTemplate()))
            .map(TemplateEnum::getFunction)
            .findFirst()
            .orElse(Function.identity())
            .apply(template);
    }
}
