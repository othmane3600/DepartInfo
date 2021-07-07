package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.SingletonConnection;
import metierEntite.Emploi_du_temps;

public class Emploi_du_tempsDaoImpl implements Emploi_du_TempsDAO{
	
public Emploi_du_temps Add(Emploi_du_temps p) {
		
		// TODO Auto-generated method stub
		
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO emploi_du_temps(Emploi) VALUES(?)");
	    	ps.setBlob(1,p.getEmploi());
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	return p;
	// TODO Auto-generated method stub
	
}
public void Modify( Emploi_du_temps p ) {
	Connection conn=SingletonConnection.getConnection();
	   
    try {
    	PreparedStatement ps= conn.prepareStatement("UPDATE emploi_du_temps SET Emploi=? WHERE IdEmploi=?");
    	ps.setBlob(1,p.getEmploi());
        ps.setInt(2,p.getIdEmploi());
        ps.executeUpdate();
        
    	} catch (SQLException e) {
    	e.printStackTrace();
    	}
}
public void Delete(int IdEmploi) {
	
    Connection conn = SingletonConnection.getConnection();
    PreparedStatement ps;
 
    try {
           ps = conn.prepareStatement("delete from emploi_du_temps where IdEmploi=?");
           ps.setInt(1,IdEmploi);
           ps.execute();
          

           ps.close();
           conn.close();




    }

    catch (Exception e) {
        e.printStackTrace();
    }
    

}
@Override
public void Delete(Emploi_du_temps a) {
	// TODO Auto-generated method stub
	
}
@Override
public Emploi_du_temps getEmploiByName(String name) {
	// TODO Auto-generated method stub
	return null;
}
    

}
