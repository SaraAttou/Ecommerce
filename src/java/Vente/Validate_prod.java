/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ferial
 */
public class Validate_prod extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         int qte_panier=0, qte_prod=0;
         Boolean change=false;
         Double prix_prod=0.;
         Double prix_prod2=0.;
         String req_produit, req_panier;
        String nom_prod = request.getParameter("button"); ;
        qte_panier=Integer.parseInt(request.getParameter("qte"));
       
        
         
         
        java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet selection_prod = null;
        java.sql.Connection con2 = null;
        java.sql.Statement st2 = null;
        java.sql.Connection con3 = null;
        java.sql.Statement st3 = null;
        Panier Panier=new Panier();
        try
        {
                Class.forName("com.mysql.jdbc.Driver");
                con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
                st = con.createStatement();
                String select_prod="select prix_prod, qts  from produit where libelle='"+nom_prod+"';";
                selection_prod= st.executeQuery(select_prod);
           
             while (selection_prod.next())
             {
                prix_prod=selection_prod.getDouble(1);
                qte_prod=selection_prod.getInt(2); 
                
             }  
             
                   //********Vérification de quantité*****************//
          
       
       
       if (qte_panier<=qte_prod && qte_panier >0){      
            int qte_calc=qte_prod-qte_panier;
            prix_prod2=prix_prod * qte_panier;
          try
        {
                Class.forName("com.mysql.jdbc.Driver");
                con2=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
                st2 = con2.createStatement();
                
                req_produit="update produit set qts='"+qte_calc+"' where libelle='"+nom_prod+"';";
                req_panier="update panier set prix='"+prix_prod2+"' where nom='"+nom_prod+"'; ";
                 
                  int req_pan=st2.executeUpdate(req_panier);
                  
                  int req_prod=st2.executeUpdate(req_produit);
                 
                   
                   if ((req_prod!=-1) && (req_pan!=-1) ){
                 Panier.doPost(request, response);
                RequestDispatcher rd = request.getRequestDispatcher("Panier");
                 rd.forward(request, response);
                        //*******plus rend le champs disable*****///
                   }
                   else
                   {
        Panier.doPost(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("Panier");
        rd.forward(request, response); ///**** Pour resaisir la quantité
                   }
            
                     
    } catch (SQLException a) {a.printStackTrace();	}
                    catch (ClassNotFoundException a) {a.printStackTrace(); }

                    finally {
                        try {
                          
                             con2.close();
                             st2.close();
                             con3.close();
                             st2.close();
                             
                        }
                        catch (SQLException a) {
                            a.printStackTrace();
                        }

                    }
           
           
        }else{
            //la quantité demandé n'est pas disponible
               Panier.doPost(request, response);
        RequestDispatcher rd = request.getRequestDispatcher("Panier");
        rd.forward(request, response);
        }
        
           //******** FIN  Vérification de quantité*****************//
      
             
             
           
                     
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
        
     
    
    }

   

    
}
