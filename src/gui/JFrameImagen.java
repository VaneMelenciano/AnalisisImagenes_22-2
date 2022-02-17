package gui;

import herramientas.AbrirImagen;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vanessa
 */
public class JFrameImagen extends JFrame{
    /*private JLabel etiqueta;
    public JFrameImagen(Image imagenOriginal){
        init();
        //agregamos la imagen a la etiqueta utilizando la clase ImageIcon
        this.etiqueta.setIcon(new ImageIcon(imagenOriginal));
        setSize(new Dimension(imagenOriginal.getWidth(null), imagenOriginal.getWidth(null)));
    }
    private void init() {
        this.etiqueta = new JLabel();
        //setSize(700, 600);
        add(this.etiqueta);
        setVisible(true);
    }
    */
    
    private Image imagenOriginal;
    private Image imagenNueva;

    public JFrameImagen(Image imagenOriginal){                                    
        this.imagenOriginal = imagenOriginal;
        JLabel etiqueta = new JLabel(new ImageIcon(this.imagenOriginal));
        setLayout(new GridLayout(1,1));
        add(etiqueta);
        setSize(new Dimension(this.imagenOriginal.getWidth(null), this.imagenOriginal.getWidth(null)));
        setVisible(rootPaneCheckingEnabled);
    }
    
    public JFrameImagen(Image imagen, int n){                                    
        this.imagenNueva = imagen;
        //agregar un botonh
        Button b = new Button("Guardar");
        b.setLocation(0, 0);
        
        JPanel panelCentral = new JPanel();
        b.setMinimumSize(new Dimension(20,20));
        b.setMaximumSize(new Dimension(150,60));
        b.setPreferredSize(new Dimension(120,30));

        JLabel etiqueta = new JLabel(new ImageIcon(this.imagenNueva));
        
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
        setSize(new Dimension(this.imagenNueva.getWidth(null), this.imagenNueva.getWidth(null)));
        setVisible(rootPaneCheckingEnabled);
    }
    
    public Image getImagenOriginal(){
        return this.imagenOriginal;
    }
    public void setImagenOriginal(Image aux){
        this.imagenOriginal = aux;
    }
    
    private void bMouseClicked(java.awt.event.MouseEvent evt) throws IOException {  
            //AQUI SE DEBE MANDAR LA IMAGEN A ABRIR IMAGEN, EN SAVE IMAGE
            AbrirImagen.saveImage(AbrirImagen.toBufferedImage(this.imagenNueva));
    }
}
