package metierEntite;

public class Equipe_Recherche {
	private int IdEquipeRech;
	private String Nom;
	private String Sujet;
	private int IdLab;
	
	
	public Equipe_Recherche(int Idlab, String nom, String sujet) {
		super();
		IdLab = Idlab;
		Nom = nom;
		Sujet = sujet;
	}
	public int getIdEquipeRech() {
		return IdEquipeRech;
	}
	public void setIdEquipeRech(int idEquipeRech) {
		IdEquipeRech = idEquipeRech;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getSujet() {
		return Sujet;
	}
	public void setSujet(String sujet) {
		Sujet = sujet;
	}
	public int getIdLab() {
		return IdLab;
	}
	public void setIdLab(int idLab) {
		IdLab = idLab;
	}
	
}
