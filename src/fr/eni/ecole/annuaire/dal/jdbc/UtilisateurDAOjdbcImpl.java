package fr.eni.ecole.annuaire.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.annuaire.bll.bo.Utilisateur;
import fr.eni.ecole.annuaire.dal.ContactDAO;
import fr.eni.ecole.annuaire.dal.Settings;

public class UtilisateurDAOjdbcImpl implements ContactDAO {

	static {
		try {
			Class.forName(Settings.getProperty("driverjdbc"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void insert(Utilisateur utilisateur) {
		Connection cnx = null;
		try {
			cnx = getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO utilisateur VALUES(?,?,?,?,?)");
			pstmt.setString(1, utilisateur.getNom());
			pstmt.setString(2, utilisateur.getPrenom());
			pstmt.setString(3, utilisateur.getEmail());
			pstmt.setString(4, utilisateur.getPassword());
			pstmt.setString(5, utilisateur.getDateCreation());
			pstmt.executeUpdate();
			System.out.printf("\nVous venez de saisir le contact : %s %s %s %s%n", utilisateur.getNom(),
					utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getDateCreation());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Utilisateur> vueAnnuaire() {
		Utilisateur utilisateur;
		List<Utilisateur> listUtilisateur = new ArrayList<>();
		ResultSet rs = null;
		Connection cnx = null;
		try {
			cnx = getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("SELECT nom, prenom, email, dateCreation FROM utilisateur");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				utilisateur = new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3), "*******");
				utilisateur.setDateCreation(rs.getString(4));
				listUtilisateur.add(utilisateur);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listUtilisateur;
	}

	public void delete(String email) {
		ResultSet rs = null;
		Connection cnx = null;
		try {
			cnx = getConnection();
			PreparedStatement pstmt1 = cnx.prepareStatement("SELECT nom, prenom, email FROM utilisateur WHERE email=?");
			pstmt1.setString(1, email);
			rs = pstmt1.executeQuery();
			PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM utilisateur WHERE email=?");
			pstmt.setString(1, email);
			pstmt.executeUpdate();

			if (rs.next()) {
				System.out.printf("Vous avez supprimé l'utilisateur %s %s.%n", rs.getString(1), rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(Settings.getProperty("url"), Settings.getProperty("user"),
				Settings.getProperty("password"));
		return connection;
	}

}
