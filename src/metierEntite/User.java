	package metierEntite;

public class User { 
	public String username;
	public String password;
	public String role;
	public int IdProf,IdEtud,IdJournaliste;
	
	public int getIdProf() {
		return IdProf;
	}
	public void setIdProf(int idProf) {
		IdProf = idProf;
	}
	public int getIdEtud() {
		return IdEtud;
	}
	public void setIdEtud(int idEtud) {
		IdEtud = idEtud;
	}
	public int getIdJournaliste() {
		return IdJournaliste;
	}
	public void setIdJournaliste(int idJournaliste) {
		IdJournaliste = idJournaliste;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public User(String username2, String password2) {
		username=username2;
		password=password2;
	}
	
	public User(String username, String password, String role, int idProf, int idEtud, int idJournaliste) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		IdProf = idProf;
		IdEtud = idEtud;
		IdJournaliste = idJournaliste;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
}
