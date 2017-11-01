package classes;

import java.io.Serializable;

/**
 * 
 * @author vince
 *
 */

/**
 * 
 * @class Utente
 *
 */
public class Utente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id = 0;
	int cont = 0;
	private String nominativo;

	/**
	 * 
	 * @param nominativo
	 */
	public Utente(String nominativo) {
		this.nominativo = nominativo;
		id = ++cont;
	}

	/**
	 * 
	 * @return nominativo
	 */
	public String getNominativo() {
		return nominativo;
	}

	/**
	 * 
	 * @param nominativo
	 */
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @override toString()
	 */
	@Override
	public String toString() {
		return "Utente [getNominativo()=" + getNominativo() + ", getId()=" + getId() + "]";
	}

	/**
	 * @override hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * @override equals()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
