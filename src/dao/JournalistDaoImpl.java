package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metierEntite.Journaliste;

public class JournalistDaoImpl implements JournalistImpl {

	@Override
	public List<Journaliste> listerJournalistes() {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Journaliste>Liste=new ArrayList<>();
		
		try {
			ps=conn.prepareStatement("SELECT * FROM journaliste  ");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Journaliste Et=new Journaliste();
				Et.setIdJournaliste(rs.getInt("IdJournaliste"));
				Et.setNom(rs.getString("Nom"));
				Et.setPrenom(rs.getString("Prenom"));
				Et.setEmail(rs.getString("Email"));
				Et.setMdp(rs.getString("Mdp"));
			
				Liste.add(Et);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Liste;
	}

	@Override
	public Journaliste ajouterJournaliste(Journaliste journaliste) {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
	    try {
	    	ps= conn.prepareStatement("INSERT INTO journaliste(Prenom,Nom,Email,Mdp) VALUES(?,?,?,?)");
	    	ps.setString(1,journaliste.getPrenom());
	        ps.setString(2, journaliste.getNom());
	        ps.setString(3, journaliste.getEmail());
	        ps.setString(4, journaliste.getMdp());
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	    	
	
	return journaliste;
	}

	@Override
	public void suprimerJournaliste(Journaliste E) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("delete from journaliste where Prenom=?,Nom=?,Email=?,Mdp=?");
			ps.setString(1,E.getPrenom());
	        ps.setString(2, E.getNom());
	        ps.setString(3, E.getEmail());
	        ps.setString(4, E.getMdp());
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}	
		
	}

	@Override
	public Journaliste getJournalisteById(int id) {

		Connection con= SingletonConnection.getConnection();
		PreparedStatement ps;
		Journaliste et =new Journaliste();
		
		try {
			ps=con.prepareStatement("SELECT * FROM journaliste WHERE IdJournaliste=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			et.setIdJournaliste(rs.getInt("IdJournaliste"));
			et.setNom(rs.getString("Nom"));
			et.setPrenom(rs.getString("Prenom"));
			et.setEmail(rs.getString("Email"));
			et.setMdp(rs.getString("Mdp"));}
			


		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return et;
	}

	@Override
	public void modifierJournaliste(String nom , String prenom , String email , String mdp,int id) {
		Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("UPDATE Journaliste SET Prenom=?,Nom=?,Email=?,Mdp=? WHERE IdJournaliste=?");
			ps.setString(1,prenom);
	        ps.setString(2, nom);
	        ps.setString(3, email);
	        ps.setString(4, mdp);
	        ps.setInt(6, id);
	        ps.executeUpdate();
	        
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}

}
