package utils;


import com.jayway.jsonpath.JsonPath;

/**
 * @author chen
 */

public class AssertByJsonPath {
    public static <T> boolean equal(String jsonStr, String patten, T expVal){
        Object result = JsonPath.read(jsonStr, patten);
        if(result.equals(expVal)) {
            return true;
        }else {
            return false;
        }
    }
}
