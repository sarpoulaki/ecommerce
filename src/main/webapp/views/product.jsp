<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Products</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1 align="center">
    Add a Product
</h1>

<c:url var="addAction" value="/product/add" ></c:url>

<form:form action="${addAction}" modelAttribute="product" >
    <table align="center">
        <c:if test="${!empty product.name}">
            <tr>
                <td>
                    <form:label path="id" >
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id"  />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="unitPrice">
                    <spring:message text="Unit price"/>
                </form:label>
            </td>
            <td>
                <form:input path="unitPrice" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="quantityOnHand">
                    <spring:message text="Quantity On Hand"/>
                </form:label>
            </td>
            <td>
                <form:input path="quantityOnHand" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>" />
                </c:if>
                <c:if test="${empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>" />
                </c:if>
                <input type="button" onclick="location.href='/'"
                       value="<spring:message text="Back"/>" />
            </td>
        </tr>
    </table>
</form:form>
<br>

</body>
</html>
