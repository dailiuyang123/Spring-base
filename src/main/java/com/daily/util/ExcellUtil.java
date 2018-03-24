package com.daily.util;

import com.daily.web.controller.ExcellController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Azir on 2018/2/25.
 */
public class ExcellUtil {

    public static void createExcel(List<Map<String, String>> list, OutputStream output, HttpServletRequest request) {

        Workbook tempWorkBook = null;
        Sheet tempSheet = null;
        int rowIndex = 5;
        Row tempRow = null;
        Cell tempCell = null;
        InputStream inputstream = null;
        try {
            //inputstream = request.getSession().getServletContext().getResourceAsStream("/templates/test.xlsx");
            //inputstream=ExcellUtil.class.getResourceAsStream("/templates/test.xlsx");
            String path = ExcellController.class.getResource("/").getPath() + "/templet/Demo.xlsx";
            File file = new File(path);
            boolean exists = file.exists();
            System.out.println(exists);
            FileInputStream fileInputStream = new FileInputStream(file);

            inputstream = fileInputStream;
            // 获取模板
            tempWorkBook = new XSSFWorkbook(inputstream);
            // 获取模板sheet页
            tempSheet = tempWorkBook.getSheetAt(0);



            // 将数据写入excel
            for (int i = 0; i < list.size(); i++) {

                int cellNo = 0;
                // 获取指定行
                tempRow = tempSheet.getRow(0);

                //获取当前sheet最后一行数据对应的行索引
                int currentLastRowIndex = tempSheet.getLastRowNum();
                int newRowIndex = currentLastRowIndex + 1;
                XSSFRow newRow = (XSSFRow) tempSheet.createRow(newRowIndex);
                //开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始
                int cellIndex = 0;

                //创建一个单元格，设置其内的数据格式为字符串，并填充内容，其余单元格类同
                XSSFCell newNameCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
                newNameCell.setCellValue(list.get(i).get("No").toString());
                XSSFCell newGenderCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
                newGenderCell.setCellValue(list.get(i).get("name"));
                XSSFCell newAgeCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_NUMERIC);
                newAgeCell.setCellValue(list.get(i).get("sex"));
                XSSFCell newAddressCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_NUMERIC);
                newAddressCell.setCellValue(list.get(i).get("age").toString());

            }
            // 将内容写入Excel
            tempWorkBook.write(output);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
