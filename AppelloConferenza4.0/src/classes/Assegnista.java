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
 * @class Assegnista
 *
 */
public class Assegnista extends Afferente {

	private int anniExp;
	private Afferente strutturato;

	public Assegnista(String nome, String cognome, int anniExp, Afferente strutturato)
			throws ClassException, AnnoException {
		super(nome, cognome);
		if (anniExp > 0) {
			this.anniExp = anniExp;
		} else {
			throw new AnnoException();
		}
		if (strutturato instanceof Strutturato) {
			Strutturato s = (Strutturato) strutturato;
			this.strutturato = s;
		} else {
			throw new ClassException();
		}
	}

	public int getAnniExp() {
		return anniExp;
	}

	public void setAnniExp(int anniExp) throws AnnoException {
		if (anniExp > 0) {
			this.anniExp = anniExp;
		} else {
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
