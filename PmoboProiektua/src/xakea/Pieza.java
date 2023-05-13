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
                    if(!Taula.getTaula().laukiaBetetaDago(i, j)){
                        return true;
                    }else if(Taula.getTaula().getLaukikoPieza(i, j).zuriaDa()!=this.zuriaDa()){
                        return true;
                    }
                }
                catch(MugimenduOkerraException e){}
            }
        }
    	return false;
    }

    public void aukeraPosibleak(){
        String ikurra;
        for(int i = 7; i>=0; i--){
            System.out.println("");
            System.out.print(i+1+" ");
            for(int j=0; j<=7; j++){
                try{
                    this.mugituDaiteke(i, j);
                    if(Taula.getTaula().getLaukikoPieza(i, j)==null){
                        ikurra=("\u001B[93m" + "X" + "\u001B[0m");
                    }else{
                        ikurra = Taula.getTaula().getLaukikoPieza(i, j).getIzena();
                    }
                }
                catch(MugimenduOkerraException e){
                    if(Taula.getTaula().getLaukikoPieza(i, j)!=null){
                        ikurra = Taula.getTaula().getLaukikoPieza(i, j).getIzena();
                    }else{
                        ikurra = "□";
                    }
                }
                System.out.print(ikurra + " ");
            }
        }
        System.out.println("");
        System.out.print("  A B C D E F G H");
        System.out.println("");
    }
    public void aldatuIzena(String pIzena){
        this.izena=pIzena;
    }
}
