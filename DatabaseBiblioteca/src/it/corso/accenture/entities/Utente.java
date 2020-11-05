package it.corso.accenture.entities;

public class Utente {
	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	private String indirizzo;
	
	public Utente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Utente(int id, String nome, String cognome, String telefono, String indirizzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + ", indirizzo=" + indirizzo
				+ "]";
	}

	
	
	
}
