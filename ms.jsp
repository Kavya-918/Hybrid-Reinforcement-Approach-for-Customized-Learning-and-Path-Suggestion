
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Design by http://www.bluewebtemplates.com
Released for free under a Creative Commons Attribution 3.0 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>MS : Microsoft office | Products</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<!-- CuFon: Enables smooth pretty custom font rendering. 100% SEO friendly. To disable, remove this section -->
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<!-- CuFon ends -->
</head>
<body>

<style>
#sidebar {
    width:20%;
    float:left;
    background-color:#BD4538;
    color:white;
}
</style>
<div class="sidebar">

</div>
<div class="main">

  <div class="menu_nav">
    <div class="menu_nav_resize">
      <ul>
        <li><a href="index.jsp" target="_blank">Home</a></li>
        <li><a href="reg.html">Registration</a></li>
        <li><a href="user.html">User Login</a></li>
        <li><a href="admin.jsp">Admin</a></li>
        <li><a href="contact.jsp">Contact Us</a></li>
      </ul>
    </div>
    <div class="clr"></div>
  </div>

  <div class="header">
    <div class="header_resize">
      <div class="logo"><h1><a href="index.jsp">Learning Path  Recommendation System</a></h1></div>
      <span><%@include file='logtime.html'%></span></span>
    </div>
  </div>

  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
        <h2>
Welcome to Office</h2><br>
From home to business, <br>from desktop to web and the devices in between,<br> Office delivers the tools to get work done.
	<br>
<img width="350" height="350" src="Office2.jpg"><br>
<a href="msword.jsp">MS WORD</a><br>
<a href="msppt.jsp">MS POWERPOINT</a><br>
<a href="msexcel.jsp">MS EXCEL</a><br>
<a href="msaccess.jsp">MS ACCESS</a><br>
<a href="mspublisher.jsp">MS PUBLISHER</a><br>
          
        
      </div>
      </div>
        <div class="sidebar">
	  <a href="searchform.jsp" >Search a term</a>
       <br> 
	   <h3 style="color:black">RECOMMENDATIONS:</h3>
        <div class="gadget">
         
          <ul class="sb_menu">
            <jsp:include page="recomendations.jsp"/>
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