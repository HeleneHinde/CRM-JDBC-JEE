<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Création d'une commande" />
<%@ include file="inc/header.jsp" %>

		<div>
			<h1>Créer une nouvelle commande</h1>
			
			<!-- Affichage des erreurs -->
			<c:if test="${not empty error}">
				<div class="error-message">
					<c:out value="${error}" />
				</div>
			</c:if>
			
			<form method="post" action="createOrder">
				<fieldset>
					<legend>Informations commande</legend>

					<label for="customer">Client <span class="required">*</span></label>
					<select id="customer" name="customer" required>
						<option value="">-- Sélectionnez un client --</option>
						<c:forEach var="customer" items="${customers}">
							<option value="${customer.id}" <c:if test="${param.customer == customer.id}">selected</c:if>>
								<c:out value="${customer.lastname}" /> <c:out value="${customer.firstname}" />
								<c:if test="${not empty customer.company}">
									- <c:out value="${customer.company}" />
								</c:if>
							</option>
						</c:forEach>
					</select>
					<br />
					<label for="label">Label <span class="required">*</span></label>
					<input type="text" id="label" name="label" 
						   value="<c:out value='${param.label}' default='' />" 
						   size="50" maxlength="100" required />
					<br />
					<label for="adrEt">Prix journalier <span class="required">*</span></label>
					<input type="number" id="adrEt" name="adrEt" 
						   value="<c:out value='${param.adrEt}' default='' />" 
						   min="0" step="0.01" required />
					<br />
					<label for="numberOfDays">Nombre de jours <span class="required">*</span></label>
					<input type="number" id="numberOfDays" name="numberOfDays" 
						   value="<c:out value='${param.numberOfDays}' default='' />" 
						   min="1" step="0.5" required />
					<br />
					<label for="tva">TVA (%)</label>
					<input type="number" id="tva" name="tva" 
						   value="<c:out value='${param.tva}' default='20' />" 
						   min="0" max="100" step="0.1" />
					<br />
					<label for="status">Status</label>
					<select id="status" name="status">
						<option value="PENDING" <c:if test="${param.status == 'PENDING' or empty param.status}">selected</c:if>>En attente</option>
						<option value="CONFIRMED" <c:if test="${param.status == 'CONFIRMED'}">selected</c:if>>Confirmée</option>
						<option value="IN_PROGRESS" <c:if test="${param.status == 'IN_PROGRESS'}">selected</c:if>>En cours</option>
						<option value="COMPLETED" <c:if test="${param.status == 'COMPLETED'}">selected</c:if>>Terminée</option>
						<option value="CANCELLED" <c:if test="${param.status == 'CANCELLED'}">selected</c:if>>Annulée</option>
					</select>
					<br />
					<label for="type">Type <span class="required">*</span></label>
					<input type="text" id="type" name="type" 
						   value="<c:out value='${param.type}' default='' />" 
						   size="50" maxlength="200" required />
					<br />
					<label for="notes">Notes</label>
					<textarea id="notes" name="notes" rows="4" cols="60" maxlength="200"><c:out value="${param.notes}" default="" /></textarea>
					<br />
				</fieldset>
				<input class="submitButton" type="submit" value="Créer la commande" />
				<input class="resetButton" type="reset" value="Remettre à zéro" />
			</form>
		</div>

<%@ include file="inc/footer.jsp" %>