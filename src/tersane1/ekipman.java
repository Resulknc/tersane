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
import tersane1.data.database;
import static tersane1.data.database.con;

/**
 *
 * @author HP
 */
public class ekipman {
    private String ad;
    private String kutup;
    private String taşıyıcı;
    private String mıknatıs;
    private String uvışık;
    private String ışıkşid;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKutup() {
        return kutup;
    }

    public void setKutup(String kutup) {
        this.kutup = kutup;
    }

    public String getTaşıyıcı() {
        return taşıyıcı;
    }

    public void setTaşıyıcı(String taşıyıcı) {
        this.taşıyıcı = taşıyıcı;
    }

    public String getMıknatıs() {
        return mıknatıs;
    }

    public void setMıknatıs(String mıknatıs) {
        this.mıknatıs = mıknatıs;
    }

    public String getUvışık() {
        return uvışık;
    }

    public void setUvışık(String uvışık) {
        this.uvışık = uvışık;
    }

    public String getIşıkşid() {
        return ışıkşid;
    }

    public void setIşıkşid(String ışıkşid) {
        this.ışıkşid = ışıkşid;
    }

    public ekipman(String ad, String kutup, String taşıyıcı, String mıknatıs, String uvışık, String ışıkşid) {
        this.ad = ad;
        this.kutup = kutup;
        this.taşıyıcı = taşıyıcı;
        this.mıknatıs = mıknatıs;
        this.uvışık = uvışık;
        this.ışıkşid = ışıkşid;
    }  
 
    public static ekipman ekip(String name){
        
        String query="select * from ekipman where adı=?";
        ekipman mus=null;
        PreparedStatement prep;
        
        try {
            prep=con.prepareStatement(query);
            prep.setString(1, name);
            ResultSet res=prep.executeQuery();
            
            while(res.next()){
                mus=new ekipman(res.getString("adı"),res.getString("kutupmsf"), res.getString("mptasiyici"),
                    res.getString("mıknatıs"),res.getString("uvisik"),res.getString("isiksid"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return mus;
    }
}
