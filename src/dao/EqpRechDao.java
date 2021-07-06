package dao;

import metierEntite.Equipe_Recherche;

public interface EqpRechDao {
	public Equipe_Recherche Add(Equipe_Recherche a);
	public void Modify(Equipe_Recherche a);
	public void Delete(Equipe_Recherche a);
}
