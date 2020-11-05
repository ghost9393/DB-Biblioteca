package it.corso.accenture.entities;

public class Libro {
	
	private int id;
	private String titolo;
	private String nome_editore;
	
	
	public Libro(int id, String titolo, String nome_editore) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.nome_editore = nome_editore;
	}
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getNome_editore() {
		return nome_editore;
	}
	
	public void setNome_editore(String nome_editore) {
		this.nome_editore = nome_editore;
	}
	
	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", nome_editore=" + nome_editore + "]";
	}

	
	
}
