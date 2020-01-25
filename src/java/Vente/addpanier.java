/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sara
 */
public class addpanier extends HttpServlet {
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
    public Boolean exist_SelectedElement(String nom_prod){
         Boolean exist=false;
         Connection con=getConnection();
        
        try{
           Statement st = con.createStatement();
        
           String select_prod="select * from panier";
           ResultSet selection_prod= st.executeQuery(select_prod);
             while (selection_prod.next()){
                      if ((selection_prod.getObject(2).toString()).equals(nom_prod)){
                          exist=true;
                      }
             }
    }catch(SQLException e){System.out.print(e);}
         
         return exist;
     }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean exist=false;
         catalogue catalogue=new catalogue();
         String photo=null;
         Double prix = null;
        String nom = request.getParameter("button"); 
        
        String insert=null;
        String selection=null;
        java.sql.Connection con = null;
        java.sql.Statement st = null;
         java.sql.Connection con1 = null;
        java.sql.Statement st1 = null;
        ResultSet selection_prod = null;
        
    
        try
        {
                 Class.forName("com.mysql.jdbc.Driver");
                 con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
                 st = con.createStatement(); 
                 selection="select photo , prix_prod from produit where libelle='"+nom+"' ;" ; 
                 selection_prod= st.executeQuery(selection);
                 while(selection_prod.next())
                 {
                 photo=selection_prod.getObject(1).toString();
                 prix = Double.parseDouble(selection_prod.getObject(2).toString());
                 }
                
                                             
    } catch (SQLException a) {a.printStackTrace();}
                    catch (ClassNotFoundException a) {a.printStackTrace(); }

                    finally {
                        try {
                          
                             con.close();
                             st.close();
                             
                             
                        }
                        catch (SQLException a) {
                            a.printStackTrace();
                        }

                    }
        
    exist=exist_SelectedElement(nom);
    if(!exist){
        try
        {
                 Class.forName("com.mysql.jdbc.Driver");
                 con1=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
                 st1 = con1.createStatement(); 
                 insert="insert into panier values(null,'"+nom+"','"+prix+"','"+photo+"');";
                 st1.executeUpdate(insert);
        }catch (SQLException a) {a.printStackTrace();}
                    catch (ClassNotFoundException a) {a.printStackTrace(); }

                    finally {
                        try {
                          
                             con1.close();
                             st1.close();
                             
                             
                        }
                        catch (SQLException a) {
                            a.printStackTrace();
                        }

                    }
          
        catalogue.doPost(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("catalogue");
        rd.forward(request, response);
    }
    else{
        catalogue.doPost(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("catalogue");
        rd.forward(request, response); 
    }
  

}
}
