package objs;

import objs.utilities.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import utils.excel.ExcelReader;

import java.io.*;
import java.util.HashMap;

/**
 * @author chen
 */

public class Step {
    private String path = "./case.xlsx";
    private int caseIndex = 0;
    private int propIndex = 1;
    private int totalRow;
    private int cursor = 0;
    private int minRow = 2;
    private int minCol = 2;

    private ExcelReader excelReader;

    public Step(String excelFIle){
        this.path = excelFIle;
    }

    public Step(String excelFIle, int caseIndex, int propIndex){
        this.path = excelFIle;
        this.caseIndex = caseIndex;
        this.propIndex = propIndex;
    }

    public Step(){
    }

    public boolean check() throws IOException {
        /**
         * 以下情况返回false
         * 1、文件不存在
         * 2、行数或者列数小于2
         */
        File file = new File(this.path);
        if(!file.exists()){
            return false;
        }else {
            this.excelReader = new ExcelReader(new FileInputStream(path));
            this.totalRow = this.excelReader.getTotalRow(caseIndex);
            if(this.excelReader.getTotalRow(caseIndex) == minRow || this.excelReader.getTotalCol(caseIndex) < minCol){
                return false;
            }
            return true;
        }
    }

    public HashMap<String, String> getNext() throws IOException {
        if(this.cursor + 1 <= totalRow){
            this.cursor += 1;
            return this.excelReader.getRow(0, 1);
        }else {
            return null;
        }
    }



//    public boolean check(){
//        url.check()
//    }



}
