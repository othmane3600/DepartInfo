package metierEntite;

public class Professeur {
	private int IdProfeseur;
	private String Nom;
	private String Prenom;
	private String Role;
	private int Tel;
	private String Email;
	private String Mdp;
	public Professeur() {
		
	}
	
	public Professeur(String nom, String prenom, int tel, String email, String mdp) {
		super();
		Nom = nom;
		Prenom = prenom;
		Tel = tel;
		Email = email;
		Mdp = mdp;
	}

	public Professeur(int idProfeseur, String nom, String prenom, String role, int tel, String email, String mdp) {
		super();
		IdProfeseur = idProfeseur;
		Nom = nom;
		Prenom = prenom;
		Role = role;
		Tel = tel;
		Email = email;
		Mdp = mdp;
	}
	public int getIdProfeseur() {
		return IdProfeseur;
	}
	public void setIdProfeseur(int idProfeseur) {
		IdProfeseur = idProfeseur;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
}
