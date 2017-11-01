package classes;

/**
 * 
 * @author vince
 * 
 */

import java.util.Random;

import classes.Domanda.tipoRisposta;

/**
 * 
 * @class Risposta
 *
 */
public class Risposta {

	static Random rnd = new Random();
	private int id;
	private String risposta;

	/**
	 * 
	 * @param domanda
	 */
	public Risposta(Domanda domanda) {
		if (domanda.getTipoRisposta().equals(tipoRisposta.Aperta)) {
			this.risposta = genRandString();
			id = domanda.getId();
		} else {
			switch (rnd.nextInt(3)) {
			case 0:
				this.risposta = "A";
				break;
			case 1:
				this.risposta = "B";
				break;
			case 2:
				this.risposta = "C";
				break;
			}
			id = domanda.getId();
		}
	}

	/**
	 * 
	 * @return random String
	 */
	static String genRandString() {
		int l = rnd.nextInt();
		char[] c = new char[l];
		String a = "qwertyuiopasdfg hjklzxcvbnm";
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return risposta
	 */
	public String getRisposta() {
		return risposta;
	}

}
