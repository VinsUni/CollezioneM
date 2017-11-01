package classes;

import java.io.Serializable;

/**
 * 
 * @author vince
 *
 */

/**
 * 
 * @class Domanda
 *
 */
public class Domanda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @enum tipoRisposta
	 *
	 */
	public enum tipoRisposta {
		Aperta, Chiusa
	}

	private int id = 0;
	int cont = 0;
	private String domanda;
	private tipoRisposta tipoRisposta;

	/**
	 * 
	 * @param domanda
	 * @param tipoRisposta
	 */
	public Domanda(String domanda, classes.Domanda.tipoRisposta tipoRisposta) {
		this.domanda = domanda;
		this.tipoRisposta = tipoRisposta;
		id = ++cont;
	}

	/**
	 * 
	 * @return domanda
	 */
	public String getDomanda() {
		return domanda;
	}

	/**
	 * 
	 * @param domanda
	 */
	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	/**
	 * 
	 * @return tipoRisposta
	 */
	public tipoRisposta getTipoRisposta() {
		return tipoRisposta;
	}

	/**
	 * 
	 * @param tipoRisposta
	 */
	public void setTipoRisposta(tipoRisposta tipoRisposta) {
		this.tipoRisposta = tipoRisposta;
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
		return "Domanda [getId()=" + getId() + ", getDomanda()=" + getDomanda() + ", getTipoRisposta()="
				+ getTipoRisposta() + "]";
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
		Domanda other = (Domanda) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
