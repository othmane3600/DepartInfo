package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import metier.SingletonConnection;
import metierEntite.Etudiant;

public class EtudiantDaoImpl {
	public List<Etudiant> getAllEtudiant()  {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Etudiant>Liste=new ArrayList<>();
		
		try {
			ps=conn.prepareStatement("SELECT * FROM etudiant Where State=1 ");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Etudiant Et=new Etudiant();
				Et.setId(rs.getInt("IdEtud"));
				Et.setNom(rs.getString("Nom"));
				Et.setPrenom(rs.getString("Prenom"));
				Et.setEmail(rs.getString("email"));
				Et.setMassar(rs.getString("Massar"));
				Et.setMdp(rs.getString("Mdp"));
			
				Liste.add(Et);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Liste;
	}

	public List<Etudiant> getEtudiantParMC(String mc) {
		
		Connection con= SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Etudiant>Liste=new ArrayList<>();
		
		try {
			ps=con.prepareStatement("SELECT * FROM etudiant WHERE Nom like ?");
			ps.setString(1, mc +"%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Etudiant Et=new Etudiant();
				Et.setNom(rs.getString("Nom"));
				Et.setPrenom(rs.getString("Prenom"));
				Et.setEmail(rs.getString("Email"));
				Et.setMassar(rs.getString("Massar"));
				Liste.add(Et);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Liste;
	}
public Etudiant getEtudiantParId(int id) {
		
		Connection con= SingletonConnection.getConnection();
		PreparedStatement ps;
		Etudiant et =new Etudiant();
		
		try {
			ps=con.prepareStatement("SELECT * FROM etudiant WHERE IdEtud=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			et.setId(rs.getInt("IdEtud"));
			et.setNom(rs.getString("Nom"));
			et.setPrenom(rs.getString("Prenom"));
			et.setEmail(rs.getString("Email"));
			et.setMassar(rs.getString("Massar"));
			et.setMdp(rs.getString("Mdp"));}
			


		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return et;
	}
	public Etudiant Add(Etudiant E) {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO etudiant(Prenom,Nom,Email,Mdp,Massar) VALUES(?,?,?,?,?)");
	    	ps.setString(1,E.getPrenom());
	        ps.setString(2, E.getNom());
	        ps.setString(3, E.getEmail());
	        ps.setString(4, E.getMdp());
	        ps.setString(5, E.getMassar());
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	return E;
	}
	public void Modify(String nom , String prenom , String email , String mdp,String massar,int id) {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("UPDATE etudiant SET Prenom=?,Nom=?,Email=?,Mdp=?,Massar=? WHERE IdEtud=?");
			ps.setString(1,prenom);
	        ps.setString(2, nom);
	        ps.setString(3, email);
	        ps.setString(4, mdp);
	        ps.setString(5, massar);
	        ps.setInt(6, id);
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}
	public void Delete(Etudiant E) {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("delete from etudiant where Prenom=?,Nom=?,Email=?,Mdp=?,Massar=?");
			ps.setString(1,E.getPrenom());
	        ps.setString(2, E.getNom());
	        ps.setString(3, E.getEmail());
	        ps.setString(4, E.getMdp());
	        ps.setString(5, E.getMassar());
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}	
		
	}
	public void Stop(int id) {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("UPDATE etudiant SET State=0 WHERE IdEtud=?");
			ps.setInt(1,id);
	        ps.executeUpdate();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}	
	}
	
}
