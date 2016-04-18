
package pokemonmemory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelTitulo extends JPanel {
    
    Panel panelInterior = new Panel();
    JPanel panelCabecera = new JPanel();
    public static JLabel labelPuntuacion,labelPuntos,labelAciertos,labelIntentos;
    public static Color amarillo,azul;
    
        
    public PanelTitulo(){
        
        amarillo = new Color(255,233,1);
        azul = new Color(49, 69, 158);
    
        panelCabecera.setLayout(null);
        panelCabecera.setPreferredSize(new Dimension(510, 100));
        panelCabecera.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, Color.BLACK));
        
        panelCabecera.setBackground(amarillo);
        panelInterior.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, Color.BLACK));
        
        this.setLayout(new FlowLayout(BoxLayout.Y_AXIS));
        
        this.setBackground(amarillo);
        this.add(panelCabecera);
        this.add(panelInterior);
        
        //Etiquetas
        
        labelPuntuacion = new JLabel("Puntuacion: ");
        labelPuntuacion.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        labelPuntuacion.setForeground(azul);
        labelPuntuacion.setBounds(299,20,200,20);
        
        labelIntentos = new JLabel("Intentos: 0");
        labelIntentos.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        labelIntentos.setForeground(azul);
        labelIntentos.setBounds(15,20,200,30);
        
        labelAciertos = new JLabel("Aciertos: 0");
        labelAciertos.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        labelAciertos.setForeground(azul);
        labelAciertos.setBounds(15,40,200,50);
        
        labelPuntos = new JLabel("0");
        labelPuntos.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        labelPuntos.setForeground(azul);
        labelPuntos.setBounds(299,50,200,20);
        
        
        panelCabecera.add(labelAciertos);
        panelCabecera.add(labelIntentos);
        panelCabecera.add(labelPuntuacion);
        panelCabecera.add(labelPuntos);
        
    }    
       
    
    
}
