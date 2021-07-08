package metierEntite;

public class Semestre {
	private int Id;
	private String Nom;
	private int IDsession;
	public int getId() {
		return Id;
	}
	
	public Semestre(int id, String nom) {
		super();
		Id = id;
		Nom = nom;
	}

	public Semestre(String nom) {
		super();
		Nom = nom;
	}

	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getIDsession() {
		return IDsession;
	}
	public void setIDsession(int iDsession) {
		IDsession = iDsession;
	}
	public Semestre(int id, String nom, int iDsession) {
		super();
		Id = id;
		Nom = nom;
		IDsession = iDsession;
	}
}
