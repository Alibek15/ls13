<%@ page import="java.util.List" %>
<%@ page import="org.alibek.ls13.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.01.2023
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
 <%
List<Student> students= (List<Student>)request.getAttribute("students");
if(students != null){

    for (Student student:students) {
 %>
<h1><%=student.toString()%></h1>
<%
        }
    }
    %>
</body>
</html>
