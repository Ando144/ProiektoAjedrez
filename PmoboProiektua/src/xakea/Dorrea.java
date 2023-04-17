package xakea;

public class Dorrea extends Pieza {
	
    public Dorrea(boolean kolorea, int errenkada, int zutabea) {
        super(kolorea, errenkada, zutabea);
    }

    public int maximoaKalkulatu(int N1, int N2) 
    {
    	int maximoa =0;
    	
    	
    	//xd
    	
    	if (N1 > N2)
    	{
    		maximoa =N1;
    	}
    	else
    	{
    		maximoa=N2;
    	}
    	return maximoa;
    }
   
    public int minimoaKalkulatu(int N1, int N2) 
    {
    	int minimoa =0;
    	
    	if (N1 > N2)
    	{
    		minimoa =N2;
    	}
    	else
    	{
    		minimoa=N1;
    	}
    	return minimoa;
    }
  

    @Override
    public boolean mugituDaiteke(int zeinErrenkadara, int zeinZutabera) {
    	int lerro=0;
    	int zut=0;
    	int kont =0;
    	boolean ahalDu = true;
    	
    	//un while para que vaya iterando y que salga cuando llegue a la columna 
    	//destino, a la errenkada destino o que encuentre una pieza en el camino
    	while (((zut != zeinErrenkadara) && (lerro != zeinZutabera)) || ahalDu==false) 
    	{
    		if (zeinErrenkadara == this.getErrenkada())
    		{
    			if (this.getZutabea()>zeinZutabera) 
    			{
    				kont=this.getZutabea();
    				while(kont != zeinZutabera) 
    				{
    					if(Taula.getTaula().laukiaBetetaDago(this.getErrenkada(), kont)) 
    					{
    						ahalDu=false;
    					}
    					kont=kont-1;
    				}
    			}
    			else 
    			{
    				kont=this.getZutabea();
    				while(kont != zeinZutabera) 
    				{
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
    			if (this.getErrenkada()>zeinErrenkadara) 
    			{
    				kont=this.getErrenkada();
    				while(kont != zeinErrenkadara) 
    				{
    					if(Taula.getTaula().laukiaBetetaDago( kont,this.getZutabea())) 
    					{
    						ahalDu=false;
    					}
    					kont=kont-1;
    				}
    			}
    			else 
    			{
    				kont=this.getErrenkada();
    				while(kont != zeinErrenkadara) 
    				{
    					if(Taula.getTaula().laukiaBetetaDago(kont, this.getErrenkada())) 
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
//no esta terminado, de hecho no se si funciona o si es asi