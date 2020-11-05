package fr.eni.ecole.annuaire.dal;

import java.util.List;

import fr.eni.ecole.annuaire.bll.bo.Utilisateur;

public interface ContactDAO {

	public void insert(Utilisateur utilisateur);

	public List<Utilisateur> vueAnnuaire();

	public void delete(String email);
}
