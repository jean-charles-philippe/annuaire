package fr.eni.ecole.annuaire.bll.bo;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String dateCreation;

	public Utilisateur() {
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 */
	public Utilisateur(String nom, String prenom, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;

	}

	/*	*//**
			 * @param nom
			 * @param prenom
			 * @param email
			 *//*
				 * public Utilisateur(String nom, String prenom, String email) { this.nom = nom;
				 * this.prenom = prenom; this.email = email; }
				 */

	/**
	 * @return the nom
	 */
	public final String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public final String getPrenom() {
		return prenom;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public final void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public final void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dateCreation
	 */
	public final String getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation
	 *            the dateCreation to set
	 */
	public final void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
				+ ", dateCreation=" + dateCreation + "]";
	}

}
