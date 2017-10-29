package classes;
/**
 * 
 * @author vince
 *
 */

import exception.ClassException;

/**
 * 
 * @class Laboratorio
 *
 */
public class Laboratorio {

	private String nome;
	private Afferente responsabile;

	public Laboratorio(String nome, Afferente responsabile) throws ClassException {
		this.nome = nome;
		if (responsabile instanceof Strutturato) {
			Strutturato s = (Strutturato) responsabile;
			this.responsabile = s;
		} else {
			throw new ClassException();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Afferente getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Afferente responsabile) {
		this.responsabile = responsabile;
	}

}
