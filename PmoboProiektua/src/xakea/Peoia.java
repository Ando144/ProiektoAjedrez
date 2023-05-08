package xakea;

public class Peoia extends Pieza 
{
	
    public Peoia(boolean kolorea, int errenkada, int zutabea, String izena) 
	{
        super(kolorea, errenkada, zutabea, izena);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) throws MugimenduOkerraException
	{
    	boolean ahalDu = false;
			/*Si es blanca */
		if(Taula.getTaula().getLaukikoPieza(this.getErrenkada(), this.getZutabea()).zuriaDa())
		{
			/*en el caso de que sea la primera linea de las blancas */
			if(this.getErrenkada()==1)
			{
				/*Comprueba si cuando esta haciendo el primer movimiento puede desplazarse dos para adelante */
				if(zeinErrenkadara==this.getErrenkada()+2 && zeinZutabera==this.getZutabea())
				{
					if(!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera)&&!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara-1, zeinZutabera-1)){
						ahalDu=true;
					}
				}
			}

			/*Comprueba si puede moverse uno hacia adelante*/
			if (zeinErrenkadara==this.getErrenkada()+1 && zeinZutabera==this.getZutabea())
			{
				if(!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera)){
					ahalDu=true;
				}
			}

			/*Comprueba si puede moverse a la derecha para comer, en el caso de que sea una ficha de su equipo no puede  */
			if (zeinErrenkadara==this.getErrenkada()+1 && zeinZutabera==this.getZutabea()+1)
			{
				if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
				{
					if(Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa()==false)
					{
						ahalDu=true;
					}
				}
			}

			/*Comprueba si puede moverse a la izquierda para comer, en el caso de que sea una ficha de su equipo no puede  */
			if (zeinErrenkadara==this.getErrenkada()+1 && zeinZutabera==this.getZutabea()-1)
			{
				if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
				{
					if(Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa()==false)
					{
						ahalDu=true;
					}
				}
			}
			
		/*Si es Negra */
		}else{
			
			/*en el caso de que sea la primera linea de las negras */
			if(this.getErrenkada()==6)
			{
				/*Comprueba si cuando esta haciendo el primer movimiento puede desplazarse dos para adelante */
				if(zeinErrenkadara==this.getErrenkada()-2 && zeinZutabera==this.getZutabea())
				{
					if(!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera)&&!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara+1, zeinZutabera+1)){
						ahalDu=true;
					}
				}
			}

			/*Comprueba si puede moverse uno hacia adelante*/
			if (zeinErrenkadara==this.getErrenkada()-1 && zeinZutabera==this.getZutabea())
			{
				if(!Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera)){
					ahalDu=true;
				}
			}
			/*Comprueba si puede moverse a la derecha para comer, en el caso de que sea una ficha de su equipo no puede  */
			if (zeinErrenkadara==this.getErrenkada()-1 && zeinZutabera==this.getZutabea()+1)
			{
				if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
				{
					if(Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa()){
						ahalDu=true;
					}
				}
			}
			
			/*Comprueba si puede moverse a la izquierda para comer, en el caso de que sea una ficha de su equipo no puede  */
			if (zeinErrenkadara==this.getErrenkada()-1 && zeinZutabera==this.getZutabea()-1)
			{
				if(Taula.getTaula().laukiaBetetaDago(zeinErrenkadara, zeinZutabera))
				{
					if(Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
					{
						ahalDu=true;
					}
				}
			}
		}
		if (ahalDu==false){
			throw new MugimenduOkerraException();
		}
		return ahalDu;
    }
}

