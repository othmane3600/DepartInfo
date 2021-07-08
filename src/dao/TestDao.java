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
	System.out.println(e.etudiantsDSgroupe(1));
	List<Groupe> g = e.groupeFROMsection("Sect1");
	System.out.println(g.size());
	HashSet<Etudiant> hs = e.getEtudiant(g);
	System.out.println(hs);
		
}}
