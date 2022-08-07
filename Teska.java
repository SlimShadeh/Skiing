package skijanje;

public class Teska extends Deonica {

	private char oznaka='T';
	private double a;
	
	public Teska(double duz, double nag) {
		super(duz, nag);
		a=9.81 * Math.sin(nag*Math.PI/180);
	}

	@Override
	public char oznaka() {
		return oznaka;
	}

	@Override
	public double ubrzanje() {
		return a;
	}
}
