package fr.wijin.crm.form;

import fr.wijin.crm.model.Customer;

public class CustomerForm extends Customer{

	public static boolean estPresent(String chaine) {
		return chaine != null && !chaine.trim().isEmpty();
	}

	public void validate() {
		
		// Méthode vide pour l'instant, peut être utilisée pour des validations futures
	}

	public static Double toDouble(String valeur) {
		try {
			return Double.parseDouble(valeur);
		} catch (Exception exception) {
			return null;
		}
	}

	public static Integer toInteger(String valeur) {
		try {
			return Integer.parseInt(valeur);
		} catch (Exception exception) {
			return null;
		}
	}
}
