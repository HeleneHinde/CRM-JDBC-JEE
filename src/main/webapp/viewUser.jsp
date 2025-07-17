<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Visualisation d'un utilisateur" />
<%@ include file="inc/header.jsp" %>

<div>
    <h1>Client : ${user.username}</h1>
		<%-- Affichage de la chaîne "message" transmise par la servlet --%>
			<p class="info">${message}</p>
			<%-- Puis affichage des données enregistrées dans le bean "customer" transmis par la servlet --%>
				<p>Nom d'utilisateur : ${user.username}</p>
				<p>Mot de passe : ${user.password}</p>
				<p>Email : ${user.mail}</p>
				<p>Droits : ${user.grants}</p>
	</body>

	</html>