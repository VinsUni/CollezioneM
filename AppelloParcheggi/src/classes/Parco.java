package classes;

import java.util.ArrayList;
import java.util.List;

import classes.Posto.Stato;
import exceptions.IsFullException;
import exceptions.PostoException;

/**
 * 
 * @class Parco
 *
 */
public class Parco {

	private List<Posto> postiAuto;
	private List<Posto> postiMoto;
	private int orologio;

	public Parco(int orologio, int maxAuto, int maxMoto) {
		this.orologio = orologio;
		postiAuto = new ArrayList<>();
		for (int i = 0; i < maxAuto; i++) {
			postiAuto.add(new Posto());
		}
		postiMoto = new ArrayList<>();
		for (int i = 0; i < maxMoto; i++) {
			postiMoto.add(new Posto());
		}
	}

	public int getOrologio() {
		return orologio;
	}

	public Posto getPostoLibero(List<Posto> lista) {
		Posto posto = new Posto();
		for (Posto p : lista) {
			if (p.getStato().equals(Stato.LIBERO)) {
				posto = p;
			}
		}
		return posto;
	}

	public boolean isFull(List<Posto> lista) {
		boolean res = true;
		for (Posto p : lista) {
			if (p.getStato().equals(Stato.LIBERO)) {
				res = false;
			}
		}
		return res;
	}

	public void entrata(Veicolo v, int durata) throws IsFullException, PostoException {
		if (durata < orologio) {
			if (v != null || v instanceof Moto) {
				if (isFull(postiMoto)) {
					throw new IsFullException();
				} else {
					Posto p = new Posto();
					p = getPostoLibero(postiMoto);
					p.occupa(v, orologio);
					p.setDurata(durata);
					System.out.println("OCCUPATO" + p.toString());
					tic();
				}
			} else if (v != null || v instanceof Auto) {
				if (isFull(postiAuto)) {
					throw new IsFullException();
				} else {
					Posto p = new Posto();
					p = getPostoLibero(postiAuto);
					p.occupa(v, orologio);
					p.setDurata(durata);
					System.out.println("OCCUPATO! " + p.toString());
					tic();
				}
			}
		}

	}

	public void uscita(Veicolo v) throws PostoException {
		Posto posto = new Posto();
		if (v instanceof Auto) {
			Auto a = (Auto) v;
			for (Posto p : postiAuto) {
				if (p.getVeicolo().equals(a)) {
					p.setCostoTotale((p.getDurata() * p.getVeicolo().getCosto()));
					posto = p;
					p.libera();
				}
			}
			System.out.println("Scontrino:" + "\n" + posto.getVeicolo() + "\nOra ingresso: " + posto.getOraIngresso()
					+ "\nOra uscita: " + orologio + "\nCosto totale: " + (posto.getDurata() * a.getCosto()));
			tic();
		} else if (v instanceof Moto) {
			Moto m = (Moto) v;
			for (Posto p : postiMoto) {
				if (p.getVeicolo().equals(m)) {
					p.setCostoTotale((p.getDurata() * p.getVeicolo().getCosto()));
					posto = p;
					p.libera();
				}
			}
			System.out.println("Scontrino:" + "\n" + posto.getVeicolo() + "\nOra ingresso: " + posto.getOraIngresso()
					+ "\nOra uscita: " + orologio + "\nCosto totale: " + (posto.getDurata() * m.getCosto()));
			tic();
		}
	}

	public void tic() {
		orologio -= 1;
	}

	public boolean isPresente(Veicolo v){
		boolean res = false;
		if(v instanceof Moto){
			Moto m = (Moto) v;
			for(Posto p: postiMoto){
				if(p.getVeicolo().equals(m)){
					res = true;
				}else{
					continue;
				}
			}
		}else if(v instanceof Auto){
			Auto a = (Auto) v;
			for(Posto p: postiAuto){
				if(p.getVeicolo().equals(a)){
					res = true;
				}
			}
		}
		return res;
	}
	
	public void promo(String string, int sconto, String codice) {
		if (string.equals("Moto")) {
			for (Posto p : postiMoto) {
				if (p.getStato().equals(Stato.OCCUPATO)) {
					if (codice.charAt(0) == p.getVeicolo().getTarga().charAt((p.getVeicolo().getTarga().length() - 1))
							&& codice.charAt(1) == p.getVeicolo().getTarga()
									.charAt((p.getVeicolo().getTarga().length() - 2))) {
						double costo = 0;
						costo = p.getCostoTotale();
						p.setCostoTotale(costo - (costo * sconto / 100));
					}
				}
			}
		} else if (string.equals("Auto")) {
			for (Posto p : postiAuto) {
				if (p.getStato().equals(Stato.OCCUPATO)) {
					if (codice.charAt(0) == p.getVeicolo().getTarga().charAt((p.getVeicolo().getTarga().length() - 1))
							&& codice.charAt(1) == p.getVeicolo().getTarga()
									.charAt((p.getVeicolo().getTarga().length() - 2))) {
						double costo = 0;
						costo = p.getCostoTotale();
						p.setCostoTotale(costo - (costo * sconto / 100));
					}
				}
			}
		}
	}

	public void stato() {
		System.out.println("Elenco posti Auto:");
		for (Posto p : postiAuto) {
			System.out.println(p.toString());
		}

		System.out.println("Elenco posti Moto:");
		for (Posto p : postiMoto) {
			System.out.println(p.toString());
		}
	}
}
