<%@page import='webrecomendation.*,java.io.*,java.sql.*,java.util.*'%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <META HTTP-EQUIV="Refresh" CONTENT="5" URL="recomendations.jsp">
<title>MS</title>
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

	<br><br>

<%
try{
TreeMap<String,String> tree=(TreeMap<String,String>)session.getAttribute("tree");

%>

<table>
<tr>
<%--<img width="300" height="200" src="rec.jpg">--%>
<br>
<%
	 for(String al:tree.keySet())
        {
        	%>
<tr><td><td><a href=<%=tree.get(al)%> target="main"> <%=al%> </a><br>
</tr>       
<%
}
}catch(Exception ex){}//ex.printStackTrace();}
%>   
</table>
        
      </div>
</body>
</html>