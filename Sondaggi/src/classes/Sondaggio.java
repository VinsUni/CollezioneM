package classes;

/**
 * 
 * @author vince
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @class Sondaggio
 *
 */
public class Sondaggio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Utente> elencoUtenti;
	private List<Domanda> elencoDomande;
	private Risultati risultati;

	/**
	 * 
	 * @param utenti
	 * @param domande
	 * 
	 */
	public Sondaggio(File utenti, File domande) {
		elencoDomande = new ArrayList<>();
		elencoUtenti = new ArrayList<>();

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(utenti);
			ois = new ObjectInputStream(fis);
			elencoUtenti = (List<Utente>) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(domande);
			ois = new ObjectInputStream(fis);
			elencoDomande = (List<Domanda>) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void serializzaFile() throws IOException {
		FileOutputStream fos;
		ObjectOutputStream oos;
		fos = new FileOutputStream(new File("sondaggio.txt"));
		oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
		fos.close();
	}

	/**
	 * 
	 * @param risultati
	 */
	public void acquisisciRisultati(Risultati risultati) {
		this.risultati = risultati;
	}

	/**
	 * 
	 * @return elencoUtenti
	 */
	public List<Utente> getElencoUtenti() {
		return elencoUtenti;
	}

	/**
	 * 
	 * @return elencoDomande
	 */
	public List<Domanda> getElencoDomande() {
		return elencoDomande;
	}

	/**
	 * 
	 * @return risultati
	 */
	public Risultati getRisultati() {
		return risultati;
	}

}
