<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<title>Création d'un utilisateur</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<div>
		<form method="post" action="createUser">
				<fieldset>
					<legend>Informations client</legend>

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
				<input class="submitButton" type="submit" value="Valider" /> <input class="resetButton" type="reset"
					value="Remettre à zéro" /> <br />
			</form>
	</div>
</body>
</html>
