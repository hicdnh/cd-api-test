package objs.utilities;

import utils.AssertByJsonPath;
import utils.Parser;

import java.util.HashMap;

/**
 * @author chen
 */
public class Assert{
    private HashMap<String, Object> assMap = new HashMap<>();

    /**
     * 字符串解析为HashMap
     * @param t 直解析String类型；其他类型不做解析
     * @return boolean 解析结果
     */

    public <T> boolean init(T t) {
        if(t instanceof String){
            assMap = Parser.parse((String) t);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 校验解析结果合法性
     * @param t
     * @return boolean 校验结果
     */

    public <T> boolean check(T t) {
        // TODO: 2021/9/9 后续实现
        return true;
    }

    /**
     * 执行任务：例如返回header，data，method等
     *
     * @param t resJson
     * @return boolean 所有结果都正确，返回true
     */

    public <T> boolean run(T t) {
        String resJson = (String) t;
        for(String expKey: assMap.keySet()){
            if(AssertByJsonPath.equal(resJson, expKey, assMap.get(expKey))){
                continue;
            }
            return false;
        }
        return true;
    }
}