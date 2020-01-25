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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ferial
 */
public class AfficherPanier extends HttpServlet {
    
    public ArrayList<Produits> list_prod_pan=  new ArrayList<Produits>();
     public Produits P= null;
     Double total=0.;
     
     @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
       
        java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet selection_prod = null;
        try
        {
                Class.forName("com.mysql.jdbc.Driver");
                con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
                st = con.createStatement();
                String select_prod="select nom, prix ,photo  from panier;";
                selection_prod= st.executeQuery(select_prod);
               
               
             while (selection_prod.next()){
                P=new Produits(selection_prod.getString(1),selection_prod.getString(3),selection_prod.getDouble(2));
                Double prix=selection_prod.getDouble(2);
                total=total+prix;
                list_prod_pan.add(P);         
             }           
                     
    } catch (SQLException a) {a.printStackTrace();	}
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
                  request.setAttribute("listpan",list_prod_pan);
                  request.setAttribute("total",total);
                   total=0.;
                  RequestDispatcher rd = request.getRequestDispatcher("afficherPanier.jsp");
                  rd.forward(request, response);
                  
                  list_prod_pan.clear();
                  
    
                  
                  
    }

       
    }

   


