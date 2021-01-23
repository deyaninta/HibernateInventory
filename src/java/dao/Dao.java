/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author RHYZONE
 */
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Produk;
 
public class Dao {
    
    public void addProduk(Produk produk)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(produk);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteProduk(int kode_produk)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Produk prod=(Produk)session.load(Produk.class, new Integer(kode_produk));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<Produk> getbyID(int kode_produk)
    {
        List<Produk> produk1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Produk where kode_produk= :kode_produk");
            query.setInteger("kode_produk", kode_produk);
            produk1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return produk1;
    }
    
    public List<Produk> retrieveProduk()
    {
       
        List prod=new ArrayList();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Produk");
            prod=query.list();
         
            trans.commit();
            
        }
        catch(Exception e)
        {

        }
        return prod;
    }
    
    public void updateProduk(Produk produk)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(produk);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }   
}