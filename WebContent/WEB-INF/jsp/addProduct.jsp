<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product</title>
</head>
<body>
	<form:form method="post" action="addProduct" enctype="multipart/form-data">
		Enter Product Name<input type="text" name="productName" id="productName"/></br>
		Enter Product cost<input type="text" name="cost" id="cost"/></br>
		Upload product image<input type="file" name="multiPartFileData" id="multiPartFileData"/></br>
		Submit<input type="submit">
		<!-- <form:errors path="name" /> -->
	</form:form>
</body>
</html>