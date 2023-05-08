package xakea;

public abstract class Pieza {
    private boolean zuria;
    private int errenkada;
    private int zutabea;
    private String izena;

    public Pieza(boolean pZuria, int pErrenkada, int pZutabea, String pIzena) {
        this.zuria = pZuria;
        this.errenkada = pErrenkada;
        this.zutabea = pZutabea;
        this.izena = pIzena;
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

    public String getIzena(){
        return izena;
    }

    public void setErrenkadaEtaZutabea(int x, int y) {
        this.errenkada = x;
        this.zutabea = y;
    }
    
    public abstract boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) throws MugimenduOkerraException;
    
    
    //METODOS PUESTOS POR ASIER F:
    
    public void piezaJan(Pieza jandakoa) {
    	//...
    }
    
    public boolean mugimenduLegalakDitu() {
    	for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                try{
                    this.mugituDaiteke(i, j);
                    return true;
                }
                catch(MugimenduOkerraException e){}
            }
        }
    	return false;
    }
}
