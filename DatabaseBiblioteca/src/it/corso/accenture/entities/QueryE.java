package it.corso.accenture.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class QueryE {

	public void Query5() {

		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		try {

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();



			//Interrogazione al DB
			String queryString = "select distinct l.titolo, l.nome_editore, l.idlibro\r\n"
					+ "	from utente u, prestito p, libro l\r\n"
					+ "	where l.idlibro = p.idlibro and p.idUtente = u.idUtente\r\n"
					+ "	group by u.nome\r\n"
					+ "	order by count(p.idLibro) DESC";


			//Creo la query e la invio al database 
			PreparedStatement statement2 = conn.prepareStatement(queryString);

			ResultSet rSet = statement2.executeQuery();

			List<Libro> libri = new ArrayList<Libro>();


			while (rSet.next()) {
				Libro libro = new Libro(rSet.getInt("idlibro"), rSet.getString("titolo"), rSet.getString("nome_editore"));
				libri.add(libro);
			}

			System.out.println("\nI libri maggiormente prestati sono: ");

			for (Libro libro : libri) {
				System.out.println(libro.toString());
			}


			statement2.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
