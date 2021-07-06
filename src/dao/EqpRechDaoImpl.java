package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.SingletonConnection;
import metierEntite.Equipe_Recherche;
import metierEntite.Laboratoire;


public class EqpRechDaoImpl {
public Equipe_Recherche Add(Equipe_Recherche p, Laboratoire l) {
		
		// TODO Auto-generated method stub
		
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO equipe_recherche(Sujet,Nom,IdLab) VALUES(?,?,?)");
	    	ps.setString(1,p.getSujet());
	        ps.setString(2, p.getNom());
	        ps.setInt(3, p.getIdLab());
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	return p;
	// TODO Auto-generated method stub
	
}
public void Modify( Equipe_Recherche p ) {
	Connection conn=SingletonConnection.getConnection();
	   
    try {
    	PreparedStatement ps= conn.prepareStatement("UPDATE equipe_recherche SET Sujet=?,Nom=?,IdLab=? WHERE IdEqpRech=?");
    	ps.setString(1,p.getSujet());
        ps.setString(2, p.getNom());
        ps.setInt(3,p.getIdLab());
        ps.setInt(4,p.getIdEquipeRech());
        ps.executeUpdate();
        
    	} catch (SQLException e) {
    	e.printStackTrace();
    	}
}
public void Delete(int IdEqpRech) {
	
    Connection conn = SingletonConnection.getConnection();
    PreparedStatement ps;
 
    try {
           ps = conn.prepareStatement("delete from equipe_recherche where IdEqpRech = ?");
           ps.setInt(1,IdEqpRech);
           ps.execute();
          

           ps.close();
           conn.close();




    }

    catch (Exception e) {
        e.printStackTrace();
    }
    

}
    
}
