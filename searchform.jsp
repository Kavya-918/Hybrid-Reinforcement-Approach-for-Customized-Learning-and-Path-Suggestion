<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Design by http://www.bluewebtemplates.com
Released for free under a Creative Commons Attribution 3.0 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Search Microsoft </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<!-- CuFon: Enables smooth pretty custom font rendering. 100% SEO friendly. To disable, remove this section -->
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>

	
<!-- CuFon ends -->
</head>
<body >

<div class="main">

  <div class="menu_nav">
    <div class="menu_nav_resize">
      <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="reg.html">Registration</a></li>
        <li class="active"><a href="user.html">User Login</a></li>
        <li><a href="admin.jsp">Admin</a></li>
        <li><a href="contact.jsp">Contact Us</a></li>
      </ul>
    </div>
    <div class="clr"></div>
  </div>

  <div class="header">
    <div class="header_resize">
      <div class="logo"><h1><a href="index.jsp">Welcome | Learning Path Recommendation System</a></h1></div>
    </div>
  </div>

  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
	<br><br>
      <fieldset>
	  <h2>SEARCH A QUERY TERM</h2>
	<form action="searchform.jsp">
	<input type="text" name="t1">
	<input type=submit value="Search">
	</form>
	<br>
	<p>** Search Only the terms related to Microsoft</p>
	<br>
	
	<br>
</fieldset>

     </div>   
      </div>
      <div class="sidebar">
   <h3 style="color:black">RECOMMENDATIONS:</h3>
        <div class="gadget">
          
          <ul class="sb_menu">
            <jsp:include page="recomendations.jsp"/>
           </ul>
        </div>

        
        <div class="gadget">
          <h2 class="star"><span>About Us</span></h2>
          <ul class="sb_menu">
            <li>Our system provides users with</li>
            <li> Recommendations that are</li>
            <li>appropriate. The system provides </li>
            <li>recommendations based on the </li>	
            <li> previous history of the user.</li>
            
           </ul>
        </div>
      <div class="gadget">
          
          <ul class="ex_menu">
             <img width="250" height="250" src="web1.jpg">
           
          </ul>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>


  
      
      
</div>

</body>
</html>

