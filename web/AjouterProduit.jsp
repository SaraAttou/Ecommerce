<%-- 
    Document   : affichage
    Created on : Jan 9, 2020, 12:24:42 PM
    Author     : Ferial
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    <link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet">
    <!-- Bulma Version 0.8.x-->
    <link rel="stylesheet" href="https://unpkg.com/bulma@0.8.0/css/bulma.min.css" />
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    </head>
    <body>
       <section>
           
     <div class="div3a">
               
          <div class="div3A">
                    <img class="photoprofil" src="<c:out value="${photo}" />" />     
          </div> 
           <div class="div3B">
               
         <div class="hhA">   <h2 class="hh" >  Nom : <c:out value="${nom}" />  </h2>    </div>   
         <div class="hhA">   <h2 class="hh" >  Prenom : <c:out value="${prenom}" /></h2> </div>
            </div>
      </div>
                 
    <div class="div1">   
        <div class="div2 profil">
                  <form method="POST" action="AjouterProduits">
             <p class="label">Enter product name :</p>    
             <input class="in" type="text"  autofocus="" name="libelle">
             <p class="label">Enter product price :</p>  
             <input class="in" type="number" name="prix">
             <p class="label">Choose an image :</p> <input  type="file" class="in"  accept="image/png, image/jpeg" name="img">
             <p class="label">Enter the quantity of product:</p>  
             <input class="in" type="number"  autofocus="" name="qte">
             <input class="add btn" type="submit" value="ADD"  class="button"> 
                    
                 </form>  
   </div> 
    
   <div class="div2">
         <div  class="Ajout"> </div> 
        
              <a href="home.jsp" >   <Button class="btnajout btn" id="btnajout" >validate</Button> </a> 
    </div> 
              
              
  </div>   
       </section>
    </body>
</html>
