package classes;

import exception.DurataNegativaException;

public class Traccia implements Comparable<Traccia>{

	private int id = 0;
	static int cont = 0;
	private String titolo, esecutore;
	private int durata;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Traccia other = (Traccia) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public Traccia(String titolo, String esecutore, int durata) throws DurataNegativaException{
		if(durata > 0){
			this.titolo = titolo;
			this.esecutore = esecutore;
			this.durata = durata;
		}else{
			throw new DurataNegativaException();
		}
		
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getEsecutore() {
		return esecutore;
	}
	
	public void setEsecutore(String esecutore) {
		this.esecutore = esecutore;
	}
	
	public int getDurata() {
		return durata;
	}
	
	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	@Override
	public String toString() {
		return "Traccia [getTitolo()=" + getTitolo() + ", getEsecutore()=" + getEsecutore() + ", getDurata()="
				+ getDurata() + "]";
	}
	@Override
	public int compareTo(Traccia arg0) {
		return -(this.getDurata()-arg0.getDurata());
	}
	
	
	
}
