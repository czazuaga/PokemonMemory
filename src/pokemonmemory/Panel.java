
package pokemonmemory;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Panel extends JPanel implements ActionListener {
   
    private final int NUMERO_COLUMNAS= 6;
    private final int NUMERO_FILAS= 6;
    
    private URL interroganteImgURL;
    
    ArrayList<String> arrayLista = new ArrayList<>();
    ArrayList<JButton> arrayBtnSelec = new ArrayList<>();

    Icon imagenInterrogante = new ImageIcon(getClass().getResource("/pokemonmemory/Imagenes/18.jpg"));
    
    public Panel () {
    InitComponents();
     
    }
    
    public void InitComponents () {
    
    InitImagenes();      
        
    int intIndice=0;
    
    GridLayout layout = new GridLayout(NUMERO_FILAS,NUMERO_COLUMNAS,2,2);
        this.setLayout(layout);
     
    interroganteImgURL = getClass().getResource("Imagenes/18.jpg");
        
    
    
    for (int i=0;i < NUMERO_FILAS;i++){
        for(int j=0;j < NUMERO_COLUMNAS;j++){
        
        Icon imagen = new ImageIcon (interroganteImgURL);
           
        JButton boton = new JButton(imagen);
        boton.setName(arrayLista.get(intIndice));
        boton.setActionCommand(i + "-" + j);
        this.add(boton);
        boton.addActionListener(this);
        intIndice++;
        }   
    }     
    
    }
    
    public void InitImagenes () {             
        
    for (int i=0;i<18;i++){
   
        arrayLista.add(String.valueOf(i)); 
     
        arrayLista.add(String.valueOf(i));   
        
    }        
        Collections.shuffle(arrayLista);
    }

    int contador = 0;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
             
        JButton button = (JButton) ae.getSource();
              
        
        if (!button.getName().equals("OK")){
        
            Icon imagen2 = new ImageIcon(getClass().getResource("/pokemonmemory/Imagenes/"+button.getName()+".jpg"));
        button.setIcon(imagen2);
        button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE));
        
        arrayBtnSelec.add(button);
        
        if(arrayBtnSelec.size()==2){
            if (arrayBtnSelec.get(0).getName().equals(arrayBtnSelec.get(1).getName())){
                
                JOptionPane.showMessageDialog(Panel.this, "Enhorabuena","Acertaste!!!", JOptionPane.INFORMATION_MESSAGE);
                
                arrayBtnSelec.get(0).setName("OK");
                arrayBtnSelec.get(1).setName("OK");
                 
                
            }else{
                
                    JOptionPane.showMessageDialog(Panel.this, "Prueba de nuevo","Fallaste", JOptionPane.INFORMATION_MESSAGE);
                         
                    arrayBtnSelec.get(0).setIcon(imagenInterrogante);
                    arrayBtnSelec.get(1).setIcon(imagenInterrogante);
                                                      
            }
     
            arrayBtnSelec.get(0).setBorder(BorderFactory.createEmptyBorder());
            arrayBtnSelec.get(1).setBorder(BorderFactory.createEmptyBorder());
            
                        
            arrayBtnSelec.remove(1);
            arrayBtnSelec.remove(0);
            
            
        }
        }
        
        
    }
    
    
}
