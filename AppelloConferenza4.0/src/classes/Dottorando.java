package classes;
/**
 * 
 * @author vince
 *
 */

import exception.AnnoException;
import exception.ClassException;

/**
 * 
 * @class Dottorando
 *
 */
public class Dottorando extends Afferente{

	private int annoCorso;
	private Afferente strutturato;
	
	public Dottorando(String nome, String cognome, int annoCorso, Afferente strutturato) throws AnnoException, ClassException {
		super(nome, cognome);
		if( annoCorso > 0 && annoCorso <= 3 ){
			this.annoCorso = annoCorso;
		}else{
			throw new AnnoException();
		}
		if(strutturato instanceof Strutturato){
			Strutturato s = (Strutturato) strutturato;
			this.strutturato = s;
		}else{
			throw new ClassException();
		}
	}

	public int getAnnoCorso() {
		return annoCorso;
	}

	public void setAnnoCorso(int annoCorso) throws AnnoException {
		if( annoCorso > 0 && annoCorso <= 3 ){
			this.annoCorso = annoCorso;
		}else{
			throw new AnnoException();
		}
	}

	public Afferente getStrutturato() {
		return strutturato;
	}

	public void setStrutturato(Afferente strutturato) throws ClassException {
		if (strutturato instanceof Strutturato) {
			Strutturato s = (Strutturato) strutturato;
			this.strutturato = s;
		} else {
			throw new ClassException();
		}
	}

	
}
