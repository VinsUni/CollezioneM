package classes;
/**
 * 
 * @author vince
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import exception.AfLaException;
import exception.AffException;
import exception.LabException;
import exception.PostiException;

/**
 * 
 * @class Dipartimento
 *
 */
public class Dipartimento {

	private String nome;
	private String indirizzo;
	private int postiTesisti;
	private Map<Laboratorio, List<Afferente>> mappa;

	public Dipartimento(String nome, String indirizzo, int postiTesisti) throws PostiException {
		if (postiTesisti > 0) {
			this.nome = nome;
			this.indirizzo = indirizzo;
			this.postiTesisti = postiTesisti;
			mappa = new TreeMap<>();
		} else {
			throw new PostiException();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getPostiTesisti() {
		return postiTesisti;
	}

	public void setPostiTesisti(int postiTesisti) throws PostiException {
		if (postiTesisti > 0) {
			this.postiTesisti = postiTesisti;
		} else {
			throw new PostiException();
		}
	}

	public void addLab(Laboratorio lab) throws LabException {
		if (mappa.containsKey(lab)) {
			throw new LabException();
		} else {
			mappa.put(lab, new ArrayList<>());
		}
	}

	public void addAfferente(Laboratorio lab, Afferente afferente) throws AffException, AfLaException, PostiException {
		if (mappa.containsKey(lab)) {
			if (afferente instanceof Tesista && postiTesisti > 0) {
				boolean res = false;
				for (Laboratorio l : mappa.keySet()) {
					if (mappa.get(l).contains(afferente)) {
						res = true;
					}
				}
				if (res == false) {
					mappa.get(lab).add(afferente);
					postiTesisti--;
				} else {
					throw new AfLaException();
				}
			} else {
				throw new PostiException();
			}
		} else {
			throw new AffException();
		}
	}

	public void removeAfferente(Laboratorio lab, Afferente afferente) throws LabException, AffException {
		if (mappa.containsKey(lab)) {
			if (mappa.get(lab).contains(afferente)) {
				mappa.get(lab).remove(afferente);
			} else {
				throw new AffException();
			}
		} else {
			throw new LabException();
		}
	}

	public int getTesisti(Laboratorio lab) {
		int num = 0;
		for (Afferente a : mappa.get(lab)) {
			if (a instanceof Tesista) {
				num++;
			}
		}
		return num;
	}

	public Laboratorio getLabMax() {
		int max = 0;
		int corr = 0;
		Laboratorio lab = null;
		for (Laboratorio l : mappa.keySet()) {
			corr = getTesisti(l);
			if (corr > max) {
				max = corr;
				lab = l;
			}
		}
		return lab;
	}

	public List<Afferente> ciclaAfferenti(Laboratorio lab) {
		Collections.sort(mappa.get(lab));
		return mappa.get(lab);
	}
}
