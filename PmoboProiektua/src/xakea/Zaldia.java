package xakea;

public class Zaldia extends Pieza {
	
    public Zaldia(boolean kolorea, int errenkada, int zutabea) {
        super(kolorea, errenkada, zutabea);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
    	boolean ahalDu = true;
    	//comprueba a ver si la casilla a la que se va a mover esta dentro del tablero
        if(!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera)){
            ahalDu=false;
        }
        
        if(ahalDu!=false){
            //El caballo se mueve en una L de 2x3, o vamos si se mueve una errenkada para arriba o para abajo (da igual) 
            //tiene que moverse tambien dos zutabe para la izquieda o derecha 
            if(this.getErrenkada()==zeinErrenkadara-1||this.getErrenkada()==zeinErrenkadara+1){
                if(this.getZutabea()==zeinZutabera-2||this.getZutabea()==zeinZutabera+2){
                    return ahalDu;
                }
            }
            //Lo mismo al contrario, si se mueve una zutabe a la izquierda o derecha se mueve tambien dos errenkada
            //arriba o abajo
            if(this.getZutabea()==zeinZutabera-1||this.getZutabea()==zeinZutabera+1){
                if(this.getErrenkada()==zeinErrenkadara-2||this.getErrenkada()==zeinErrenkadara+2){
                    return ahalDu;
                }
            }
            else{
                ahalDu=false;
            }
        }
        
        return ahalDu;
    }
}
