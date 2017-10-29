package classes;

import java.io.Serializable;

import exception.DurataException;

/**
 * 
 * @author vince
 *
 */

/**
 * 
 * @Class Traccia
 *
 */
public class Traccia implements Comparable<Traccia>, Serializable{

	/**
	 * static final long serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private int id = 0;
	
	/**
	 * Static variable
	 */
	int cont = 0;
	private String titolo;
	private String esecutore;
	private int durata;
	
	/**
	 * @Override Method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (this == obj){
			res = true;
		}
		if (obj == null){
			res = false;
		}
		if (getClass() != obj.getClass()){
			res = false;
		}
		Traccia other = (Traccia) obj;
		if (id != other.id){
			res = false;
		}
		return res;
	}
	
	public Traccia(String titolo, String esecutore, int durata) throws DurataException{
		if(durata > 0){
			this.id = ++cont;
			this.titolo = titolo;
			this.esecutore = esecutore;
			this.durata = durata;
		}else{
			throw new DurataException();
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
	
	public int getId() {
		return id;
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
