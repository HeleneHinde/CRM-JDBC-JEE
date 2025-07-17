<%@ page pageEncoding="UTF-8"%>

<c:set var="pageTitle" value="Création d'un utilisateur" />
<%@ include file="inc/header.jsp" %>

	<div>
		<h1>Créer un nouvel utilisateur</h1>
		
		<form method="post" action="createUser">
				<fieldset>
					<legend>Informations utilisateur</legend>

					<label for="username">Nom d'utilisateur <span class="required">*</span></label>
					<input type="text" id="username" name="username" value="" size="30" maxlength="25" required/>
					<br />
					<label for="password">Mot de passe <span class="required">*</span></label>
					<input type="password" id="password" name="password" value="" size="50" maxlength="100" required/>
					<br />
					<label for="mail">Adresse email <span class="required">*</span></label>
					<input type="email" id="mail" name="mail" value="" size="50" maxlength="200" required/>
					<br />
					<label for="grants">Notes</label>
					<input type="text" id="grants" name="grants" size="20" maxlength="20">
					<br />
				</fieldset>
				<input class="submitButton" type="submit" value="Créer l'utilisateur" />
				<input class="resetButton" type="reset" value="Remettre à zéro" />
			</form>
	</div>

<%@ include file="inc/footer.jsp" %>
