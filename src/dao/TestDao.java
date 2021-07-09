package dao;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;

import metierEntite.*;
import metier.SingletonConnection;

public class TestDao {
	public static void main(String[] args) {
		Connection conn=SingletonConnection.getConnection();
	EtudiantDaoImpl e=new EtudiantDaoImpl();
	Etudiant et = e.getEtudiantParId(3);
	List<Section> s = e.listeSecfromSem("S1");
	HashSet<Etudiant> hs = e.etudiantDSSem("S1");
	System.out.println(hs);
}}
