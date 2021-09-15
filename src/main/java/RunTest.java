/**
 * @author chen
 */

import objs.Step;
import utils.FileReader;
import utils.excel.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class RunTest {
    public static void main(String[] args) throws IOException {
        Step step = new Step(args[0]);
        step.check();
        boolean flag = true;
        while (flag){
            HashMap<String, String> stepMap = step.getNext();
            if(stepMap == null){
                flag = false;
            }else {

            }

        }
//      HashMap<String, String> propMap = excelReader.getProp();
        HashMap<String, String> envMap = new HashMap<>();



    }
}
