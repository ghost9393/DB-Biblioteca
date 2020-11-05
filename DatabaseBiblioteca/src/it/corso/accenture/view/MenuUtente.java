package it.corso.accenture.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class MenuUtente {


	public MenuUtente() {

	}

	public void inserisciUtente() {
		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		String nome;
		String cognome;
		String telefono;
		String indirizzo;

		int id = 0;

		try {

			Scanner in = new Scanner(System.in);
			Scanner ind = new Scanner(System.in);
			System.out.println("\nCREAZIONE NUOVO UTENTE!");
			System.out.println("Inserisci nome: ");
			nome = in.next();
			System.out.println("Inserisci cognome: ");
			cognome = in.next();
			System.out.println("Inserisci numero di telefono: ");
			telefono = in.next();
			System.out.println("Inserisci indirizzo: ");
			indirizzo = ind.nextLine();


			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();


			String sqlString = "insert into utente(nome, cognome, telefono, indirizzo)"
					+ " values(?, ?, ?, ?)";


			//inserisco la mia sqlString che andrà inviata al db
			PreparedStatement statement;

			statement = conn.prepareStatement(sqlString);


			statement.setString(1, nome);
			statement.setString(2, cognome);
			statement.setString(3, telefono);
			statement.setString(4, indirizzo);		

			statement.execute();
			statement.close();



			//Creo la query e la invio al database che mi restituisce l'ultimo id generato
			PreparedStatement statement2 = conn.prepareStatement("select max(idUtente) as id from utente");
			ResultSet rSet = statement2.executeQuery();

			while (rSet.next()) {
				id = rSet.getInt("id");
			}

			System.out.println("\nL'utente con ID " + id + " è stato inserito!");

			statement2.close();

			conn.close();


		} catch (Exception e) {
			// TODO: handle exception
		}		



	}
}
