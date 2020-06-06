/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.TextField;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class excel {
    public static void exc(String a,int b,int c)throws IOException{
        POIFSFileSystem fs = new POIFSFileSystem(
        new FileInputStream("RAPOR.xls"));
 
        //FileInputStream fs= new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\tersane1_2\\raport.xlsx"));
         
        HSSFWorkbook work=new HSSFWorkbook(fs,true);
            
        HSSFSheet sheet=work.getSheetAt(0);
       
        HSSFRow row=sheet.getRow(b);
        HSSFCell cell=row.getCell(c);
      
        cell.setCellValue(a);
        FileOutputStream fo=new FileOutputStream("NEW Rapor.xls");
        work.write(fo);
        fs.close();
        fo.close();
    }
    public static void exc1(String a,int b,int c)throws IOException{
            POIFSFileSystem fs = new POIFSFileSystem(
            new FileInputStream("NEW Rapor.xls"));

            //FileInputStream fs= new FileInputStream(new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\tersane1_2\\raport.xlsx"));

            HSSFWorkbook work=new HSSFWorkbook(fs,true);

            HSSFSheet sheet=work.getSheetAt(0);

            HSSFRow row=sheet.getRow(b);
            HSSFCell cell=row.getCell(c);

            cell.setCellValue(a);
            FileOutputStream fo=new FileOutputStream("NEW Rapor.xls");
            work.write(fo);
            fs.close();
            fo.close();
        }      
}
