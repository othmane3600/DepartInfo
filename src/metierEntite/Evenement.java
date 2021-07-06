package metierEntite;

public class Evenement {
	private int IdEvent;
	private byte[] Image;
	private String Nom;
	public Evenement(int idEvent, byte[] image, String nom) {
		super();
		IdEvent = idEvent;
		Image = image;
		Nom = nom;
	}
	public int getIdEvent() {
		return IdEvent;
	}
	public void setIdEvent(int idEvent) {
		IdEvent = idEvent;
	}
	public byte[] getImage() {
		return Image;
	}
	public void setImage(byte[] image) {
		Image = image;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
}
