<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css"/>
         <link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet">
    <!-- Bulma Version 0.8.x-->
    <link rel="stylesheet" href="https://unpkg.com/bulma@0.8.0/css/bulma.min.css" />
    <link rel="stylesheet" type="text/css" href="../css/login.css">
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
                          
                     
<div> <form method="POST" action="catalogue" > <button class="cont btn Button2">Catalog</button ></form></div>  
<div> <a href="home.jsp" >  <button class="cont btn Button3" >  Home </button>  </a> </div>    
                   
           
 <div class="login">     
                    <p class="subtitle has-text-black "id="ples">Please tap to accede.</p>
                    <img src="user.png" class="user" /> 
                    <div class="box">
                        
                        <form method="post" action="VendeurPage">
                            <div class="field">
                                <div class="control">
                                    <input class="input is-2 " type="text" placeholder="User name" autofocus="" name="username">
                                </div>
                            </div>

                            <div class="field">
                                <div class="control">
                                    <input class="input is-2" type="password" placeholder="Password" name="userpass">
                                </div>
                            </div>

                             <input type="submit" value="Login"  class="button  is-black is-fullwidth">     
                        </form>
                        
                    </div>
                  
                </div>
         
           
    
       </div> 
           
      </section>
    </body>
</html>

