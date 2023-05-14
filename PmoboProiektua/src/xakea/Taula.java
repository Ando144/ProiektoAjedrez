package xakea;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

public class Taula {
    private static final int tamaina = 8;
    private Laukia[][] laukiak;
    private static Taula nireTaula=null;
    private String beltza = "\u001B[34m";
    private String resetColor = "\u001B[0m";
    private String gorria = "\u001B[31m";

    private Taula() {
        this.laukiak = new Laukia[tamaina][tamaina];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	laukiak[i][j] = new Laukia(i, j, null);
            }
        }

        //Pieza zuriak sortu eta kokatu
        boolean zuria = true;
        this.laukiak[0][0].setPieza(new Dorrea(zuria,0,0, gorria + "♖" + resetColor));
        this.laukiak[0][7].setPieza(new Dorrea(zuria,0,7, gorria + "♖" + resetColor));
        this.laukiak[0][1].setPieza(new Zaldia(zuria,0,1,gorria + "♘" + resetColor));
        this.laukiak[0][6].setPieza(new Zaldia(zuria,0,6,gorria + "♘" + resetColor));
        this.laukiak[0][2].setPieza(new Alfila(zuria,0,2,gorria + "♗" + resetColor));
        this.laukiak[0][5].setPieza(new Alfila(zuria,0,5,gorria + "♗" + resetColor));
        this.laukiak[0][4].setPieza(new Erregea(zuria,0,4,gorria + "♔" + resetColor));
        this.laukiak[0][3].setPieza(new Erregina(zuria,0,3,gorria + "♕" + resetColor));
        for(int i=0; i<=7; i++) {
        	this.laukiak[1][i].setPieza(new Peoia(zuria,1,i,gorria + "♙" + resetColor));
        }
        
        //Pieza beltzak sortu eta kokatu
        zuria = false;
        this.laukiak[7][0].setPieza(new Dorrea(zuria,7,0,beltza + "♖" + resetColor));
        this.laukiak[7][7].setPieza(new Dorrea(zuria,7,7,beltza + "♖" + resetColor));
        this.laukiak[7][1].setPieza(new Zaldia(zuria,7,1,beltza + "♘" + resetColor));
        this.laukiak[7][6].setPieza(new Zaldia(zuria,7,6,beltza + "♘"+ resetColor));
        this.laukiak[7][2].setPieza(new Alfila(zuria,7,2,beltza + "♗" + resetColor));
        this.laukiak[7][5].setPieza(new Alfila(zuria,7,5,beltza + "♗" + resetColor));
        this.laukiak[7][4].setPieza(new Erregea(zuria,7,4,beltza + "♔" + resetColor));
        this.laukiak[7][3].setPieza(new Erregina(zuria,7,3,beltza + "♕" + resetColor));
        for(int i=0; i<=7; i++) {
        	this.laukiak[6][i].setPieza(new Peoia(zuria,6,i,beltza + "♙" + resetColor));
        } 
    }
    
    //Taula atzitu singleton patroia erabiliz 
    public static Taula getTaula() {
    	if(nireTaula==null) {
    		nireTaula = new Taula();
    	}
    	return nireTaula;
    }

    public Pieza getLaukikoPieza(int err, int zut) {
        return laukiak[err][zut].getPieza();
    }

    public void setLaukianPieza(int err, int zut, Pieza pPieza) {
        laukiak[err][zut].setPieza(pPieza);
    }
    
    public boolean laukiaBetetaDago(int err, int zut) {
    	if (laukiaTaulanDago(err, zut)) {
    		if (this.laukiak[err][zut].getPieza()!=null) {
    			return true;
    		}
    	}return false;
    }

    public boolean laukiaTaulanDago(int err, int zut) {
        return err >= 0 && err < tamaina && zut >= 0 && zut < tamaina;
    }

    public void taulaInprimatu(){
        String ikurra;
        for(int i = 7; i>=0; i--){
            System.out.println("");
            System.out.print(i+1+" ");
            for(int j=0; j<=7; j++){
                if(getTaula().getLaukikoPieza(i, j)!=null){
                    ikurra = getTaula().getLaukikoPieza(i, j).getIzena();
                }else{
                    ikurra = "□";
                }
                System.out.print(ikurra + " ");
            }
        }
        System.out.println("");
        System.out.print("  A B C D E F G H");
        System.out.println("");
    }

    /*metodo hau pieza bat tableroan jartzeko da */
	public void piezaJarri(Pieza pieza, int err, int zut){
		if (taulanDago(err, zut)){
			this.laukiak[err][zut].setPieza(pieza);
			this.laukiak[pieza.getErrenkada()][pieza.getZutabea()].setPieza(null);
            pieza.setErrenkadaEtaZutabea(err, zut);
        }
	}
    /*Hemen begiratuko dugu ea taula barruan dagoen a la ez */
    public boolean taulanDago(int x, int y){
		if (x < 8 && x >= 0 &&
			y < 8 && y >= 0){
                    return true;}
		return false;
     }

    public void taulaErreseteatu(){
        nireTaula=null;
    }
    
    public void reset() {
    	nireTaula = new Taula();
    }
}