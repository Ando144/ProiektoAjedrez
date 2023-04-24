package xakea;

public class Erregina extends Pieza {
	
    public Erregina(boolean kolorea, int errenkada, int zutabea, String izena) {
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
    	boolean ahalDu = true;
        int kont=0;
    	//...
        if(!Taula.getTaula().laukiaTaulanDago(zeinErrenkadara, zeinZutabera)){
            ahalDu=false;
        }
        if(this.zuriaDa()==Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa()){
            ahalDu=false;
        }
        if(ahalDu==true){
            //Si se mueve en diagonal, literal lo mismo que en el alfil
            if(Math.abs(this.getErrenkada()-zeinErrenkadara)==Math.abs(getZutabea()-zeinZutabera)){
                if(this.getZutabea()<zeinZutabera){
                    if(this.getErrenkada()<zeinErrenkadara){
                        while(ahalDu!=false && this.getZutabea()+kont!=zeinZutabera){
                            if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()+kont, this.getErrenkada()+kont)){
                                ahalDu=false;
                            }
                            kont++;
                        }
                    }
                    else if(this.getErrenkada()>zeinErrenkadara){
                        while(ahalDu!=false && this.getZutabea()+kont!=zeinZutabera){
                            if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()+kont, this.getErrenkada()-kont)){
                                ahalDu=false;
                            }
                            kont++;
                        }
                    }
                }
                else if(this.getZutabea()>zeinZutabera){
                    if(this.getErrenkada()<zeinErrenkadara){
                        while(ahalDu!=false && this.getZutabea()-kont!=zeinZutabera){
                            if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()-kont, this.getErrenkada()-kont)){
                                ahalDu=false;
                            }
                            kont++;
                        }
                    }
                    else if(this.getErrenkada()>zeinErrenkadara){
                        while(ahalDu!=false && this.getZutabea()-kont!=zeinZutabera){
                            if(Taula.getTaula().laukiaBetetaDago(this.getZutabea()-kont, this.getErrenkada()-kont)){
                                ahalDu=false;
                            }
                            kont++;
                        }
                    }
                }
            }
            //Si se mueve en linea recta
            else if (this.getErrenkada()==zeinErrenkadara ||this.getZutabea()==zeinZutabera){

            }
            else{
                ahalDu=false;
            }
        }

    	return ahalDu; 
    }
}
