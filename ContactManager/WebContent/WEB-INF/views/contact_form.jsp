<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NEW/EDIT Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>
		<form:form action="save" method="post" modelAttribute="contact">
			<table cellpadding="5">
				<form:hidden path="id"/>
				<tr>
					<td>NAME :</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>EMAIL :</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>ADDRESS :</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>TELEPHONE :</td>
					<td><form:input path="telephone" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="save"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>