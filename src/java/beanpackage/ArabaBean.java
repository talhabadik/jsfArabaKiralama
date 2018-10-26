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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author TalhaBadik
 */
public class ArabaBean implements Serializable{
    
    private List<Araba>alist;
    private Araba araba;

    
    public ArabaBean() {
       alist=new ArrayList<Araba>();
       araba=new Araba();
    }
    
    public  String arabaKaydet(){
        try{
            baglanti b= new baglanti();
            Connection c=b.baglan();
            String sorgu="insert into arabalar(Afiyat,Marka,Model,ModelYili,Yakit,Sinif,Renk,Vites) VALUES(?,?,?,?,?,?,?,?) ";
            PreparedStatement prs;
            prs=c.prepareStatement(sorgu);
            prs.setInt(1,araba.getAfiyat());
            prs.setString(2, araba.getMarka());
            prs.setString(3, araba.getModel());
            prs.setInt(4, araba.getModelYili());
            prs.setString(5, araba.getYakit());
            prs.setString(6, araba.getSinif());
            prs.setString(7, araba.getRenk());
            prs.setString(8, araba.getVites());
            prs.executeUpdate();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kayit basarili"));
            
            
        }catch(SQLException ex){
          Logger.getLogger(ArabaBean.class.getName()).log(Level.SEVERE,null,ex);  
        }
        return"admin";
    }
    
    
    public List<Araba> getAlist() {
        return alist;
    }

    public void setAlist(List<Araba> alist) {
        this.alist = alist;
    }

    public Araba getAraba() {
        return araba;
    }

    public void setAraba(Araba araba) {
        this.araba = araba;
    }
    
    
}
