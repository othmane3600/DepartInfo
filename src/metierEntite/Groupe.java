package metierEntite;

public class Groupe {
  private int IdGroupe;
  private String Nom;
  private int Idsect;
  private int IdEmploi;
  private int IdSect;
public int getIdGroupe() {
	return IdGroupe;
}
public void setIdGroupe(int idGroupe) {
	IdGroupe = idGroupe;
}
public String getNom() {
	return Nom;
}
public void setNom(String nom) {
	Nom = nom;
}
public int getIdsect() {
	return Idsect;
}
public void setIdsect(int idsect) {
	Idsect = idsect;
}
public int getIdEmploi() {
	return IdEmploi;
}
public void setIdEmploi(int idEmploi) {
	IdEmploi = idEmploi;
}
public int getIdSect() {
	return IdSect;
}
public void setIdSect(int idSect) {
	IdSect = idSect;
}
public Groupe(int idGroupe, String nom, int idsect, int idEmploi, int idSect2) {
	super();
	IdGroupe = idGroupe;
	Nom = nom;
	Idsect = idsect;
	IdEmploi = idEmploi;
	IdSect = idSect2;
}
  
}
