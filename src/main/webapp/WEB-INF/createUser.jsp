<%@ page pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="Création d'un utilisateur" />
<%@ include file="/inc/header.jsp" %>

	<div>
		<h1>Créer un nouvel utilisateur</h1>
		
		<!-- Affichage des erreurs -->
		<c:if test="${not empty error}">
			<div class="error-message">
				<c:out value="${error}" />
			</div>
		</c:if>
		
		<form method="post" action="createUser">
				<fieldset>
					<legend>Informations utilisateur</legend>

					<label for="username">Nom d'utilisateur <span class="required">*</span></label>
					<input type="text" id="username" name="username" 
						   value="<c:out value='${param.username}' default='' />" 
						   size="30" maxlength="25" required/>
					<br />
					<label for="password">Mot de passe <span class="required">*</span></label>
					<input type="password" id="password" name="password" 
						   value="<c:out value='${param.password}' default='' />" 
						   size="50" maxlength="100" required/>
					<br />
					<label for="mail">Adresse email <span class="required">*</span></label>
					<input type="email" id="mail" name="mail" 
						   value="<c:out value='${param.mail}' default='' />" 
						   size="50" maxlength="200" required/>
					<br />
					<label for="grants">Permissions</label>
					<select id="grants" name="grants">
						<option value="USER" <c:if test="${param.grants == 'USER' or empty param.grants}">selected</c:if>>Utilisateur</option>
						<option value="ADMIN" <c:if test="${param.grants == 'ADMIN'}">selected</c:if>>Administrateur</option>
						<option value="MANAGER" <c:if test="${param.grants == 'MANAGER'}">selected</c:if>>Manager</option>
					</select>
					<br />
				</fieldset>
				<input class="submitButton" type="submit" value="Créer l'utilisateur" />
				<input class="resetButton" type="reset" value="Remettre à zéro" />
			</form>
	</div>

<%@ include file="/inc/footer.jsp" %>
