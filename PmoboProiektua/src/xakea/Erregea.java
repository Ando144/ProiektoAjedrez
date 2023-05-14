package xakea;

public class Erregea extends Pieza {
	
    public Erregea(boolean kolorea, int errenkada, int zutabea, String izena) {
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) throws MugimenduOkerraException{
    	boolean ahalDu = true;
    	int desplErrenkadak = Math.abs(zeinErrenkadara - this.getErrenkada());
        int desplZutabeak = Math.abs(zeinZutabera - this.getZutabea());
        if ((desplErrenkadak > 1 || desplZutabeak > 1) || (desplErrenkadak==0 && desplZutabeak==0) ){
			throw new MugimenduOkerraException();
		}
        return ahalDu;
    }
}
