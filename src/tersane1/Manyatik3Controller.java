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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tersane1.ManyatikController;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class Manyatik3Controller implements Initializable {

    @FXML
    private Button önceki;
    @FXML
    private Button sonraki;
    @FXML
    private CheckBox optiona;
    @FXML
    private CheckBox optionb;
    @FXML
    private TextField sapma;
   
    @FXML
    private TextField acıklama;
    @FXML
    private Label hatame;
    @FXML
    private DatePicker muaytarh;

    @FXML
    public void handleButtonAction(ActionEvent event){
        if(event.getSource()==önceki){
            
            try {
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.close();
                
            Scene scene= new Scene(FXMLLoader.load(getClass().getResource("manyatik2.fxml")));
            stage.setScene(scene);
            stage.show();
            } catch(IOException e){
                System.err.println(e.getMessage());
            }
            
        }if(event.getSource()==sonraki){
            
           
                if(sapma.getText().isEmpty()){
                    hatame.setText("Lütfen Boşluklar doldurunuz");
                }else{
                    try {
                        excel.exc1(sapma.getText(), 19, 7);
                        excel.exc1(muaytarh.getValue().toString(), 20, 7);
                        excel.exc1(acıklama.getText(), 21, 7);

                        Node node=(Node) event.getSource();
                        Stage stage=(Stage) node.getScene().getWindow();
                        stage.close();

                        Scene scene= new Scene(FXMLLoader.load(getClass().getResource("manyatik4.fxml")));
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
        // TODO
    }    
    
}
