package fr.eni.ecole.annuaire.bll;

import java.util.List;

import fr.eni.ecole.annuaire.bll.bo.Utilisateur;
import fr.eni.ecole.annuaire.dal.ContactDAO;
import fr.eni.ecole.annuaire.dal.FactoryDAO;

public class ContactManager {

	public void insert(Utilisateur utilisateur) {
		ContactDAO contactDAO = FactoryDAO.getContactDAO();
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
}
