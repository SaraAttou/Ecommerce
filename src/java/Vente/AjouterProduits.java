/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Ferial
 */
public class AjouterProduits extends HttpServlet {
    

  //Connection a la bdd     
     public Connection getConnection() {
        Connection c=null;
        try
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch(ClassNotFoundException e){System.out.print(e);}
              
                c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
        }catch(SQLException e){System.out.print(e);}
             
         
       return c;       
    }
     
     // Verification de l'existance de produit
     
     public Boolean exist_prod(String nom_prod){
         Boolean exist=false;
         Connection con=getConnection();
        
        try{
           Statement st = con.createStatement();
        
           String select_prod="select * from produit";
           ResultSet selection_prod= st.executeQuery(select_prod);
             while (selection_prod.next()){
                      if ((selection_prod.getObject(2).toString()).equals(nom_prod)){
                          exist=true;
                      }
             }
    }catch(SQLException e){System.out.print(e);}
         
         return exist;
     }
   
     //L'ajout de produit s'il n'existe pas
      public Boolean ajouter_prod(String nom_prod, Double prix,String img, int qte) {
        
      
       Connection con=getConnection();
         boolean insert;
         insert=false;
  
        try{
           Statement st = con.createStatement();
        
           String insert_prod="insert into produit values(null,'"+nom_prod+"','"+img+"','"+prix+"','"+qte+"')";
            int x=st.executeUpdate(insert_prod);
            if (x!=-1){
             insert=true;
            }else {insert=false;}
    }catch(SQLException e){System.out.print(e);}
         
                        
    return insert;
      
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VendeurPage  VendeurPage= new  VendeurPage();
        String nom_prod=(request.getParameter("libelle")).toString();
        File f= new File(request.getParameter("img"));
        String image=f.getName();
        
        Double prix=Double.parseDouble(request.getParameter("prix"));
        int qte=Integer.parseInt(request.getParameter("qte"));
                Boolean insert=false,exist=false;
                
          exist=exist_prod(nom_prod);
         if(exist==false){
        insert=ajouter_prod(nom_prod,prix,image,qte);
         if(insert)
         {
              response.sendRedirect("AjouterProduits.jsp");
        }else{
           
        }
          }
          else
          {
            
                response.sendRedirect("home.jsp");
          }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
