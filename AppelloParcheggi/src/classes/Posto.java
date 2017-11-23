package classes;

import java.io.Serializable;

import exceptions.PostoException;

public class Posto implements Comparable<Posto>, Serializable {

	public enum Stato {
		LIBERO, OCCUPATO
	}

	private Veicolo veicolo;
	private Stato stato;
	private int oraIngresso;
	private int durata;
	private double costoTotale;

	public Posto() {
		stato = Stato.LIBERO;
	}

	public Veicolo getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public int getOraIngresso() {
		return oraIngresso;
	}

	public void setOraIngresso(int oraIngresso) {
		this.oraIngresso = oraIngresso;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}

	@Override
	public String toString() {
		return "Posto [getVeicolo()=" + getVeicolo() + ", getStato()=" + getStato() + ", getOraIngresso()="
				+ getOraIngresso() + ", getDurata()=" + getDurata() + ", getCostoTotale()="+ getCostoTotale() + "]";
	}

	public void occupa(Veicolo v, int oraIngresso) throws PostoException {
		if (getStato().equals(Stato.LIBERO)) {
			this.setVeicolo(v);
			this.setOraIngresso(oraIngresso);
			this.setStato(Stato.OCCUPATO);
		} else {
			throw new PostoException();
		}
	}

	public void libera() throws PostoException {
		if (getStato().equals(Stato.OCCUPATO)) {
			this.setVeicolo(null);
			this.setOraIngresso(0);
			this.setStato(Stato.LIBERO);
		} else {
			throw new PostoException();
		}
	}

	@Override
	public int compareTo(Posto arg0) {
		return this.getDurata() - arg0.getDurata();
	}

}
