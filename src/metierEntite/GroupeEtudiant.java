package metierEntite;

public class GroupeEtudiant {
 private int IdGroupe;
 private int IdEtudiant;
public int getIdGroupe() {
	return IdGroupe;
}
public void setIdGroupe(int idGroupe) {
	IdGroupe = idGroupe;
}
public int getIdEtudiant() {
	return IdEtudiant;
}
public void setIdEtudiant(int idEtudiant) {
	IdEtudiant = idEtudiant;
}
public GroupeEtudiant(int idGroupe, int idEtudiant) {
	super();
	IdGroupe = idGroupe;
	IdEtudiant = idEtudiant;
}

}
