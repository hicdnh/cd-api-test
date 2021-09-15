//package objs.ware;
//
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//
//import static org.testng.Assert.*;
//
//public class AssertTest {
//    String data_001 = "$.a==1";
//    String data_002 = "$.a==\"1\"";
//    @Test
//    public void getAssertConditionTest(){
//        HashMap<String, Object> condition = Assert.getAssertCondition(data_001);
//        System.out.println(condition.toString());
//        System.out.println(condition.get("$.a"));
//        System.out.println(condition.get("$.a") instanceof Integer);
//        System.out.println(condition.get("$.a") instanceof String);
//        System.out.println(condition.get("$.a") instanceof Object);
//    }
//
//}