/*
 * package dao;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.SQLException;
 * 
 * import metier.SingletonConnection; import metierEntite.*;
 * 
 * public class AdminDaoImpl { public Admin Add(Admin p) {
 * 
 * // TODO Auto-generated method stub
 * 
 * Connection conn=SingletonConnection.getConnection(); PreparedStatement ps;
 * try { ps= conn.prepareStatement("INSERT INTO admin(Login,Mdp) VALUES(?,?)");
 * ps.setString(1,p.getLogin()); ps.setString(2, p.getMdp());
 * ps.executeUpdate();
 * 
 * } catch (SQLException e) { e.printStackTrace(); }
 * 
 * 
 * return p; // TODO Auto-generated method stub
 * 
 * } public Equipe_Recherche Add(Equipe_Recherche p) {
 * 
 * // TODO Auto-generated method stub
 * 
 * Connection conn=SingletonConnection.getConnection(); PreparedStatement ps;
 * try { ps=
 * conn.prepareStatement("INSERT INTO equipe_recherche(Nom,Sujet) VALUES(?,?)");
 * ps.setString(1,p.getNom()); ps.setString(2, p.getSujet());
 * ps.executeUpdate();
 * 
 * } catch (SQLException e) { e.printStackTrace(); }
 * 
 * 
 * return p; // TODO Auto-generated method stub
 * 
 * } public Evenement Add(Evenement p) {
 * 
 * // TODO Auto-generated method stub
 * 
 * Connection conn=SingletonConnection.getConnection(); PreparedStatement ps;
 * try { ps=
 * conn.prepareStatement("INSERT INTO evenement(Nom,Image) VALUES(?,?)");
 * ps.setString(1,p.getNom()); ps.setBytes(2, p.getImage()); ps.executeUpdate();
 * 
 * } catch (SQLException e) { e.printStackTrace(); }
 * 
 * 
 * return p; // TODO Auto-generated method stub
 * 
 * }
 * 
 * public SemFiliere Add(SemFiliere p) {
 * 
 * // TODO Auto-generated method stub
 * 
 * Connection conn=SingletonConnection.getConnection(); PreparedStatement ps;
 * try { ps=
 * conn.prepareStatement("INSERT INTO equipe_recherche(Nom,Sujet) VALUES(?,?)");
 * ps.setString(1,p.getNom()); ps.setString(2, p.getSujet());
 * ps.executeUpdate();
 * 
 * } catch (SQLException e) { e.printStackTrace(); }
 * 
 * 
 * return p; // TODO Auto-generated method stub
 * 
 * }
 * 
 * public Formation Add(Formation p) {
 * 
 * // TODO Auto-generated method stub
 * 
 * Connection conn=SingletonConnection.getConnection(); PreparedStatement ps;
 * try { ps=
 * conn.prepareStatement("INSERT INTO formation(Nom,Descrip) VALUES(?,?)");
 * ps.setString(1,p.getNom()); ps.setString(2, p.getDescrip());
 * ps.executeUpdate();
 * 
 * } catch (SQLException e) { e.printStackTrace(); }
 * 
 * 
 * return p; // TODO Auto-generated method stub
 * 
 * } public Equipe_Recherche Add(Equipe_Recherche p) {
 * 
 * // TODO Auto-generated method stub
 * 
 * Connection conn=SingletonConnection.getConnection(); PreparedStatement ps;
 * try { ps=
 * conn.prepareStatement("INSERT INTO equipe_recherche(Nom,Sujet) VALUES(?,?)");
 * ps.setString(1,p.getNom()); ps.setString(2, p.getSujet());
 * ps.executeUpdate();
 * 
 * } catch (SQLException e) { e.printStackTrace(); }
 * 
 * 
 * return p; // TODO Auto-generated method stub
 * 
 * } }
 */