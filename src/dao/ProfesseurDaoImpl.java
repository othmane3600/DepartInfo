package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metierEntite.Professeur;

public class ProfesseurDaoImpl implements ProfesseurDao {

	public List<Professeur> getAllProf()  {
		Connection con= SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Professeur>Liste=new ArrayList<Professeur>();
		
		try {
			ps=con.prepareStatement("SELECT * FROM professeur");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Professeur p=new Professeur();
				
				p.setIdProfeseur(rs.getInt("IdProf"));
				p.setNom(rs.getString("Nom"));
				p.setPrenom(rs.getString("Prenom"));
				p.setEmail(rs.getString("Email"));
				p.setMdp(rs.getString("Mdp"));
				p.setTel(rs.getInt("Tel"));
			
				Liste.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Liste;
	}

	public List<Professeur> getProfParMC(String mc) {
		
		Connection con= SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Professeur>Liste=new ArrayList<>();
		
		try {
			ps=con.prepareStatement("SELECT * FROM professeur WHERE Nom like ?");
			ps.setString(1, mc +"%");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Professeur p=new Professeur();
				p.setNom(rs.getString("Nom"));
				p.setPrenom(rs.getString("Prenom"));
				p.setEmail(rs.getString("Email"));
				p.setMdp(rs.getString("Mdp"));
				p.setTel(rs.getInt("Tel"));
				
				Liste.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Liste;
	}

	
	public Professeur Add(Professeur p) {
		Connection con= SingletonConnection.getConnection();
		PreparedStatement ps;
		
		try {
			ps=con.prepareStatement("INSERT INTO professeur ( Nom,Prenom,Email,Mdp,Tel) VALUES(?,?,?,?,?)");
		
		ps.setString(1,p.getNom());
		ps.setString(2,p.getPrenom());
		ps.setString(3,p.getEmail());
		ps.setString(4,p.getMdp());
		ps.setInt(5,p.getTel());
		
		
		ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return p;
	}

	
	public void Stop(int idP) {
			
			
            Connection conn = SingletonConnection.getConnection();
            PreparedStatement ps;
            
            try {
                   ps = conn.prepareStatement("UPDATE professeur SET State=0 WHERE IdProf=?");
                   ps.setInt(1,idP);
                   ps.execute();
                   System.out.print("delete : ");

                   ps.close();
                   conn.close();

            }

            catch (Exception e) {
                e.printStackTrace();
            }
            
        
	}
		
	

	
	public void Modify(Professeur p) {
		Connection conn=SingletonConnection.getConnection();
		   
	    try {
	    	PreparedStatement ps= conn.prepareStatement("UPDATE professeur SET Nom=?,Prenom=?,Email=?,Mdp=?,Tel=? WHERE IdProf=?");
	    
	    	ps.setString(1,p.getNom());
			ps.setString(2,p.getPrenom());
			ps.setString(3,p.getEmail());
			ps.setString(4,p.getMdp());
			ps.setInt(5,p.getTel());
			ps.setInt(6,p.getIdProfeseur());
			
			ps.execute();
			ps.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}

	public Professeur getProfesseurById(int id) {
		Connection connection = SingletonConnection.getConnection();
		Professeur pr = new Professeur();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT Nom,Prenom,Email,Mdp,Tel  FROM Professeur WHERE IdProf = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pr.setIdProfeseur(id);
				pr.setNom(rs.getString("Nom"));
				pr.setPrenom(rs.getString("Prenom"));
				pr.setTel(rs.getInt("Tel"));
				pr.setEmail(rs.getString("Email"));
				pr.setMdp(rs.getString("Mdp"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}
	public Professeur geProfesseur(String username, String pass) {
		Connection connection = SingletonConnection.getConnection();
		Professeur pr = new Professeur();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT IdProf,Nom,Prenom,Email,Mdp  FROM professeur WHERE Email =? and Mdp =?");
			ps.setString(1, username);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pr.setNom(rs.getString("Nom"));
				pr.setPrenom(rs.getString("Prenom"));
				pr.setEmail(rs.getString("Email"));
				pr.setMdp(rs.getString(pass));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}

	public void Modify(String nom, String prenom, String email, String mdp, int tel, int id) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		   
	    try {
	    	PreparedStatement ps= conn.prepareStatement("UPDATE professeur SET Nom=?,Prenom=?,Email=?,Mdp=?,Tel=? WHERE IdProf=?");
	    
	    	ps.setString(1,nom);
			ps.setString(2,prenom);
			ps.setString(3,email);
			ps.setString(4,mdp);
			ps.setInt(5,tel);
			ps.setInt(6,id);
			
			ps.execute();
			ps.close();
	    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	}
	}

	
		
}
