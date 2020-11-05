package it.corso.accenture.test;

import java.util.Scanner;

import it.corso.accenture.entities.QueryA;
import it.corso.accenture.entities.QueryB;
import it.corso.accenture.entities.QueryC;
import it.corso.accenture.entities.QueryD;
import it.corso.accenture.entities.QueryE;
import it.corso.accenture.entities.QueryF;
import it.corso.accenture.view.MenuLibro;
import it.corso.accenture.view.MenuPrestito;
import it.corso.accenture.view.MenuUtente;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int scelta;
		int sceltaQuery;


		do {
			System.out.println("\nBIBLIOTECA\n[1] - Inserisci Utente. \n[2] - Inseresci Libro. \n[3] - Richiedi in prestito un libro."
					+ "\n[4] - Interrogazione al DB. \n[5] ESCI!");
			scelta = scanner.nextInt();

			switch (scelta) {
			case 1: {
				MenuUtente utente = new MenuUtente();
				utente.inserisciUtente();
			}
			break;

			case 2: {
				MenuLibro libro = new MenuLibro();
				libro.inserisciLibro();

			}
			break;

			case 3:	{
				MenuPrestito menuPrestito = new MenuPrestito();
				menuPrestito.richiediPrestito();

			}
			break;

			case 4:	{

				do {
					System.out.println("\nINTERROGAZIONI DB \n[1] - Libri prestati ad un utente specifico. "
							+ "\n[2] - Primi tre lettori che hanno letto più libri. \n[3] - Possessori dei libri non ancora rientrati."
							+ "\n[4] - Storico dei libri chiesti in prestito da un utente. \n[5] - Classifica dei libri maggiormente prestati"
							+ "\n[6] - Prestiti la cui durata supera i 15gg"
							+ "\n[7] - ESCI!");
					sceltaQuery = scanner.nextInt();


					switch (sceltaQuery) {
					case 1: {
						System.out.println("Inserisci nome utente: ");
						String utente = scanner.next();
						QueryA queryA = new QueryA();
						queryA.Query1(utente);

					}
					break;

					case 2: {
						QueryB queryB = new QueryB();
						queryB.Query2();
					}
					break;
					
					case 3: {
						QueryC queryC = new QueryC();
						queryC.Query3();
					}
					break;
					
					case 4: {
						System.out.println("Inserisci id utente: ");
						int id = scanner.nextInt();
						QueryD queryD = new QueryD();
						queryD.Query4(id);
					}
					break;
					
					case 5: {
						QueryE queryE = new QueryE();
						queryE.Query5();
					}
					break;
					
					case 6: {
						QueryF queryF = new QueryF();
						queryF.Query6();
					}
					break;
					}
				} while(sceltaQuery != 7);
			}
			break;

			} 

		} while (scelta != 5);

		scanner.close();
	}
}
