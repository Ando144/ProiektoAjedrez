package xakea;

public class Peoia extends Pieza 
{
	
    public Peoia(boolean kolorea, int errenkada, int zutabea, String izena) 
	{
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) 
	{
    	boolean ahalDu = true;

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

        /*Comprueba si esta dentro del tablero a donde quiere  ir */
		if (!Taula.getTaula().laukiaTaulanDago(zeinErrenkadara, zeinZutabera))
		{
			ahalDu=false;
		}

        if(ahalDu==true)
		{
			 /*Si es blanca */
            if(Taula.getTaula().getLaukikoPieza(this.getErrenkada(), this.getZutabea()).zuriaDa())
            {
				/*en el caso de que sea la primera linea de las blancas */
				if(this.getErrenkada()==1)
				{
					/*Comprueba si cuando esta haciendo el primer movimiento puede desplazarse dos para adelante */
					if(zeinErrenkadara==this.getErrenkada()+2 && zeinZutabera==this.getZutabea())
					{
						if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera) && Taula.getTaula().laukiaBetetaDago(zeinErrenkadara-1, zeinZutabera-1))
						{
							ahalDu=false;
						}
					}
				}

				/*Comprueba si puede moverse uno hacia adelante*/
				if (zeinErrenkadara==this.getErrenkada()+1 && zeinZutabera==this.getZutabea())
				{
					if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
					{
						ahalDu=false;
					}
				}

				/*Comprueba si puede moverse a la derecha para comer, en el caso de que sea una ficha de su equipo no puede  */
				if (zeinErrenkadara==this.getErrenkada()+1 && zeinZutabera==this.getZutabea()+1)
				{
					if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
					{
						if(Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
						{
							ahalDu=false;
						}
					}
				}

				/*Comprueba si puede moverse a la izquierda para comer, en el caso de que sea una ficha de su equipo no puede  */
				if (zeinErrenkadara==this.getErrenkada()+1 && zeinZutabera==this.getZutabea()-1)
				{
					if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
					{
						if(Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
						{
							ahalDu=false;
						}
					}
				}
				
			/*Si es Negra */
			}else{
				
				/*en el caso de que sea la primera linea de las negras */
				if(this.getErrenkada()==7)
				{
					/*Comprueba si cuando esta haciendo el primer movimiento puede desplazarse dos para adelante */
					if(zeinErrenkadara==this.getErrenkada()-2 && zeinZutabera==this.getZutabea())
					{
						if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera) && Taula.getTaula().laukiaBetetaDago(zeinErrenkadara+1, zeinZutabera+1))
						{
							ahalDu=false;
						}
					}
				}

				/*Comprueba si puede moverse uno hacia adelante*/
				if (zeinErrenkadara==this.getErrenkada()-1 && zeinZutabera==this.getZutabea())
				{
					if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
					{
						ahalDu=false;
					}
				}
				/*Comprueba si puede moverse a la derecha para comer, en el caso de que sea una ficha de su equipo no puede  */
				if (zeinErrenkadara==this.getErrenkada()-1 && zeinZutabera==this.getZutabea()+1)
				{
					if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
					{
						if(!Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
						{
							ahalDu=false;
						}
					}
				}
				
				/*Comprueba si puede moverse a la izquierda para comer, en el caso de que sea una ficha de su equipo no puede  */
				if (zeinErrenkadara==this.getErrenkada()-1 && zeinZutabera==this.getZutabea()-1)
				{
					if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
					{
						if(!Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
						{
							ahalDu=false;
							
						}
					}
				}
			}
        }
		return ahalDu;
    }
}

