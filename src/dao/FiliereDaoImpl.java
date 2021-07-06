package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.SingletonConnection;
import metierEntite.Filiere;

public class FiliereDaoImpl implements FiliereDao {

	@Override
	public Filiere Add(Filiere p) {
		 
		  Connection conn=SingletonConnection.getConnection();
		  PreparedStatement ps;
		  try { ps=conn.prepareStatement("INSERT INTO filiere(Nom) VALUES(?)");
		  ps.setString(1,p.getNom());
		 
		  ps.executeUpdate();
		  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  }
		  return p;
	}

	@Override
	public void Modify(Filiere p) {
		Connection conn=SingletonConnection.getConnection();
		  PreparedStatement ps;
		  try { ps=conn.prepareStatement("Update filiere set Nom=? where IdFiliere=? ");
		  ps.setString(1,p.getNom());
		 ps.setInt(2,p.getId());
		  ps.executeUpdate();
		  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  }
		  
	}

	@Override
	public void Delete(int idFil) {
		Connection conn=SingletonConnection.getConnection();
		  PreparedStatement ps;
		  try { ps=conn.prepareStatement("delete from filiere where IdFiliere=? ");
		  ps.setInt(1,idFil);
		 
		  ps.executeUpdate();
		  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  }

	}

}
