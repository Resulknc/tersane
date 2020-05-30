package tersane1;

import java.io.IOException;
import tersane1.data.database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static tersane1.data.database.con;


public class EkleController implements Initializable {

    @FXML
    private TextField ad;
    @FXML
    private TextField soyad;
    @FXML
    private TextField level;
    @FXML
    private Button ekle;
    @FXML
    private Label oldumu;
    @FXML
    private TextField ıd;
    @FXML
    private Button anasayfa;
    @FXML
    private Button düzelt;
    @FXML
    private Button sil;
    @FXML
    private  TableView<personel> personeller_table;
    @FXML
    private  TableColumn<personel, String> pers_ID;
    @FXML
    private  TableColumn<personel, String> pers_AD;
    @FXML
    private  TableColumn<personel,String> pers_SOYAD;
    @FXML
    private  TableColumn<personel,String> pers_LEVEL;
    
    private  ObservableList<personel>data;

    /**
     * Initializes the controller class.
     */
     public void tablo(){
       try {
            
            data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM calisanlar");
            while(rs.next()) {

                data.add(new personel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EkleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pers_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        pers_AD.setCellValueFactory(new PropertyValueFactory<>("ad"));
        pers_SOYAD.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        pers_LEVEL.setCellValueFactory(new PropertyValueFactory<>("level"));

        personeller_table.setItems(null);
        personeller_table.setItems(data);
    }
    
    @FXML
    public void HandleButtonAction(ActionEvent event){
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
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database.baglan();
        tablo();
         
    }    
    
    
    
    @FXML
    private void ekle(ActionEvent event){
        
        String name=ad.getText();
        String nach=soyad.getText();      
        String lev=level.getText();
        String id=ıd.getText();
        
        personel a=new personel(id,name,nach,lev);
        database.insert(a);
            
            
        oldumu.setTextFill(Color.GREEN);
        oldumu.setText("BAŞARIYLA EKLENDİ");
        tablo();
                 
    }

    @FXML
    private void düzelt(ActionEvent event) {
        String name=ad.getText();
        String soy=soyad.getText();
        String id=ıd.getText();
        String lev=level.getText();
        personel b=new personel(id,name,soy,lev);
        database.update(b);
        
        oldumu.setTextFill(Color.GREEN);
        oldumu.setText("BAŞARIYLA GÜNCELLENDİ");   
        tablo();
    }

    @FXML
    private void sil(ActionEvent event) {
        String id=ıd.getText();
     
        database.delete(id);
            
        oldumu.setTextFill(Color.GREEN);
        oldumu.setText("BAŞARIYLA SİLİNDİ");    
        tablo();
        
    }
}