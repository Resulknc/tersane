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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
            
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}