package xakea;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

public class Taula {
    private static final int tamaina = 8;
    private Laukia[][] laukiak;
    private static Taula nireTaula=null;;

    private Taula() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	laukiak[i][j] = new Laukia(i, j, null);
            }
        }
                            /*public Taula(){
                                for (int i = 0; i < 8; i++) {
                                    for (int j = 0; j < 8; j++) {
                                        if ((i + j) % 2 == 0) {
                                            this.laukiak[i][j] = ' ';
                                        } else {
                                            this.laukiak[i][j] = '[ ]';
                                        }
                                    }
                            }*/

        //Pieza zuriak sortu eta kokatu
        boolean zuria = true;
        this.laukiak[0][0].setPieza(new Dorrea(zuria,0,0, "DZ"));
        this.laukiak[0][7].setPieza(new Dorrea(zuria,0,7, "DZ"));
        this.laukiak[0][1].setPieza(new Zaldia(zuria,0,1,"ZZ"));
        this.laukiak[0][6].setPieza(new Zaldia(zuria,0,6,"ZZ"));
        this.laukiak[0][2].setPieza(new Alfila(zuria,0,2,"AZ"));
        this.laukiak[0][5].setPieza(new Alfila(zuria,0,5,"AZ"));
        this.laukiak[0][3].setPieza(new Erregea(zuria,0,3,"KZ"));
        this.laukiak[0][4].setPieza(new Erregina(zuria,0,4,"QZ"));
        for(int i=0; i<=7; i++) {
        	this.laukiak[1][i].setPieza(new Peoia(zuria,1,i,"PZ"));
        }
        
        //Pieza beltzak sortu eta kokatu
        zuria = false;
        this.laukiak[7][0].setPieza(new Dorrea(zuria,7,0,"DB"));
        this.laukiak[7][7].setPieza(new Dorrea(zuria,7,7,"DB"));
        this.laukiak[7][1].setPieza(new Zaldia(zuria,7,1,"ZB"));
        this.laukiak[7][6].setPieza(new Zaldia(zuria,7,6,"ZB"));
        this.laukiak[7][2].setPieza(new Alfila(zuria,7,2,"AB"));
        this.laukiak[7][5].setPieza(new Alfila(zuria,7,5,"AB"));
        this.laukiak[7][3].setPieza(new Erregea(zuria,7,3,"KB"));
        this.laukiak[7][4].setPieza(new Erregina(zuria,7,4,"QB"));
        for(int i=0; i<=7; i++) {
        	this.laukiak[6][i].setPieza(new Peoia(zuria,6,i,"PB"));
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
    	for (int j = 0; j < 8; j++){
            System.out.print((char) ('a' + j)+" ");    
        }
        System.out.println();
        for(int i = 0 ; i < 8; i++){
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++){
                System.out.print(this.laukiak[i][j] + " ");
            }
            System.out.println(8-i);
        }
        System.out.print("  ");
        for (int j = 0; j<8; j++){
            System.out.print((char) ('a' + j) + " ");
        }
        System.out.println();
    }

    public void taulaInprimatu2(){//otra forma posible de printear que se me ocurre
        String ikurra;
        for(int i = 8; i>0; i--){
            System.out.println(i+" ");
            for(int j=0; j<8; j++){
                if(getTaula().getLaukikoPieza(i-1, j-1)!=null){
                    ikurra = getTaula().getLaukikoPieza(i-1, j-1).getIzena();
                }else{
                    ikurra = "  ";
                }
                System.out.print("["+ikurra+"]");
            }
        }
    }

    public void taulatikKendu(Pieza pieza){
		int xZaharra = pieza.getErrenkada();
		int yZaharra = pieza.getZutabea();
		
		this.laukiak[xZaharra][yZaharra] = null;
	}

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
}
/*  A
[BD][BP][AA][AA][AA][AA][AA][AA]
[BP][AA][AA][AA][AA][AA][AA][AA]
[  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ]
[AA][AA][AA][AA][AA][AA][AA][AA]
[AA][AA][AA][AA][AA][AA][AA][AA]
*/