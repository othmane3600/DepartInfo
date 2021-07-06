package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.SingletonConnection;
import metierEntite.Evenement;

public class EvenementDaoImpl implements EvenementDao {

	@Override
	public Evenement Add(Evenement p) {
		  
		  // TODO Auto-generated method stub
		  
		  Connection conn=SingletonConnection.getConnection();
		  PreparedStatement ps;
		  try { ps=conn.prepareStatement("INSERT INTO evenement(Nom,Image) VALUES(?,?)");
		  ps.setString(1,p.getNom());
		  ps.setBytes(2, p.getImage()); 
		  ps.executeUpdate();
		  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  }
		  return p; // TODO Auto-generated method stub
	}

	@Override
	public void Modify(Evenement p) {
		 
		  Connection conn=SingletonConnection.getConnection();
		  PreparedStatement ps;
		  try { ps=conn.prepareStatement("Update evenement SET Nom=?,Image=? where IdEven=? ");
		  ps.setString(1,p.getNom());
		  ps.setBytes(2, p.getImage()); 
		  ps.setInt(3,p.getIdEvent());
		  ps.executeUpdate();
		  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  }

	}

	@Override
	public void Delete(int Id) {
		Connection conn=SingletonConnection.getConnection();
		  PreparedStatement ps;
		  try { ps=conn.prepareStatement("delete from evenement where IdEven=? ");
		  
		  ps.setInt(1,Id);
		  ps.executeUpdate();
		  
		  } catch (SQLException e) {
			  e.printStackTrace(); 
			  }

	}

}
