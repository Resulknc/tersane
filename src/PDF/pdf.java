/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class pdf {
    
    public static void pdf() throws Exception{
        
        PdfSaveOptions pdf=new PdfSaveOptions(SaveFormat.PDF);
        Workbook work=new Workbook("NEW Rapor.xls");
        Worksheet sheet=work.getWorksheets().get(0);
        
        
        sheet.getPageSetup().setFitToPagesWide(1);
        sheet.getPageSetup().setFitToPagesTall(0);
        work.save("Rapor.pdf", pdf);
      
    }
    
    
    
}
