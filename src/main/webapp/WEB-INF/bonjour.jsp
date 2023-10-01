<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
<p>Bonjour ${ !empty name ? name : '' }</p>
<p>${ noms[2] }</p>
<p>Bonjour ${ auteur.prenom } ${ auteur.nom }</p>
<p>${ auteur.actif ? 'Vous êtes très actif !' : 'Vous êtes inactif !' }</p>
</body>
</html>