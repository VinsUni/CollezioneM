package main;

/**
 * 
 * @author vince
 * 
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import classes.Domanda;
import classes.Domanda.tipoRisposta;
import classes.Risultati;
import classes.Sondaggio;
import classes.Utente;

/**
 * 
 * @class TestMain
 *
 */
public class TestMain {

	/**
	 * @static Random
	 */
	static Random rnd = new Random();

	/**
	 * 
	 * @return String
	 */
	static String genRandString() {
		int l = rnd.nextInt(5) + 5;
		char[] c = new char[l];
		String a = "qwertyuiopasdfghjklzxcvbnm";
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File utenti = new File("elencoUtenti.txt");
		File domande = new File("elencoDomande.txt");

		ArrayList<Utente> elencoUtenti = new ArrayList<>();
		ArrayList<Domanda> elencoDomande = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			elencoUtenti.add(new Utente(genRandString()));
			switch (rnd.nextInt(2)) {
			case 0:
				elencoDomande.add(new Domanda(genRandString(), tipoRisposta.Aperta));
				break;
			case 1:
				elencoDomande.add(new Domanda(genRandString(), tipoRisposta.Chiusa));
				break;
			}
		}

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(utenti);
			oos = new ObjectOutputStream(fos);
			for (Utente u : elencoUtenti) {
				oos.writeObject(u.toString());
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.getMessage();
		}

		try {
			fos = new FileOutputStream(domande);
			oos = new ObjectOutputStream(fos);
			for (Domanda d : elencoDomande) {
				oos.writeObject(d.toString());
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.getMessage();
		}

		Sondaggio s = new Sondaggio(utenti, domande);
		Risultati risultati = new Risultati(elencoDomande, elencoUtenti);
		s.acquisisciRisultati(risultati);
		risultati.calcoloModa();
		s.serializzaFile();
	}

}
