package xakea;

public class Alfila extends Pieza {
	
    public Alfila(boolean kolorea, int errenkada, int zutabea, String izena) {
        super(kolorea, errenkada, zutabea, izena);
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
            //derecha
            if(this.getZutabea()<zeinZutabera){
                //arriba derecha
                if(this.getErrenkada()<zeinErrenkadara){
                    //Va usando el contador a vase de sumarlo o restarlo a la posicion inicial, depende de hacia
                    //donde se mueva, para comprobar si las casillas estan ocupadas
                    while(this.getZutabea()+kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()+kont,this.getErrenkada()+kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
                //abajo derecha
                else if(this.getErrenkada()>zeinErrenkadara){
                    while(this.getZutabea()+kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()+kont, this.getErrenkada()-kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
            }
            //izquierda
            else if(this.getZutabea()>zeinZutabera){
                //arriba izquierda
                if(this.getErrenkada()<zeinErrenkadara){
                    while(this.getZutabea()-kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()-kont, this.getErrenkada()+kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
                //abajo izquierda
                else if(this.getErrenkada()>zeinErrenkadara){
                    while(this.getZutabea()-kont!=zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()-kont, this.getErrenkada()-kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
            }
            else{
                ahalDu=false;
            }
        }
        return ahalDu;
    }
}
