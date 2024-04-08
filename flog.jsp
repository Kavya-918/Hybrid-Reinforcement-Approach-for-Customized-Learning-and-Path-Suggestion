<%@page import="java.sql.Statement"%>
<%@page import="java.sql.*"%>
<%
    String fname = request.getParameter("fname");
    String pwd1 = request.getParameter("pwd1");
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prs","prs");
       Statement st = con.createStatement();
       ResultSet rs=st.executeQuery("select * from  users where fname='"+fname+"' and pwd='"+pwd1+"'");

      
       if(rs.next())
       {
          response.sendRedirect("home.jsp? ");
       }
       else
       {
           response.sendRedirect("user.jsp?Login_Failed");
       }
        con.commit();
       con.close();
    }
    catch(Exception e)
    {
        System.out.println("Error in signupction"+e.getMessage());
    }
    
    %>