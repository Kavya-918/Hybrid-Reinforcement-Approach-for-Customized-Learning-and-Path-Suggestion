<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Design by http://www.bluewebtemplates.com
Released for free under a Creative Commons Attribution 3.0 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<!-- CuFon: Enables smooth pretty custom font rendering. 100% SEO friendly. To disable, remove this section -->
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<!-- CuFon ends -->
</head>
<body>
<div class="main">

  <div class="menu_nav">
    <div class="menu_nav_resize">
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="reg.html">Registration</a></li>
        <li class="active"><a href="user.html">User Login</a></li>
        <li><a href="admin.html">Admin</a></li>
        <li><a href="contact.html">Contact Us</a></li>
      </ul>
    </div>
    <div class="clr"></div>
  </div>

  <div class="header">
    <div class="header_resize">
      <div class="logo"><h1><a href="index.html">Welcome | Learning Path Recommendation System</a></h1></div>
    </div>
  </div>

  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
	<br><br>
        <h2><span>User Login</span></h2><br><br>
        <span><%if(request.getQueryString()!=null){out.println(request.getQueryString());}%></span>
	<form  name="f2" action="flog.jsp" method="post">
	<table>
	<tr>
	<td>User Name :</td>
	<td><input type="text"	name="fname" size="20" maxlength="15"></td></tr>
	 <tr>
	<td>

	</td></tr><img src="userpic.gif">
	<tr>
	<td>
	
	</td></tr>
	<tr><td>
	Password : </td>
	<td>
	<input type="password" name="pwd1" size="20" maxlength="10"></td></tr>
	</table>
	<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

	<input type="submit" value="Submit">&nbsp&nbsp
	<input type="reset" value="Reset">
	</form>
	<br><br><br><br>
	

	 
          
        </div>
        
      </div>
      <div class="sidebar">
        
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

