package main;

import java.util.Random;

import classes.Auto;
import classes.Moto;
import classes.Parco;
import classes.Veicolo;
import exceptions.IsFullException;
import exceptions.PostoException;

public class TestMain {

	static Random rnd = new Random();

	static String genRandString(int l) {
		String a = "qwertyuioplkjhgfdsazxcvbnm";
		char c[] = new char[l];
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}

	public static void main(String[] args) {

		Parco parco = new Parco(99, 50, 50);
		Veicolo veicoli[] = new Veicolo[80];

		for (int i = 0; i < 80; i++) {
			if (i < 40) {
				veicoli[i] = new Auto(genRandString(7));
			} else if (i >= 40 && i < 80) {
				veicoli[i] = new Moto(genRandString(7));
			}
		}
		try {
			for (int i = 0; i < 99; i++) {
				switch (rnd.nextInt(2)) {
				case 0:
					double p = rnd.nextDouble();
					switch (rnd.nextInt(2)) {
					case 0:
						if (p < 0.6) {
							parco.entrata(veicoli[(rnd.nextInt(40) + 40)], (rnd.nextInt(10) + 1));
						} else {
							parco.entrata(veicoli[(rnd.nextInt(40))], (rnd.nextInt(10) + 1));
						}
						break;
					case 1:
						if (p < 0.6) {
							Moto m = (Moto) veicoli[(rnd.nextInt(40) + 40)];
							if(parco.isPresente(m)){
								parco.uscita(m);
							}else{
								continue;
							}
							
						} else {
							parco.uscita(veicoli[rnd.nextInt(40)]);
							Auto a = (Auto) veicoli[(rnd.nextInt(40) + 40)];
							if(parco.isPresente(a)){
								parco.uscita(a);
							}else{
								continue;
							}
						}
						break;
					}
					break;
				case 1:
					break;
				}
				parco.stato();
			}
		} catch (IsFullException | PostoException e) {
			System.out.println(e.getMessage());
		}

		parco.promo("Moto", (rnd.nextInt(20) + 1), genRandString(2));
		parco.promo("Auto", (rnd.nextInt(20) + 1), genRandString(2));

	}

}
