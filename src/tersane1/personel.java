/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tersane1.data.database;
import static tersane1.data.database.con;

/**
 *
 * @author HP
 */
public class personel {
    
    private final SimpleStringProperty ıd,isim,soyisim,level;
    
    public personel(String ıd,String isim,String soyisim,String level){
        this.ıd= new SimpleStringProperty(ıd);
        this.isim = new SimpleStringProperty(isim);
        this.soyisim =  new SimpleStringProperty(soyisim);
        this.level = new SimpleStringProperty(level); ;
    }

    public String getId() {
        return ıd.get();
    }

    public void setId(String value) {
        ıd.set(value);
    }

    public String getAd() {
        return isim.get();
    }

    public void setAd(String value) {
        isim.set(value);
    }

    public String getSoyad() {
        return soyisim.get();
    }

    public void setSoyad(String value) {
        soyisim.set(value);
    }

    public String getLevel() {
        return level.get();
    }

    public void setLevel(String value) {
        level.set(value);
    }
      public StringProperty adProperty(){
          return isim;
      }
       public StringProperty soyadProperty(){
          return soyisim;
      }
        public StringProperty idProperty(){
          return ıd;
      }
         public StringProperty levelProperty(){
          return level;
      }
       
    public static personel must(String id){
        
        String query="select * from CALISANLAR where ıd=?";
        personel mus=null;
        PreparedStatement prep;
        
        try {
            prep=con.prepareStatement(query);
            prep.setString(1, id);
            ResultSet res=prep.executeQuery();
            
            while(res.next()){
                mus=new personel(res.getString("ıd"),res.getString("isim"), res.getString("soyisim"),res.getString("level"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return mus;
    }

}

