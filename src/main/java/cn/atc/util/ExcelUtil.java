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
     * ����Excel
     * @param sheetName sheet����
     * @param title ����
     * @param values ����
     * @param wb HSSFWorkbook����
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb,List<ReceiveCollectMaterial> list){

        // ��һ��������һ��HSSFWorkbook����Ӧһ��Excel�ļ�
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // �ڶ�������workbook�����һ��sheet,��ӦExcel�ļ��е�sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������
        HSSFRow row = sheet.createRow(0);

        // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ
        style.setBorderTop((short)1);
        style.setBorderBottom((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
        
        //�����ж���
        HSSFCell cell = null;

        //��������
        cell = row.createCell(1);
        heBingCell(wb,sheet, sheet.createRow(0),0,0,0,2, "���ϵ��ţ�"+list.get(0).getId());
        heBingCell(wb,sheet, sheet.createRow(1),1,1,0,2, "����ʱ�䣺"+list.get(0).getReleaseTime().substring(0,19));
        heBingCell(wb,sheet, sheet.createRow(2),2,2,0,2, "���״̬��"+list.get(0).getAuditState().getAuditStateName());
        if(list.get(0).getIsAgree()==1) {
        	heBingCell(wb,sheet, sheet.createRow(3),3,3,0,2, "����״̬��������");
        }else {
        	heBingCell(wb,sheet, sheet.createRow(3),3,3,0,2, "����״̬��δ����");
        }
        heBingCell(wb,sheet, sheet.createRow(4),4,4,0,2, "��ӡʱ�䣺"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //��������
        HSSFRow newRow = sheet.createRow(5);
        for(int i=0;i<title.length;i++){
            cell = newRow.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
       
        //��������
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 6);
            for(int j=0;j<values[i].length;j++){
                //�����ݰ�˳�򸳸���Ӧ���ж���
                HSSFCell newCell = row.createCell(j);
                newCell.setCellValue(values[i][j]);
                newCell.setCellStyle(style);
            }
        }
        return wb;
    }
    
    /**
     * �ϲ���
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