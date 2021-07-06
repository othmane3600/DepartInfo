package dao;

import metierEntite.Filiere;

public interface FiliereDao {
public Filiere Add(Filiere A);
public void Modify(Filiere A);
public void Delete(int idFil);
}
