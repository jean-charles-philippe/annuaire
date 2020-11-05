package fr.eni.ecole.annuaire.dal;

import fr.eni.ecole.annuaire.dal.jdbc.UtilisateurDAOjdbcImpl;

public class FactoryDAO {
	
	public static ContactDAO getContactDAO() {
		ContactDAO contactDAO = new UtilisateurDAOjdbcImpl();
		return contactDAO;
	}

}
