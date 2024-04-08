<%@page import='webrecomendation.*,java.io.*,java.sql.*,java.util.*,minisession.clicklog.*'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <!--<META HTTP-EQUIV="Refresh" CONTENT="1" URL="recomendations.jsp">-->
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
<div class="main1">


<%
int i=0;
try{
ArrayList<Rec> tree=(ArrayList<Rec>)session.getAttribute("RCTree");
ArrayList<String> a=new ArrayList<String>();
	 for(Rec al:tree)
        {
		if(!a.contains(al.title))
		{
		a.add(al.title);
		}
	   }
out.println("Number of Recommendations ::"+a.size()+"<br>");
%>

<table>
<tr>
<%--<img width="300" height="200" src="rec.jpg">--%>
<br>
<%
a.clear();
i=4;
int j=0;
	 for(Rec al:tree)
        {

		if(!a.contains(al.title))
		{
	         i++;

if(i%5==0)
{
j++;
%>
<tr><td><td>Cluster : <%=j%><br>
</tr> 
<%
}
a.add(al.title);
%>
<tr><td><td><a href=<%=al.url%> target="main"><%=al.title%>-(<%=al.weight%>) </a><br>
</tr>       
<%
}
}
}catch(Exception ex){ex.printStackTrace();}
%>   
</table>
        
      </div>
</body>
</html>