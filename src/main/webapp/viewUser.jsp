<%@ page pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="fr">

	<head>
		<meta charset="utf-8" />
		<title>Affichage d'un utilisateur</title>
		<link type="text/css" rel="stylesheet" href="inc/style.css" />
	</head>

	<body>
		<%-- Affichage de la chaîne "message" transmise par la servlet --%>
			<p class="info">${message}</p>
			<%-- Puis affichage des données enregistrées dans le bean "customer" transmis par la servlet --%>
				<p>Nom : ${user.username}</p>
				<p>Prénom : ${user.password}</p>
				<p>Email : ${user.mail}</p>
				<p>Notes : ${user.grants}</p>
	</body>

	</html>