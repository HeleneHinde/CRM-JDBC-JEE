<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Visualisation d'un client" />
<%@ include file="inc/header.jsp" %>

<div>
    <h1>Commande n°${order.id} du client : ${order.customer.lastname} ${order.customer.firstname}</h1>


	<p class="info">${message}</p>

	<p>Numéro de commande : ${order.id}</p>
	<p>Client : ${order.customer.lastname} ${order.customer.firstname}</p>
	<p>Label : ${order.label}</p>
	<p>Coût journalier : ${order.adrEt}</p>
	<p>Nombre de jour : ${order.numberOfDays}</p>
	<p>TVA : ${order.tva}</p>
	<p>Status : ${order.status}</p>
	<p>Type : ${order.type}</p>
	<p>Notes : ${order.notes}</p>

</div>