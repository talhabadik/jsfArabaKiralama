/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanpackage;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

/**
 *
 * @author TalhaBadik
 */
public class KullaniciBean implements Serializable{
    private String KullaniciAdi;
    private String Sifre;
    private int Yetki;
    private kullanici k1;

   
    private List<kullanici>klist;

   
    public KullaniciBean() {
        k1=new kullanici();
        klist=new ArrayList<kullanici>();
     }
    
    public String kullaniciListele(){
      
        String sonuc="";
        try {
            baglanti b=new baglanti();
            Connection c=b.baglan();
            String sorgu="Select * from kullanici";
            PreparedStatement ps;
            ps=c.prepareStatement(sorgu);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                kullanici k2=new kullanici();
                k2.setKAdi(rs.getString("KAdi"));
                k2.setKSadi(rs.getString("KSadi"));
                k2.setKullaniciAdi(rs.getString("KullaniciAdi"));
                k2.setSifre(rs.getString("Sifre"));
                k2.setEmail(rs.getString("Email"));
                k2.setYetki(rs.getInt("Yetki"));
                klist.add(k2);
                setKlist(klist);
            }
            sonuc="#";
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciBean.class.getName()).log(Level.SEVERE,null,ex);

        }
        return sonuc;
       
    }
    public String giris(){
        String sonuc="";
        try {
            baglanti b=new baglanti();
          Connection c=b.baglan();
          
          String sorgu="select * from kullanici where KullaniciAdi="+"'"+getKullaniciAdi()+"'"
                  +"and Sifre="+"'"+getSifre()+"'";
            PreparedStatement ps=c.prepareStatement(sorgu);
            ResultSet rs=ps.executeQuery();
            
            kullanici k=new kullanici();
            while(rs.next()){
                k.setKAdi(rs.getString("KAdi"));
                k.setKullaniciAdi(rs.getString("KullaniciAdi"));
                k.setSifre(rs.getString("Sifre"));
                k.setKSadi(rs.getString("KSadi"));
                k.setEmail(rs.getString("Email"));
                k.setYetki(rs.getInt("Yetki"));
          }
         if(k.getKullaniciAdi().equals(getKullaniciAdi())&& k.getSifre().equals(getSifre()) && k.getYetki()==1)
         {
           sonuc="admin"; 
             
            }   
            
         else if(k.getKullaniciAdi().equals(getKullaniciAdi())&& k.getSifre().equals(getSifre()) && k.getYetki()==0)
         {
          sonuc="Arabalar";   
         }
           
            else
         {
            sonuc="Anasayfa"; 
         }
          
            
            
            
        } catch (SQLException ex) 
        {
        Logger.getLogger(KullaniciBean.class.getName()).log(Level.SEVERE,null,ex);
            
        }
  
        return sonuc;
        
        
        
    }
    
    public String kaydol(){
        String sonuc="";
        try {
            baglanti b=new baglanti();
            Connection c=b.baglan();
            String sorgu="Insert into kullanici(KullaniciAdi,Sifre,KAdi,KSadi,Email,Yetki) values(?,?,?,?,?,?)";
            PreparedStatement ps;
            ps=c.prepareStatement(sorgu);
            ps.setString(1,k1.getKullaniciAdi());
            ps.setString(2,k1.getSifre());
            ps.setString(3,k1.getKAdi());
            ps.setString(4,k1.getKSadi());
            ps.setString(5,k1.getEmail());
            ps.setInt(6,k1.getYetki());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
                    Logger.getLogger(KullaniciBean.class.getName()).log(Level.SEVERE,null,ex);

        }
        return  sonuc;
    }

      
      

    
    
    
    
    
    
    
     public List<kullanici> getKlist() {
        return klist;
    }

    public void setKlist(List<kullanici> klist) {
        this.klist = klist;
    }
    
    
     public kullanici getK1() {
        return k1;
    }

    public void setK1(kullanici k1) {
        this.k1 = k1;
    }
    
    
    
     public String getKullaniciAdi() {
        return KullaniciAdi;
    }

    public void setKullaniciAdi(String KullaniciAdi) {
        this.KullaniciAdi = KullaniciAdi;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String Sifre) {
        this.Sifre = Sifre;
    }

    public int getYetki() {
        return Yetki;
    }

    public void setYetki(int Yetki) {
        this.Yetki = Yetki;
    }
   
}
