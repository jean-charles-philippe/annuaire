package fr.eni.ecole.annuaire.dal;

public class FactoryDAO {
	
	public static ContactDAO getContactDAO() {
		ContactDAO contactDAO = new UtilisateurDAOjdbcImpl();
		return contactDAO;
	}

}
