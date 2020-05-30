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
import tersane1.data.database;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EkipmanController implements Initializable {

    @FXML
    private Button anasayfa;
    @FXML
    private Button ekipekle;
    @FXML
    private Button ekipsil;
    @FXML
    private Button ekipupdate;
    @FXML
    private TextField ad;
    @FXML
    private TextField isik;
    @FXML
    private TextField uv;
    @FXML
    private TextField mıknatıs;
    @FXML
    private TextField tasiyici;
    @FXML
    private TextField ktp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==anasayfa){
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
        else if(event.getSource()==ekipekle){
            String isim=ad.getText();
            String ıssık=this.isik.getText();
            String uv=this.uv.getText();
            String mık=mıknatıs.getText();
            String tsyc=tasiyici.getText();
            String kutup=ktp.getText();
            
            ekipman a=new ekipman(isim,  kutup,  tsyc,  mık,  uv,  ıssık);
            database.ekiprinsert(a);
            
        }else if(event.getSource()==ekipupdate){
            String isim=ad.getText();
            String ıssık=this.isik.getText();
            String uv=this.uv.getText();
            String mık=mıknatıs.getText();
            String tsyc=tasiyici.getText();
            String kutup=ktp.getText();
            
            ekipman a=new ekipman(isim,  kutup,  tsyc,  mık,  uv,  ıssık);
            database.ekipupdate(a);
            
        }else if(event.getSource()==ekipsil){
            String isim=ad.getText();
            database.ekipdelete(isim);
        }
    }
    
}
