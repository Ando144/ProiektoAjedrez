package xakea;

public class Erregina extends Pieza {
	
    public Erregina(boolean kolorea, int errenkada, int zutabea, String izena) {
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
    	boolean ahalDu = true;
        int kont=1;
    	//Comprobar que no quiera ir fuera de la tabla
        if(!Taula.getTaula().laukiaTaulanDago(zeinErrenkadara, zeinZutabera)){
            ahalDu=false;
        }
        //Comprobar que no haya una pieza de su mismo color donde quiere moverse
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
            //Si se mueve en linea recta, lo mismo que en dorrea
            else if (this.getErrenkada()==zeinErrenkadara ||this.getZutabea()==zeinZutabera){
                if(this.getErrenkada()==zeinErrenkadara){
                    if(this.getZutabea()<zeinZutabera){
                        kont=this.getZutabea()+1;
                        while(ahalDu==true && kont!=zeinZutabera){
                            if(Taula.getTaula().laukiaBetetaDago(kont, zeinErrenkadara)){
                                ahalDu=false;
                            }
                            kont++;
                        }
                    }
                    else if(this.getZutabea()>zeinZutabera){
                        kont=this.getZutabea()-1;
                        while(ahalDu==true && kont!=zeinZutabera){
                            if(Taula.getTaula().laukiaBetetaDago(kont, zeinErrenkadara)){
                                ahalDu=false;
                            }
                            kont--;
                        }
                    }
                }
                else if(this.getZutabea()==zeinZutabera){
                    if(this.getErrenkada()<zeinErrenkadara){
                        kont=this.getErrenkada()+1;
                        while(ahalDu==true && kont!=zeinErrenkadara){
                            if(Taula.getTaula().laukiaBetetaDago(zeinZutabera,kont)){
                                ahalDu=false;
                            }
                            kont++;
                        }
                    }
                    else if(this.getErrenkada()>zeinErrenkadara){
                        kont=this.getErrenkada()-1;
                        while(ahalDu==true && kont!=zeinErrenkadara){
                            if(Taula.getTaula().laukiaBetetaDago(zeinZutabera, kont)){
                                ahalDu=false;
                            }
                            kont--;
                        }
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
