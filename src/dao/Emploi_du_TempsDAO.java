package dao;

import metierEntite.Articles;
import metierEntite.Emploi_du_temps;

public interface Emploi_du_TempsDAO {
	public Emploi_du_temps Add(Emploi_du_temps a);
	public void Modify(Emploi_du_temps a);
	public void Delete(Emploi_du_temps a);
	
	public Emploi_du_temps getEmploiByName(String name);
}
