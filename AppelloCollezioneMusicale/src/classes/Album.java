package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import exception.ListaVuotaException;
import exception.SupportoNonValidoException;
import exception.TracciaEsistenteException;

public class Album implements Serializable{

	public enum Supporto{USB, VINILE, CD}
	
	private int id = 0;
	static int cont = 0;
	private LinkedList<Traccia> listaTracce;
	private Supporto supporto;
	private String titolo, esecutore;
	private LocalDateTime data;
	
	public Album(Supporto supporto, LocalDateTime data) throws SupportoNonValidoException {
		if(supporto.equals(Supporto.CD) || supporto.equals(Supporto.USB) || supporto.equals(Supporto.VINILE)){
			this.supporto = supporto;
			this.data = data;
			listaTracce = new LinkedList<>();
		}else{
			throw new SupportoNonValidoException();
		}
		
	}
	
	public Album(Supporto supporto, String titolo, String esecutore, LocalDateTime data) throws SupportoNonValidoException {
		if(supporto.equals(Supporto.CD) || supporto.equals(Supporto.USB) || supporto.equals(Supporto.VINILE)){
			this.supporto = supporto;
			this.titolo = titolo;
			this.esecutore = esecutore;
			this.data = data;
			listaTracce = new LinkedList<>();
		}else{
			throw new SupportoNonValidoException();
		}
		
	}

	public Supporto getSupporto() {
		return supporto;
	}

	public void setSupporto(Supporto supporto) {
		this.supporto = supporto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEsecutore() {
		return esecutore;
	}

	public void setEsecutore(String esecutore) {
		this.esecutore = esecutore;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public int getId() {
		return id;
	}

	public void addTracce(ArrayList<Traccia> lista) throws TracciaEsistenteException{
		for(Traccia t: lista){
			if(listaTracce.contains(t)){
				throw new TracciaEsistenteException();
			}else{
				listaTracce.add(t);
			}
		}
	}
	
	public boolean isPresente(Traccia t){
		if(listaTracce.contains(t)){
			return true;
		}else{
			return false;
		}
	}

	public int getDurataTraccia(Traccia t) throws ListaVuotaException{
		if(listaTracce.isEmpty()){
			throw new ListaVuotaException();
		}else{
			if(isPresente(t)){
				return t.getDurata();
			}else{
				return -1;
			}
		}
	}
	
	public int getDurataAlbum() throws ListaVuotaException{
		if(listaTracce.isEmpty()){
			throw new ListaVuotaException();
		}else{
			int totale = 0;
			for(Traccia t: listaTracce){
				totale += t.getDurata();
			}
			return totale;
		}
	}

	@Override
	public String toString() {
		String stringa = "";
		try {
			stringa = "Album [getData()=" + getData() + ", getId()=" + getId() + ", getDurataAlbum()=" + getDurataAlbum()
					+ "]";
		} catch (ListaVuotaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringa;
	}
	
	public Iterator<Traccia> tracceIterator(){
		Collections.sort(listaTracce);
		return listaTracce.listIterator();
	}
	
	
}
