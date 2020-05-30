/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tersane1;

/**
 *
 * @author HP
 */
public class musteri {
    private String ad;
    private String il;
    private String ilce;
    private String iş;
    private String teklif;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getIş() {
        return iş;
    }

    public void setIş(String iş) {
        this.iş = iş;
    }

    public String getTeklif() {
        return teklif;
    }

    public void setTeklif(String teklif) {
        this.teklif = teklif;
    }
    
    public musteri(String isim,String sehir,String ilce,String isno,String teklif){
       this.ad=  isim;
       this.il=sehir;
       this.ilce=ilce;
       this.iş=isno;
       this.teklif=teklif;
    }
}
