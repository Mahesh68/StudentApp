<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h3>Hi Mahesh</h3><br>
<strong>Current Time is</strong>: <%=new Date() %>

<form action="addStudent" method="post">
    Enter Student Id: <input type="text" name="sid"><br>
    Enter Student Name: <input type="text" name="sname"><br>
    <input type="submit">
</form>
<hr>
<form action="getStudent" method="get">
    Enter Student Id: <input type="text" name="sid"><br>
    <input type="submit">
</form>
<hr>
<form action="getStudentByName" method="get">
    Enter Student name: <input type="text" name="sname"><br>
    <input type="submit">
</form>


</body>
</html>