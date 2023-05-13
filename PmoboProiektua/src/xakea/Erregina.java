package xakea;

public class Erregina extends Pieza {
	
    public Erregina(boolean kolorea, int errenkada, int zutabea, String izena) {
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
	public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) throws MugimenduOkerraException{
    	boolean ahalDu = true;
		int kont = 1;
    	/*int desplErrenkadak = Math.abs(zeinErrenkadara - this.getErrenkada());
        int desplZutabeak = Math.abs(zeinZutabera - this.getZutabea());
        ahalDu = desplErrenkadak <= 1 && desplZutabeak <= 1;*/
		//Comprueba si el movimiento que hace es vertical o horizontal y si es diagonal tambien
		if(((this.getErrenkada()!=zeinErrenkadara)&&(this.getZutabea()!=zeinZutabera))||(Math.abs(this.getErrenkada()-zeinErrenkadara)!=Math.abs(this.getZutabea()-zeinZutabera)))
		{
			throw new MugimenduOkerraException();
		}
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
				while((kont > zeinZutabera)) 
				{
					/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
					if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada(), kont)) 
					{
						throw new MugimenduOkerraException();
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
				while((kont < zeinZutabera)) 
				{
					/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
					if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada(), kont)) 
					{
						throw new MugimenduOkerraException();
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
				while((kont > zeinErrenkadara)) 
				{
					/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
					if(Taula.getTaula().laukiaBetetaDago(kont, this.getZutabea())) 
					{
						throw new MugimenduOkerraException();
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
				while((kont < zeinErrenkadara)) 
				{
					/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
					if(Taula.getTaula().laukiaBetetaDago(kont, this.getZutabea())) 
					{
						throw new MugimenduOkerraException();
					}
					kont=kont+1;
				}
			}
		}
        return ahalDu;
    }
}