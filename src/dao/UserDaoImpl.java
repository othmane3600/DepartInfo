package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.SingletonConnection;

import metierEntite.User;

public class UserDaoImpl {
public User Add(User p) {
		
		// TODO Auto-generated method stub
		
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO users(username,password,role) VALUES(?,?,?)");
	    	ps.setString(1,p.getUsername());
	    	ps.setString(2,p.getPassword());
	    	ps.setString(3,p.getRole());
			/*
			 * ps.setInt(4,p.getIdProf()); ps.setInt(5,p.getIdEtud());
			 * ps.setInt(6,p.getIdJournaliste());
			 */
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	return p;
	// TODO Auto-generated method stub
	
}
public void Modify( User p ) {
	Connection conn=SingletonConnection.getConnection();
	   
    try {
    	PreparedStatement ps= conn.prepareStatement("UPDATE users SET username=? , password=? , role=? ,IdProf=? ,IdEtud=? ,IdJournaliste=? WHERE IdUs=?");
    	ps.setString(1,p.getUsername());
    	ps.setString(2,p.getPassword());
    	ps.setString(3,p.getRole());
    	ps.setInt(4,p.getIdProf());
    	ps.setInt(5,p.getIdEtud());
    	ps.setInt(6,p.getIdJournaliste());
        ps.executeUpdate();
        
    	} catch (SQLException e) {
    	e.printStackTrace();
    	}
}
public void Delete(int Id) {
	
    Connection conn = SingletonConnection.getConnection();
    PreparedStatement ps;
 
    try {
           ps = conn.prepareStatement("delete from emploi_du_temps where IdUs=?");
           ps.setInt(1,Id);
           ps.execute();
          

           ps.close();
           conn.close();




    }

    catch (Exception e) {
        e.printStackTrace();
    }
    

}
}
