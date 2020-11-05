package fr.eni.ecole.annuaire.bll;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.ecole.annuaire.bll.bo.Utilisateur;
import fr.eni.ecole.annuaire.dal.ContactDAO;
import fr.eni.ecole.annuaire.dal.FactoryDAO;

public class ContactManager {

	public void insert(Utilisateur utilisateur) {
		ContactDAO contactDAO = FactoryDAO.getContactDAO();
		utilisateur.setNom(utilisateur.getNom().toUpperCase());
		utilisateur.setDateCreation(DateFormat.getDateInstance(DateFormat.SHORT).format(new Date())); 
		contactDAO.insert(utilisateur);
	}
	
	public List<Utilisateur> vueAnnuaire() {
		List<Utilisateur> listUtilisateur;
		ContactDAO contactDAO = FactoryDAO.getContactDAO();
		listUtilisateur = contactDAO.vueAnnuaire();
		return listUtilisateur;
	}
	
	public void delete(String email) {
		ContactDAO contactDAO = FactoryDAO.getContactDAO();
		contactDAO.delete(email);
	}

	public boolean verifEmail(String email) {
		if (email.contains("@")) {
			return true;
		}
		return false;
	}

	public boolean verifPassword(String password) {
        Pattern patternNb = Pattern.compile("(\\d)");
        Matcher matcherNb = patternNb.matcher(password);
        Pattern patternMaj = Pattern.compile("([A-Z])");
        Matcher matcherMaj = patternMaj.matcher(password);
        
		if (matcherNb.find() == true && matcherMaj.find() == true) {
			return true;
		}
		return false;
	}


}
