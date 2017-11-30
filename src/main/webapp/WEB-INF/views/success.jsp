<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table cellspacing="5" cellpadding="5" border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>UUID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="student">
				<tr>
					<td>${student.studentname}</td>
					<td>${student.studentemail}</td>
					<td>${student.studentid}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>