package fr.wijin.crm.service;

public class FormService {

	public static boolean estPresent(String chaine) {
		return chaine != null && !chaine.trim().isEmpty();
	}

}
