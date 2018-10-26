
package beanpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class baglanti {
     public Connection baglan(){
             Connection c=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/arabakiralama", "root", "");
        } catch (Exception ex) {
            Logger.getLogger(baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
        
    }
}
