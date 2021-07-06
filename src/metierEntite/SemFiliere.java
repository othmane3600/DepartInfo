package metierEntite;

public class SemFiliere {
	private int IdFiliere;
	private int IdSemestre;
	public SemFiliere(int idFiliere, int idSemestre) {
		super();
		IdFiliere = idFiliere;
		IdSemestre = idSemestre;
	}
	public int getIdFiliere() {
		return IdFiliere;
	}
	public void setIdFiliere(int idFiliere) {
		IdFiliere = idFiliere;
	}
	public int getIdSemestre() {
		return IdSemestre;
	}
	public void setIdSemestre(int idSemestre) {
		IdSemestre = idSemestre;
	}
}
