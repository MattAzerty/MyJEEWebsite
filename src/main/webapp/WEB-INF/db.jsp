<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>DATABASE</title>
</head>
<body>
 <%@ include file="menu.jsp" %>  
 <c:if test="${ !empty error }"><p style="color:red;"><c:out value="${ error }" /></p></c:if>
    <form method="post" action="db">
        <p>
            <label for="pizzaName">Recette : </label>
            <input type="text" name="pizzaName" id="pizzaName" />
        </p>
        <p>
            <label for="pizzaPrice">Prix : </label>
            <input type="text" name="pizzaPrice" id="pizzaPrice" />
        </p>
        
        <input type="submit" />
    </form>
    
    <ul>
        <c:forEach var="pizza" items="${ pizza }">
            <li><c:out value="${ pizza.name }:" /> <c:out value="${ pizza.price }€" /></li>
        </c:forEach>
    </ul>    
</body>
</html>