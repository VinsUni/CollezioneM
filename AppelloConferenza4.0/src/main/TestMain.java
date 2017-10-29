package main;
/**
 * 
 * @author vince
 * 
 */

import java.util.Random;

import classes.Afferente;
import classes.Assegnista;
import classes.Dottorando;
import classes.Strutturato;
import classes.Strutturato.Grado;
import classes.Tesista;
import exception.AnnoException;
import exception.ClassException;
import exception.GradoException;

/**
 * 
 * @class TestMain
 *
 */
public class TestMain {

	static final Random rnd = new Random();

	static String genRandString() {
		int l = (rnd.nextInt(5) + 5);
		char[] c = new char[l];
		String a = "qwertyuiopasdfghjklzxcvbnm";
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}

	public static void main(String[] args) {

		Afferente[] afferenti = new Afferente[150];
		try{
			for (int i = 0; i < afferenti.length; i++) {
				if (i < 30) {
					switch (rnd.nextInt(3)) {
					case 0:
						afferenti[i] = new Strutturato(genRandString(), genRandString(), Grado.Associato);
						break;
					case 1:
						afferenti[i] = new Strutturato(genRandString(), genRandString(), Grado.Ordinario);
						break;
					case 2:
						afferenti[i] = new Strutturato(genRandString(), genRandString(), Grado.Ricercatore);
						break;
					default:
						break;
					}
				} else if (i >= 30 && i < 70) {
					switch (rnd.nextInt(2)) {
					case 0:
						afferenti[i] = new Dottorando(genRandString(), genRandString(), (rnd.nextInt(3) + 1),
								afferenti[rnd.nextInt(30)]);
						break;
					case 1:
						afferenti[i] = new Assegnista(genRandString(), genRandString(), (rnd.nextInt(10) + 1),
								afferenti[rnd.nextInt(30)]);
						break;
					default:
						break;
					}
				} else if (i >= 70) {
					afferenti[i] = new Tesista(genRandString(), genRandString(), genRandString(),
							afferenti[rnd.nextInt(30)], afferenti[(rnd.nextInt(40) + 30)]);
				}
			}
		}catch( ClassException | GradoException |AnnoException e) {
			e.getMessage();
		}
		
		

	}

}
