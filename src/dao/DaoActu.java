package dao;
import metierEntite.Actualite;
public interface DaoActu {
	public Actualite Add(Actualite a);
	public void Modify(Actualite a);
	public void DeleteA(int Id);
}
