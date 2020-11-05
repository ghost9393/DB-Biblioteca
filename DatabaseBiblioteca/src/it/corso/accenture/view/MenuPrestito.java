package it.corso.accenture.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class MenuPrestito {

	public MenuPrestito() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void richiediPrestito() {
		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		int idUtente;		
		int idLibro;		
		String data_prestito;
		int giorniPrestito;		
		String data_riconsegna;

		try {

			Scanner in = new Scanner(System.in);
			System.out.println("\nRICHIEDI PRESTITO!");
			System.out.println("Inserisci il tuo ID: ");
			idUtente = in.nextInt();
			System.out.println("Inserisci l'ID del libro che vorresti: ");
			idLibro = in.nextInt();
			
			//Acquisisco la data di oggi
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime today = LocalDateTime.now();
			
			//Creo la stringa con la data di oggi
			data_prestito = dtf.format(today);
			
			System.out.println("Per quanti giorni vorresti effettuare il prestito: ");
			giorniPrestito = in.nextInt();
			
			//Aggiungo i giorni di prestito al giorno di oggi
			LocalDateTime futuro = today.plusDays(giorniPrestito);
			
			//Creo la stringa con la data del giorno in cui dovrà restituire il libro
			data_riconsegna = dtf.format(futuro);

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();


			
			String sqlString = "insert into prestito(idUtente, idLibro, data_prestito, data_riconsegna)"
					+ " values(?, ?, ?, ?)";


			//inserisco la mia sqlString che andrà inviata al db
			PreparedStatement statement;
			statement = conn.prepareStatement(sqlString);

			
			statement.setInt(1, idUtente);
			statement.setInt(2, idLibro);		
			statement.setString(3, data_prestito);		
			statement.setString(4, data_riconsegna);		

			statement.execute();
			statement.close();

			//Creo la query e la invio al database che mi restituisce il libro chiesto in prestito e la data di consegna
			PreparedStatement statement2 = conn.prepareStatement("SELECT titolo FROM libro where idlibro=" + idLibro);
			ResultSet rSet = statement2.executeQuery();
			String titoloLibro = null;

			while (rSet.next()) {
				titoloLibro = rSet.getString("titolo");
			}

			System.out.println("\nHai preso in prestito " + titoloLibro + " e dovrai restituirlo il " + data_riconsegna);

			statement2.close();


			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}		



	}

}
