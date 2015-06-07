<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	this is restful example
<br>
<form method="post" action="http://localhost:8080/RESTwithForms-1.0-SNAPSHOT/messages">
    Name: <input type="text" name="name" id="name"><br>
    Message: <input type="text" name="message" id="message"><br>
    Item 1: <input type="text" name="author" id="thelist"><br>
    Item 2: <input type="text" name="thelist" id="thelist"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>