package skijanje;

import java.util.ArrayList;
import java.util.HashMap;

public class Staza {

	private String naziv;
	private ArrayList<Deonica> deonice;
	
	public Staza(String naz) {
		naziv=naz;
		deonice=new ArrayList<Deonica>();
	}
	
	public void dodaj(Deonica d) {
		deonice.add(d);
	}
	
	public int broj() {
		return deonice.size();
	}
	public double duzina() {
		double duz=0;
		for(int i=0;i<deonice.size();i++) {
			duz+=deonice.get(i).duzina();
		}
		return duz;
	}
	
	public double nagib() {
		double nag=0;
		for(int i=0;i<deonice.size();i++) {
			if (nag<deonice.get(i).nagib()) nag=deonice.get(i).nagib();
		}
		return nag;
	}
	
	public char oznaka() throws GOznaka{
		HashMap<Character,Integer> ozn=new HashMap<Character,Integer>();
		int max=0;
		char ret='P';
		if(deonice.size()<=0) throw new GOznaka();
		for(int i=0;i<deonice.size();i++) {
			if(!ozn.containsKey(deonice.get(i).oznaka())) ozn.put(deonice.get(i).oznaka(), 1);
			else {
				int x=ozn.get(deonice.get(i).oznaka());
				x++;
				if(max<x) ret=deonice.get(i).oznaka();
				ozn.put(deonice.get(i).oznaka(),x);
			}
		}
		return ret;
		
	}
	
	public double brzina(double Pocetna) {
		double brz=Pocetna;
		for(int i=0;i<deonice.size();i++) {
			brz=deonice.get(i).brzina(brz);
		}
		return brz;
	}
	
	public double vreme(double Pocetna) {
		double vr=0;
		double brz=Pocetna;
		for(int i=0;i<deonice.size();i++) {
			vr+=deonice.get(i).vreme(brz);
			brz=deonice.get(i).brzina(brz);
		}
		return vr;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(naziv).append('|').append(this.broj()).append('|').append(this.duzina()).append('|').append(this.nagib()).append("\n");
		sb.append('[');
		for(int i=0;i<deonice.size();i++) {
			sb.append(deonice.get(i));
			if(deonice.size()-1!=i)sb.append(',');
		}
		sb.append(']');
		return sb.toString() ;
	}
	
	
}
