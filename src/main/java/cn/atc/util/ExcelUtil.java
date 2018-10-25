package cn.atc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.atc.pojo.ReceiveCollectMaterial;

public class ExcelUtil {

    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb,List<ReceiveCollectMaterial> list){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        style.setBorderTop((short)1);
        style.setBorderBottom((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
        
        //声明列对象
        HSSFCell cell = null;

        //设置数据
        cell = row.createCell(1);
        heBingCell(wb,sheet, sheet.createRow(0),0,0,0,2, "领料单号："+list.get(0).getId());
        heBingCell(wb,sheet, sheet.createRow(1),1,1,0,2, "发布时间："+list.get(0).getReleaseTime().substring(0,19));
        heBingCell(wb,sheet, sheet.createRow(2),2,2,0,2, "审核状态："+list.get(0).getAuditState().getAuditStateName());
        if(list.get(0).getIsAgree()==1) {
        	heBingCell(wb,sheet, sheet.createRow(3),3,3,0,2, "审批状态：已审批");
        }else {
        	heBingCell(wb,sheet, sheet.createRow(3),3,3,0,2, "审批状态：未审批");
        }
        heBingCell(wb,sheet, sheet.createRow(4),4,4,0,2, "打印时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //创建标题
        HSSFRow newRow = sheet.createRow(5);
        for(int i=0;i<title.length;i++){
            cell = newRow.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
       
        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 6);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                HSSFCell newCell = row.createCell(j);
                newCell.setCellValue(values[i][j]);
                newCell.setCellStyle(style);
            }
        }
        return wb;
    }
    
    /**
     * 合并列
     * @param sheet
     * @param cell
     * @param num
     * @param value
     */
    private static void heBingCell(HSSFWorkbook wb,HSSFSheet sheet,HSSFRow row,int one,int two,int three,int four,String value) {
    	HSSFCell oldCell = row.createCell(0);
    	HSSFCellStyle style = wb.createCellStyle();
        style.setBorderTop((short)1);
        style.setBorderBottom((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
    	oldCell.setCellValue(value);
    	oldCell.setCellStyle(style);
    	CellRangeAddress region=new CellRangeAddress(one,two, three,four);
    	sheet.addMergedRegion(region);
    }
}