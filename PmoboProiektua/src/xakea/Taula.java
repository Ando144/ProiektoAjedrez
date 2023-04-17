package xakea;

public class Taula {
    private static final int tamaina = 8;
    private Laukia[][] laukiak;
    private static Taula nireTaula=null;;

    private Taula() {
        laukiak = new Laukia[tamaina][tamaina];
        
        //Taulako laukiak sortu
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	laukiak[i][j] = new Laukia(i, j, null);
            }
        }
        
        //Pieza zuriak sortu eta kokatu
        boolean zuria = true;
        this.laukiak[0][0].setPieza(new Dorrea(zuria,0,0));
        this.laukiak[0][7].setPieza(new Dorrea(zuria,0,7));
        this.laukiak[0][1].setPieza(new Zaldia(zuria,0,1));
        this.laukiak[0][6].setPieza(new Zaldia(zuria,0,6));
        this.laukiak[0][2].setPieza(new Alfila(zuria,0,2));
        this.laukiak[0][5].setPieza(new Alfila(zuria,0,5));
        this.laukiak[0][3].setPieza(new Erregea(zuria,0,3));
        this.laukiak[0][4].setPieza(new Erregina(zuria,0,4));
        for(int i=0; i<=7; i++) {
        	this.laukiak[1][i].setPieza(new Peoia(zuria,1,i));
        }
        
        //Pieza beltzak sortu eta kokatu
        zuria = false;
        this.laukiak[7][0].setPieza(new Dorrea(zuria,7,0));
        this.laukiak[7][7].setPieza(new Dorrea(zuria,7,7));
        this.laukiak[7][1].setPieza(new Zaldia(zuria,7,1));
        this.laukiak[7][6].setPieza(new Zaldia(zuria,7,6));
        this.laukiak[7][2].setPieza(new Alfila(zuria,7,2));
        this.laukiak[7][5].setPieza(new Alfila(zuria,7,5));
        this.laukiak[7][3].setPieza(new Erregea(zuria,7,3));
        this.laukiak[7][4].setPieza(new Erregina(zuria,7,4));
        for(int i=0; i<=7; i++) {
        	this.laukiak[6][i].setPieza(new Peoia(zuria,6,i));
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
    
    public boolean laukiaBetetaDago(int xDim, int yDim) {
    	if (laukiaTaulanDago(xDim, yDim)) {
    		if (this.laukiak[xDim][yDim]!=null) {
    			return true;
    		}
    	}return false;
    }

    public boolean laukiaTaulanDago(int err, int zut) {
        return err >= 0 && err < tamaina && zut >= 0 && zut < tamaina;
    }
    
    public void taulaInprimatu() {
    	//...
    }
}
