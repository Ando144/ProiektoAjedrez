package xakea;

import java.util.*;

public class Teklatua {
	private static Teklatua nireTeklatua;
	private static Scanner sc;

	private Teklatua(){
		sc = new Scanner(System.in);
	}
	
	public static Teklatua getTeklatua() {
		if(nireTeklatua==null){
			nireTeklatua= new Teklatua();
		}
		return nireTeklatua;
	}
	
	public String irakurriString() {
		return sc.nextLine();
	}
	
	public int irakurriInt() {
		return sc.nextInt();
	}

	public int irakurriZut() throws TaulatikKanpoException {
		String aukera = sc.nextLine();
		if(aukera.equals("a")||aukera.equals("A")){
			return 1;
		}
		else if(aukera.equals("b")||aukera.equals("B")){
			return 2;
		}
		else if(aukera.equals("c")||aukera.equals("C")){
			return 3;
		}
		else if(aukera.equals("d")||aukera.equals("D")){
			return 4;
		}
		else if(aukera.equals("e")||aukera.equals("E")){
			return 5;
		}
		else if(aukera.equals("f")||aukera.equals("F")){
			return 6;
		}
		else if(aukera.equals("g")||aukera.equals("G")){
			return 7;
		}
		else if(aukera.equals("h")||aukera.equals("H")){
			return 8;
		}
		else{
			throw new TaulatikKanpoException();
		}
	}

	public int irakurriErr() throws TaulatikKanpoException{
		int aukera = sc.nextInt();
		if(aukera >= 1 || aukera <=8){
			return aukera;
		}else{
			throw new TaulatikKanpoException();
		}
	}
	
	/*public boolean irakurriBaiEz(String pMezua) {
		
	}
	
	public String irakurriAukera(String pMezua, StringZerrenda pAukerak) {
		
	}*/
}
