package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import metier.SingletonConnection;
import metierEntite.Etudiant;
import metierEntite.Groupe;
import metierEntite.Section;
import metierEntite.Semestre;

public class EtudiantDaoImpl {
	public List<Etudiant> getEtudiantActive() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Etudiant> Liste = new ArrayList<>();

		try {
			ps = conn.prepareStatement("SELECT * FROM etudiant Where State=1 ");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Etudiant Et = new Etudiant();
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

	public List<Etudiant> getEtudiantNotActive() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Etudiant> Liste = new ArrayList<>();

		try {
			ps = conn.prepareStatement("SELECT * FROM etudiant Where State=0 ");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Etudiant Et = new Etudiant();
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

	public List<Etudiant> getAllEtudiant() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Etudiant> Liste = new ArrayList<>();

		try {
			ps = conn.prepareStatement("SELECT * FROM etudiant ");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Etudiant Et = new Etudiant();
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

		Connection con = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Etudiant> Liste = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT * FROM etudiant WHERE Nom like ?");
			ps.setString(1, mc + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Etudiant Et = new Etudiant();
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

		Connection con = SingletonConnection.getConnection();
		PreparedStatement ps;
		Etudiant et = new Etudiant();

		try {
			ps = con.prepareStatement("SELECT * FROM etudiant WHERE IdEtud=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				et.setId(rs.getInt("IdEtud"));
				et.setNom(rs.getString("Nom"));
				et.setPrenom(rs.getString("Prenom"));
				et.setEmail(rs.getString("Email"));
				et.setMassar(rs.getString("Massar"));
				et.setMdp(rs.getString("Mdp"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return et;
	}

	public Etudiant Add(Etudiant E) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("INSERT INTO etudiant(Prenom,Nom,Email,Mdp,Massar) VALUES(?,?,?,?,?)");
			ps.setString(1, E.getPrenom());
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

	public int getIdGroupe(String nom) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		int id = 0;
		try {
			ps = conn.prepareStatement("select IdGrp from groupe where Nom=? ");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("IdGrp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
	}

	public int getIdSection(String nom) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		int id = 0;
		try {
			ps = conn.prepareStatement("select IdSect from section where Nom=? ");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("IdSect");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
	}

	public List<Groupe> groupeFROMsection(String noms) {
		int ids = getIdSection(noms);
		List<Groupe> lg = new ArrayList<Groupe>();
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select g.* from groupe g , section s where g.IdSect=s.IdSect and s.Nom=?");
			ps.setString(1, noms);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Groupe g = new Groupe(rs.getInt("IdGrp"), rs.getString("Nom"), ids, rs.getInt("IdEmploi"), 0);
				lg.add(g);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lg;
	}

	public List<Etudiant> etudiantsDSgroupe(int idg) {
		List<Etudiant> le = new ArrayList<Etudiant>();
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(
					"select e.* from etudiant e ,groupe g , grpetud ge where g.IdGrp=ge.IdGrp and g.IdGrp=? and ge.IdEtud=e.IdEtud");
			ps.setInt(1, idg);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Etudiant e = new Etudiant(rs.getString("Email"), rs.getString("Massar"), null, rs.getString("Nom"),
						rs.getString("Prenom"));
				le.add(e);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return le;
	}

	public List<Groupe> listegroupe() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Groupe> lg = new ArrayList<Groupe>();
		try {
			ps = conn.prepareStatement("select IdGrp,nom from groupe");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Groupe g = new Groupe(rs.getInt("IdGrp"), rs.getString("nom"));
				lg.add(g);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lg;
	}

	public List<Section> listeSec() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Section> lg = new ArrayList<Section>();
		try {
			ps = conn.prepareStatement("select IdSect,nom from section");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Section g = new Section(rs.getInt("IdSect"), rs.getString("nom"));
				lg.add(g);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lg;
	}

	public List<Semestre> listeSem() {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Semestre> lg = new ArrayList<Semestre>();
		try {
			ps = conn.prepareStatement("select IdSemestre,nom from semestre");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Semestre g = new Semestre(rs.getInt("IdSemestre"), rs.getString("nom"));
				lg.add(g);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lg;
	}
	
	public void Modify(String nom, String prenom, String email, String mdp, String massar, int id) {
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("UPDATE etudiant SET Prenom=?,Nom=?,Email=?,Mdp=?,Massar=? WHERE IdEtud=?");
			ps.setString(1, prenom);
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
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("delete from etudiant where Prenom=?,Nom=?,Email=?,Mdp=?,Massar=?");
			ps.setString(1, E.getPrenom());
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
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("UPDATE etudiant SET State=0 WHERE IdEtud=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public HashSet<Etudiant> getEtudiant(List<Groupe> g) {
		System.out.println("au sein de la methhode ");
		HashSet<Etudiant> e = new HashSet<Etudiant>();
		List<Etudiant> le= null;
		for (int i = 0; i < g.size(); i++) {
			int idg = getIdGroupe(g.get(i).getNom());
			le = etudiantsDSgroupe(idg);
			e.addAll(le);
			
		}
		return e;
	}
	
	public List<Section> listeSecfromSem(String semestre ){
		Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		List<Section> ls = new  ArrayList<Section>();
		try {
			ps=conn.prepareStatement("select s.Nom from section s , semestre sm , sectsem ss where s.IdSect=ss.IdSect and sm.Nom=? and sm.IdSemestre=ss.IdSemestre;");
			ps.setString(1, semestre);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Section s = new Section(rs.getString("Nom"));
				ls.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ls;
	}
	
	public HashSet<Etudiant> etudiantDSSem(String semestre){
		List<Section> ls = listeSecfromSem(semestre);
		HashSet<Etudiant> hs = new HashSet<Etudiant>();
		HashSet<Etudiant> t = null;
		for (int i = 0; i < ls.size(); i++) {
			List<Groupe> lg = groupeFROMsection(ls.get(i).getNom());
			t=getEtudiant(lg);
			hs.addAll(t);
		}
		return hs;
	}
}
