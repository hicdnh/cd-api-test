package objs.utilities;

import java.util.ArrayList;

/**
 * @author chen
 */
public class Pre {
    public Pre(ArrayList<String> pre){
        for(String p: pre){
            // 设置env变量
            if(p.contains("$_set ")){
                p.replaceAll("$_", "");
            }
        }
    }
}
