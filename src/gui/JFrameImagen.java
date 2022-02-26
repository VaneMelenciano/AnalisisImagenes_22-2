package gui;

import herramientas.AbrirImagen;
import herramientas.Histograma;
import herramientas.ModificarImagen;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Vanessa
 */
public class JFrameImagen extends JFrame{
    private Image imagen;
    private Image imagenOriginal;
    private int umbral1, umbral2;
    private JLabel etiqueta1; //etiqueta para panel con umbral

    public JFrameImagen(Image imagen){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        
    }
    //normal, solo muestra imagen
    public void JFrame(){
        JLabel etiqueta = new JLabel(new ImageIcon(this.imagen));
        setLayout(new GridLayout(1,1));
        add(etiqueta);
        setSize(new Dimension(this.imagen.getWidth(null), this.imagen.getWidth(null)));
        setVisible(rootPaneCheckingEnabled);
        
    }
    
    //con un boton
    public void JFrameBoton(){                                    
        this.imagen = imagen;
        //agregar un botonh
        Button b = new Button("Guardar");
        b.setLocation(0, 0);
        
        JPanel panelCentral = new JPanel();
        b.setMinimumSize(new Dimension(20,20));
        b.setMaximumSize(new Dimension(150,60));
        b.setPreferredSize(new Dimension(120,30));

        JLabel etiqueta = new JLabel(new ImageIcon(this.imagen));
        
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    bMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        panelCentral.setSize(new Dimension(150,60));
        panelCentral.add(b);
        add(panelCentral);
        add(etiqueta);
        setSize(new Dimension(this.imagen.getWidth(null), this.imagen.getWidth(null)));
        setVisible(rootPaneCheckingEnabled);
    }
    
    //con opciones para modificar imagen
    //no quiere hacer al precionar items
    public void JFrameMenu(){
        JLabel etiqueta = new JLabel(new ImageIcon(this.imagen));
        
        JPanel panelCentral = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu1 = new JMenu(); //modificar imagen
        JMenu menu2 = new JMenu(); //histograma
        JMenu menu3 = new JMenu(); //guardar
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //umbralizada
        JMenuItem item13 = new JMenuItem(); //binarizacion
        item11.setText("En escala de grises");
        item12.setText("Umbralizacion");
        item13.setText("Binarizacion");
        menu1.setText("Modificar imagen");
        menu3.setText("Guardar");
        menu2.setText("Histograma");
        
        item11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Hola2");
                escalaGrisesMouseClicked(evt);
            }
        });
        item12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                umbralizacionMouseClicked(evt);
            }
        });
        item13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                binarizacionMouseClicked(evt);
            }
        });
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        menu1.add(item11);
        menu1.add(item12);
        menu1.add(item13);
        opciones.add(menu1);
        opciones.add(menu2);
        opciones.add(menu3);
        opciones.setLocation(0, 0);
        panelCentral.setSize(new Dimension(260,27));
        panelCentral.add(opciones);
        add(panelCentral);
        add(etiqueta);
        //add(opciones);
        
        setSize(new Dimension(this.imagen.getWidth(null), this.imagen.getWidth(null)));
        setVisible(rootPaneCheckingEnabled);
    }
    //para imagen con umbral
    public void JFumbral(int val1, int val2){
        //JLabel etiqueta = new JLabel(new ImageIcon(this.imagen));
        this.umbral1=val1; this.umbral2=val2;
         etiqueta1 = new JLabel(new ImageIcon(this.imagen));actualizarImagen();
       
       
        
        //etiqueta1 = new JLabel();
        
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu1 = new JMenu(); //modificar imagen
        JMenu menu2 = new JMenu(); //histograma
        JMenu menu3 = new JMenu(); //guardar
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //binaria
        item11.setText("En escala de grises");
        item12.setText("Binarizacion");
        menu1.setText("Modificar imagen");
        menu3.setText("Guardar");
        menu2.setText("Histograma");
        //slider
        JSlider slider1 = new JSlider(0,255,this.umbral1);
        JSlider slider2 = new JSlider(0,255,this.umbral2);
        slider1.setMajorTickSpacing(50);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        slider2.setMajorTickSpacing(50);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintLabels(true);
        slider2.setPaintTicks(true);
        //JLabel txtUmbral1 = new JLabel("\t\t\tUmbra 1: ");
        //JLabel txtUmbral2 = new JLabel("\t\t\tUmbra 2: ");
        JLabel txtValor1 = new JLabel(val1<10 ? "00"+String.valueOf(val1) : val1<100 ? "0"+String.valueOf(val1) : String.valueOf(val1));
        JLabel txtValor2 = new JLabel(val2<10 ? "00"+String.valueOf(val2) : val2<100 ? "0"+String.valueOf(val2) : String.valueOf(val2));
        
        slider1.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider1.setValue(slider1.getValue() );
              int valor=slider1.getValue();
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor1.setText(b1);
                umbral1 = valor;
              actualizarImagen();
            }
          } );
        slider2.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider2.setValue(slider2.getValue());
              int valor=slider2.getValue();
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor2.setText(b1);
              umbral2 = valor;
              actualizarImagen();
            }
          } );
        
        
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        item11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escalaGrisesMouseClicked(evt);
            }
        });
        item12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                binarizacionMouseClicked(evt);
            }
        });
        
        menu1.add(item11);
        menu1.add(item12);
        opciones.add(menu1);
        opciones.add(menu2);
        opciones.add(menu3);
        //opciones.setLocation(0, 0);
        //panelCentral1.setLocation(0, 150);
        panelCentral1.setSize(new Dimension(259,29));
        panelCentral1.add(opciones);
        slider1.setLocation(0, 0);
        panelCentral2.add(slider1);
        panelCentral2.add(txtValor1);
        panelCentral2.add(slider2);
        panelCentral2.add(txtValor2);
        panelCentral2.setSize(new Dimension(480,56));
        panelCentral2.setLocation(0, 30);
        add(panelCentral1);
        
        add(panelCentral2);
        //etiqueta1.setIcon(new ImageIcon(this.imagen));
        etiqueta1.setLocation(0, 87);
        add(etiqueta1);
        //add(opciones);
        int x = this.imagen.getWidth(null)>=480 ? this.imagen.getWidth(null) : 480;
        setSize(new Dimension(x, this.imagen.getHeight(null)));
        setVisible(rootPaneCheckingEnabled);
    }
    
    public Image getImagenOriginal(){
        return this.imagenOriginal;
    }
    public Image getImagen(){
        return this.imagen;
    }
    public void setImagenOriginal(Image aux){
        this.imagenOriginal = aux;
    }
    public void setImagen(Image aux){
        this.imagen = aux;
    }
    
    private void bMouseClicked(java.awt.event.MouseEvent evt) throws IOException {  
            //AQUI SE DEBE MANDAR LA IMAGEN A ABRIR IMAGEN, EN SAVE IMAGE
            AbrirImagen.saveImage(AbrirImagen.toBufferedImage(this.imagen));
    }
    
    private void guardarMouseClicked(MouseEvent evt) throws IOException {
        AbrirImagen.saveImage(AbrirImagen.toBufferedImage(this.imagen));
    }
    private void histogramaMouseClicked(MouseEvent evt) {
       Histograma.crear(this.imagen);
    }
    private void escalaGrisesMouseClicked(MouseEvent evt) {
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(this.imagen);
        JFrameImagen auxResultante = new JFrameImagen(imagenResultante);
        auxResultante.JFrameMenu();
        auxResultante.setTitle("Imagen en espala de grises");
   }
    private void umbralizacionMouseClicked(MouseEvent evt) {
        int u1=39, u2=255;
        Image nuevaImagen = ModificarImagen.umbralizacion(this.imagen, u1, u2);
        JFrameImagen auxResultante = new JFrameImagen(nuevaImagen);
        auxResultante.JFumbral(u1, u2);
        auxResultante.setTitle("Imagen con umbrales");
    }
    private void binarizacionMouseClicked(MouseEvent evt) {
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(this.imagen);
        //pasar imagenResultante a binaria
        JFrameImagen auxResultante = new JFrameImagen(imagenResultante);
        auxResultante.JFrameMenu();
        auxResultante.setTitle("Imagen binaria");
    }
    private void actualizarImagen() {
        Image imagenNueva = ModificarImagen.umbralizacion(this.imagenOriginal, this.umbral1, this.umbral2);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
}
