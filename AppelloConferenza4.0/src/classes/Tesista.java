package classes;
/**
 * 
 * @author vince
 *
 */

import exception.ClassException;

/**
 * 
 * @class Tesista
 *
 */
public class Tesista extends Afferente{

	private String titolo;
	private Afferente relatore;
	private Afferente correlatore;
	
	public Tesista(String nome, String cognome, String titolo, Afferente relatore, Afferente correlatore) throws ClassException {
		super(nome, cognome);
		this.titolo = titolo;
		if(relatore instanceof Strutturato){
			Strutturato r = (Strutturato) relatore;
			this.relatore = r;
		}else{
			throw new ClassException();
		}
		if(correlatore instanceof Dottorando){
			Dottorando d = (Dottorando) correlatore;
			this.correlatore = d;
		}else if(correlatore instanceof Assegnista){
			Assegnista a = (Assegnista) correlatore;
			this.correlatore = a;
		}else{
			throw new ClassException();
		}
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Afferente getRelatore() {
		return relatore;
	}

	public void setRelatore(Afferente relatore) throws ClassException {
		if(relatore instanceof Strutturato){
			Strutturato r = (Strutturato) relatore;
			this.relatore = r;
		}else{
			throw new ClassException();
		}
	}

	public Afferente getCorrelatore() {
		return correlatore;
	}

	public void setCorrelatore(Afferente correlatore) throws ClassException {
		if(correlatore instanceof Dottorando){
			Dottorando d = (Dottorando) correlatore;
			this.correlatore = d;
		}else if(correlatore instanceof Assegnista){
			Assegnista a = (Assegnista) correlatore;
			this.correlatore = a;
		}else{
			throw new ClassException();
		}
	}
	
	

}
