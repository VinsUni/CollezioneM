package classes;
/**
 * 
 * @author vince
 *
 */

import exception.GradoException;

/**
 * 
 * @class Strutturato
 *
 */
public class Strutturato extends Afferente {

	public enum Grado{Ricercatore, Associato, Ordinario}
	
	private Grado grado;
	
	public Strutturato(String nome, String cognome, Grado grado) throws GradoException {
		super(nome, cognome);
		if(grado.equals(Grado.Associato) || grado.equals(Grado.Ricercatore) || grado.equals(Grado.Ordinario)){
			this.grado = grado;
		}else{
			throw new GradoException();
		}
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	
	

}
