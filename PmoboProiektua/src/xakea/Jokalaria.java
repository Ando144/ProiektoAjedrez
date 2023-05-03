package xakea;

import java.util.*;

public class Jokalaria {
	private String izena;
	private boolean zuria;
	private ArrayList<Pieza> piezak;
	//private Teklatua tekl;
	
	public Jokalaria(String pIzena, String pKolorea) {
		//izena = Teklatua.getTeklatua();
		this.izena=pIzena;
		piezak = new ArrayList<Pieza>();

		if(pKolorea.equals("Zuria")) {
			zuria=true;
			for(int i=0; i<=1; i++) {
	        	for(int j=0; j<=7; j++) {
	        		piezak.add(Taula.getTaula().getLaukikoPieza(i,j));
	        	}
	        }
		}else{
			zuria=false;
			for(int i=7; i>=6; i--) {
	        	for(int j=0; j<=7; j++) {
	        		piezak.add(Taula.getTaula().getLaukikoPieza(i,j));
	        	}
	        }
		}
	}
	
	public String getIzena() {
		return this.izena;
	}
	
	public boolean zuriaDa() {
		return zuria;
	}
	
	public boolean piezarikGabe() {
		return piezak.size()==0;
	}

	private Iterator<Pieza> getIteradorea(){
		return this.piezak.iterator();
	}

	public Erregea getErregea(){
		Iterator<Pieza> itr = this.getIteradorea();
		Pieza hau = null;
		while(itr.hasNext() && !(hau instanceof Erregea)){
			hau = itr.next();
		}
		return ((Erregea)hau);
	}

	public boolean posizioaMehatxatzenAriDa(int pErr, int pZut){
		Iterator<Pieza> itr = this.getIteradorea();
		while(itr.hasNext()){
			if(itr.next().mugituDaiteke(pErr, pZut)){
				return true;
			}
		}
		return false;
	}

	public void piezaGaldu(Pieza jandakoa){
		piezak.remove(jandakoa);
	}
	
}