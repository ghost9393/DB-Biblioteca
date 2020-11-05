package it.corso.accenture.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class QueryB {
	
	public void Query2() {

		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		try {

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();

			//Interrogazione al DB
			String queryString = "select u.idUtente, u.nome, u.cognome, u.telefono, u.indirizzo\r\n"
					+ "	from utente u, prestito p, libro l\r\n"
					+ "	where l.idlibro = p.idlibro and p.idUtente = u.idUtente\r\n"
					+ "	group by u.nome\r\n"
					+ "	having count(p.idLibro) > 2";

			
			//Creo la query e la invio al database 
			PreparedStatement statement2 = conn.prepareStatement(queryString);
			
			ResultSet rSet = statement2.executeQuery();
			
			List<Utente> utenti = new ArrayList<Utente>();
			
			
			while (rSet.next()) {
				Utente ut = new Utente(rSet.getInt("idUtente"), rSet.getString("nome"), rSet.getString("cognome"), rSet.getString("telefono"), rSet.getString("indirizzo"));
				utenti.add(ut);
			}

			
			System.out.println("\nI primi tre lettori che hanno letto più libri sono: ");
			
			for (Utente uten : utenti) {
				System.out.println(uten.toString());
			}

			statement2.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}	
	}

}
