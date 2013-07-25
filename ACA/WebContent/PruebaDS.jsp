<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<%@ page import="java.sql.*, javax.naming.*, javax.sql.*"%>
	<%
		try {
			Context ctx = new InitialContext();
			Context con = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource) con.lookup("jdbc/MySQLDS");
			java.sql.Connection sqlc = ds.getConnection();
			out.println("se conecto!!");
			//sqlc.executeQuery("select * from encuesta");
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>