package metierEntite;

public class Etudiant {
   private String Email;
   private int Id;
   private String Massar;
   private String Mdp;
   private String Nom;
   private String Prenom;
public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getMassar() {
	return Massar;
}
public void setMassar(String massar) {
	Massar = massar;
}
public String getMdp() {
	return Mdp;
}
public void setMdp(String mdp) {
	Mdp = mdp;
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
public Etudiant(String email,String massar, String mdp, String nom, String prenom) {
	super();
	Email = email;
	Massar = massar;
	Mdp = mdp;
	Nom = nom;
	Prenom = prenom;
}
public Etudiant() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Etudiant [Email=" + Email + ", Id=" + Id + ", Massar=" + Massar + ", Mdp=" + Mdp + ", Nom=" + Nom
			+ ", Prenom=" + Prenom + "]";
}
   
}
