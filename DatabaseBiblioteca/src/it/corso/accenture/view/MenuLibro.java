package it.corso.accenture.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import it.corso.accenture.connessioneDB.utils.DBConnection;

public class MenuLibro {
	
	public MenuLibro() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserisciLibro() {
		//istanzio la mia classe DBConnection per poter usare la mia getConnection()
		DBConnection dbConnection = new DBConnection();

		String titolo;
		String nome_editore;		

		int id = 0;

		try {

			Scanner in = new Scanner(System.in);
			System.out.println("\nINSERIMENTO NUOVO LIBRO!");
			System.out.println("Inserisci titolo: ");
			titolo = in.nextLine();
			System.out.println("Inserisci nome editore: ");
			nome_editore = in.nextLine();

			//creo qui la mia connessione ufficialmente.
			Connection conn = dbConnection.getConnection();


			String sqlString = "insert into libro(titolo, nome_editore)"
					+ " values(?, ?)";


			//inserisco la mia sqlString che andrà inviata al db
			PreparedStatement statement;
			statement = conn.prepareStatement(sqlString);


			statement.setString(1, titolo);
			statement.setString(2, nome_editore);		

			statement.execute();
			statement.close();



			//Creo la query e la invio al database che mi restituisce l'ultimo id generato
			PreparedStatement statement2 = conn.prepareStatement("select max(idLibro) as id from libro");
			ResultSet rSet = statement2.executeQuery();

			while (rSet.next()) {
				id = rSet.getInt("id");
			}

			System.out.println("\nIl libro con ID " + id + " è stato inserito!");

			statement2.close();

			conn.close();


		} catch (Exception e) {
			// TODO: handle exception
		}		



	}

}
