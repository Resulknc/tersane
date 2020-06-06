/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Excel.excel;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ManyatikController implements Initializable {

    @FXML
    private Button sonraki;
    @FXML
    private TextField sehir;
    @FXML
    private TextField mstradı;
    @FXML
    private TextField muayenestnd;
    @FXML
    private TextField degerstnd;
    @FXML
    private TextField muaypro;
    @FXML
    private TextField muaykap;
    @FXML
    private TextField res;
    @FXML
    private TextField sayfa;
    @FXML
    private TextField yuzey;
    @FXML
    private TextField muayasa;
    @FXML
    private TextField isemri;
    @FXML
    private TextField teklifno;
    @FXML
    private TextField projead;
    /*public static String musad;
    public static String il;
    public static String proad;
    public static String muaystand;
    public static String degerstand;
    public static String muayenepros;
    public static String muayenekap;
    public static String resim;
    public static String yuzeyd;
    public static String muayeneaş;
    public static String sayfan;
    public static String raporn;
    public static String raport;
    public static String işem;
    public static String teklifn;*/
    @FXML
    private Label hata;
    @FXML
    private TextField raporno;
    @FXML
    private DatePicker tarih;
    
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException{
        if(event.getSource()==sonraki){
            if(sehir.getText().isEmpty() || mstradı.getText().isEmpty() ||muayenestnd.getText().isEmpty()|| degerstnd.getText().isEmpty()||
                muaypro.getText().isEmpty()|| sayfa.getText().isEmpty()||yuzey.getText().isEmpty()||muayasa.getText().isEmpty()||
                isemri.getText().isEmpty()||teklifno.getText().isEmpty()){
                
                    hata.setText("Lütfen boşulları doldurunuz");
                    
            }else {
               
                excel.exc(mstradı.getText(),2,3);              
                excel.exc1(projead.getText(), 3, 3);               
                excel.exc1(sehir.getText(), 4, 3);
                excel.exc1(muayenestnd.getText(), 5, 3);
                excel.exc1(degerstnd.getText(), 6, 3);
                excel.exc1(muaypro.getText(), 2, 19);
                excel.exc1(muaykap.getText(), 3, 19);
                excel.exc1(res.getText(), 4, 19);
                excel.exc1(yuzey.getText(), 5, 19);
                excel.exc1(muayasa.getText(), 6, 19);
                excel.exc1(sayfa.getText(), 2, 26);
                excel.exc1(raporno.getText(), 3, 26);
                excel.exc1(tarih.getValue().toString(), 4, 26);
                excel.exc1(isemri.getText(), 5, 26);
                excel.exc1(teklifno.getText(), 6, 26);
                
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();

                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("manyatik2.fxml")));
                stage.setScene(scene);
                stage.show();
            }    
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mstradı.setText(RaporController.a.getAd());
        sehir.setText(RaporController.a.getIl());
        isemri.setText(RaporController.a.getIş());
        teklifno.setText(RaporController.a.getTeklif());
        
    }
    
    
}
