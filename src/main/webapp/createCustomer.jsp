<%@ page pageEncoding="UTF-8" %>

<c:set var="pageTitle" value="Création d'un client" />
<%@ include file="inc/header.jsp" %>

<div>
    <h1>Créer un nouveau client</h1>
    
    <!-- Affichage des erreurs -->
    <c:if test="${not empty error}">
        <div class="error-message">
            <c:out value="${error}" />
        </div>
    </c:if>
    
    <form method="post" action="createCustomer">
        <fieldset>
            <legend>Informations client</legend>

            <!-- CORRECT - Protection XSS avec c:out -->
            <label for="lastname">Nom <span class="required">*</span></label>
            <input type="text" id="lastname" name="lastname" 
                   value="<c:out value='${param.lastname}' default='' />" 
                   size="50" maxlength="100" required />
            <br />

            <label for="firstname">Prénom <span class="required">*</span></label>
            <input type="text" id="firstname" name="firstname" 
                   value="<c:out value='${param.firstname}' default='' />" 
                   size="50" maxlength="100" required />
            <br />

            <label for="company">Entreprise</label>
            <input type="text" id="company" name="company" 
                   value="<c:out value='${param.company}' default='' />" 
                   size="50" maxlength="200" />
            <br />

            <label for="phone">Téléphone <span class="required">*</span></label>
            <input type="tel" id="phone" name="phone" 
                   value="<c:out value='${param.phone}' default='' />" 
                   size="20" maxlength="15" required />
            <br />

            <label for="mobile">Mobile</label>
            <input type="tel" id="mobile" name="mobile" 
                   value="<c:out value='${param.mobile}' default='' />" 
                   size="20" maxlength="15" />
            <br />

            <label for="mail">Adresse email <span class="required">*</span></label>
            <input type="email" id="mail" name="mail" 
                   value="<c:out value='${param.mail}' default='' />" 
                   size="50" maxlength="200" required />
            <br />

            <label for="notes">Notes</label>
            <textarea id="notes" name="notes" rows="4" cols="60" maxlength="200"><c:out value="${param.notes}" default="" /></textarea>
            <br />
        </fieldset>
        
        <input class="submitButton" type="submit" value="Créer le client" />
        <input class="resetButton" type="reset" value="Remettre à zéro" />
    </form>
</div>

<%@ include file="inc/footer.jsp" %>