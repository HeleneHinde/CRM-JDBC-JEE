package fr.wijin.crm.service;

public class FormService {

	public static boolean estPresent(String chaine) {
		return chaine != null && !chaine.trim().isEmpty();
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
