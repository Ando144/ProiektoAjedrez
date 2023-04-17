package xakea;

public class Laukia {
    private int errenkada;
    private int zutabea;
    private Pieza pieza;

    public Laukia(int pErr, int pZut, Pieza pPieza) {
        this.errenkada = pErr;
        this.zutabea = pZut;
        this.pieza = pPieza;
    }

    public Pieza getPieza() {
        return pieza;
    }
    
    public void setPieza(Pieza pPieza) {
    	pieza = pPieza;
    }
    
    /*public boolean laukiaHutsikDago(int err, int zut) {
        return this.getPieza()==null;
    }*/

}




