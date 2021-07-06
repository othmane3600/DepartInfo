package metierEntite;

import java.sql.Date;

import com.mysql.jdbc.Blob;

public class Articles {
	private int IdArticles;
	private Date DateArticle;
	private String titre;
	private Blob Image;
	private int IdJournaliste;
	public int getIdArticles() {
		return IdArticles;
	}
	public void setIdArticles(int idArticles) {
		IdArticles = idArticles;
	}
	public Date getDateArticle() {
		return DateArticle;
	}
	public void setDateArticle(Date dateArticle) {
		DateArticle = dateArticle;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Blob getImage() {
		return Image;
	}
	public void setImage(Blob image) {
		Image = image;
	}
	public int getIdJournaliste() {
		return IdJournaliste;
	}
	public void setIdJournaliste(int idJournaliste) {
		IdJournaliste = idJournaliste;
	}
	public Articles( Date dateArticle, String titre, Blob image, int idJournaliste) {
		super();
		
		DateArticle = dateArticle;
		this.titre = titre;
		Image = image;
		IdJournaliste = idJournaliste;
	}
	
}
