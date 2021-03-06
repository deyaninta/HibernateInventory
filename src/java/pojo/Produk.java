package pojo;
// Generated Oct 15, 2020 5:16:42 AM by Hibernate Tools 4.3.1
import dao.Dao;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 * Produk generated by hbm2java
 */
@ManagedBean
public class Produk  implements java.io.Serializable {


     private int kodeProduk;
     private String namaProduk;
     private int harga;
     private int stok;

    public Produk() {
    }

    public Produk(int kodeProduk, String namaProduk, int harga, int stok) {
       this.kodeProduk = kodeProduk;
       this.namaProduk = namaProduk;
       this.harga = harga;
       this.stok = stok;
    }
   
    public int getKodeProduk() {
        return this.kodeProduk;
    }
    
    public void setKodeProduk(int kodeProduk) {
        this.kodeProduk = kodeProduk;
    }
    public String getNamaProduk() {
        return this.namaProduk;
    }
    
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }
    public int getHarga() {
        return this.harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }
    public int getStok() {
        return this.stok;
    }
    
    public void setStok(int stok) {
        this.stok = stok;
    }

    public void save()
    {
        Dao pdao=new Dao();
        pdao.addProduk(this);
    }

    public void delete()
    {    
        Dao pdao=new Dao();
        pdao.deleteProduk(kodeProduk);
    }

    public List<Produk> getbyid()
    { 
        Dao pdao=new Dao();
        List<Produk> prod=pdao.getbyID(kodeProduk);
        namaProduk=prod.get(0).namaProduk;
        harga=prod.get(0).harga;
        stok=prod.get(0).stok;
        return prod;
    }

    public List<Produk> getallrecords()
    {
        Dao pdao=new Dao();
        List<Produk> prod=pdao.retrieveProduk();
        return prod;
    }

    public void update()
    {
        Dao pdao=new Dao();
        pdao.updateProduk(this);
    }
}


