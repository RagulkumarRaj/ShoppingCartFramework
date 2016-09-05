<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ecommerce</title>
  <script src="<c:url value="/resources/js/lib/angular.js" />"></script>
  <script src="<c:url value="/resources/js/app.js" />"></script>
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
  <script src="<c:url value="/resources/js/lib/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
  <link rel="stylesheet" href="<c:url value="/resources/css/starrating/star-rating.css"/>" media="all" rel="stylesheet" type="text/css">
  <script src="<c:url value="/resources/js/custom/star-rating.js" />"></script>
</head>
<body ng-app="Appln" ng-controller="TestCtrl">
<div class="container">
<h3>Welcome</h3><span></span><span></span><span></span>
<a href="<c:url value="addProduct"/>">Add Product</a>
<a href="<c:url value="/resources/js/lib/jquery.min.js" />"></script>

<div class="form-group has-feedback">
<label for="search" class="sr-only">Search</label>
<input type="text" class="form-control" name="search" id="search" placeholder="search">
<span class="glyphicon glyphicon-search form-control-feedback"></span>
</div>

<div class="col-sm-2">
<div>
  <h4>BRAND</h4>
  <input type="checkbox">SAMSUMG</input><br>
  <input type="checkbox">LG</input><br>
  <input type="checkbox">HUAWEI</input><br>
</div>

<div>
  <h4>PRICE</h4>
  <input type="checkbox">Rs. 2000 and Below</input><br>
  <input type="checkbox">Rs. 2000 - Rs. 5000</input><br>
  <input type="checkbox">Rs. 5000 - Rs. 10000</input><br>
  <input type="checkbox">Rs. 10000 - Rs. 15000</input><br>
  <input type="checkbox">Rs. 15000 and above</input><br>
</div>

<div>
  <h4>RAM</h4>
  <input type="checkbox">1 GB and Below</input><br>
  <input type="checkbox">1 GB - 1.5 GB</input><br>
  <input type="checkbox">1.5 GB - 2.0 GB</input><br>
  <input type="checkbox">2.0 GB - 3.0 GB</input><br>
  <input type="checkbox">3.0 GB and above</input><br>
</div>
</div>
<div class="col-sm-10">
<div ng-repeat="prod in products" class="col-sm-4">
<div class="container" style="border:brown solid 1px">
<!-- <img alt="{{prod.name}}" src="resources/images/{{prod.image}}.jpeg"> -->
<img src="data:image/PNG;base64,{{prod.imageByteData | bracketless}}" alt="{{prod.productName}}">
<h3>{{prod.productId}}</h3>
<h3>{{prod.productName}}</h3>
<span><h5>Rs {{prod.cost}}</h5></span>
<!-- <input id="input-2ba" type="number" class="rating" min="0" max="5" step="0.5" data-stars=5
    data-symbol="&#xek005;" data-default-caption="{rating} hearts" data-star-captions="{}"> -->
<h6>EMI from Rs. 1,261</h6>
<ul>
 <li>Android Marshmallow</li>
 <li>2 GB RAM</li>
 <li>5.2 inch Display</li>
 <li>12.3 megapixel Prima...</li>
</ul>
</div>
</div>
</div>
</div><!-- End of the container div -->
</body>
</html>