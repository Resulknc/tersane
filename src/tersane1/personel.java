/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

}

