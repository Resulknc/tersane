/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tersane1.data.database;
import tersane1.musteri;
import tersane1.ekipman;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class RaporController implements Initializable {

    @FXML
    private Button yaz;
    @FXML
    private Button anasayfa;
    @FXML
    private ChoiceBox<String> mstr;    
    @FXML
    private TextField opıd;
    @FXML
    private TextField degid;
    @FXML
    private TextField onıd;
    
    private static String mus;
    public static musteri a;
    private static String ekip;
    public static ekipman e;
    private static String deg;
    public static personel b;
    private static String onay;
    public static personel c;
    private static String op;
    public static personel d;
    
    @FXML
    private ChoiceBox<String> ekipm;
    @FXML
    private Label hatamessag;
    
    
    @FXML
    public void handleButtonAction(ActionEvent event){
        if(event.getSource()==yaz){
            if(opıd.getText().isEmpty()||onıd.getText().isEmpty()||degid.getText().isEmpty()||mstr.getValue().isEmpty()){
                hatamessag.setText("Lütfen Boşlukları Doldurunuz");
            }else {
                try{
                    mus=mstr.getSelectionModel().getSelectedItem();               
                    a=musteri.must(mus);
                    deg=degid.getText();
                    b=personel.must(deg);
                    onay=onıd.getText();
                    c=personel.must(onay);
                    op=opıd.getText();
                    d=personel.must(op);
                    ekip=ekipm.getSelectionModel().getSelectedItem();
                    e=ekipman.ekip(ekip);

                    Node node=(Node) event.getSource();
                    Stage stage=(Stage) node.getScene().getWindow();
                    stage.close();

                    Scene scene=new Scene(FXMLLoader.load(getClass().getResource("manyatik.fxml")));
                    stage.setScene(scene);
                    stage.show();
                
                
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }
           
        }if(event.getSource()==anasayfa){
            try{
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            
            database.baglan();
            String sql = "SELECT adı from musteri ";
            try {
                mstr.getItems().addAll(database.showMusteri(sql));
            } catch (SQLException ex) {
                Logger.getLogger(RaporController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query="Select adı from ekipman";
            try{
                ekipm.getItems().addAll(database.showekipman(query));
            }catch(SQLException ex){
                ex.printStackTrace();
            }
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                        
    } 
    
}
