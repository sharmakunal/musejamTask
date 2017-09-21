<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.musejam.orders.entities.Product" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<center>
<table border="1">

    <h1><Strong><em>Welcome To MuseJam Resturant
            We Are Here to Serve You </em></strong></h1>
    <br><br>

    <c:forEach items="${mainProducts}" var="mainProduct">
        <form action="/order" method="post">
            <tr>
                <td>
                    <input type="checkbox" name="drink" value="${mainProduct.getName()}"><c:out
                        value="${mainProduct.getName()}"/>
                </td>
                <td><c:out value="${mainProduct.getCost()}"/></td>
                <td>
                    <table>
                        <c:forEach items="${addOnProducts}" var="addOnProduct">
                            <tr>
                                <td>
                                    <input type="checkbox" name="addons" value="${addOnProduct.getName()}"><c:out
                                        value="${addOnProduct.getName()}"/>
                                </td>
                                <td><c:out value="${addOnProduct.getCost()}"/></td>

                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td><input type="submit" value="add"></td>
        </form>
        </tr>
    </c:forEach>
</table>
    <table>
        <tr>
            ${product}
        </tr>
        <tr>
            ${totalCost}
        </tr>
    </table>
</center>
</body>
</html>
