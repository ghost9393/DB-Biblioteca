package it.corso.accenture.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class QueryC {

	public void Query3() {

		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		try {

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();
			
			//Acquisisco la data di oggi
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime today = LocalDateTime.now();
			
			//Creo la stringa con la data di oggi
			String data_oggi = dtf.format(today);

			//Interrogazione al DB
			String queryString = "select u.idUtente, u.nome, u.cognome, u.telefono, u.indirizzo, l.titolo\r\n"
					+ "	from utente u, prestito p, libro l\r\n"
					+ "	where l.idlibro = p.idlibro and p.idUtente = u.idUtente and '" + data_oggi + "' > p.data_riconsegna";


			//Creo la query e la invio al database 
			PreparedStatement statement2 = conn.prepareStatement(queryString);

			ResultSet rSet = statement2.executeQuery();

			//List<Utente> utenti = new ArrayList<Utente>();
			HashMap<Utente, String> utenteLibro = new HashMap<Utente, String>();


			while (rSet.next()) {
				Utente ut = new Utente(rSet.getInt("idUtente"), rSet.getString("nome"), rSet.getString("cognome"), rSet.getString("telefono"), rSet.getString("indirizzo"));
				String titoloString = rSet.getString("titolo");
				utenteLibro.put(ut, titoloString);
			}


			System.out.println("\nI Possessori dei libri non ancora rientrati oggi sono: ");

			for(Utente i: utenteLibro.keySet()) {
				System.out.println(i.toString() + " libro: " + utenteLibro.get(i));
			}

			statement2.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}	
	}

}
