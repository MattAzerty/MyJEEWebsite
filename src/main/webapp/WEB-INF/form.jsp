<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>FORM</title>
    </head>
    <body>

        <c:if test="${ !empty form.result }"><p><c:out value="${ form.result }" /></p></c:if>
        <c:if test="${ !empty loginCookie }"><p><c:out value="CookieLogin: ${ loginCookie }" /></p></c:if>
        <form method="post" action="form"><!-- method can be post or get 
        (get use url but more limited, post will use doPost() // action is the page that will be called after a submit-->
            <p>
            <label for="login">Login : </label>
            <input type="text" name="login" id="login" />
            </p>
            <p>
            <label for="password">Password : </label>
            <input type="password" name="password" id="password" />
            </p>
            <input type="submit" />
        </form>
       
        <%@ include file="menu.jsp" %>
    </body>
</html>