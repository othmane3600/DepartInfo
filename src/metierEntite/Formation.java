package metierEntite;

public class Formation {
	private int IdFormation;
	private String Descrip;
	private String Nom;
	public Formation(int idFormation, String descrip, String nom) {
		super();
		IdFormation = idFormation;
		Descrip = descrip;
		Nom = nom;
	}
	public int getIdFormation() {
		return IdFormation;
	}
	public void setIdFormation(int idFormation) {
		IdFormation = idFormation;
	}
	public String getDescrip() {
		return Descrip;
	}
	public void setDescrip(String descrip) {
		Descrip = descrip;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
}
