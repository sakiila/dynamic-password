package me.baobo.meta;

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
    
    private int index;
    
    private String template;
    
    private boolean needParse;
}
