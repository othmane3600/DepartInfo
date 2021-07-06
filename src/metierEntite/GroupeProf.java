package metierEntite;

public class GroupeProf {
	private int IdProf;
	private int IdEquipeRech;
	public int getIdProf() {
		return IdProf;
	}
	public void setIdProf(int idProf) {
		IdProf = idProf;
	}
	public int getIdEquipeRech() {
		return IdEquipeRech;
	}
	public void setIdEquipeRech(int idEquipeRech) {
		IdEquipeRech = idEquipeRech;
	}
	public GroupeProf(int idProf, int idEquipeRech) {
		super();
		IdProf = idProf;
		IdEquipeRech = idEquipeRech;
	}
}
