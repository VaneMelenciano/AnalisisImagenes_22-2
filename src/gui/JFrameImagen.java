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
    public Image imagen;
    public Image imagenOriginal;
    public int umbral1, umbral2;
    public Seleccion seleccion;
    public JLabel etiqueta1; //etiqueta para panel con umbral

    public JFrameImagen(Image imagen){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        crear();
    }
    public JFrameImagen(Seleccion seleccion, Image imagen, int v1, int v2){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        this.umbral1=v1; this.umbral2=v2;
        this.seleccion = seleccion;
        crear();
        
    }
    //normal, solo muestra imagen
    public void crear(){
        JLabel etiqueta = new JLabel(new ImageIcon(this.imagen));
        setLayout(new GridLayout(1,1));
        add(etiqueta);
        setSize(new Dimension(this.imagen.getWidth(null), this.imagen.getWidth(null)));
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
    
    
    public void guardarMouseClicked(MouseEvent evt) throws IOException {
        AbrirImagen.saveImage(AbrirImagen.toBufferedImage(this.imagen));
    }
    public void histogramaMouseClicked(MouseEvent evt) {
       Histograma.crear(this.imagen);
    }
    
    public void escalaGrisesMouseClicked(java.awt.event.ActionEvent evt) {                                           
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(this.imagen);
        JFrameMenu auxResultante = new JFrameMenu(imagenResultante);
        auxResultante.setTitle("Imagen en espala de grises");
    }
    public void escalaGrisesMouseClicked(java.awt.event.ActionEvent evt, Image imagen) {                                           
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(imagen);
        JFrameMenu auxResultante = new JFrameMenu(imagenResultante);
        auxResultante.setTitle("Imagen en espala de grises");
    }
    
    public void umbralizacionMouseClicked(java.awt.event.ActionEvent evt) {
        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Umbralizacion, this.imagenOriginal, 0, 255);
        auxResultante.setTitle("Imagen con umbrales");
    }
    public void umbralizacionMouseClicked(java.awt.event.ActionEvent evt, Image imagen) {
        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Umbralizacion, imagen, 0, 255);
        auxResultante.setTitle("Imagen con umbrales");
    }
    
    public void binarizacionMouseClicked(java.awt.event.ActionEvent evt) {
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(this.imagenOriginal);      
        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Binarizacion, imagenResultante, 0, 255);
        auxResultante.setTitle("Imagen binaria");
    }
    public void binarizacionMouseClicked(java.awt.event.ActionEvent evt, Image imagen) {
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(imagen);      
        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Binarizacion, imagenResultante, 0, 255);
        auxResultante.setTitle("Imagen binaria");
    }
    
    public void negativoMouseClicked(java.awt.event.ActionEvent evt) {
        Image imagenResultante = ModificarImagen.negativo(this.imagenOriginal);
        JFrameMenu auxResultante = new JFrameMenu(imagenResultante);
        auxResultante.setTitle("Negativo de imagen");
    }
    public void negativoMouseClicked(java.awt.event.ActionEvent evt, Image imagen) {
        Image imagenResultante = ModificarImagen.negativo(imagen);
        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Binarizacion, imagenResultante, 0, 255);
        auxResultante.setTitle("Imagen binaria");
    }
    
    public void actualizarImagen() {
        Image imagenNueva = ModificarImagen.umbralizacion(this.imagenOriginal, this.umbral1, this.umbral2);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
    public void actualizarImagenBinaria() {
        Image imagenNueva = ModificarImagen.convertirBinaria(this.imagenOriginal, this.umbral1, this.umbral2);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
    
}
