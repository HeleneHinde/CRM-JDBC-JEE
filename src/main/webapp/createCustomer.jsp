<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Création d'un client" />
<%@ include file="inc/header.jsp" %>

<div>
    <h1>Créer un nouveau client</h1>
    
    <form method="post" action="createCustomer">
        <fieldset>
            <legend>Informations client</legend>

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
				<input class="submitButton" type="submit" value="Créer le client" />
				<input class="resetButton" type="reset" value="Remettre à zéro" />
			</form>
		</div>

<%@ include file="inc/footer.jsp" %>