
package pokemonmemory;

import java.util.Timer;
import java.util.TimerTask;


public class Temporizador {
    
    
  
    private Timer timer = new Timer();
    private int seconds=0;

     class Contador extends TimerTask {
        public void run() {
            seconds++;
     System.out.println("segundo: " + seconds);
        }
    }
    
 
    public void startCount(int timeDelay)
    {
        this.seconds=0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, timeDelay);
    }
    //Detiene el contador
    public void stop() {
        timer.cancel();
    }
    //Metodo que retorna los segundos transcurridos
    public int getSeconds()
    {
        return this.seconds;
    }
    
    
    
}
