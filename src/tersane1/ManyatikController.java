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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    public void handleButtonAction(ActionEvent event) throws IOException{
        if(event.getSource()==sonraki){
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            stage.close();
                
            Scene scene=new Scene(FXMLLoader.load(getClass().getResource("manyatik2.fxml")));
            stage.setScene(scene);
            stage.show();
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
