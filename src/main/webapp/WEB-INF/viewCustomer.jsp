<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Visualisation d'un client" />
<%@ include file="/inc/header.jsp" %>

<div>
    <c:if test="${not empty customer}">
        <h1>Client : <c:out value="${customer.lastname}" /> <c:out value="${customer.firstname}" /></h1>
        
        <c:if test="${not empty message}">
            <div class="message ${fn:startsWith(message, 'Erreur') ? 'error' : 'success'}">
                <c:out value="${message}" />
            </div>
        </c:if>
        
        <div class="customer-details">
            <p><strong>Nom :</strong> <c:out value="${customer.lastname}" /></p>
            <p><strong>Prénom :</strong> <c:out value="${customer.firstname}" /></p>
            <p><strong>Entreprise :</strong> <c:out value="${customer.company}" default="Non spécifiée" /></p>
            <p><strong>Téléphone :</strong> <c:out value="${customer.phone}" /></p>
            <c:if test="${not empty customer.mobile}">
                <p><strong>Mobile :</strong> <c:out value="${customer.mobile}" /></p>
            </c:if>
            <p><strong>Email :</strong> 
                <a href="mailto:${customer.mail}">
                    <c:out value="${customer.mail}" />
                </a>
            </p>
            <c:if test="${not empty customer.notes}">
                <p><strong>Notes :</strong> <c:out value="${customer.notes}" /></p>
            </c:if>
            <c:if test="${not empty customer.active}">
                <p><strong>Statut :</strong> 
                    <c:choose>
                        <c:when test="${customer.active}">
                            <span class="status-active">Actif</span>
                        </c:when>
                        <c:otherwise>
                            <span class="status-inactive">Inactif</span>
                        </c:otherwise>
                    </c:choose>
                </p>
            </c:if>
        </div>
    </c:if>
    
    <c:if test="${empty customer}">
        <div class="error-message">
            <p>Aucun client trouvé.</p>
        </div>
    </c:if>
    
    <div class="actions">
        <a href="/crm/createCustomer" class="button">Créer un nouveau client</a>
        <a href="/crm/createOrder" class="button">Créer une commande</a>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>