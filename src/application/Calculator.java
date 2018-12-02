package application;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Berechnet das Formelrad
 * 
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {


	private Logger logger = Logger.getLogger(Calculator.class.getName());  

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
		return "Calculator [leistung =" + leistung + ", spannung =" + spannung + ", strom =" + strom + ", widerstand ="
				+ widerstand + "]";
	}
	
	public String getError() {
		int count = 0;
		if (leistung != 0.0) {
			count++;
		}

		if (strom != 0.0) {
			count++;
		}

		if (spannung != 0.0) {
			count++;
		}

		if (widerstand != 0.0) {
			count++;
		}

		if (count == 2) {
			return "";
		} else {
			return "Bitte 2 Felder angeben.";
		}
	
	}

	

	public void calculate() {
		/*
		 * Hier auf Grund der vorhanden Werte entscheiden welche Methode unten
		 * aufgerufen werden muss.
		 */
		if (leistung == 0.0 && spannung == 0.0 && strom != 0.0 && widerstand != 0.0) {

			leistung = Math.round(pAusRundI(widerstand, strom) * 100.0) / 100.0;
			
			spannung = Math.round(uAusRundI(widerstand, strom) * 100.0) / 100.0;
			

		}
	
		if (leistung == 0.0 && spannung != 0.0 && strom == 0.0 && widerstand != 0.0) {

			leistung = Math.round(pAusUundR(spannung, widerstand) * 100.0) / 100.0;
			
			strom = Math.round(iAusUundR(spannung, widerstand) * 100.0) / 100.0;
			

		}
		
		if (leistung != 0.0 && spannung == 0.0 && strom == 0.0 && widerstand != 0.0) {

			spannung = Math.round(uAusPundR(leistung, widerstand) * 100.0) / 100.0;
			
			strom = Math.round(iAusPundR(leistung, widerstand) * 100.0) / 100.0;
			

		}
		
		if (leistung == 0.0 && spannung != 0.0 && strom != 0.0 && widerstand == 0.0) {

			leistung = Math.round(pAusUundI(spannung, strom) * 100.0) / 100.0;
			
			widerstand = Math.round(rAusUundI(spannung, strom) * 100.0) / 100.0;
		

		}
		
		if (leistung != 0.0 && spannung == 0.0 && strom != 0.0 && widerstand == 0.0) {

			spannung = Math.round(uAusPundI(leistung, strom) * 100.0) / 100.0;
		
			widerstand = Math.round(rAusPundI(leistung, strom) * 100.0) / 100.0;
			

		}
		
		if (leistung != 0.0 && spannung != 0.0 && strom == 0.0 && widerstand == 0.0) {

			strom = Math.round(iAusPundU(leistung, spannung) * 100.0) / 100.0;
			
			widerstand = Math.round(rAusUundP(spannung, leistung) * 100.0) / 100.0;
			

		}
		

	}

	/*
	 * Hier die Methoden mit den Formlen hinzufügen
	 */
	

	public double pAusUundI(double u, double i) {
		return u * i;
	}
	
	public double pAusUundR(double u, double r) {
		return (u * u) / r;
	}
	
	public double pAusRundI(double r, double i) {
		return (i * i) * r;
	}
	
	public double uAusRundI(double r, double i) {
		return r * i;
	}

	public double uAusPundI(double p, double i) {
		return p / i;
	}

	public double uAusPundR(double p, double r) {
		return Math.sqrt(p * r);
	}

	public double iAusPundR(double p, double r) {
		return Math.sqrt(p / r);
	}

	public double iAusPundU(double p, double u) {
		return p / u;
	}

	public double iAusUundR(double u, double r) {

		return u / r;
	}

	public double rAusUundP(double u, double p) {
		return (u * u) / p;
	}

	public double rAusPundI(double p, double i) {
		return p / (i * i);
	}

	public double rAusUundI(double u, double i) {
		return u / i;
	}

	
}
