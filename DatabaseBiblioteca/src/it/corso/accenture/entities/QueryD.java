package it.corso.accenture.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class QueryD {
	
	public int Query4(int id) {

		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		try {

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();
			
			

			//Interrogazione al DB
			String queryString = "select l.titolo, p.data_prestito, p.data_riconsegna \r\n"
					+ "	from utente u, prestito p, libro l\r\n"
					+ "	where l.idlibro = p.idlibro and p.idUtente = u.idUtente and u.idUtente = " + id;


			//Creo la query e la invio al database 
			PreparedStatement statement2 = conn.prepareStatement(queryString);

			ResultSet rSet = statement2.executeQuery();

			//List<Utente> utenti = new ArrayList<Utente>();
			HashMap<Prestito, String> prestitoLibro = new HashMap<Prestito, String>();


			while (rSet.next()) {
				Prestito prestito = new Prestito(rSet.getString("data_prestito"), rSet.getString("data_riconsegna"));
				String titoloString = rSet.getString("titolo");
				prestitoLibro.put(prestito, titoloString);
			}


			System.out.println("\nLo storico dei libri chiesti in prestito dall'utente id " + id + " sono: ");

			for(Prestito i: prestitoLibro.keySet()) {
				System.out.println(i.toString() + " libro: " + prestitoLibro.get(i));
			}

			statement2.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return id;	
	}


}
