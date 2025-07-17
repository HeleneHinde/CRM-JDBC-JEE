<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Visualisation d'un utilisateur" />
<%@ include file="/inc/header.jsp" %>

<div>
    <h1>Utilisateur : <c:out value="${user.username}" /></h1>
    
    <c:if test="${not empty message}">
        <div class="message ${fn:startsWith(message, 'Erreur') ? 'error' : 'success'}">
            <c:out value="${message}" />
        </div>
    </c:if>
    
    <c:if test="${not empty user}">
        <div class="user-details">
            <p><strong>Nom d'utilisateur :</strong> <c:out value="${user.username}" /></p>
            <p><strong>Mot de passe :</strong> 
                <c:choose>
                    <c:when test="${not empty user.password}">
                        <span class="password-hidden">••••••••</span>
                    </c:when>
                    <c:otherwise>
                        <em>Non défini</em>
                    </c:otherwise>
                </c:choose>
            </p>
            <p><strong>Email :</strong> <c:out value="${user.mail}" default="Non spécifié" /></p>
            <p><strong>Droits :</strong> 
                <c:choose>
                    <c:when test="${user.grants == 'ADMIN'}">
                        <span class="role-admin">Administrateur</span>
                    </c:when>
                    <c:when test="${user.grants == 'MANAGER'}">
                        <span class="role-manager">Manager</span>
                    </c:when>
                    <c:when test="${user.grants == 'USER'}">
                        <span class="role-user">Utilisateur</span>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${user.grants}" default="Non spécifié" />
                    </c:otherwise>
                </c:choose>
            </p>
            <c:if test="${not empty user.active}">
                <p><strong>Statut :</strong> 
                    <c:choose>
                        <c:when test="${user.active}">
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
    
    <c:if test="${empty user}">
        <div class="error-message">
            <p>Aucun utilisateur trouvé.</p>
        </div>
    </c:if>
    
    <div class="actions">
        <a href="/crm/createUser" class="button">Créer un nouvel utilisateur</a>
        <a href="/crm/createCustomer" class="button">Créer un nouveau client</a>
    </div>
</div>

<%@ include file="/inc/footer.jsp" %>