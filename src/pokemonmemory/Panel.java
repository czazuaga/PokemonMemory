
package pokemonmemory;


import com.sun.prism.impl.PrismSettings;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
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
    
    JButton[] botones = new JButton[36];
    
    
    private int intentos =0,aciertos =0,puntos=0;
    public boolean botonesActivos=false;
    
    ArrayList<String> arrayLista = new ArrayList<>();
    ArrayList<JButton> arrayBtnSelec = new ArrayList<>();

    Icon imagenInterrogante = new ImageIcon(getClass().getResource("/pokemonmemory/Imagenes/18.jpg"));
    Icon[] imagenes=new Icon[18];
    
    
    NuevoHilo nuevoHilo = new NuevoHilo(this);
    
    public Panel () {
        
        nuevoHilo.start();
        
    InitComponents();
    
     
    
     
    }
    
    public void InitComponents () {
    
          for (int i =0;i<18;i++){
          imagenes[i]=new ImageIcon(getClass().getResource("/pokemonmemory/Imagenes/"+
                    i+".jpg"));
          
          }
        
    int intIndice=0;
    
    GridLayout layout = new GridLayout(NUMERO_FILAS,NUMERO_COLUMNAS,2,2);
        this.setLayout(layout);
        
        
     
    interroganteImgURL = getClass().getResource("Imagenes/18.jpg");
       
        
     for (int i=0;i<18;i++){
   
        arrayLista.add(String.valueOf(i)); 
     
        arrayLista.add(String.valueOf(i));   
        
    }        
    Collections.shuffle(arrayLista);
      
      
    
    for (int i=0;i < NUMERO_FILAS;i++){
        for(int j=0;j < NUMERO_COLUMNAS;j++){
        
       
           
        
        botones[intIndice]= new JButton(imagenInterrogante);
        botones[intIndice].setBackground(PanelTitulo.amarillo);
        botones[intIndice].setPreferredSize(new Dimension(imagenInterrogante.getIconWidth(),imagenInterrogante.getIconHeight()));
        botones[intIndice].setName(arrayLista.get(intIndice));
        botones[intIndice].setActionCommand(i + "-" + j);
        this.add(botones[intIndice]);
        botones[intIndice].addActionListener(this);
        intIndice++;
        }   
    }     
     
           mostrarImagenes();    
            
           
 
    }   
    

    String primeroPulsado;
    int numEntero; 
    
    //Al pulsar un boton...
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
         
        
        if (botonesActivos){
             
        JButton button = (JButton) ae.getSource();
        
        if (!button.getName().equals("OK")&&!button.getName().equals("procesando")){
            
        numEntero = Integer.parseInt(button.getName());                   
        button.setIcon(imagenes[numEntero]);
        button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, PanelTitulo.azul));
        
        arrayBtnSelec.add(button);
        
        if(arrayBtnSelec.size()==2){
            intentos++;
            arrayBtnSelec.get(0).setName(primeroPulsado);
            
            if (arrayBtnSelec.get(0).getName().equals(arrayBtnSelec.get(1).getName())){
            
                aciertos++;
                puntos+=100;
                actualizarUi();
                if(aciertos >17){
                    
                 JOptionPane.showMessageDialog(Panel.this, "Tu "+
                         "persistencia de memoria es del "+ calcularPorcentaje() +
                         "%","Fin del juego ", JOptionPane.INFORMATION_MESSAGE);
                }else {
                JOptionPane.showMessageDialog(Panel.this, "Enhorabuena","Acertaste!!!"
                        , JOptionPane.INFORMATION_MESSAGE);
                
                }
                arrayBtnSelec.get(0).setName("OK");
                arrayBtnSelec.get(1).setName("OK");
                 
                
            }else{
                actualizarUi();               
                
                if(puntos>0){
                puntos-=5;
                }
                
                    JOptionPane.showMessageDialog(Panel.this, "Prueba de nuevo",
                            "Fallaste", JOptionPane.INFORMATION_MESSAGE);
                         
                    arrayBtnSelec.get(0).setIcon(imagenInterrogante);
                    arrayBtnSelec.get(1).setIcon(imagenInterrogante);
                                                      
            }
     
            arrayBtnSelec.get(0).setBorder(BorderFactory.createEmptyBorder());
            arrayBtnSelec.get(1).setBorder(BorderFactory.createEmptyBorder());
            
                        
            arrayBtnSelec.remove(1);
            arrayBtnSelec.remove(0);
            
            
        }else{
            primeroPulsado=button.getName();
            System.out.println(primeroPulsado);
            
        arrayBtnSelec.get(0).setName("procesando");
        }  
        
        }
        
        }
    
    }
    

    private void actualizarUi(){
    PanelTitulo.labelAciertos.setText("Aciertos: "+ aciertos);
    PanelTitulo.labelIntentos.setText("Intentos: "+ intentos);
    PanelTitulo.labelPuntos.setText(""+puntos);
    
    }
    
    
    private int calcularPorcentaje(){
         
     return (aciertos *100)/ intentos;
    }
    
    int numIntIndice; 
    private void mostrarImagenes(){
    for (int i =0;i<36;i++){
      numIntIndice = Integer.parseInt(botones[i].getName());
      botones[i].setIcon(imagenes[numIntIndice]); 
    }
        
    }
    
    public void ocultarImagenes(){
    for (int i =0;i<36;i++){ 
      botones[i].setIcon(imagenInterrogante); 
    }
    }
    
  
    
}
