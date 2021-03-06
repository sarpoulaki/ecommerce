<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Products</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1 align="center">
    Login
</h1>

<c:url var="addAction" value="/validate"></c:url>
<h3 style="color:red" align="center">${message} </h3>

<form:form action="${addAction}" modelAttribute="user">
    <table align="center">
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="Password"/>
                </form:label>
            </td>
            <td>
                <form:password path="password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit"
                       value="<spring:message text="Login"/>"/>
                <input type="button" onclick="location.href='/'"
                       value="<spring:message text="Back"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<div style="font-size:85%" align="center">
    Don't have an account!
    <a href="#" onClick="location.href='/newUser'">
        Sign Up Here
    </a>
</div>
<br>

</body>
</html>
