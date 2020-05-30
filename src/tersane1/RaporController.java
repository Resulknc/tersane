/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

import java.io.IOException;
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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import tersane1.data.database;

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
    public void handleButtonAction(ActionEvent event){
        if(event.getSource()==yaz){
            try{
                
                String secilenmstr=mstr.getSelectionModel().getSelectedItem().toString();
                System.out.println(secilenmstr);
                
                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
                
                Scene scene=new Scene(FXMLLoader.load(getClass().getResource("manyatik.fxml")));
                stage.setScene(scene);
                stage.show();
                
                
            }catch(IOException e){
                System.err.println(e.getMessage());
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
        String sql = "SELECT adı from musteri ";
        try {
            mstr.getItems().addAll(database.showMusteri(sql));
        } catch (SQLException ex) {
            Logger.getLogger(RaporController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
