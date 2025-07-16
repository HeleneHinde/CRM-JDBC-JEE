<%@ page pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="fr">

	<head>
		<meta charset="utf-8" />
		<title>Création d'un client</title>
		<link type="text/css" rel="stylesheet" href="inc/style.css" />
	</head>

	<body>
		<div>
			<form method="post" action="createCustomer">
				<fieldset>
					<legend>Informations utilisateur</legend>

					<label for="lastname">Nom <span class="required">*</span></label>
					<input type="text" id="lastname" name="lastname" value="" size="50" maxlength="100" required/>
					<br />
					<label for="firstname">Prénom </label>
					<input type="text" id="firstname" name="firstname" value="" size="50" maxlength="100" required/>
					<br />
					<label for="company">Entreprise <span class="required">*</span></label>
					<input type="text" id="company" name="company" value="" size="50" maxlength="200" required/>
					<br />
					<label for="phone">Téléphone <span class="required">*</span></label>
					<input type="text" id="phone" name="phone" value="" size="20" maxlength="15" required/>
					<br />
					<label for="mobile">Mobile</label>
					<input type="text" id="mobile" name="mobile" value="" size="20" maxlength="15" />
					<br />
					<label for="mail">Adresse email <span class="required">*</span></label>
					<input type="email" id="mail" name="mail" value="" size="50" maxlength="200" required/>
					<br />
					<label for="notes">Notes</label>
					<textarea id="notes" name="notes" rows="4" cols="60" maxlength="200"></textarea>
					<br />
				</fieldset>
				<input class="submitButton" type="submit" value="Valider" /> <input class="resetButton" type="reset"
					value="Remettre à zéro" /> <br />
			</form>
		</div>
	</body>

	</html>