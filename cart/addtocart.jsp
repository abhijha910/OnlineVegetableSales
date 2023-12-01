<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add To Cart</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
     <div class="container">
        <form:form action="addtocart" modelAttribute="veg" method="post">
          
         <div class="form-group">
          <label for="customer.customerId">Customer Id :</label>
          <form:input path="customer.customerId" class="form-control" id="customer.customerId"></form:input>
        </div>

         <div class="form-group">
           <label for="vegId">Vegetable Id :</label>
           <form:input path="vegId" class="form-control" id="vegId"/>
         </div>
        
         <div class="form-group">
            <button type="submit" class="btn btn-primary">Save</button>
          </div>
        </form:form>
     </div>

</body>
</html>