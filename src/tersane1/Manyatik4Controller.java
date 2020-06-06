/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

import Excel.excel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Manyatik4Controller implements Initializable {

    @FXML
    private Button önceki;
    @FXML
    private Button bitir;
    @FXML
    private ChoiceBox<String> sonuc;
    @FXML
    private ChoiceBox<String> sonuc10;
    @FXML
    private ChoiceBox<String> sonuc3;
    @FXML
    private ChoiceBox<String> sonuc4;
    @FXML
    private ChoiceBox<String> sonuc5;
    @FXML
    private ChoiceBox<String> sonuc6;
    @FXML
    private ChoiceBox<String> sonuc7;
    @FXML
    private ChoiceBox<String> sonuc8;
    @FXML
    private ChoiceBox<String> sonuc9;
    @FXML
    private ChoiceBox<String> sonuc2;
    @FXML
    private TextField parcano;
    @FXML
    private TextField uzun;
    @FXML
    private TextField yon;
    @FXML
    private TextField kalın;
    @FXML
    private TextField cap;
    @FXML
    private TextField hatatip;
    @FXML
    private TextField hatayer;
    @FXML
    private Label hatames;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> sonu = FXCollections.observableArrayList();
        sonu.add("OK");
        sonu.add("RED");
        sonuc.getItems().addAll(sonu);
        sonuc2.getItems().addAll(sonu);
        sonuc3.getItems().addAll(sonu);
        sonuc4.getItems().addAll(sonu);
        sonuc5.getItems().addAll(sonu);
        sonuc6.getItems().addAll(sonu);
        sonuc7.getItems().addAll(sonu);
        sonuc8.getItems().addAll(sonu);
        sonuc9.getItems().addAll(sonu);
        sonuc10.getItems().addAll(sonu);
        
        try {
            excel.exc1(java.time.LocalDate.now().toString(), 41, 5);
            excel.exc1(java.time.LocalDate.now().toString(), 41, 15);
            excel.exc1(java.time.LocalDate.now().toString(), 41, 20);
        } catch (Exception ex) {
            Logger.getLogger(Manyatik4Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==önceki){
            
            try {
                
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.close();
                
            Scene scene= new Scene(FXMLLoader.load(getClass().getResource("manyatik3.fxml")));
            stage.setScene(scene);
            stage.show();
            } catch(IOException e){
                System.err.println(e.getMessage());
            }
            
        }if(event.getSource()==bitir){
            if(parcano.getText().isEmpty()||uzun.getText().isEmpty()||yon.getText().isEmpty()||kalın.getText().isEmpty()
                    ||cap.getText().isEmpty()||sonuc.getValue().isEmpty()){
                hatames.setText("Lütfen Bolukları Doldurunuz");
            }else{
                try {
                    excel.exc1(parcano.getText(), 24, 1);
                    excel.exc1(uzun.getText(), 24, 8);
                    excel.exc1(yon.getText(), 24, 11);
                    excel.exc1(kalın.getText(), 24, 17);
                    excel.exc1(cap.getText(), 24, 18);
                    excel.exc1(hatatip.getText(), 24, 22);
                    excel.exc1(hatayer.getText(), 24, 24);
                    excel.exc1(sonuc.getValue(), 24, 27);        
                    
                    excel.exc1(RaporController.d.getAd(), 39, 5);
                    excel.exc1(RaporController.d.getLevel(), 40, 5);
                    
                    excel.exc1(RaporController.b.getAd(), 39, 15);
                    excel.exc1(RaporController.b.getLevel(), 40, 15);
                    excel.exc1(RaporController.c.getAd(), 39, 20);
                    excel.exc1(RaporController.c.getLevel(), 40, 20);
                    
                    Node node=(Node) event.getSource();
                    Stage stage=(Stage) node.getScene().getWindow();
                    stage.close();

                    Scene scene= new Scene(FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));
                    stage.setScene(scene);
                    stage.show();
                } catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }
            
            
        }
        
    }
    
}
