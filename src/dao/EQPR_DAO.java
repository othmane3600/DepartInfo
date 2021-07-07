package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import metier.SingletonConnection;
import metierEntite.Equipe_Recherche;

public class EQPR_DAO {

    public void addEqp(Equipe_Recherche er ,int[] id) {
        Connection conn= SingletonConnection.getConnection();
        PreparedStatement ps1,ps2;
        try {
            ps1=conn.prepareStatement("INSERT INTO equipe_recherche(Nom, Sujet) VALUES (?, ?)");
            ps1.setString(1, er.getNom());
            ps1.setString(2, er.getSujet());

            ps1.executeUpdate();
            int i= getEqpr(er.getNom(), er.getSujet());
            ps2=conn.prepareStatement("INSERT INTO grprof(IdProf,IdEqpRech) VALUES (?, ?);");
            ps2.setInt(2, i);
            for (int j = 0; j < 4; j++) {
                ps2.setInt(1, id[j]);
            }
            ps2.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public int getEqpr(String nom , String sujet) {
        Connection conn= SingletonConnection.getConnection();
        PreparedStatement ps;
        int i=0 ;
        try {
            ps=conn.prepareStatement("select IdEqpRech from equipe_recherche where Nom=? and Sujet=?");
            ps.setString(1, nom);
            ps.setString(2, sujet);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                i=rs.getInt("IdEqpRech");
            }
        }catch (Exception e) {
        // TODO: handle exception
    }
        return i;}
}