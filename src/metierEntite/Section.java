package metierEntite;

public class Section {
	private int Idsection;
	private String Nom;
	public int getIdsection() {
		return Idsection;
	}
	public void setIdsection(int idsection) {
		Idsection = idsection;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Section(int idsection, String nom) {
		super();
		Idsection = idsection;
		Nom = nom;
	}
	public Section(String nom) {
		super();
		Nom = nom;
	}
	
}
