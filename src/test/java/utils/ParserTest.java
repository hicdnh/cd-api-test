package utils;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

public class ParserTest {
    @Test
    /*
        $.a:  false
        $.a:  1
        $.b:  true
        $.b:  "1"
        $.c:  true
        $.c:  汉
     */

    public void parserTest(){
        String str = "$.a=1\n$.b=\"1\"\n$.c=汉";
        HashMap<String, Object> map = Parser.parse(str);
        for(String key: map.keySet()){
            System.out.println(key + ":  " + (map.get(key) instanceof String));
            System.out.println(key + ":  " + map.get(key));
        }
    }
}