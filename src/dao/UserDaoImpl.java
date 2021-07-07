package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.SingletonConnection;
import metierEntite.Professeur;
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
public int getIDProf(String nom , String prenom) {
    Connection conn = SingletonConnection.getConnection();
    PreparedStatement ps ;
    int idProf =0;
    try {
        ps = conn.prepareStatement("select id_professeur from professeur where nom_professeur=? and prenom_professeur=?");
        ps.setString(1, nom);
        ps.setString(2, prenom);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            idProf = rs.getInt("id_professeur");
        }
        ps.close();
        conn.close();
    }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    return idProf ;
}
public void addUser(User user , Professeur prof) {
    Connection conn = SingletonConnection.getConnection();
    int idprf = getIDProf(prof.getNom(),prof.getPrenom());
    PreparedStatement ps ;
    try {
        ps=conn.prepareStatement(" insert into user(password,roles,username,id_prof) values(?,?,?,?)");
        ps.setString(1, user.getPassword());
        ps.setString(2, "professeur");
        ps.setString(3, user.getUsername());
        ps.setInt(4, idprf);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }catch(Exception e ) {
        e.printStackTrace();
    }
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
