package xakea;

public class Partida {
	private Jokalaria jokalariZuria;
	private Jokalaria jokalariBeltza;
	private Jokalaria oraingoJokalaria;

	public Partida(){
		
	}

	public void partidaBatJolastu() {
		Taula.getTaula().taulaInprimatu();
		System.out.println("Idatzi jokalari zuriaren izena.");
		jokalariZuria = new Jokalaria(Teklatua.getTeklatua().irakurriString(), "Zuria");
		System.out.println("Idatzi jokalari beltzaren izena.");
		jokalariBeltza = new Jokalaria(Teklatua.getTeklatua().irakurriString(), "Beltza");
		oraingoJokalaria = jokalariZuria;
		while(!partidaBukatuDa()) {
			Taula.getTaula().taulaInprimatu();
			mugimenduBatEgin(oraingoJokalaria);
			jokalarizAldatu();
		}
		emaitzaInprimatu();
	}

	public boolean partidaBukatuDa() {
		return(this.xakeMate(jokalariZuria)||this.xakeMate(jokalariBeltza)||this.berdinketa());
	}
	
	public boolean xakeMate(Jokalaria pJokalaria) {
	    Erregea erregea = pJokalaria.getErregea();
	    int errErregea = erregea.getErrenkada();
	    int zutErregea = erregea.getZutabea();
	    if (!xakeanDago(errErregea, zutErregea, pJokalaria)) {
	        return false;
	    }
	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            try {
					erregea.mugituDaiteke(i, j);
					if(!xakeanDago(i,j,pJokalaria)){
						return false;
					}
	            }
				catch(MugimenduOkerraException e){}
	        }
	    }
	    return true;
	}

	private boolean xakeanDago(int pErrErregea, int pZutErregea, Jokalaria pJokalaria) {
		Jokalaria aurkakoa;
		if(pJokalaria.zuriaDa()){
			aurkakoa = jokalariBeltza;
		}else{
			aurkakoa = jokalariZuria;
		}
	    if(aurkakoa.posizioaMehatxatzenAriDa(pErrErregea,pZutErregea)) {
	        return true;
	    }else{
	    	return false;
	    }
	}
	
	public boolean berdinketa() {
		boolean oraingoa = false, aurrekoa = false;
		String erantzuna;
		System.out.println("Berdinketa egotea bozkatzen duzu? Baiezko kasuan, 'Bai' idatzi. Bestela, beste edozer idatzi.");
		System.out.println("Bi jokalariek baietz bozkatzen baduzue jarraian, berdinketa adostuko duzue.");
		erantzuna = Teklatua.getTeklatua().irakurriString();
		aurrekoa = oraingoa;
		if(erantzuna.equals("Bai")||erantzuna.equals("bai")){
			oraingoa = true;
		}else{
			oraingoa = false;
		}
		return oraingoa && aurrekoa;
	}
	
	public void mugimenduBatEgin(Jokalaria pJokalaria) {
		boolean mugZuzena = false, piezaZuzena = false, eginda;
		int errNon=0; int zutNon=0; int errNora=0; int zutNora=0;
		Pieza mugitzekoPieza = null;
		while(!piezaZuzena) {
			eginda = false;
			System.out.println(pJokalaria.getIzena() + " Aukeratu mugitu nahi duzun piezaren zutabea (A-tik H-ra)");
			while(! eginda){
				try{
					zutNon = Teklatua.getTeklatua().irakurriZut();
					eginda = true;
				}
				catch(TaulatikKanpoException e){
					System.out.println(pJokalaria.getIzena() +" Hori ez da taulako zutabe bat. Beste bat aukeratu.");
				}
			}
			eginda = false;
			System.out.println( pJokalaria.getIzena() +" Aukeratu mugitu nahi duzun piezaren errenkada (1etik 8ra)");
			while(! eginda){
				try{
					errNon = Teklatua.getTeklatua().irakurriErr();
					eginda = true;
				}
				catch(TaulatikKanpoException e){
					System.out.println(pJokalaria.getIzena() +" Hori ez da taulako errenkada bat. Beste bat aukeratu.");
				}
			}
			piezaZuzena = piezaZuzenaDa(pJokalaria, errNon-1, zutNon-1);
		}
		mugitzekoPieza = Taula.getTaula().getLaukikoPieza(errNon-1, zutNon-1);
		mugitzekoPieza.aukeraPosibleak();
		while(!mugZuzena) {
			eginda = false;
			System.out.println(pJokalaria.getIzena() +" Aukeratu zein zutabera mugitu nahi duzun pieza (A-tik H-ra)");
			while(! eginda){
				try{
					zutNora = Teklatua.getTeklatua().irakurriZut();
					eginda = true;
				}
				catch(TaulatikKanpoException e){
					System.out.println(pJokalaria.getIzena() +" Hori ez da taulako zutabe bat. Beste bat aukeratu.");
				}
			}
			eginda = false;
			System.out.println(pJokalaria.getIzena() +" Aukeratu zein errenkadara mugitu nahi duzun pieza (1etik 8ra)");
			while(! eginda){
				try{
					errNora = Teklatua.getTeklatua().irakurriErr();
					eginda = true;
				}
				catch(TaulatikKanpoException e){

					System.out.println(pJokalaria.getIzena() +" Hori ez da taulako errenkada bat. Beste bat aukeratu.");
				}
			}
			mugZuzena = mugimenduaZuzenaDa(mugitzekoPieza, errNora-1, zutNora-1);
		}
		if(Taula.getTaula().laukiaBetetaDago(errNora-1, zutNora-1)){
			Jokalaria aurkakoa;
			if(pJokalaria.zuriaDa()){
				aurkakoa = jokalariBeltza;
			}else{
				aurkakoa = jokalariZuria;
			}
			aurkakoa.piezaGaldu(Taula.getTaula().getLaukikoPieza(errNora-1, zutNora-1));
		}
		Taula.getTaula().piezaJarri(mugitzekoPieza, errNora-1, zutNora-1);
	}

	/* hello */
	//Metodo bat frogatzeko ea egin nahi duzun mugimendua onargarria den
	private boolean mugimenduaZuzenaDa(Pieza mugitzekoPieza, int errNora, int zutNora){
		try{
			mugitzekoPieza.mugituDaiteke(errNora, zutNora);
			System.out.println(errNora+"  "+zutNora);
			if(!Taula.getTaula().laukiaBetetaDago(errNora, zutNora)){
				return true;
			}else if(Taula.getTaula().getLaukikoPieza(errNora, zutNora).zuriaDa()!=mugitzekoPieza.zuriaDa()){
				return true;
			}else{
				System.out.println("Lauki horretan badaukazu zure pieza bat. Beste mugimendu bat egiten saiatu.");
			}
		}catch(MugimenduOkerraException e){
			System.out.println("Ezin duzu mugimendu hori egin pieza horrekin. Beste mugimendu bat egiten saiatu.");
		}
		return false;
	}
	
	//Metodo bat frogatzeko ea pieza egokia aukeratu duzun
	private boolean piezaZuzenaDa(Jokalaria jokalaria, int errNon, int zutNon) {
		if(Taula.getTaula().getLaukikoPieza(errNon, zutNon)!=null) {
			 if(Taula.getTaula().getLaukikoPieza(errNon, zutNon).zuriaDa() == jokalaria.zuriaDa()) {
				 Erregea errege=jokalaria.getErregea();
				 if((this.xakeanDago(errege.getErrenkada(), errege.getZutabea(), jokalaria)) && (!Taula.getTaula().getLaukikoPieza(errNon, zutNon).equals (errege))){
					System.out.println("Zure erregea xakean dago, hau mugitu behar duzu");
				 }
				 else if(Taula.getTaula().getLaukikoPieza(errNon, zutNon).mugimenduLegalakDitu()) {
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
			System.out.println("Partida bukatu da. "+jokalariBeltza.getIzena()+" da irabazlea.");
		}else if(this.xakeMate(jokalariBeltza)){
			System.out.println("Partida bukatu da. "+jokalariZuria.getIzena()+" da irabazlea.");
		}else { 
			System.out.println("Partida bukatu da. Berdinketa dago.");
		}
	}
}
