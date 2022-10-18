package me.baobo.utils;

import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import me.baobo.meta.Fragment;

/**
 * @author Bob
 */
@UtilityClass
public class StringConvertUtil {
    
    public static List<Fragment> toList(String template) {
        List<Fragment> fragmentList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean hasLeftBracket = false;
        
        for (char c : template.toCharArray()) {
            if (c == '{') {
                if (sb.length() > 0) {
                    fragmentList.add(Fragment.builder()
                        .index(index++)
                        .template(sb.toString())
                        .needParse(false)
                        .build());
                    sb = new StringBuilder();
                }
                hasLeftBracket = true;
                sb.append(c);
                continue;
            }
            if (c == '}' && hasLeftBracket) {
                fragmentList.add(Fragment.builder()
                    .index(index++)
                    .template(sb.deleteCharAt(0).toString())
                    .needParse(true)
                    .build());
                sb = new StringBuilder();
                hasLeftBracket = false;
                continue;
            }
            sb.append(c);
        }
        
        if (sb.length() > 0) {
            fragmentList.add(Fragment.builder()
                .index(index)
                .template(sb.toString())
                .needParse(false)
                .build());
        }
        
        return fragmentList;
    }
}
