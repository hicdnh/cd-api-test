package utils;

import org.testng.annotations.Test;

public class AssertByJsonPathTest {
    @Test
    public void equalTest(){
        String jsonStr = "{\"a\": \"1\"}";
        String jsonStr_001 = "{\"a\": [1,2,3]}";
        String patten = "$.a";
//String patten = "$.b";如果对应的变量不存在；就提示异常
//com.jayway.jsonpath.PathNotFoundException: No results for path: $['b']
        String expVal = "1";
        int expVal_001 = 1;
//        Object result = AssetByJsonPath.equal(
//                jsonStr, patten, expVal
//        );

        Object result = AssertByJsonPath.equal(
                jsonStr, patten, expVal_001
        );

//        Object result_001 = AssetByJsonPath.equal(
//                jsonStr_001, patten, expVal
//        );
        System.out.println(result instanceof Boolean);
//        System.out.println(result_001 instanceof Boolean);
//        System.out.println(result instanceof Integer);
//        System.out.println(result instanceof String);
//        System.out.println(result instanceof ArrayList);
        System.out.println(result);
//        System.out.println(result_001);
    }

}