package dao;

import java.util.List;

import metierEntite.Journaliste;

public interface JournalistImpl {

	public List<Journaliste> listerJournalistes();
	
	public Journaliste ajouterJournaliste(Journaliste journaliste);
	
	public void suprimerJournaliste(Journaliste journaliste);
	
	public Journaliste getJournalisteById(int id);
	
	public void modifierJournaliste(String nom , String prenom , String email , String mdp,int id);
}
