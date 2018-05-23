package it.polito.tdp.porto.model;

public class AutArt {

	private int pubblicazione;
	private int autore;

	public int getPubblicazione() {
		return pubblicazione;
	}

	public int getAutore() {
		return autore;
	}

	public AutArt(int pubblicazione, int autore) {
		super();
		this.pubblicazione = pubblicazione;
		this.autore = autore;
	}

}
