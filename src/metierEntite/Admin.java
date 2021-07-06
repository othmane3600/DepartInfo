package metierEntite;

public class Admin {
	private int IdAdmin;
	private String Login;
	private String Mdp;
	public int getIdAdmin() {
		return IdAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		IdAdmin = idAdmin;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
	public Admin(int idAdmin, String login, String mdp) {
		super();
		IdAdmin = idAdmin;
		Login = login;
		Mdp = mdp;
	}
	
}
