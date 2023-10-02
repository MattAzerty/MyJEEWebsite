<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<p>Bonjour ${ !empty name ? name : '' }</p>
<p>${ noms[2] }</p>
<p>Bonjour ${ auteur.prenom } ${ auteur.nom }</p>
<p>${ auteur.actif ? 'Vous êtes très actif !' : 'Vous êtes inactif !' }</p>
<!-- JSTL STUFF -->
<p><c:out value="Ceci est injecté via JSTL !" /></p>
<p><c:out value="${ variable }">Valeur par défaut si variable null</c:out></p>
<c:set target="${ auteur }" property="prenom" value="Mathieu" />
<p><c:out value="${ auteur.prenom }" /></p>
<c:set var="pseudo" value="MattAzerty" scope="page" />
<p><c:out value="${pseudo}" /></p>

<c:if test="${ 50 > 10 }" var="testResult" scope="page">
    50 > 10 C'est vrai !
</c:if>
<!-- else if equivalent in java -->
<c:choose>
    <c:when test="${ testResult }">Et je peux sauvegarder ce résultat</c:when>
    <c:when test="${ autreVariable }">Du texte</c:when>
    <c:when test="${ encoreUneAutreVariable }">Du texte</c:when>
    <c:otherwise>equivalent du 'else' sur un 'when' en kotlin</c:otherwise>
</c:choose>

<c:forEach begin="0" end="2" step="1">
    <p>Un message !</p>
</c:forEach>
<c:forEach var="i" begin="0" end="10" step="2">
    <p>Un message n°<c:out value="${ i }" /> !</p>
</c:forEach>
<c:forEach items="${ titres }" var="titre" varStatus="status"><!-- varStatus give information about 
the current loop https://docs.oracle.com/javaee/6/api/javax/servlet/jsp/jstl/core/LoopTagStatus.html -->
    <p>N°<c:out value="${ status.count }" /> : <c:out value="${ titre }" /> !</p>
</c:forEach>
<c:forTokens var="morceau" items="Un élément/Encore un autre élément/Un dernier pour la route" delims="/ ">
    <p>${ morceau }</p>
</c:forTokens>

</body>
</html>