<%@page import="java.sql.Statement"%>
<%@page import="java.sql.*"%>
<%
    String fname = request.getParameter("fname");
    String pwd1 = request.getParameter("pwd1");
    String pwd2 = request.getParameter("pwd2");
    String email = request.getParameter("email");
    String mno = request.getParameter("mno");
    if(pwd1.equals(pwd2))
    {
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prs","prs");
       Statement st = con.createStatement();
       int i = st.executeUpdate("insert into users values('"+fname+"','"+pwd1+"','"+pwd2+"','"+email+"','"+mno+"')");
       con.commit();
       con.close();
       if(i!= 0)
       {
          response.sendRedirect("user.jsp?Registration_Successfully");
       }
       else
       {
           response.sendRedirect("user.jsp?Registration_Failed");
       }
    }
    catch(Exception e)
    {
        System.out.println("Error in signupction"+e.getMessage());
    }
    }
    else
    {
%><H1>Confirm Password Does't match ,Try again<a href='reg.html'>back</a></H1><%

    }
    %>