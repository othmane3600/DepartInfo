package dao;

import java.util.List;

import metierEntite.Journaliste;

public interface JournalistImpl {

	public List<Journaliste> listerJournalistes();
	
	public Journaliste ajouterJournaliste(Journaliste journaliste);
	
	public void suprimerJournaliste(Journaliste journaliste);
	
	public Journaliste getJournalisteById(int id);
	
	public Journaliste modifierJournaliste(Journaliste journaliste);
}
