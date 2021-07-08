package metierEntite;

public class Journaliste {
	private int IdJournaliste;
	private String Nom;
	private String Prenom;
	private String Email;
	private String Mdp;
	public int getIdJournaliste() {
		return IdJournaliste;
	}
	public void setIdJournaliste(int idJournaliste) {
		IdJournaliste = idJournaliste;
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
	public Journaliste( String nom, String prenom, String email, String mdp) {
		super();
		Nom = nom;
		Prenom = prenom;
		Email = email;
		Mdp = mdp;
	}
	
	public Journaliste() {
		
	}
	
}
