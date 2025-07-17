<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Visualisation d'une commande" />
<%@ include file="/inc/header.jsp" %>

<div>
    <h1>Commande n° <c:out value="${order.id}"/> du client : <c:out value="${order.customer.lastname}" /> <c:out value="${order.customer.firstname}" /></h1>

	<c:if test="${not empty message}">
		<div class="message ${fn:startsWith(message, 'Erreur') ? 'error' : 'success'}">
			<c:out value="${message}" />
		</div>
	</c:if>

	<c:if test="${not empty order}">
		<div class="order-details">
			<p><strong>Numéro de commande :</strong> <c:out value="${order.id}" /></p>
			<p><strong>Client :</strong> 
				<c:out value="${order.customer.lastname}" /> 
				<c:out value="${order.customer.firstname}" />
				<c:if test="${not empty order.customer.company}">
					(<c:out value="${order.customer.company}" />)
				</c:if>
			</p>
			<p><strong>Label :</strong> <c:out value="${order.label}" default="Pas de label" /></p>
			<p><strong>Coût journalier :</strong> <c:out value="${order.adrEt}" />€</p>
			<p><strong>Nombre de jours :</strong> <c:out value="${order.numberOfDays}" /></p>
			<p><strong>TVA :</strong> <c:out value="${order.tva}" />%</p>
			<p><strong>Status :</strong> 
				<c:choose>
					<c:when test="${order.status == 'PENDING'}">
						<span class="status-pending">En attente</span>
					</c:when>
					<c:when test="${order.status == 'CONFIRMED'}">
						<span class="status-confirmed">Confirmée</span>
					</c:when>
					<c:when test="${order.status == 'IN_PROGRESS'}">
						<span class="status-progress">En cours</span>
					</c:when>
					<c:when test="${order.status == 'COMPLETED'}">
						<span class="status-completed">Terminée</span>
					</c:when>
					<c:when test="${order.status == 'CANCELLED'}">
						<span class="status-cancelled">Annulée</span>
					</c:when>
					<c:otherwise>
						<c:out value="${order.status}" />
					</c:otherwise>
				</c:choose>
			</p>
			<p><strong>Type :</strong> <c:out value="${order.type}" default="Type non spécifié" /></p>
			<c:if test="${not empty order.notes}">
				<p><strong>Notes :</strong> <c:out value="${order.notes}" /></p>
			</c:if>
			
			<!-- Calcul du total -->
<!-- 			<div class="order-summary">
				<h3>Résumé financier</h3>
				<p><strong>Montant HT :</strong> <c:out value="${order.adrEt * order.numberOfDays}" />€</p>
				<p><strong>TVA :</strong> <c:out value="${(order.adrEt * order.numberOfDays) * (order.tva / 100)}" />€</p>
				<p class="total"><strong>Total TTC :</strong> <c:out value="${(order.adrEt * order.numberOfDays) * (1 + order.tva / 100)}" />€</p>
			</div> -->
		</div>
	</c:if>
	
	<c:if test="${empty order}">
		<div class="error-message">
			<p>Aucune commande trouvée.</p>
		</div>
	</c:if>
	
	<div class="actions">
		<a href="/crm/createOrder" class="button">Créer une nouvelle commande</a>
		<a href="/crm/createCustomer" class="button">Créer un nouveau client</a>
	</div>
</div>

<%@ include file="/inc/footer.jsp" %>