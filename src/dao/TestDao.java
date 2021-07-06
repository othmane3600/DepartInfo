package dao;

import java.sql.Connection;

import metierEntite.*;
import metier.SingletonConnection;

public class TestDao {
	public static void main(String[] args) {
		Connection conn=SingletonConnection.getConnection();
	EtudiantDaoImpl e=new EtudiantDaoImpl();
	Etudiant et = e.getEtudiantParId(3);
	Etudiant ot= new Etudiant();
	e.Modify("ayman", "moutchou", "hh@hh", "amoud", "M133462726", 3);
		
}}
