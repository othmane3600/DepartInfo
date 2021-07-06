package dao;

import metierEntite.*;

public interface AdminDao {
	public Admin Add(Admin a);
	public Equipe_Recherche Add(Equipe_Recherche a);
	public Evenement Add(Evenement a);
	public SemFiliere Add(SemFiliere a);
	public Formation Add(Formation a);
	public Journaliste Add(Journaliste a);
	public Emploi_du_temps Add(Emploi_du_temps a);
	public Etudiant Add(Etudiant a);
	public Professeur Add(Professeur a);
	
	
	public Admin Modify(Admin a);
	public Equipe_Recherche Modify(Equipe_Recherche a);
	public Evenement Modify(Evenement a);
	public SemFiliere Modify(SemFiliere a);
	public Formation Modify(Formation a);
	public Journaliste Modify(Journaliste a);
	public Emploi_du_temps Modify(Emploi_du_temps a);
	public Etudiant Modify(Etudiant a);
	public Professeur Modify(Professeur a);
	
	public void DeleteAdm(int Id);
	public void DeleteEqpRech(int Id);
	public void DeleteEvent(int Id);
	public void DeleteSemFiliere(int Id);
	public void DeleteFormation(int Id);
	public void DeleteJournaliste(int Id);
	public void DeleteEmpl(int Id);
	public void DeleteEtud(int Id);
	public void DeleteProf(int Id);
	
}
