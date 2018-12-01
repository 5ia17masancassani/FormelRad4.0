package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
	}
	
	//Feature3
	public double iAusPundR(double p,double r){
		return Math.sqrt(p/r);
	}

	public double iAusPundU(double p,double u){
		return p/u;
	}
	
	public double iAusUundR(double u,double r){
		return u/r;
	}
	
	//Feature 4
		public double rAusUundP(double u,double p){
			return (u*u)/p;
		}

	
	
	
	
	/* Hier die Methoden mit den Formlen hinzufügen
	 */
	
}
