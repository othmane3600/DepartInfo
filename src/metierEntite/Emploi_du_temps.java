package metierEntite;

import java.io.InputStream;

import com.mysql.jdbc.Blob;

public class Emploi_du_temps {
	private int IdEmploi;
	private InputStream Emploi;
	private String nom;

	

	public Emploi_du_temps(InputStream emploi, String nom) {
		super();
		Emploi = emploi;
		this.nom = nom;
	}

	public int getIdEmploi() {
		return IdEmploi;
	}

	public void setIdEmploi(int idEmploi) {
		IdEmploi = idEmploi;
	}

	public InputStream getEmploi() {
		return Emploi;
	}

	public void setEmploi(InputStream emploi) {
		Emploi = emploi;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

}
