package xakea;

public class Partida {
	private Jokalaria jokalariZuria;
	private Jokalaria jokalariBeltza;
	private Jokalaria oraingoJokalaria;

	public Partida(){
		
	}

	public void partidaBatJolastu() {
		Taula.getTaula().taulaInprimatu2();
		System.out.println("Idatzi jokalari zuriaren izena.");
		jokalariZuria = new Jokalaria(Teklatua.getTeklatua().irakurriString(), "Zuria");
		System.out.println("Idatzi jokalari beltzaren izena.");
		jokalariBeltza = new Jokalaria(Teklatua.getTeklatua().irakurriString(), "Beltza");
		oraingoJokalaria = jokalariZuria;
		int kont =0;
		while(kont<10){
			mugimenduBatEgin(oraingoJokalaria);
			Taula.getTaula().taulaInprimatu2();
			jokalarizAldatu();
		kont++;
		}
		/*while(!partidaBukatuDa()) {
			System.out.println(jokalariZuria.zuriaDa());
			Taula.getTaula().taulaInprimatu2();
			mugimenduBatEgin(oraingoJokalaria);
			Taula.getTaula().taulaInprimatu2();
			jokalarizAldatu();
		}*/
		emaitzaInprimatu();
	}
	public boolean partidaBukatuDa() {
		return(this.xakeMate(jokalariZuria)||this.xakeMate(jokalariBeltza)||this.berdinketa());
	}
	
	public boolean xakeMate(Jokalaria pJokalaria) {
		if(this.xakeanDago(pJokalaria)){
			int erregeaErr = pJokalaria.getErregea().getErrenkada();
			int erregeaZut = pJokalaria.getErregea().getZutabea();
			for(int i = erregeaErr-1; i<=erregeaErr+1; i++){
				for(int j = erregeaZut-1; j<=erregeaZut+1; j++){
					if(Taula.getTaula().laukiaTaulanDago(i, j)){
						Erregea erregeaKopia = new Erregea(pJokalaria.zuriaDa(), i, j, "  ");
						Jokalaria aurkakoa;
						if(pJokalaria.zuriaDa()){
							aurkakoa = jokalariBeltza;
						}else{
							aurkakoa = jokalariZuria;
						}
						if(aurkakoa.erregeaMehatxatzenAriDa(erregeaKopia)==false){
							return false;
						}
						erregeaKopia = null;
					}
				}
			}
			return true;
		}else{
			return false;
		}
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
		boolean oraingoa = false, aurrekoa = false;
		String erantzuna;
		System.out.println("Berdinketa egotea bozkatzen duzu? Baiezko kasuan, 'Bai' idatzi. Bestela, beste edozer idatzi.");
		System.out.println("Bi jokalariek baietz bozkatzen baduzue jarraian, berdinketa adostuko duzue.");
		erantzuna = Teklatua.getTeklatua().irakurriString();
		aurrekoa = oraingoa;
		if(erantzuna=="Bai"||erantzuna=="bai"){
			oraingoa = true;
		}else{
			oraingoa = false;
		}
		return oraingoa && aurrekoa;
	}
	
	public void mugimenduBatEgin(Jokalaria jokalaria) {
		boolean mugZuzena = false, piezaZuzena = false, eginda;
		int errNon=0; int zutNon=0; int errNora=0; int zutNora=0;
		Pieza mugitzekoPieza = null;
		while(!piezaZuzena) {
			eginda = false;
			System.out.println("Aukeratu mugitu nahi duzun piezaren zutabea (A-tik H-ra)");
			while(! eginda){
				try{
					zutNon = Teklatua.getTeklatua().irakurriZut();
					eginda = true;
				}
				catch(TaulatikKanpoException e){
					System.out.println("Hori ez da taulako zutabe bat. Beste bat aukeratu.");
				}
			}
			eginda = false;
			System.out.println("Aukeratu mugitu nahi duzun piezaren errenkada (1etik 8ra)");
			while(! eginda){
				try{
					errNon = Teklatua.getTeklatua().irakurriErr();
					eginda = true;
				}
				catch(TaulatikKanpoException e){
					System.out.println("Hori ez da taulako errenkada bat. Beste bat aukeratu.");
				}
			}
			System.out.println("b");
			piezaZuzena = piezaZuzenaDa(jokalaria, errNon-1, zutNon-1);
		}
		System.out.println("c");
		mugitzekoPieza = Taula.getTaula().getLaukikoPieza(errNon-1, zutNon-1);
		System.out.println("d");
		while(!mugZuzena) {
			eginda = false;
			System.out.println("Aukeratu zein zutabera mugitu nahi duzun pieza (A-tik H-ra)");
			while(! eginda){
				try{
					zutNora = Teklatua.getTeklatua().irakurriZut();
					eginda = true;
				}
				catch(TaulatikKanpoException e){
					System.out.println("e");
					System.out.println("Hori ez da taulako zutabe bat. Beste bat aukeratu.");
				}
			}
			eginda = false;
			System.out.println("Aukeratu zein errenkadara mugitu nahi duzun pieza (1etik 8ra)");
			while(! eginda){
				try{
					errNora = Teklatua.getTeklatua().irakurriErr();
					eginda = true;
				}
				catch(TaulatikKanpoException e){
					System.out.println("Hori ez da taulako errenkada bat. Beste bat aukeratu.");
				}
			}
			mugZuzena = mugimenduaZuzenaDa(mugitzekoPieza, errNora-1, zutNora-1);
		}
		if(Taula.getTaula().laukiaBetetaDago(errNora-1, zutNora-1)){
			Jokalaria aurkakoa;
			if(jokalaria.zuriaDa()){
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
	private boolean mugimenduaZuzenaDa(Pieza mugitzekoPieza, int errNora, int zutNora) {
		if(mugitzekoPieza.mugituDaiteke(errNora, zutNora)){
			System.out.println(errNora+"  "+zutNora);
			if(!Taula.getTaula().laukiaBetetaDago(errNora, zutNora)){
				return true;
			}else if(Taula.getTaula().getLaukikoPieza(errNora, zutNora).zuriaDa()!=mugitzekoPieza.zuriaDa()){
				return true;
			}else{
				System.out.println("Lauki horretan badaukazu zure pieza bat. Beste mugimendu bat egiten saiatu.");
			}
		}else{
			System.out.println("Ezin duzu mugimendu hori egin pieza horrekin. Beste mugimendu bat egiten saiatu.");
		}
		return false;
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
