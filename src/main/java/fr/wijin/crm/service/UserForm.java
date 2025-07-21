package fr.wijin.crm.service;

import fr.wijin.crm.model.User;
import jakarta.servlet.http.HttpServletRequest;

public class UserForm extends User {

    private boolean isValid = false;
    private static final long serialVersionUID = 10L;
    private String message;



    public UserForm(HttpServletRequest request) {
        this.setGrants((String) request.getParameter("grants"));
        this.setUsername((String) request.getParameter("username"));
        this.setPassword((String) request.getParameter("password"));
        this.setMail((String) request.getParameter("mail"));
        this.validate(request);
    }

    public static boolean estPresent(String chaine) {
        return chaine != null && !chaine.trim().isEmpty();
    }

    private void validate(HttpServletRequest request) {    
        String lien = null;
        if (!estPresent(getUsername()) || !estPresent(getPassword()) || !estPresent(getMail())) {
            message = ("Erreur - Vous n'avez pas rempli tous les champs obligatoires.");
            isValid = false;
            lien = "/createUser";
        } else {
            isValid = true;
            message = ("Utilisateur créé avec succès !");
        }

        request.setAttribute("user", this);
		request.setAttribute("lien", lien);
    }

    public boolean isIsValid() {
        return isValid;
    }
    
    public String getMessage() {
        return message;
    }
    
}
