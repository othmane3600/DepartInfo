package dao;
import java.util.List;

import metierEntite.*;
public interface ProfesseurDao {
	
		public List<Professeur> getAllProf();
		public List<Professeur> getProfParMC(String mc);
		public Professeur Add(Professeur Et);
		public void Modify(Professeur p);
		
		public void Stop(int id);
		public Professeur getProfesseurById(int id);
		public Professeur geProfesseur(String username, String pass);
		
		
		public void updateProfesseur(int idProfesseur,int idEmploi);
}
