package metierEntite;

import java.io.InputStream;


public class Emploi_du_temps {
	private int IdEmploi;
	private InputStream Emploi;
	private String nom;
	private String nomp;
	
	
	public String getNomp() {
		return nomp;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	public Emploi_du_temps(String nom, String nomp) {
		super();
		this.nom = nom;
		this.nomp = nomp;
	}

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

	public Emploi_du_temps(int idEmploi, String nom) {
		super();
		IdEmploi = idEmploi;
		this.nom = nom;
	}
	

	

}
