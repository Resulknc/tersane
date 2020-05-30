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
public class MusteriController implements Initializable {

    @FXML
    private Button anasayfa;
    @FXML
    private Button mstekle;
    @FXML
    private Button mstsil;
    @FXML
    private Button mstupdate;
    @FXML
    private TextField ad;
    @FXML
    private TextField teklif;
    @FXML
    private TextField is;
    @FXML
    private TextField ilce;
    @FXML
    private TextField il;

    @FXML
    public void handleButtonAction(ActionEvent event){
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
        else if(event.getSource()==mstekle){
            String isim=ad.getText();
            String sehir=il.getText();
            String ilc=ilce.getText();
            String is= this.is.getText();
            String teklif= this.teklif.getText();
            
            musteri mst=new musteri(isim,sehir,ilc,is,teklif);
            database.mstrinsert(mst);
            
        }else if(event.getSource()==mstupdate){
            String isim=ad.getText();
            String sehir=il.getText();
            String ilc=ilce.getText();
            String is= this.is.getText();
            String teklif= this.teklif.getText();
            
            musteri mst=new musteri(isim,sehir,ilc,is,teklif);
            database.mstupdate(mst);
            
        }else if(event.getSource()==mstsil){
            String isim=ad.getText();
            database.mstdelete(isim);
        }
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database.baglan();
    }    
    
}
