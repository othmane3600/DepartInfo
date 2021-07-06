package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metier.SingletonConnection;
import metierEntite.Actualite;
import metierEntite.Articles;
import metierEntite.Journaliste;

public class ArticleDaoImpl {
public Articles Add(Articles p,Journaliste a) {
		
		// TODO Auto-generated method stub
		
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO Articles(Titre,Image,DateArt,IdJournaliste) VALUES(?,?,?,?)");
	    	ps.setString(1,p.getTitre());
	        ps.setBlob(2, p.getImage());
	        ps.setDate(3, p.getDateArticle());
	        ps.setInt(4, p.getIdJournaliste());
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	return p;
	// TODO Auto-generated method stub
	
}
public void Modify( Articles p ) {
	Connection conn=SingletonConnection.getConnection();
	   
    try {
    	PreparedStatement ps= conn.prepareStatement("UPDATE Articles SET Titre=?,Image=?,DateArt=?,IdJournaliste=? WHERE IdActu=?");
    	ps.setString(1,p.getTitre());
        ps.setBlob(2, p.getImage());
        ps.setDate(3,p.getDateArticle());
        ps.setInt(4,p.getIdJournaliste());
        ps.executeUpdate();
        
    	} catch (SQLException e) {
    	e.printStackTrace();
    	}
}
public void Delete(int IdArt) {
	
    Connection conn = SingletonConnection.getConnection();
    PreparedStatement ps;
 
    try {
           ps = conn.prepareStatement("delete from article where IdArt = ?");
           ps.setInt(1,IdArt);
           ps.execute();
          

           ps.close();
           conn.close();




    }

    catch (Exception e) {
        e.printStackTrace();
    }
    

}
    




}
