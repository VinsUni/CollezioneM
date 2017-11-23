package classes;

public class Moto extends Veicolo {

	public Moto(String targa) {
		super(targa);
	}

	@Override
	public double getCosto() {
		return 0.25;
	}

	@Override
	public String toString() {
		return "Moto " + super.toString();
	}

}
