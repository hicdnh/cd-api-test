package utils;

import java.util.HashMap;

/**
 * @author chen
 */

public class Parser {
    /*
    1、如果入参内容为空，return null
    2、$.data=  return null
    3、$.data="abc" || $.data='abc' 返回{“data”: "abc"}
    4、$.data=12345.4324 return {“data”: 12345.4324}
    5、$.data=123 返回{“data”: 123}
    6、其他非null情况，返回{“data”: “xxx”}
     */

    public static HashMap<String, Object> parse(String str){
        HashMap<String, Object> resultMap = new HashMap<>();
        String[] lines = str.split("\n");
        if(lines.length == 0){
            return null;
        }else {
            for(String line: lines){
                String patten;
                if(line.contains("==")){
                    patten = "==";
                }else if(line.contains("=")){
                    patten = "=";
                }else {
                    continue;
                }

                String[] vars = line.split(patten);

                if(vars[1].contains("'") || vars[1].contains("\"")){
                    resultMap.put(vars[0], vars[1]);
                }else {
                    if(vars[1].contains(".")){
                        Float newVar;
                        newVar = Float.parseFloat(vars[1]);
                        assert resultMap != null;
                        resultMap.put(vars[0], newVar);
                        continue;
                    }else {
                        Integer newVar;
                        try{
                            newVar = Integer.parseInt(vars[1]);
                            resultMap.put(vars[0], newVar);
                        }catch (Exception e){
                            resultMap.put(vars[0], vars[1]);
                            System.out.println("非Integer类型");
                        }
                    }
                }
            }
        }
        return resultMap;
    }
}
