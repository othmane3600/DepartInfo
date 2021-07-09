package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metierEntite.Emploi_du_temps;
import metierEntite.Professeur;

public class Emploi_du_tempsDaoImpl{
	
public void Add(InputStream ip, String nom) {
		
		// TODO Auto-generated method stub
		
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO emploi_du_temps(Emploi, nom) VALUES(?,?)");
	    	ps.setBlob(1,ip);
	    	ps.setString(2,nom);
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	
	// TODO Auto-generated method stub
	
}
public void Modify( Emploi_du_temps p ) {
	Connection conn=SingletonConnection.getConnection();
	   
    try {
    	PreparedStatement ps= conn.prepareStatement("UPDATE emploi_du_temps SET Emploi=? Nom=? WHERE IdEmploi=?");
    	ps.setBlob(1,p.getEmploi());
    	ps.setString(2,p.getNom());
        ps.setInt(3,p.getIdEmploi());
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
public void Delete(Emploi_du_temps a) {
	// TODO Auto-generated method stub
	
}
public int getEmploiByName(String name) {
	// TODO Auto-generated method stub
	Connection con= SingletonConnection.getConnection();
	PreparedStatement ps;
	int idedt =0;	
	try {
		ps=con.prepareStatement("SELECT IdEmploi FROM emploi_du_temps WHERE Nom like ?");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			idedt =rs.getInt("IdEmploi");
			
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return idedt;
}

public List<Emploi_du_temps> emploiavecProfesseur(){
	Connection conn = SingletonConnection.getConnection();
	PreparedStatement ps;
	List<Emploi_du_temps> edt = new ArrayList<Emploi_du_temps>();
	try {
		ps=conn.prepareStatement("select edt.Nom , p.Nom from emploi_du_temps edt , professeur p where edt.IdEmploi=p.idemploi \r\n"
				+ "");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Emploi_du_temps e = new Emploi_du_temps(rs.getString("edt.Nom"), rs.getString("p.Nom"));
			edt.add(e);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return edt;
}

}
    


