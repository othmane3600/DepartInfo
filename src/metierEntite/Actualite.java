package metierEntite;

import java.sql.Blob;

public class Actualite {
	private int IdActu; 
	private Blob Image;
	private String Nom ;
	
	public int getIdActu() {
		return IdActu;
	}
	public void setIdActu(int idActu) {
		IdActu = idActu;
	}
	public Blob getImage() {
		return Image;
	}
	public void setImage(Blob image) {
		Image = image;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	
	@Override
	public String toString() {
		return "Actualite [IdActu=" + IdActu + ", Image=" + Image + ", Nom=" + Nom + "]";
	}
	public Actualite(Blob image, String nom) {
		super();
		Image = image;
		Nom = nom;
	}
}
