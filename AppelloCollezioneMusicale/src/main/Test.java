package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


import classes.Album;
import classes.Album.Supporto;
import classes.Traccia;
import exception.DurataNegativaException;
import exception.SupportoNonValidoException;
import exception.TracciaEsistenteException;

public class Test {

	static Random rnd = new Random();
	
	static String genRandString(){
		int l = (rnd.nextInt(5)+5);
		char[] c = new char[l];
		String a = "qwertyuioplkjhgfdsazxcvbnm";
		for(int i = 0; i < c.length; i++){
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}
	
	public static void main(String[] args) {
		
		final int TRACCE = 100;
		final int ALBUM = 12;
		
		Traccia collezione[] = new Traccia[TRACCE];
		String titoli[] = new String[TRACCE]; 
		String esecutori[] = new String[TRACCE];
		int durate[] = new int[TRACCE];
	
		
		
		for(int i = 0; i < TRACCE; i++){
			titoli[i] = genRandString();
			esecutori[i] = genRandString();
			durate[i] = (rnd.nextInt(150)+150);
		}
		
		for(int i = 0; i < TRACCE; i++){
			try {
				collezione[i] = new Traccia(titoli[rnd.nextInt(TRACCE)], esecutori[rnd.nextInt(TRACCE)], durate[rnd.nextInt(TRACCE)]);
			} catch (DurataNegativaException e) {
				e.printStackTrace();
			}
		}
		
		Album[] albums = new Album[ALBUM];
		try {
			for(int i = 0; i < ALBUM; i++){
				double prob = rnd.nextDouble();
				switch(rnd.nextInt(3)){
				case 0: 
					if(prob > 0.5){
						albums[i] = new Album(Supporto.CD, titoli[rnd.nextInt(TRACCE)], esecutori[rnd.nextInt(TRACCE)], LocalDateTime.now());
					}else{
						albums[i] = new Album(Supporto.CD, LocalDateTime.now());
					}
				break;
				case 1: 
					if(prob > 0.5){
						albums[i] = new Album(Supporto.VINILE, titoli[rnd.nextInt(TRACCE)], esecutori[rnd.nextInt(TRACCE)], LocalDateTime.now());
					}else{
						albums[i] = new Album(Supporto.VINILE, LocalDateTime.now());
					}
					break;
				case 2: 
					if(prob > 0.5){
						albums[i] = new Album(Supporto.USB, titoli[rnd.nextInt(TRACCE)], esecutori[rnd.nextInt(TRACCE)], LocalDateTime.now());
					}else{
						albums[i] = new Album(Supporto.USB, LocalDateTime.now());
					}
					break;
				}
			}
		} catch (SupportoNonValidoException e) {
			e.printStackTrace();
		}
		
		
		
		ArrayList<Traccia> lista = new ArrayList<>();
		for(Album a : albums){
			for(int i = 0; i < 5; i++){
				Traccia test = collezione[rnd.nextInt(TRACCE)];
				if(lista.contains(test)){
					continue;
				}else{
					lista.add(test);
				}
			}
			try {
				a.addTracce(lista);
			} catch (TracciaEsistenteException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(albums[0].toString());
		Iterator<Traccia> it = albums[0].tracceIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		File file = new File("collezione_album.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			try {
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(albums[0].toString());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
