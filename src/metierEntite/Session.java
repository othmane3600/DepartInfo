package metierEntite;

public class Session {
	private int IdSession;
	private String Nom;
	public Session(int idSession, String nom) {
		super();
		IdSession = idSession;
		Nom = nom;
	}
	public int getIdSession() {
		return IdSession;
	}
	public void setIdSession(int idSession) {
		IdSession = idSession;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
}
