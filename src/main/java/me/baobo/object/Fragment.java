package me.baobo.object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Bob
 */
@Data
@Builder
@AllArgsConstructor
public class Fragment {
    
    private int number;
    
    private String template;
    
    private boolean needParse;
}
