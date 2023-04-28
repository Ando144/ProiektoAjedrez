package xakea;

public class Partida {
	private Jokalaria jokalariZuria;
	private Jokalaria jokalariBeltza;
	private Jokalaria oraingoJokalaria;

	public void partidaBatJolastu() {
		taula = Taula.getTaula();
		jokalariZuria = new Jokalaria("eskatu izena", "Zuria");
		jokalariBeltza = new Jokalaria("eskatu izena", "Beltza");
		oraingoJokalaria = jokalariZuria;
		while(!partidaBukatuDa()) {
			Taula.getTaula().taulaInprimatu2();
			mugimenduBatEgin(oraingoJokalaria);
			Taula.getTaula().taulaInprimatu2();
			jokalarizAldatu();
		}
		emaitzaInprimatu();
	}
	public boolean partidaBukatuDa() {
		return(this.xakeMate(jokalariZuria)||this.xakeMate(jokalariBeltza)||this.berdinketa());
	}
	
	public boolean xakeMate(Jokalaria pJokalaria) {
		return this.xakeanDago(pJokalaria) && !pJokalaria.getErregea().mugimenduLegalakDitu();
	}

	public boolean xakeanDago(Jokalaria pJokalaria){
		Jokalaria aurkakoa;
		if(pJokalaria.zuriaDa()){
			aurkakoa = jokalariBeltza;
		}else{
			aurkakoa = jokalariZuria;
		}
		if(aurkakoa.erregeaMehatxatzenAriDa(pJokalaria.getErregea())){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean berdinketa() {
		boolean emaitza = false;
		//...
		return emaitza;
	}
	
	public void mugimenduBatEgin(Jokalaria jokalaria) {
		boolean mugZuzena = false, piezaZuzena = false;
		int errNon ; int zutNon; int errNora; int zutNora;
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
		Taula.getTaula().piezaJarri(mugitzekoPieza, errNora-1, zutNora-1);
	}

	/* hello */
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
