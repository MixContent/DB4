<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    
    <body>
    <form:form action="deleteid" method="post" modelAttribute="student">
    
    Name:<form:input path="studentname"/><br>
    Email<form:input path="studentemail"/><br>
          <input type="submit" value="submit"><br>
          <a href="showdata">datatobeshow</a><br>
          <a href="delete">Deletebutton</a><br>
          <a href="searchbyid">clickforid</a><br>
          <a href="searchbyname">Serachbyname</a>
         </form:form>
    
    
    </body>
    
    
    
    </html>