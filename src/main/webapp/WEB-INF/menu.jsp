<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
    <li><a href="/test/">Accueil</a></li>
    <li><a href="/test/bonjour">Bonjour</a></li>
    <li><a href="/test/form">Form</a></li>
    <li><a href="/test/sendfile">SendFile</a></li>
</ul>
 <c:if test="${ !empty sessionScope.loginSession }">
        <p>ID: ${ sessionScope.loginSession } </p>
 </c:if>