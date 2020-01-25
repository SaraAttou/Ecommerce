<%-- 
    Document   : afficherPanier
    Created on : Jan 22, 2020, 7:02:30 PM
    Author     : Ferial
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
          <link rel="stylesheet" href="https://unpkg.com/bulma@0.8.0/css/bulma.min.css" />
        <title>Panier</title>
    </head>
    <body>
        
       <section class="section">
           <div class="header" >
                 <div class="logo" >
                 <img src="image.png" class="logo"  height="70px" width="70px"/> 
                  </div>
               
                <div class="nom">
                    <h1><span class="c1"> S</span>
                     <span class="c2">H</span>
                     <span class="c3">O</span>
                     <span class="c4">P</span>
                     <span class="c5">P</span>
                     <span class="c6">I</span>
                     <span class="c7">N</span>
                     <span class="c8">G</span>
                    
                    </h1> 
                 </div>  
                          

<div>   <form method="POST" action="catalogue" > <button class="cont btn Button2">Catalog</button ></form></div>  
<div> <a href="home.jsp" >  <button class="cont btn Button3" >  Home  </button>  </a> </div>    

             
          
           
         </div>    
      <div class="total">
              
                  <p class="total1" class="title is-6 no-padding"> Total Prix = <c:out value="${total}"/> DA</p>
         
      </div>
       
     <div class="pro">
         
        <table > 
              
             <tr   background-color="gainsboro" width="100%" height="100px">
                  <th> <p class="pp p1" > Picture  </p> </th>
                    <th> <p class="pp p1" > Product name  </p> </th>
                    <th><p class="pp p1" > Product price </p> </th>
             </tr>
         <c:forEach items="${listpan}" var="prod_pan">  
              <tr width="100%" height="80px"> 
             
                 
                   <th>  <img width="130px" height="130px" class="pp p2" src="<c:out value="${prod_pan.photo}" />" name="photo"/>  </th>           
                   <th>  <p class="pp p2" name="nom">  <c:out value="${prod_pan.nom_prod}" /> </p>   </th>    
                   <th>  <p class="pp p2" name="prix">  <c:out value="${prod_pan.prix}" /> DA </p>  </th>
              
             </tr>   
        </c:forEach>
              
    </table > 
    
      </div>
          
     <%
             
         ////// delete  le tableau panier
         
           java.sql.Connection con2 = null;
        java.sql.Statement st2 = null;
       // ResultSet supp_pan = null;
        try
        {
                 Class.forName("com.mysql.jdbc.Driver");
                con2=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes","root","");
                st2 = con2.createStatement();
                String delete_panier="delete from panier;";
                  int delete= st2.executeUpdate(delete_panier);
                       
                     
    } catch (SQLException a) {a.printStackTrace();	}
                    catch (ClassNotFoundException a) {a.printStackTrace(); }

                    finally {
                        try {
                          
                             con2.close();
                             st2.close();
                             
                        }
                        catch (SQLException a) {
                            a.printStackTrace();
                        }

                    }
     %>
           
       
          </section>
        
           
           
    </body>
</html>
