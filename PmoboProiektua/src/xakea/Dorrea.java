package xakea;

public class Dorrea extends Pieza
{
	
    public Dorrea(boolean kolorea, int errenkada, int zutabea) 
	{
        super(kolorea, errenkada, zutabea);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) 
	{
    	int kont =0;
    	boolean ahalDu = true;
		/*cddddddddddddddddddddd */
		/*Para ver si a la casilla que quiere ir esta dentro de el tablero y si no ahalDu=false */
		if(!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
		{
			ahalDu=false;
		}

		/*Para ver si el movimiento que quiere hacer es el correspondiente a la torre(Horizzontal o Vertical) */
		if((this.getErrenkada()!=zeinErrenkadara)&&(this.getZutabea()!=zeinZutabera))
		{
			ahalDu=false;
		}
		
		//por si no cumple alguna de las condiciones anteriores que ni entre
		if(ahalDu==false)
		{
			/*Este if es para ver si se mueve en la misma errenkada y el else para el caso en el que se mueva en la misma zutabe */
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
					while((kont != zeinZutabera) || (ahalDu==false)) 
					{
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(kont, this.getErrenkada())) 
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
					while((kont != zeinZutabera) || (ahalDu==false)) 
					{
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(kont, this.getErrenkada())) 
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
				
				
				//Vertical Abajo
				if (this.getErrenkada()>zeinErrenkadara) 
				{
					kont=this.getErrenkada()-1;
					/*Mientras que el contador no llegue a la casilla destino del movimiento especificado(Vertical u Horizontal)
					o que haya encontrado una ficha por el camino (ahalDu==false) seguira iterando
					*/
					while((kont != zeinErrenkadara) || (ahalDu==false)) 
					{
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(this.getZutabea(), kont)) 
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
					while((kont != zeinErrenkadara) || (ahalDu==false)) 
					{
						/*Mira aver si la casilla especificada tiene alguna pieza y si es el caso ahalDu=false */
						if(Taula.getTaula().laukiaBetetaDago(this.getZutabea(), kont)) 
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
