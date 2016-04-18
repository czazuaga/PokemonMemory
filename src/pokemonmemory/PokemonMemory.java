
package pokemonmemory;

import javax.swing.JFrame;


public class PokemonMemory  {

   

    public static void main(String[] args) {
        
      JFrame frame = new JFrame("Pokemon Memory");
      PanelTitulo panelTitulo = new PanelTitulo();  
      
        
        
        
        frame.setContentPane(panelTitulo);
       frame.setVisible(true);
       frame.setBounds(0, 0, 580, 680);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}
