<%-- 
    Document   : index
    Created on : 15 janv. 2020, 22:30:22
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>JSP Page</title>
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
                          
                     
 <div>  <a href="login.jsp" >  <button class="cont btn Button1" > Login </button ></a> </div>  
 <div>  <form method="post" action="catalogue" > <button class="cont btn Button2">Catalog</button ></form></div>  
<div> <a href="home.jsp" >  <button class="cont btn Button3" >  Home  </button>  </a> </div>    
                   
           
            </div>   
           
         <div class="bottom"> 
             
              <slider> 
                  <slide><p></p></slide>
                 <slide> <p></p></slide>
                 <slide><p></p></slide>
                 <slide><p></p></slide>
            </slider>
                    
         </div>
    </section>
    </body>
</html>
