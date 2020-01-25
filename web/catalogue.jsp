<%-- 
    Document   : index
    Created on : 15 janv. 2020, 22:30:22
    Author     : Sara
--%>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Vente.Produits"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css"/>
          <link rel="stylesheet" href="https://unpkg.com/bulma@0.8.0/css/bulma.min.css" />
      
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
                          
<div>  <form method="POST" action="Panier" > <button class="cont btn Button4" >  Basket  </button>  </form> </div>                      
<div>  <a href="login.jsp" >  <button class="cont btn Button1" > Login </button ></a> </div>  
<div>   <form method="POST" action="catalogue" > <button class="cont btn Button2">Catalog</button ></form></div>  
<div> <a href="home.jsp" >  <button class="cont btn Button3" >  Home  </button>  </a> </div>    

             
          
           
         </div>    
           
     <div class="pro">
    <c:set var="i" value="${null}" scope="session"  />
    
    <c:forEach items="${listp}" var="produits" >  
              
      <div class="produit">
          
         <form method="POST" action="addpanier">
                   
                    <img class="ima" name="photo"  value="photo" src="<c:out value="${produits.photo}" />"/> 
                   
                    <p class="np" name="nom" value="nom" > <c:out value="${produits.nom_prod}" />  </p> 
                    
                    <p class="np prix" name="prix"  value="prix"> <c:out value="${produits.prix}"/> DA</p>
                   
                    <c:set var="photo" value="${produits.photo}"  scope="session"  />
                    <c:set var="nom" value="${produits.nom_prod}" scope="session"  />
                    <c:set var="prix" value="${produits.prix}" scope="session"  />
                    
                    <p class="np"> <span > <button name="button" value="${produits.nom_prod}" class="button is-info" /> ADD</button></span></p>
          </form>  
        
             </div>        
                   
        </c:forEach>
                     
      </div>
        
           
          </section>
    </body>
</html>
