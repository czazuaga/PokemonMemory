
package pokemonmemory;

import javax.swing.JFrame;





public class PokemonMemory  {

    
    
    public static void main(String[] args) {
        
      JFrame frame = new JFrame();
        
      Panel panelInterior = new Panel();
        
        
        
        frame.setContentPane(panelInterior);
       frame.setVisible(true);
       frame.setBounds(0, 0, 800, 600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}
