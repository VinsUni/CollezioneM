package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import exception.ListaException;
import exception.SupportoException;
import exception.TracciaException;

/**
 * 
 * @author vince
 *
 */
public class Album implements Serializable{

	/**
	 * private static final long serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public enum Supporto{USB, VINILE, CD}
	
	private transient int id = 0;
	
	/**
	 * Static variable
	 */
	int cont = 0;
	private List<Traccia> listaTracce;
	private Supporto supporto;
	private String titolo;
	private String esecutore;
	private LocalDateTime data;
	
	/**
	 * 
	 * @param supporto
	 * @param data
	 * @throws SupportoNonValidoException
	 */
	public Album(Supporto supporto, LocalDateTime data) throws SupportoException {
		this(supporto, "", "", data);
		if(supporto.equals(Supporto.CD) || supporto.equals(Supporto.USB) || supporto.equals(Supporto.VINILE)){
			this.id = ++cont;
			listaTracce = new LinkedList<>();
		}else{
			throw new SupportoException();
		}
		
	}
	
	public Album(Supporto supporto, String titolo, String esecutore, LocalDateTime data) throws SupportoException {
		if(supporto.equals(Supporto.CD) || supporto.equals(Supporto.USB) || supporto.equals(Supporto.VINILE)){
			this.supporto = supporto;
			this.titolo = titolo;
			this.id = ++cont;
			this.esecutore = esecutore;
			this.data = data;
			listaTracce = new LinkedList<>();
		}else{
			throw new SupportoException();
		}
		
	}
	
	public void setListaTracce(List<Traccia> listaTracce) {
		this.listaTracce = listaTracce;
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

	public void addTracce(List<Traccia> lista) throws TracciaException{
		for(Traccia t: lista){
			if(listaTracce.contains(t)){
				throw new TracciaException();
			}else{
				listaTracce.add(t);
			}
		}
	}
	
	public boolean isPresente(Traccia t){
		boolean res = false;
		if(listaTracce.contains(t)){
			res = true;
		}else{
			res = false;
		}
		return res;
	}

	public int getDurataTraccia(Traccia t) throws ListaException{
		int durata = 0;
		if(listaTracce.isEmpty()){
			throw new ListaException();
		}else{
			if(isPresente(t)){
				durata = t.getDurata();
			}else{
				durata = 0;
			}
		}
		return durata;
	}
	
	public int getDurataAlbum() throws ListaException{
		if(listaTracce.isEmpty()){
			throw new ListaException();
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
		} catch (ListaException e) {
			e.printStackTrace();
		}
		return stringa;
	}
	
	public Iterator<Traccia> tracceIterator(){
		Collections.sort(listaTracce);
		return listaTracce.listIterator();
	}
	
	
}
