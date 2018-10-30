/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpackage;

import java.io.Serializable;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TalhaBadik
 */
public class KiralamaBean implements Serializable{

    private kiralama k2;
    
    public KiralamaBean() {
        k2=new kiralama();
    }
      public String kaydol(){
        String sonuc="";
        try {
            baglanti b=new baglanti();
            Connection c=b.baglan();
            String sorgu="Insert into kiralama(Ad,Soyad,Email,Telefon,BaslangicTarihi,BitisTarihi) values(?,?,?,?,?,?)";
            PreparedStatement ps;
            ps=c.prepareStatement(sorgu);
           ps.setString(1,k2.getAd());
           ps.setString(2,k2.getSoyad());
           ps.setString(3,k2.getEmail());
           ps.setInt(4,k2.getTelefon());
           ps.setString(5,k2.getBaslangicTarihi());
           ps.setString(6,k2.getBitisTarihi());
           ps.executeUpdate();
        } catch (SQLException ex) {
                    System.out.println(ex.getMessage());

        }
        return  sonuc;
    }
    
    
    
    

 

    public kiralama getK2() {
        return k2;
    }

    public void setK2(kiralama k2) {
        this.k2 = k2;
    }
    
    
    
    
    
}
