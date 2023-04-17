package xakea;

public abstract class Pieza {
    private boolean zuria;
    private int errenkada;
    private int zutabea;

    protected Pieza(boolean kolorea, int errenkada, int zutabea) {
        this.zuria = kolorea;
        this.errenkada = errenkada;
        this.zutabea = zutabea;
    }

    public boolean zuriaDa() {
        return zuria;
    }

    public int getErrenkada() {
        return errenkada;
    }

    public int getZutabea() {
        return zutabea;
    }

    public void setErrenkadaEtaZutabea(int x, int y) {
        this.errenkada = x;
        this.zutabea = y;
    }
    
    public abstract boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera);
    
    
    //METODOS PUESTOS POR ASIER F:
    
    public void piezaJan(Pieza jandakoa) {
    	//...
    }
    
    public boolean mugimenduLegalakDitu() {
    	//...
    	return false;
    }
}
