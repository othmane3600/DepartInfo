package dao;

import java.util.List;

import metierEntite.Etudiant;

public interface EtudiantDao {
	public List<Etudiant> getAllEtudiant();
	public List<Etudiant> getEtudiantParMC(String mc);
	public Etudiant Add(Etudiant Et);
	public void Modify(String nom , String prenom , String email , String mdp,String massar,int id);
	public void Delete(Etudiant e);
	public void Stop(Etudiant e);
}
