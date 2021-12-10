<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INDEX</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
	<div class="container mt-5">
		<h3>${expense.name}</h3>
		<table class="table table-striped">
			<tbody>
				<tr>
					<th>Vendor</th>
					<th>Amount</th>
				</tr>
				
					<tr>
						<td><c:out value="${expense.vendor}"></c:out></td>
						<td><c:out value="${expense.amount}"></c:out></td>
						<td><a href="/index/${id}/edit">Edit</a></td>
					</tr>
			</tbody>
		</table>j
		<a href="/">Back to Expenses</a>
	</div>
</body>
</html>