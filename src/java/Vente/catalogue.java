package Vente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class catalogue extends HttpServlet {
 
     public ArrayList<Produits> list_prod=  new ArrayList<Produits>();
     public Produits P= null;
     
  
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
                String select_prod="select libelle, photo ,prix_prod  from produit;";
                selection_prod= st.executeQuery(select_prod);
                //ResultSetMetaData tab_prod=selection_prod.getMetaData();
               
             while (selection_prod.next()){
                P=new Produits(selection_prod.getString(1),selection_prod.getString(2),Double.parseDouble(selection_prod.getObject(3).toString()));
                list_prod.add(P);         
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
                  request.setAttribute("listp",list_prod);
                  RequestDispatcher rd = request.getRequestDispatcher("catalogue.jsp");
                  rd.forward(request, response);
                  list_prod.clear();
                  
        
    }


}
