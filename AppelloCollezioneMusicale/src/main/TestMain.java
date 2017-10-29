package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import classes.Album;
import classes.Album.Supporto;
import classes.Traccia;
import exception.DurataException;
import exception.SupportoException;
import exception.TracciaException;

/**
 * 
 * @author vince
 *
 */
public class TestMain {

	private TestMain(){}
	/**
	 * Static random variable
	 */
	static final Random rnd = new Random();
	
	static String genRandString(){
		int x = rnd.nextInt(5);
		int y = 5;
		int l = (x + y);
		char[] c = new char[l];
		String a = "qwertyuioplkjhgfdsazxcvbnm";
		for(int i = 0; i < c.length; i++){
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int tracce = 100;
		final int album = 12;
		
		Traccia[] collezione = new Traccia[tracce];
		String[] titoli = new String[tracce]; 
		String[] esecutori = new String[tracce];
		int[] durate = new int[tracce];
	
		
		int num = 150;
		for(int i = 0; i < tracce; i++){
			int num2 = rnd.nextInt(150);
			titoli[i] = genRandString();
			esecutori[i] = genRandString();
			durate[i] = (num2+num);
		}
		
		try {
			for(int i = 0; i < tracce; i++){
				collezione[i] = new Traccia(titoli[rnd.nextInt(tracce)], esecutori[rnd.nextInt(tracce)], durate[rnd.nextInt(tracce)]);
			}
		} catch (DurataException e) {
			e.printStackTrace();
		}
		
		Album[] albums = new Album[album];
		try {
			for(int i = 0; i < album; i++){
				double prob = rnd.nextDouble();
				int n = rnd.nextInt(3);
				switch(n){
				case 0: 
					if(prob > 0.5){
						albums[i] = new Album(Supporto.CD, titoli[rnd.nextInt(tracce)], esecutori[rnd.nextInt(tracce)], LocalDateTime.now());
					}else{
						albums[i] = new Album(Supporto.CD, LocalDateTime.now());
					}
				break;
				case 1: 
					if(prob > 0.5){
						albums[i] = new Album(Supporto.VINILE, titoli[rnd.nextInt(tracce)], esecutori[rnd.nextInt(tracce)], LocalDateTime.now());
					}else{
						albums[i] = new Album(Supporto.VINILE, LocalDateTime.now());
					}
					break;
				case 2: 
					if(prob > 0.5){
						albums[i] = new Album(Supporto.USB, titoli[rnd.nextInt(tracce)], esecutori[rnd.nextInt(tracce)], LocalDateTime.now());
					}else{
						albums[i] = new Album(Supporto.USB, LocalDateTime.now());
					}
					break;
				default:
					break;
				}
			}
		} catch (SupportoException e) {
			e.printStackTrace();
		}
		
		
		
		List<Traccia> lista = new ArrayList<>();
		try {
			for(Album a : albums){
				for(int i = 0; i < 5; i++){
					Traccia test = collezione[rnd.nextInt(tracce)];
					if(lista.contains(test)){
						continue;
					}else{
						lista.add(test);
					}
				}
					a.addTracce(lista);	
				}
		} catch (TracciaException e) {
			e.printStackTrace();
		}
		
		System.out.println(albums[0].toString());
		Iterator<Traccia> it = albums[0].tracceIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		File file = new File("collezione_album.txt");
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			try {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(albums[0].toString());
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					oos.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
