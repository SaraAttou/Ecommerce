package Vente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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




public class VendeurPage extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
            String user_name=(request.getParameter("username")).toString();
            String user_pass=(request.getParameter("userpass")).toString();
            String nom=null;
            String prenom=null;
            String photoprofil=null;
            boolean exist=false;
           java.sql.Connection con = null;
           java.sql.Statement st = null;
           ResultSet selection_prod = null;
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
           st = con.createStatement();
           String select_user="select * from vendeurs";
           ResultSet selection_user= st.executeQuery(select_user);
             while (selection_user.next()){
                     if ((selection_user.getObject(2).toString()).equals(user_name) && (selection_user.getObject(3).toString()).equals(user_pass) )
                    {
                          exist=true;
                           nom=selection_user.getString(4);
                           prenom=selection_user.getString(5);
                           photoprofil=selection_user.getString(6);
                          
                      }
             }
        }catch (SQLException a) {a.printStackTrace();	}
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
             
             
             
              if (exist){
                  
                  request.setAttribute("nom",nom);
                  request.setAttribute("prenom",prenom);  
                  request.setAttribute("photo",photoprofil); 
                  RequestDispatcher rd = request.getRequestDispatcher("AjouterProduit.jsp");
                  rd.forward(request, response);
                //  JOptionPane.showMessageDialog((Component) this.getServletContext(), "Login succesful");
                  
               
            }else{
                response.sendRedirect("login.jsp");
                // JOptionPane.showMessageDialog((Component) this.getServletContext(), "Login failuare");
            }
        
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
