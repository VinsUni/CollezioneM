package classes;

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
public abstract class Afferente implements Comparable<Afferente> {

	static int cont = 0;
	private int id = 0;
	private String nome;
	private String cognome;

	public Afferente(String nome, String cognome) {
		id = ++cont;
		this.nome = nome;
		this.cognome = cognome;
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

	public int getId() {
		return id;
	}
	
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
		Afferente other = (Afferente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Afferente arg0) {
		if (this.getCognome().equals(arg0.getCognome())) {
			return this.getNome().compareTo(arg0.getNome());
		} else {
			return this.getCognome().compareTo(arg0.getCognome());
		}
	}

}
