package metierEntite;

import java.io.InputStream;


public class Emploi_du_temps {
	private int IdEmploi;
	private InputStream Emploi;
	private String nom;

	
	
	public Emploi_du_temps(int idEmploi, InputStream emploi, String nom) {
		super();
		IdEmploi = idEmploi;
		Emploi = emploi;
		this.nom = nom;
	}

	public Emploi_du_temps() {
		super();
	}

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

	@Override
	public String toString() {
		return "Emploi_du_temps [IdEmploi=" + IdEmploi + ", Emploi=" + Emploi + ", nom=" + nom + "]";
	}
	

	

}
