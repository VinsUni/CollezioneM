package classes;

import java.io.Serializable;

/**
 * 
 * @author vince
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import classes.Domanda.tipoRisposta;

/**
 * 
 * @class Risultati
 *
 */
public class Risultati implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Domanda, List<Risposta>> risposte;

	/**
	 * 
	 * @param domande
	 * @param utenti
	 */
	public Risultati(List<Domanda> domande, List<Utente> utenti) {
		risposte = new TreeMap<>();
		for(Domanda d: domande){
			risposte.put(d, new ArrayList<>());
			for(int i = 0; i < utenti.size(); i++){
				risposte.get(d).add(new Risposta(d));
			}
		}
		
	}
	
	/**
	 * Calcolo Moda risposte
	 */
	public void calcoloModa(){
		int[] cont = new int[2];
		for(Domanda d: risposte.keySet() ){
			if(d.getTipoRisposta().equals(tipoRisposta.Chiusa)){
				for(Risposta r: risposte.get(d)){
					if(r.equals("A")){
						cont[0] += 1;
					}else if(r.equals("B")){
						cont[1] += 1;
					}else{
						cont[2] += 1;
					}
				}
				System.out.println(d.toString());
				if(cont[0] > cont[1] && cont[0] > cont[2]){
					System.out.println("Moda risposte: A" );
				}else if(cont[1] > cont[0] && cont[1] > cont[2]){
					System.out.println("Moda risposte: B" );
				}else if(cont[2] > cont[0] && cont[2] > cont[1]){
					System.out.println("Moda risposte: C" );
				}
			}
			
		}
	}
	

}
