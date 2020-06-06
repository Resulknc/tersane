package tersane1.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import tersane1.EkleController;
import tersane1.ekipman;
import tersane1.musteri;
import tersane1.personel;


public class database {

    private static String kullanici_adi = "root";
    private static String parola = "5759";

    private static String db_ismi = "tersane";

    private static String host =  "localhost";

    private static int port = 3306;

    public static Connection con ;
        
  
    private static PreparedStatement ps;
    private static ResultSet rs;
    
        public static void baglan(){
            // "jbdc:mysql://localhost:3306/" 
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi+ "?useUnicode=true&characterEncoding=utf8";


             try { 
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, kullanici_adi, parola);
                System.out.println(" DB Bağlantısı Başarılı...");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        
    public static void insert(personel a){
        String sql="INSERT INTO CALISANLAR(ıd,isim,soyisim,level) VALUES(?,?,?,?)";
        try {           
            ps=database.con.prepareStatement(sql);
            ps.setString(1, a.getId());
            ps.setString(2, a.getAd());
            ps.setString(3, a.getSoyad());
            ps.setString(4, a.getLevel());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }
    public static void update(personel a){
        String sql="UPDATE CALISANLAR SET isim=?,soyisim=?,level=?  WHERE ıd=?";
        try {
            ps=database.con.prepareStatement(sql);
            ps.setString(1, a.getAd());
            ps.setString(2, a.getSoyad());
            ps.setString(3, a.getLevel());
            ps.setString(4, a.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public static void delete(String id){
        String sql="DELETE FROM CALISANLAR WHERE ıd=?";
        
        try {
            ps=database.con.prepareStatement(sql);
            ps.setString(1, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public static void mstrinsert(musteri ms){
        String sql="INSERT INTO musteri(adı,il,ilce,isemri,teklifno) VALUES(?,?,?,?,?)";
        try {           
            ps=database.con.prepareStatement(sql);
            ps.setString(1, ms.getAd());
            ps.setString(2, ms.getIl());
            ps.setString(3, ms.getIlce());
            ps.setString(4, ms.getIş());
            ps.setString(5, ms.getTeklif());            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public static void mstupdate(musteri a){
        String sql="UPDATE musteri SET il=?,ilce=?,isemri=?,teklifno=?  WHERE adı=?";
        try {
            ps=database.con.prepareStatement(sql);
            ps.setString(1, a.getIl());
            ps.setString(2, a.getIlce());
            ps.setString(3, a.getIş());
            ps.setString(4, a.getTeklif());
            ps.setString(5, a.getAd());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public static void mstdelete(String ad){
        String sql="DELETE FROM musteri WHERE adı=?";
        
        try {
            ps=database.con.prepareStatement(sql);
            ps.setString(1, ad);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public static void ekiprinsert(ekipman ekip){
        String sql="INSERT INTO ekipman(adı,kutupmsf,mptasiyici,mıknatıs,uvisik,isiksid) VALUES(?,?,?,?,?,?)";
        try {           
            ps=database.con.prepareStatement(sql);
            ps.setString(1, ekip.getAd());
            ps.setString(2, ekip.getKutup());
            ps.setString(3, ekip.getTaşıyıcı());
            ps.setString(4, ekip.getMıknatıs());
            ps.setString(5, ekip.getUvışık());    
            ps.setString(6, ekip.getIşıkşid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    public static void ekipupdate(ekipman ekip){
        String sql="UPDATE ekipman SET kutupmsf=?,mptasiyici=?,mıknatıs=?,uvisik=?,isiksid=?   WHERE adı=?";
        try {
            ps=database.con.prepareStatement(sql);
            ps.setString(6, ekip.getAd());
            ps.setString(1, ekip.getKutup());
            ps.setString(2, ekip.getTaşıyıcı());
            ps.setString(3, ekip.getMıknatıs());
            ps.setString(4, ekip.getUvışık());    
            ps.setString(5, ekip.getIşıkşid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public static void ekipdelete(String ad){
        String sql="DELETE FROM ekipman WHERE adı=?";
        
        try {
            ps=database.con.prepareStatement(sql);
            ps.setString(1, ad);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public static ObservableList<String> showMusteri(String sql) throws SQLException {
        ObservableList<String> musteriList = FXCollections.observableArrayList();
        
        ps=database.con.prepareStatement(sql);
        
        rs=ps.executeQuery("Select adı from musteri");
        while(rs.next()){
            musteriList.addAll(rs.getString("adı"));
        }
        return musteriList;
    }
    public static ObservableList<String> showekipman(String sql) throws SQLException {
        ObservableList<String> ekipmanList = FXCollections.observableArrayList();
        
        ps=database.con.prepareStatement(sql);
        
        rs=ps.executeQuery("Select adı from ekipman");
        while(rs.next()){
            ekipmanList.addAll(rs.getString("adı"));
        }
        return ekipmanList;
    }
    
    
}