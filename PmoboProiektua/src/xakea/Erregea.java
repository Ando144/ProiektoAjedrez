package xakea;

public class Erregea extends Pieza {
	
    public Erregea(boolean kolorea, int errenkada, int zutabea) {
        super(kolorea, errenkada, zutabea);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
    	boolean ahalDu = true;
    	int desplErrenkadak = Math.abs(zeinErrenkadara - this.getErrenkada());
        int desplZutabeak = Math.abs(zeinZutabera - this.getZutabea());
        ahalDu = desplErrenkadak <= 1 && desplZutabeak <= 1;
        return ahalDu;
    }
}
