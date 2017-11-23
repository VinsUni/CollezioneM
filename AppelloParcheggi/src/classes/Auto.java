package classes;

public class Auto extends Veicolo {

	public Auto(String targa) {
		super(targa);
	}

	@Override
	public double getCosto() {
		return 0.10;
	}

	@Override
	public String toString() {
		return "Auto " + super.toString();
	}

}
