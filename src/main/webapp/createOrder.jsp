<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Création d'une commande" />
<%@ include file="inc/header.jsp" %>

		<div>
			<h1>Créer une nouvelle commande</h1>
			
			<form method="post" action="createOrder">
				<fieldset>
					<legend>Informations commande</legend>

					<label for="customer">Client <span class="required">*</span></label>
					<select id="customer" name="customer" required>
						<option value="">-- Sélectionnez un client --</option>
						<c:forEach var="customer" items="${customers}">
							<option value="${customer.id}">
								${customer.lastname} ${customer.firstname} 
							</option>
						</c:forEach>
					</select>
					<br />
					<label for="label">Label </label>
					<input type="text" id="label" name="label" value="" size="50" maxlength="100" required />
					<br />
					<label for="adreEt">Prix journalier <span class="required">*</span></label>
					<input type="number" id="adreEt" name="adreEt" value="" size="50" maxlength="200" required />
					<br />
					<label for="numberOfDays">Nombre de jours <span class="required">*</span></label>
					<input type="number" id="numberOfDays" name="numberOfDays" value="" min="1" step="0.5" required />
					<br />
					<label for="tva">TVA (%)</label>
					<input type="number" id="tva" name="tva" value="20" min="0" max="100" step="0.1" />
					<br />
					<label for="status">Status</label>
					<select id="status" name="status">
						<option value="PENDING">En attente</option>
						<option value="CONFIRMED">Confirmée</option>
						<option value="IN_PROGRESS">En cours</option>
						<option value="COMPLETED">Terminée</option>
						<option value="CANCELLED">Annulée</option>
					</select>
					<br />
					<label for="type">Type <span class="required">*</span></label>
					<input type="text" id="type" name="type" value="" size="50" maxlength="200" required />
					<br />
					<label for="notes">Notes</label>
					<textarea id="notes" name="notes" rows="4" cols="60" maxlength="200"></textarea>
					<br />
				</fieldset>
				<input class="submitButton" type="submit" value="Créer la commande" />
				<input class="resetButton" type="reset" value="Remettre à zéro" />
			</form>
		</div>

<%@ include file="inc/footer.jsp" %>