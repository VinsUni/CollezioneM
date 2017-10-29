package classes;

import java.io.Serializable;

/**
 * 
 * @author Vins
 *
 */

/**
 * 
 * @class Afferente
 *
 */
public abstract class Afferente implements Comparable<Afferente>, Serializable {
	
	/**
	 * static final long serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * protected int  variable: cont
	 */
	protected transient int cont = 0;
	private transient int id = 0;
	private String nome;
	private String cognome;

	/**
	 * 
	 * @param nome
	 * @param cognome
	 */
	protected Afferente(String nome, String cognome) {
		id = ++cont;
		this.nome = nome;
		this.cognome = cognome;
	}

	/**
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @Ovverride hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * @Ovverride equals
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = true;
		if (this == obj){
			res = true;
		}
		if (obj == null){
			res = false;
		}
		if (getClass() != obj.getClass()){
			res = false;
		}
		if(obj instanceof Afferente){
			Afferente other = (Afferente) obj;
			if (id != other.id){
				res = false;
			}
		}
		return res;
	}

	/**
	 * @Override compareTo 
	 */
	@Override
	public int compareTo(Afferente arg0) {
		int num = 0;
		if (this.getCognome().equals(arg0.getCognome())) {
			num = this.getNome().compareTo(arg0.getNome());
		} else {
			num = this.getCognome().compareTo(arg0.getCognome());
		}
		return num;
	}

}
