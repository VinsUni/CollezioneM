package main;

import java.util.Random;

import classes.Auto;
import classes.Moto;
import classes.Parco;
import classes.Veicolo;
import exceptions.IsFullException;
import exceptions.PostoException;

/**
 * 
 * @class TestMain
 *
 */
public class TestMain {

	static Random rnd = new Random();

	static String genRandString(int l) {
		String a = "qwertyuioplkjhgfdsazxcvbnm";
		char[] c = new char[l];
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}

	public static void main(String[] args) {

		int orologio = 99;
		int postiaut = 40;
		int postimo = 40;
		Parco parco = new Parco(orologio, postiaut, postimo);
		Veicolo[] veicoli = new Veicolo[80];

		for (int i = 0; i < 80; i++) {
			if (i < 40) {
				veicoli[i] = new Auto(genRandString(7));
			} else if (i >= 40 && i < 80) {
				veicoli[i] = new Moto(genRandString(7));
			}
		}
		try {
			for (int i = 0; i < 99; i++) {
				int n = rnd.nextInt(2);
				switch (n) {
				case 0:
					double p = rnd.nextDouble();
					int n1 = rnd.nextInt(2);
					switch (n1) {
					case 0:
						int num = (rnd.nextInt(40) + 40);
						int num2 = (rnd.nextInt(10) + 1);
						if (p < 0.6) {
							parco.entrata(veicoli[num], num2);
						} else {
							parco.entrata(veicoli[num], num2);
						}
						break;
					case 1:
						int numero = (rnd.nextInt(40) + 40);
						if (p < 0.6) {
							Moto m = (Moto) veicoli[numero];
							if(parco.isPresente(m)){
								parco.uscita(m);
							}else{
								continue;
							}
							
						} else {
							int rn = rnd.nextInt(40);
							parco.uscita(veicoli[rn]);
							Auto a = (Auto) veicoli[numero];
							if(parco.isPresente(a)){
								parco.uscita(a);
							}else{
								continue;
							}
						}
						break;
					default:
						break;
					}
					break;
				case 1:
					break;
				default:
					break;
				}
				parco.stato();
			}
		} catch (IsFullException | PostoException e) {
			System.out.println("ERRORE");
		}

		int sconto1 = (rnd.nextInt(20) + 1);
		int sconto2 = (rnd.nextInt(20) + 1);
		parco.promo("Moto", sconto1, genRandString(2));
		parco.promo("Auto", sconto2, genRandString(2));

	}

}
