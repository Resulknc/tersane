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
import javafx.stage.Stage;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            
            try {
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
