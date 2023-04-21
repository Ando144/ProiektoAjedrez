package xakea;

public class Peoia extends Pieza {
	
    public Peoia(boolean kolorea, int errenkada, int zutabea) {
        super(kolorea, errenkada, zutabea);
    }

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
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

    	return ahalDu;

        if(ahalDu==false){
        
            if(Taula.getTaula().getLaukikoPieza(zeinErrenkadara, zeinZutabera).zuriaDa())
            {
                d
            }

        }
    }
}
