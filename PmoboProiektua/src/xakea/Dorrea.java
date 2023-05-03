package xakea;

import org.junit.Test;

public class Dorrea extends Pieza
{
	
    public Dorrea(boolean kolorea, int errenkada, int zutabea, String izena) 
	{
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) 
	{
    	int kont =0;
    	boolean ahalDu = true;

		/*Comprueba si esta dentro del tablero a donde quiere  ir */
		if (!Taula.getTaula().laukiaTaulanDago(zeinErrenkadara, zeinZutabera))
		{
			ahalDu=false;
		}
		
		/*Para ver si el movimiento que quiere hacer es el correspondiente a la torre(Horizzontal o Vertical) */
		if((this.getErrenkada()!=zeinErrenkadara)&&(this.getZutabea()!=zeinZutabera))
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
