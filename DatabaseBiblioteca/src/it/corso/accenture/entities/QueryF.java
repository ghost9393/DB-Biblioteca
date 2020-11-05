package it.corso.accenture.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class QueryF {
	
	public void Query6() {

		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		try {

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();



			//Interrogazione al DB
			String queryString = "select p.idLibro, p.idUtente, p.data_prestito, p.data_riconsegna, concat(p.data_riconsegna - data_prestito) as DurataPrestito\r\n"
					+ "	from utente u, prestito p, libro l\r\n"
					+ "	where l.idlibro = p.idlibro and p.idUtente = u.idUtente\r\n"
					+ "	having DurataPrestito > 15";


			//Creo la query e la invio al database 
			PreparedStatement statement2 = conn.prepareStatement(queryString);

			ResultSet rSet = statement2.executeQuery();

			List<Prestito> prestito = new ArrayList<Prestito>();


			while (rSet.next()) {
				Prestito prest = new Prestito(rSet.getInt("idlibro"), rSet.getInt("idUtente"), rSet.getString("data_prestito"), rSet.getString("data_riconsegna"));
				prestito.add(prest);
			}

			System.out.println("\nI libri in prestito con più di 15 giorni sono: ");

			for (Prestito pres : prestito) {
				System.out.println(pres.dettagliPrestito());
			}


			statement2.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
