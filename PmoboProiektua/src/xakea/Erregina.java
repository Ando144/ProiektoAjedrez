package xakea;

public class Erregina extends Pieza {
	
    public Erregina(boolean kolorea, int errenkada, int zutabea, String izena) {
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
	public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
    	boolean ahalDu = true;
		int kont = 1;
    	/*int desplErrenkadak = Math.abs(zeinErrenkadara - this.getErrenkada());
        int desplZutabeak = Math.abs(zeinZutabera - this.getZutabea());
        ahalDu = desplErrenkadak <= 1 && desplZutabeak <= 1;*/
		if (!Taula.getTaula().laukiaTaulanDago(zeinErrenkadara, zeinZutabera))
		{
			ahalDu=false;
		}
		/*Comprobador de si la pieza es de su mismo color */
		if (super.zuriaDa())
		{
			/*La pieza es blanca y quiere moverse a un sitio con una pieza blanca */
			if (Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera) && Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
			{
				ahalDu=false;
			}
		}
		else
		{	/*La pieza es negra y quiere moverse a un sitio con una pieza negra */
			if (Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera) && !Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
			{
				ahalDu=false;
			}
		}
		//Comprueba si el movimiento que hace es vertical o horizontal
		if((this.getErrenkada()!=zeinErrenkadara)&&(this.getZutabea()!=zeinZutabera))
		{
			ahalDu=false;
		}
		//Comprueba que se este moviendo en diagonal
        if(Math.abs(this.getErrenkada()-zeinErrenkadara)!=Math.abs(this.getZutabea()-zeinZutabera)){
            ahalDu=false;
        }
		if(ahalDu==true){
            //derecha
            if(this.getZutabea()<zeinZutabera){
                //arriba derecha
                if(this.getErrenkada()<zeinErrenkadara){
                    //Va usando el contador a vase de sumarlo o restarlo a la posicion inicial, depende de hacia
                    //donde se mueva, para comprobar si las casillas estan ocupadas
                    while(this.getZutabea()+kont<zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()+kont,this.getZutabea()+kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
                //abajo derecha
                else if(this.getErrenkada()>zeinErrenkadara){
                    while(this.getZutabea()+kont<zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()+kont, this.getZutabea()-kont)){
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
                    while(this.getZutabea()-kont>zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()+kont, this.getZutabea()-kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
                //abajo izquierda
                else if(this.getErrenkada()>zeinErrenkadara){
                    while(this.getZutabea()-kont>zeinZutabera && ahalDu==true){
                        if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada()-kont, this.getZutabea()-kont)){
                            ahalDu=false;
                        }
                        kont++;
                    }
                }
            }		
        }
		if(ahalDu ==true){
			if (zeinErrenkadara == this.getErrenkada())
			{	/*Este if es para ver a que lado de la torre esta haciendose el movimiento, en este caso es
				en la parte izquierda de la misma cuando se mueve en horizontal y el else en cambio es para cuando se 
				mueve a la derecha de la torre tambien en el eje horizontal */
				
				//Horizontal Izquierda
				if (this.getZutabea()>zeinZutabera) 
				{
					kont=this.getZutabea()-1;
					/*Mientras que el contador no llegue a la casilla destino del movimiento especificado(Vertical u Horizontal)
					o que haya encontrado una ficha por el camino (ahalDu==false) seguira iterando
					*/
					while((kont > zeinZutabera) && (ahalDu==true)) 
					{
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada(), kont)) 
						{
							ahalDu=false;
						}
						kont=kont-1;
					}
				}
				else //Horizontal Derecha
				{
					kont=this.getZutabea()+1;
					/*Mientras que el contador no llegue a la casilla destino del movimiento especificado(Vertical u Horizontal)
					o que haya encontrado una ficha por el camino (ahalDu==false) seguira iterando
					*/
					while((kont < zeinZutabera) && (ahalDu==true)) 
					{
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada(), kont)) 
						{
							ahalDu=false;
						}
						kont=kont+1;
					}
				}
			}
			else 
			{	
				/*Lo mismo que el segundo if de arriba, para ver si el movimiento es hacia arriba o hacia abajo */
				
				kont=0;
				//Vertical Abajo
				if (this.getErrenkada()>zeinErrenkadara) 
				{
					kont=this.getErrenkada()-1;
					/*Mientras que el contador no llegue a la casilla destino del movimiento especificado(Vertical u Horizontal)
					o que haya encontrado una ficha por el camino (ahalDu==false) seguira iterando
					*/
					while((kont > zeinErrenkadara) && (ahalDu==true)) 
					{
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(kont, this.getZutabea())) 
						{
							ahalDu=false;
						}
						kont=kont-1;
					}
				}
				else //Vertical Arriba
				{
					kont=this.getErrenkada()+1;
					/*Mientras que el contador no llegue a la casilla destino del movimiento especificado(Vertical u Horizontal)
					o que haya encontrado una ficha por el camino (ahalDu==false) seguira iterando
					*/
					while((kont < zeinErrenkadara) && (ahalDu==true)) 
					{
						System.out.println(Taula.getTaula().getLaukikoPieza(kont, this.getZutabea()));
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(kont, this.getZutabea())) 
						{
							ahalDu=false;
						}
						kont=kont+1;
					}
				}
			}
		}
        return ahalDu;
    }
}