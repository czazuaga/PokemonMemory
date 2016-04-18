
package pokemonmemory;


public class NuevoHilo extends Thread{
    
    Temporizador temporizador = new Temporizador();
    private Panel panel;
    
    public NuevoHilo (Panel panel){
    this.panel=panel;
    }
    
    public void esperar (int segundos){
     temporizador.startCount(segundos);
        while (temporizador.getSeconds()<segundos){
    System.out.println(temporizador.getSeconds());
    }
    temporizador.stop();
    }
    
    
    @Override
    public void run() {
        System.out.println("Start");
        esperar(80);
        System.out.println("Stop");
        panel.ocultarImagenes();
        panel.botonesActivos=true;
        
    }
    
}
