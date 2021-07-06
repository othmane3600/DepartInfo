package metierEntite;

public class Laboratoire {
	private int IdLabo;
	private String Nom;
	public Laboratoire(int idLabo, String nom) {
		super();
		IdLabo = idLabo;
		Nom = nom;
	}
	public int getIdLabo() {
		return IdLabo;
	}
	public void setIdLabo(int idLabo) {
		IdLabo = idLabo;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
}
