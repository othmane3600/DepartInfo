package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metierEntite.Actualite;
import metier.SingletonConnection;
public class ActuDaoImpl implements DaoActu {
	public Actualite Add(Actualite p) {
		
		// TODO Auto-generated method stub
		
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO Actualite(Nom,Image) VALUES(?,?)");
	    	ps.setString(1,p.getNom());
	        ps.setBlob(2, p.getImage());
	        ps.executeUpdate();
	        ps.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	return p;
	// TODO Auto-generated method stub
	
}

	@Override
	public void Modify( Actualite p ) {
		Connection conn=SingletonConnection.getConnection();
		   
	    try {
	    	PreparedStatement ps= conn.prepareStatement("UPDATE Actualite SET Nom=?,Image=? WHERE IdActu=?");
	    	ps.setString(1,p.getNom());
	        ps.setBlob(2, p.getImage());
	        ps.setInt(3,p.getIdActu());
	        ps.executeUpdate();
	        ps.close();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	
	}

	@Override
	public void DeleteA(int IdAc) {
		
            Connection conn = SingletonConnection.getConnection();
            PreparedStatement ps;
         
            try {
                   ps = conn.prepareStatement("delete from Actualite where IdActu = ?");
                   ps.setInt(1,IdAc);
                   ps.execute();
                  

                   ps.close();
                   conn.close();




            }

            catch (Exception e) {
                e.printStackTrace();
            }
            
        
	}
}
