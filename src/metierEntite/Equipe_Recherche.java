package metierEntite;

public class Equipe_Recherche {
	private int IdEquipeRech;
	private String Nom;
	private String Sujet;
	private int IdLab;
	private String Nomp;
	
	public Equipe_Recherche(int idEquipeRech, String nom, String sujet,int Idlab, String nomp) {
		super();
		IdEquipeRech = idEquipeRech;
		Nom = nom;
		Sujet = sujet;
		Nomp = nomp;
		IdLab= Idlab;
	}
	public String getNomp() {
		return Nomp;
	}
	public void setNomp(String nomp) {
		Nomp = nomp;
	}
	public Equipe_Recherche( String nom, String sujet) {
		super();
		
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
