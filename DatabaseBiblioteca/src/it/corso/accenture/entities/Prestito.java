package it.corso.accenture.entities;

public class Prestito {
	private int idUtente;
	private int idLibro;
	private String data_prestito;
	private String data_riconsegna;
	
	
	
	public Prestito(int idUtente, int idLibro, String data_prestito, String data_riconsegna) {
		super();
		this.idUtente = idUtente;
		this.idLibro = idLibro;
		this.data_prestito = data_prestito;
		this.data_riconsegna = data_riconsegna;
	}
	
	public Prestito(String data_prestito, String data_riconsegna) {
		super();
		this.data_prestito = data_prestito;
		this.data_riconsegna = data_riconsegna;
	}
	
	public Prestito() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdUtente() {
		return idUtente;
	}
	
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	
	public int getIdLibro() {
		return idLibro;
	}
	
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	
	public String getData_prestito() {
		return data_prestito;
	}
	
	public void setData_prestito(String data_prestito) {
		this.data_prestito = data_prestito;
	}
	
	public String getData_riconsegna() {
		return data_riconsegna;
	}
	
	public void setData_riconsegna(String data_riconsegna) {
		this.data_riconsegna = data_riconsegna;
	}

	@Override
	public String toString() {
		return "[data_prestito=" + data_prestito + ", data_riconsegna=" + data_riconsegna + "]";
	}

	public String dettagliPrestito() {	
		return "Prestito [idUtente=" + idUtente + ", idLibro=" + idLibro + ", data_prestito=" + data_prestito
				+ ", data_riconsegna=" + data_riconsegna + "]";
	}
	
	
}
