
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="https://unpkg.com/bulma@0.8.0/css/bulma.min.css" />
         <link rel="stylesheet" type="text/css" href="style.css"/>
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
            
            <div class="pro">

                
          <table > 
              
               <tr   background-color="gainsboro" width="100%" height="100px">
                  <th> <p class="pp p1" > Picture  </p> </th>
                    <th> <p class="pp p1" > Product name  </p> </th>
                    <th><p class="pp p1" > Product price </p> </th>
                    <th><p class="pp p1" > Amount </p> </th>
                    <th><p class="pp p1" > Click to validate </p>  </th>
              </tr>
     
         <c:forEach items="${listpan}" var="prod_pan">  
            <tr width="100%" height="80px">  
              <form method="POST" action="Validate_prod"> 
               <th>  <img width="130px" height="130px" name="photo" src="<c:out value="${prod_pan.photo}" />" /></th>          
               <th>  <p class="pp p2" >  <c:out value="${prod_pan.nom_prod}" /> </p>  </th>      
               <th>  <p class="pp p2" >  <c:out value="${prod_pan.prix}" /> DA </p>  </th>          
                
               <th>  <p class="pp p2" > Enter the quantity here : <input type="number" name="qte" /> </p>  </th>
               <th>  <p class="pp p2" > <span> <button value="${prod_pan.nom_prod}" class="button is-info" name="button" > validate </button >  </span> </p> </th>    
               </form> 
             </tr>
         </c:forEach>
          
         </table> 
         
      </div>
            
                   <div>
                       <form method="POST" action="AfficherPanier" >
                          <button class="validate" class="button is-info">Display total price </button >
                       </form>
                   </div>  
         </section>
    </body>
</html>
