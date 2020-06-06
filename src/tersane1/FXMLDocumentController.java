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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tersane1.data.database;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private Button btnrapor;
    @FXML
    private Button btncalisan;
    @FXML
    private Button btnekip;
    @FXML
    private Button btnmusteri;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btncalisan){
            try{
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("ekle.fxml")));
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
        }else if(event.getSource()==btnrapor){
           try{
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("rapor.fxml")));
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
           
        }else if(event.getSource()==btnmusteri){
            try{
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("musteri.fxml")));
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
        }else if(event.getSource()==btnekip){
            try{
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("ekipman.fxml")));
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.err.println(e.getMessage());
            }
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
    }    

    @FXML
    private void rapor(MouseEvent event) {
    }

    @FXML
    private void calisan(MouseEvent event) {
    }

    @FXML
    private void ekip(MouseEvent event) {
    }

    @FXML
    private void musteri(MouseEvent event) {
    }
    
}
