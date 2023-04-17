package xakea;

public class Partida {
	private Taula taula;
	private Jokalaria jokalariZuria;
	private Jokalaria jokalariBeltza;
	private Jokalaria oraingoJokalaria;
	
	public void partidaBatJolastu() {
		taula = Taula.getTaula();
		jokalariZuria = new Jokalaria("Sobron69", "Zuria");
		jokalariBeltza = new Jokalaria("ErikPadronso", "Beltza");
		oraingoJokalaria = jokalariZuria;
		while(!partidaBukatuDa()) {
			mugimenduBatEgin(oraingoJokalaria);
			jokalarizAldatu();
		}
		emaitzaInprimatu();
	}
	
	public boolean partidaBukatuDa() {
		return(this.xakeMate(jokalariZuria)||this.xakeMate(jokalariBeltza)||this.berdinketa());
	}
	
	public boolean xakeMate(Jokalaria pJokalaria) {
		boolean emaitza = false;
		//...
		return emaitza;
	}
	
	public boolean berdinketa() {
		boolean emaitza = false;
		//...
		return emaitza;
	}
	
	public void mugimenduBatEgin(Jokalaria jokalaria) {
		boolean mugZuzena = false, piezaZuzena = false;
		int errNon, zutNon, errNora, zutNora;
		Pieza mugitzekoPieza = null;
		while(!piezaZuzena) {
			//aukeratu mugitu nahi duzun piezaren errenkada
			//aukeratu mugitu nahi duzun piezaren zutabea
			piezaZuzena = piezaZuzenaDa(jokalaria, errNon-1, zutNon-1);
		}
		mugitzekoPieza = Taula.getTaula().getLaukikoPieza(errNon-1, zutNon-1);
		while(!mugZuzena) {
			//galdetu errenkada destino
			//galdetu zutabea destino
			mugZuzena = mugimenduaZuzenaDa(mugitzekoPieza, errNora-1, zutNora-1);
			if(!mugZuzena) {
				System.out.println("Ezin duzu mugimendu hori egin. Beste bat saiatu.");
			}
		}
		Taula.getTaula().setLaukianPieza(errNora-1, zutNora-1, mugitzekoPieza);
		mugitzekoPieza.setErrenkadaEtaZutabea(errNora-1, zutNora-1);
		Taula.getTaula().setLaukianPieza(errNon-1, zutNon-1, null);
	}

	//Metodo bat frogatzeko ea egin nahi duzun mugimendua onargarria den
	private boolean mugimenduaZuzenaDa(Pieza mugitzekoPieza, int errNora, int zutNora) {
		return mugitzekoPieza.mugituDaiteke(errNora, zutNora);
	}
	
	//Metodo bat frogatzeko ea pieza egokia aukeratu duzun
	private boolean piezaZuzenaDa(Jokalaria jokalaria, int errNon, int zutNon) {
		if(Taula.getTaula().getLaukikoPieza(errNon, zutNon)!=null) {
			 if(Taula.getTaula().getLaukikoPieza(errNon, zutNon).zuriaDa() == jokalaria.zuriaDa()) {
				 if(Taula.getTaula().getLaukikoPieza(errNon, zutNon).mugimenduLegalakDitu()) {
					 return true;
				 }else {
					 System.out.println("Pieza hau ezin duzu mugitu orain. Beste koordenatu batzuk aukeratu.");
				 }
			 }else {
				 System.out.println("Hau ez da zure pieza. Beste koordenatu batzuk aukeratu.");
			 }
		}else {
			System.out.println("Lauki horretan ez dago piezarik. Beste koordenatu batzuk aukeratu.");
		}
		return false;
	}
	
	public void jokalarizAldatu() {
		if(oraingoJokalaria==jokalariZuria) {
			oraingoJokalaria=jokalariBeltza;
		}else {
			oraingoJokalaria=jokalariZuria;
		}
	}
	
	public void emaitzaInprimatu() {
		if(this.xakeMate(jokalariZuria)) {
			System.out.println("Partida bukatu da! "+jokalariBeltza.getIzena()+" da irabazlea.");
		}else if(this.xakeMate(jokalariBeltza)){
			System.out.println("Partida bukatu da! "+jokalariZuria.getIzena()+" da irabazlea.");
		}else {
			System.out.println("Partida bukatu da! Berdinketa dago.");
		}
	}
}
