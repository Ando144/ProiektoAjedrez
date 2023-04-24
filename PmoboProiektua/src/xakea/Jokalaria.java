package xakea;

import java.util.*;

public class Jokalaria {
	private String izena;
	private boolean zuria;
	private ArrayList<Pieza> piezak;
	//private Teklatua tekl;
	
	public Jokalaria(String pIzena, String pKolorea) {
		izena = Teklatua.getTeklatua()
		if(pKolorea=="Zuria") {
			zuria=true;
			for(int i=0; i<=1; i++) {
	        	for(int j=0; j<=7; j++) {
	        		piezak.add(Taula.getTaula().getLaukikoPieza(i,j));
	        	}
	        }
		}else if(pKolorea=="Beltza") {
			zuria=false;
			for(int i=7; i>=6; i--) {
	        	for(int j=0; j<=7; j++) {
	        		piezak.add(Taula.getTaula().getLaukikoPieza(i,j));
	        	}
	        }
		}
	}
	
	public String getIzena() {
		return izena;
	}
	
	public boolean zuriaDa() {
		return zuria;
	}
	
	public boolean piezarikGabe() {
		return piezak.size()==0;
	}
	
}