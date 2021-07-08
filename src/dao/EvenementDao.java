
package dao;

import metierEntite.Evenement;

public interface EvenementDao {
	public Evenement Add(Evenement a);
	public void Modify(Evenement a);
	public void Delete(int iD);
}
