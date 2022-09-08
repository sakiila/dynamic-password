package me.bob.enums;

/**
 * @author Bob
 */
public enum TemplateEnum {
    YEAR("year"),
    MONTH("month"),
    DAY("day"),
    HOUR("hour"),
    MINUTE("minute"),
    /**
     * do not recommend
     */
    SECOND("second"),
    BRIGHT_DAY("bright_day"),
    BLACK_NIGHT("black_night"),
    ;
    
    String template;
    
    TemplateEnum(String template) {
        this.template = template;
    }
    
    public String getTemplate() {
        return template;
    }
}
