/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Excel.excel;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import tersane1.ManyatikController;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class Manyatik2Controller implements Initializable {

    @FXML
    private Button önceki;
    @FXML
    private Button sonraki;
    @FXML
    private TextField ktpmes;
    @FXML
    private TextField cihaz;
    @FXML
    private TextField mptas;
    @FXML
    private TextField mıktek;
    @FXML
    private TextField uvis;
    @FXML
    private TextField ismef;
    @FXML
    private TextField muaböl;
    @FXML
    private ChoiceBox<String> aktip;
    @FXML
    private TextField issid;
    @FXML
    private TextField muaor;
    @FXML
    private TextField mıkgid;
    @FXML
    private TextField isis;
    @FXML
    private TextField yuzsic;
    @FXML
    private TextField alsid;
    @FXML
    private TextField yüz;
    @FXML
    private TextField cihtan;
  
    @FXML
    private Label hatam;
    @FXML
    private TextField testtarh;

    @FXML
    public void handleButtonAction(ActionEvent event){
        if(event.getSource()==önceki){
            
            try {
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();

                Scene scene= new Scene(FXMLLoader.load(getClass().getResource("manyatik.fxml")));
                stage.setScene(scene);
                stage.show();
            } catch(IOException e){
                System.err.println(e.getMessage());
            }
            
        }if(event.getSource()==sonraki){         
            
                if(ktpmes.getText().isEmpty()|| cihaz.getText().isEmpty()|| mptas.getText().isEmpty()|| mıktek.getText().isEmpty()||
                    uvis.getText().isEmpty()||ismef.getText().isEmpty()||muaböl.getText().isEmpty()||aktip.getValue().isEmpty()||issid.getText().isEmpty()||
                        yuzsic.getText().isEmpty()||alsid.getText().isEmpty()||yüz.getText().isEmpty()||cihtan.getText().isEmpty()){
                                hatam.setText("Lütfen Boşlukları Doldurunuz");
                }else {
                    try {
                        excel.exc1(ktpmes.getText(), 8, 4);
                        excel.exc1(cihaz.getText(), 9, 4);
                        excel.exc1(mptas.getText(), 10, 4);
                        excel.exc1(mıktek.getText(), 11, 4);
                        excel.exc1(uvis.getText(), 12, 4);
                        excel.exc1(ismef.getText(), 13, 4);
                        excel.exc1(muaböl.getText(),8 , 16);
                        excel.exc1(aktip.getValue(), 9, 16);
                        excel.exc1(issid.getText(), 10, 16);
                        excel.exc1(muaor.getText(), 11, 16);
                        excel.exc1(mıkgid.getText(), 12, 16);
                        excel.exc1(isis.getText(), 13, 16);
                        excel.exc1(yuzsic.getText(), 8, 25);
                        excel.exc1(alsid.getText(), 9, 25);
                        excel.exc1(yüz.getText(), 11, 25);
                        excel.exc1(cihtan.getText(), 12, 25);
                        excel.exc1(testtarh.getText(), 13, 25);


                        Node node=(Node) event.getSource();
                        Stage stage=(Stage) node.getScene().getWindow();
                        stage.close();

                        Scene scene= new Scene(FXMLLoader.load(getClass().getResource("manyatik3.fxml")));
                        stage.setScene(scene);
                        stage.show();
                    }catch(IOException e){
                        System.err.println(e.getMessage());
                    }
                }
                
            
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> akim = FXCollections.observableArrayList();
        akim.add("AC");
        akim.add("DC");
        aktip.getItems().addAll(akim);
        ktpmes.setText(RaporController.e.getKutup());
        cihaz.setText(RaporController.e.getAd());
        mptas.setText(RaporController.e.getTaşıyıcı());
        mıktek.setText(RaporController.e.getMıknatıs());
        uvis.setText(RaporController.e.getUvışık());
        ismef.setText(RaporController.e.getIşıkşid());
        
    }    
    
}
