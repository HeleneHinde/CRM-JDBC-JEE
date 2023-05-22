<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<title>Affichage d'un client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<%-- Affichage de la chaîne "message" transmise par la servlet --%>
	<p class="info">${message}</p>
	<%-- Puis affichage des données enregistrées dans le bean "customer" transmis par la servlet --%>
	<p>Nom : ${customer.lastname}</p>
	<p>Prénom : ${customer.firstname}</p>
	<p>Entreprise : ${customer.company}</p>
	<p>Téléphone : ${customer.phone}</p>
	<p>Mobile : ${customer.mobile}</p>
	<p>Email : ${customer.mail}</p>
	<p>Notes : ${customer.notes}</p>
</body>
</html>