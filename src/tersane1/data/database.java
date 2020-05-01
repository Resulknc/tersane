package tersane1.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {

    private static String kullanici_adi = "root";
    private static String parola = "5759";

    private static String db_ismi = "tersane";

    private static String host =  "localhost";

    private static int port = 3306;

    public static Connection con ;

  
    private static PreparedStatement ps;

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
        public static void insert(String id,String name,String soy,String lev){
        String sql="INSERT INTO CALISANLAR(ıd,isim,soyisim,level) VALUES(?,?,?,?)";
        try {           
            ps=database.con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, soy);
            ps.setString(4, lev);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }
    public static void update(String id,String name,String soy,String lev){
        String sql="UPDATE CALISANLAR SET isim=?,soyisim=?,level=?  WHERE ıd=?";
        try {
            ps=database.con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, soy);
            ps.setString(3, lev);
            ps.setString(4, id);
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
         
}