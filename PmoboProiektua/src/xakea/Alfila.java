package xakea;

public class Alfila extends Pieza {
	
    public Alfila(boolean kolorea, int errenkada, int zutabea) {
        super(kolorea, errenkada, zutabea);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
    	boolean ahalDu = true;
        int kont=0;
    	//Comprueba que no vaya a salir de la tabla
        if(!Taula.getTaula().laukiaTaulanDago(zeinErrenkadara, zeinZutabera)){
            ahalDu=false;
        }
        //Comprueba que se este moviendo en diagonal
        if(Math.abs(this.getErrenkada()-zeinErrenkadara)!=Math.abs(this.getZutabea()-zeinZutabera)){
            ahalDu=false;
        }
        //Comprueba que no haya una pieza de su mismo color
        if(this.zuriaDa()==Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa()){
            ahalDu=false;
        }
        if(ahalDu==true){
            if(this.getZutabea()<zeinZutabera){
                //arriba derecha
                if(this.getErrenkada()<zeinErrenkadara){
                    while(this.getZutabea()+kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(zeinZutabera+kont,zeinErrenkadara+kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
                //arriba izquierda
                else if(this.getErrenkada()>zeinErrenkadara){
                    while(this.getZutabea()+kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(zeinZutabera+kont, zeinErrenkadara-kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
            }
            else{
                //abajo derecha
                if(this.getErrenkada()<zeinErrenkadara){
                    while(this.getZutabea()-kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(zeinZutabera-kont, zeinErrenkadara+kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
                //abajo izquierda
                else if(this.getErrenkada()>zeinErrenkadara){
                    while(this.getZutabea()-kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(zeinZutabera-kont, zeinErrenkadara-kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
            }
        }
        return ahalDu;
    }
}
