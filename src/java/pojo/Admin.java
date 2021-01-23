package pojo;
// Generated Oct 18, 2020 8:51:57 PM by Hibernate Tools 4.3.1

import dao.DAOAdmin;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;




/**
 * Admin generated by hbm2java
 */
@ManagedBean
public class Admin  implements java.io.Serializable {


     private String username;
     private String password;

    public Admin() {
    }

    public Admin(String username, String password) {
       this.username = username;
       this.password = password;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void save()
    {
        DAOAdmin pdao=new DAOAdmin();
        pdao.addAdmin(this);
    }

    public void delete()
    {    
        DAOAdmin pdao=new DAOAdmin();
        pdao.deleteAdmin(username);
    }

    public List<Admin> getbyid()
    { 
        DAOAdmin pdao=new DAOAdmin();
        List<Admin> prod=pdao.getbyID(username);
        password=prod.get(0).password;
        return prod;
    }

    public List<Admin> getallrecords()
    {
        DAOAdmin pdao=new DAOAdmin();
        List<Admin> prod=pdao.retrieveAdmin();
        return prod;
    }

    public void update()
    {
        DAOAdmin pdao=new DAOAdmin();
        pdao.updateAdmin(this);
    }
    
    public String validatelogin()
    { 
        try {
            DAOAdmin pdao=new DAOAdmin();
            List<Admin> prod=pdao.validateLogin(username, password);
            username=prod.get(0).username;
            password=prod.get(0).password;
            
            FacesContext context = FacesContext.getCurrentInstance();
            if(username != null) {
                context.getExternalContext().getSessionMap().put("username", username);
                return "success";
            }
            else {
                return "error";
            }
        }
        catch(Exception ex) {
            return "error";
        }
        //return prod;
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }
}