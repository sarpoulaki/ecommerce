<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Main Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<%--<c:url var="addAction" value="/product/add" ></c:url>--%>


<br>
<h3 align="center">Products List</h3>
<c:if test="${!empty listProducts}">
    <table class="tg" align="center">
        <tr>
            <th width="80">Product ID</th>
            <th width="120">Product Name</th>
            <th width="120">Product Description</th>
            <th width="120">Unit Price</th>
            <th width="120">Quantity On Hand</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listProducts}" var="product">
            <div>
            <%--<tr onclick="location.href='/edit/${product.id}'">--%>
                <p align="right">${product.id}</p>
                <p>${product.name}</p>
                <p>${product.description}</p>
                <p align="right">$${product.unitPrice}</p>
                <p align="right">${product.quantityOnHand}</p>
            </div>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
