<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Visualisation d'un client" />
<%@ include file="inc/header.jsp" %>

<div>
    <h1>Client : ${customer.lastname} ${customer.firstname}</h1>
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
</div>