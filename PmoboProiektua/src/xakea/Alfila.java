package xakea;

public class Alfila extends Pieza {
	
    public Alfila(boolean kolorea, int errenkada, int zutabea, String izena) {
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) throws MugimenduOkerraException{
    	boolean ahalDu = true;
        int kont=1;
        //Comprueba que se este moviendo en diagonal
        if(Math.abs(this.getErrenkada()-zeinErrenkadara)!=Math.abs(this.getZutabea()-zeinZutabera)){
            throw new MugimenduOkerraException();
        }
        //Comprueba que no haya una pieza de su mismo color
            //derecha
        if(this.getZutabea()<zeinZutabera){
            //arriba derecha
            if(this.getErrenkada()<zeinErrenkadara){
                //Va usando el contador a vase de sumarlo o restarlo a la posicion inicial, depende de hacia
                //donde se mueva, para comprobar si las casillas estan ocupadas
                while(this.getZutabea()+kont<zeinZutabera){
                    if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()+kont,this.getZutabea()+kont)){
                        throw new MugimenduOkerraException();
                    }
                    kont++;
                }
            }
            //abajo derecha
            else if(this.getErrenkada()>zeinErrenkadara){
                while(this.getZutabea()+kont<zeinZutabera){
                    if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()+kont, this.getZutabea()-kont)){
                        throw new MugimenduOkerraException();
                    }
                    kont++;
                }
            }
        }
        //izquierda
        else if(this.getZutabea()>zeinZutabera){
            //arriba izquierda
            if(this.getErrenkada()<zeinErrenkadara){
                while(this.getZutabea()-kont>zeinZutabera){
                    if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()+kont, this.getZutabea()-kont)){
                        throw new MugimenduOkerraException();
                    }
                    kont++;
                }
            }
            //abajo izquierda
            else if(this.getErrenkada()>zeinErrenkadara){
                while(this.getZutabea()-kont>zeinZutabera){
                    if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()-kont, this.getZutabea()-kont)){
                        throw new MugimenduOkerraException();
                    }
                    kont++;
                }
            }
        }
        return ahalDu;
    }
}
