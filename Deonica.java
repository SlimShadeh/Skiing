package skijanje;

public abstract class Deonica {

	protected double duzina;
	protected double nagib;
	
	public Deonica(double duz,double nag) {
		this.duzina=duz;
		this.nagib=nag;
	}

	public double duzina() {
		return duzina;
	}
	
	public double nagib() {
		return nagib;
	}

	public abstract char oznaka();
	
	public abstract double ubrzanje();
	
	public double brzina(double Pocetna) {
		return Math.sqrt(Pocetna*Pocetna+2*this.ubrzanje()*duzina);
	}
	
	public double vreme(double Pocetna) {
		return (this.brzina(Pocetna)-Pocetna)/this.ubrzanje();
	}

	@Override
	public String toString() {
		return this.oznaka() + "(" + this.duzina() + "," + this.nagib() + ")";
	}
	
	
}
