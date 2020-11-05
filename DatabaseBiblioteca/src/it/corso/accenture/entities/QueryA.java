package it.corso.accenture.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class QueryA {

	//Cercare tutti i libri prestati ad un utente specifico (a piacere tra quelli inseriti) in ordine cronologico
	public String Query1(String utente) {

		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		try {

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();

			//Interrogazione al DB
			String queryString = "SELECT l.idlibro, l.titolo, l.nome_editore "
					+ "FROM libro l, prestito p, utente u "
					+ "WHERE p.idUtente = u.idUtente and p.idlibro = l.idlibro and u.nome= '" + utente + "' order by p.data_prestito DESC";

			
			//Creo la query e la invio al database 
			PreparedStatement statement2 = conn.prepareStatement(queryString);
			
			ResultSet rSet = statement2.executeQuery();
			
			List<Libro> libri = new ArrayList<Libro>();
			
			
			while (rSet.next()) {
				Libro libro = new Libro(rSet.getInt("idlibro"), rSet.getString("titolo"), rSet.getString("nome_editore"));
				libri.add(libro);
			}

			for (Libro libro : libri) {
				System.out.println(libro.toString());
			}

			statement2.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return utente;		
	}


}
