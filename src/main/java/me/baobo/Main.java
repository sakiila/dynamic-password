package me.baobo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import me.baobo.enums.TemplateEnum;
import me.baobo.meta.Fragment;
import me.baobo.utils.StringConvertUtil;

/**
 * @author Bob
 */
@UtilityClass
public class Main {
    
    /**
     * method 1: use string
     *
     * @param template
     * @param inputPassword
     * @return
     */
    public static boolean matchWithBracket(String template, String inputPassword) {
        if (Objects.isNull(template) || template.isEmpty()) {
            return false;
        }
        if (Objects.isNull(inputPassword) || inputPassword.isEmpty()) {
            return false;
        }
    
        return match(StringConvertUtil.toList(template), inputPassword);
    }
    
    /**
     * method 2: use fragment list
     *
     * @param fragmentList
     * @param inputPassword
     * @return
     */
    public static boolean match(List<Fragment> fragmentList, String inputPassword) {
        if (Objects.isNull(fragmentList) || fragmentList.isEmpty()) {
            return false;
        }
        if (Objects.isNull(inputPassword) || inputPassword.isEmpty()) {
            return false;
        }
        
        return fragmentList.stream()
            .map(Main::generatePassword)
            .collect(Collectors.joining())
            .equals(inputPassword);
    }
    
    private static String generatePassword(Fragment fragment) {
        if (fragment.isNeedParse()) {
            return TemplateEnum.parse(fragment.getTemplate());
        }
        return fragment.getTemplate();
    }
    
}
