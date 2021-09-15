package utils.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author chen
 */

public class ExcelReader {
    private HSSFWorkbook workbook;
    private int minColNum = 2;
    private int minRowNum = 2;
    private int cursor = 0;
    private int caseIndex = 0;
    private int propIndex = 1;
    private int totalStep;
    private int totalProp;
    private ArrayList<String> caseHeader;
    private ArrayList<String> propHeader;
    private HSSFSheet caseSheet;
    private HSSFSheet propSheet;

    public ExcelReader(FileInputStream f) throws IOException {
        this.workbook = new HSSFWorkbook(f);
    }

    public int getTotalRow(String sheetName){
        return workbook.getSheet(sheetName).getLastRowNum();
    }

    public int getTotalRow(int sheetIndex){
        return workbook.getSheetAt(sheetIndex).getLastRowNum();
    }

    public int getTotalCol(int sheetIndex){
        return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
    }

    public int getTotalCol(String sheetName){
        return workbook.getSheet(sheetName).getRow(0).getLastCellNum();
    }


    public HashMap<String, String> getNextStep() throws IOException {
        if(this.cursor == 0){
            totalStep = this.getTotalRow(caseIndex);
            totalProp = this.getTotalCol(propIndex);

            if(totalStep < minRowNum || totalProp < minColNum){
                return null;
            }

            caseHeader = getExcelHeader(caseIndex);
            caseSheet = workbook.getSheetAt(caseIndex);
        }
        this.cursor += 1;
        if(this.cursor >= totalStep){
            return null;
        }
        HashMap<String, String> stepMap = new HashMap<>();
        HSSFRow oneRow = caseSheet.getRow(this.cursor);
        for(String h: caseHeader){
            stepMap.put(h, oneRow.getCell(caseHeader.indexOf(h)).toString());
        }
        return stepMap;
    }

    private ArrayList<String> getExcelHeader(int sheetIndex) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        HSSFRow headerRow = sheet.getRow(0);
        for(int i = 0; i<getTotalCol(sheetIndex); i++){
            arrayList.add(headerRow.getCell(i).toString());
        }
        return arrayList;
    }


    //    public HashMap<String, String> getProp(){
//        HSSFSheet propSheet = workbook.getSheet("prop");
//        HashMap<String, String> propMap = new HashMap<>();
//        int totalRow = getTotalRow("prop");
//        for(int i = 0; i <totalRow; i++){
//            propMap.put(
//                    propSheet.getRow(i).getCell(0).toString(),
//                    propSheet.getRow(i).getCell(1).toString()
//            );
//        }
//        return propMap;
//    }
}
