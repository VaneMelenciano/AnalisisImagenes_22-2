package gui;

import herramientas.AbrirImagen;
import herramientas.Histograma;
import herramientas.ModificarImagen;
import herramientas.UmbralAutomatico;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
    public double umbral;
    public Seleccion seleccion;
    //public SeleccionExpansion seleccionExp;
    public JLabel etiqueta1; //etiqueta para panel con umbral

    public JFrameImagen(Image imagen){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        this.umbral1=0;
        this.umbral2=255;
        crear();
    }
    public JFrameImagen(Seleccion seleccion, Image imagen, int v1, int v2){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        this.umbral1=v1; this.umbral2=v2;
        this.seleccion = seleccion;
        crear();  
    }
    /*public JFrameImagen(SeleccionExpansion seleccion, Image imagen, int v1, int v2){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        this.umbral1=v1; this.umbral2=v2;
        this.seleccionExp = seleccion;
        crear();  
    }*/
    public JFrameImagen(Seleccion seleccionExp, Image imagen, int v1){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        this.umbral1=v1;
        this.seleccion = seleccionExp;
        crear();  
    }
    public JFrameImagen(Seleccion seleccionExp, Image imagen, double v1){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        this.umbral=v1;
        this.seleccion = seleccionExp;
        crear();  
    }
    public JFrameImagen(Seleccion seleccionExp, Image imagen){                                    
        this.imagenOriginal = imagen;
        this.imagen = imagen;
        this.seleccion = seleccionExp;
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
    public void histogramaMouseClicked(ActionEvent e) {
       Histograma.crear(this.imagen);
    }
    
    public void escalaGrisesMouseClicked(java.awt.event.ActionEvent evt) {                                           
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(this.imagen);
        JFrameMenu auxResultante = new JFrameMenu(imagenResultante);
        auxResultante.setTitle("Imagen en escala de grises");
    }
    public void escalaGrisesMouseClicked(java.awt.event.ActionEvent evt, Image imagen) {                                           
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(imagen);
        JFrameMenu auxResultante = new JFrameMenu(imagenResultante);
        auxResultante.setTitle("Imagen en escala de grises");
    }
    
    /*public void escalaGrisesMouseClicked(java.awt.event.ActionEvent evt) {
       Image imagenResultante = ModificarImagen.convertirEscalaGrises(this.imagen);
        JFrameMenu auxResultante = new JFrameMenu(imagenResultante);
        auxResultante.setTitle("Imagen en escala de grises");
    }*/
    
    public void umbralizacionMouseClicked(java.awt.event.ActionEvent evt) {
        int[] canal = Histograma.crearBN(this.imagenOriginal);
        double[] nuevo = new double[canal.length];
        for(int i=0; i<canal.length; i++){
            nuevo[i] = canal[i];
        }
        int j= UmbralAutomatico.metodoIterativo(nuevo);
        //int j = ModificarImagen.umbralizacionAuto(Histograma.crearBN(imagenOriginal));
        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Umbralizacion, this.imagenOriginal, j, 255);
        auxResultante.setTitle("Imagen con umbrales automaticos");
    }
    public void umbralizacionMouseClicked(java.awt.event.ActionEvent evt, Image imagen) {
        int[] canal = Histograma.crearBN(this.imagen);
        double[] nuevo = new double[canal.length];
        for(int i=0; i<canal.length; i++){
            nuevo[i] = canal[i];
        }
        int j= UmbralAutomatico.metodoIterativo(nuevo);
        //int j = ModificarImagen.umbralizacionAuto(Histograma.crearBN(imagen));
        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Umbralizacion, imagen, j, 255);
        auxResultante.setTitle("Imagen con umbrales automaticos");
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
    public void expExpMouseClicked(ActionEvent evt) { //expansion Exponencial
        double z = 0.5;
        Image imagenResultante = ModificarImagen.expansionExp(this.imagenOriginal, z);
        JFrameExpansion auxResultante = new JFrameExpansion(Seleccion.Exponencial, imagenResultante, z);
        auxResultante.setTitle("Expansión exponencial");
    }
    public void expExpMouseClicked(ActionEvent evt, Image imagen) { //expansion Exponencial
        double z = 0.5;
        Image imagenResultante = ModificarImagen.expansionExp(imagen, z);
        JFrameExpansion auxResultante = new JFrameExpansion(Seleccion.Exponencial, imagenResultante, z);
        //Seleccion seleccion, Image imagen, int val1, int val2
        auxResultante.setTitle("Expansión exponencial");
    }
    public void expLinMouseClicked(ActionEvent evt) { //expansion Lineal
        System.out.println("Entro 1");
        Image imagenResultante = ModificarImagen.expansionLinal(this.imagenOriginal, this.umbral1, this.umbral2);
        System.out.println("Retorno");
        JFrameExpansion auxResultante = new JFrameExpansion(Seleccion.Lineal, imagenResultante, this.umbral1, this.umbral2);
        auxResultante.setTitle("Expansión Lineal");
    }
    public void expLinMouseClicked(ActionEvent evt, Image imagen) { //expansion Lineal
        Image imagenResultante = ModificarImagen.expansionLinal(imagen, this.umbral1, this.umbral2);
        JFrameExpansion auxResultante = new JFrameExpansion(Seleccion.Lineal, imagenResultante, 0, 255);
        auxResultante.setTitle("Expansión Lineal");
    }
    public void expLogMouseClicked(ActionEvent evt) { //expansion Logaritmica
        System.out.println("Entro 1");
        Image imagenResultante = ModificarImagen.expansionLinal(this.imagenOriginal, this.umbral1, this.umbral2);
        System.out.println("Retorno");
        JFrameExpansion auxResultante = new JFrameExpansion(Seleccion.Logaritmica, imagenResultante, this.umbral1, this.umbral2);
        auxResultante.setTitle("Expansión Lineal");
    }
    public void expLogMouseClicked(ActionEvent evt, Image imagen) { //expansion Logaritmica
        Image imagenResultante = ModificarImagen.expansionLogaritmica(imagen);
        JFrameExpansion auxResultante = new JFrameExpansion(Seleccion.Logaritmica, imagenResultante);
        auxResultante.setTitle("Expansión Lineal");
    }
    
    public void actualizarImagen() {
        System.out.println("Aqui");
        Image imagenNueva = ModificarImagen.umbralizacion(this.imagenOriginal, this.umbral1, this.umbral2);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
    public void actualizarImagenBinaria() {
        Image imagenNueva = ModificarImagen.convertirBinaria(this.imagenOriginal, this.umbral1, this.umbral2);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
    public void actualizarImagenExponencial() {
        Image imagenNueva = ModificarImagen.expansionExp(this.imagenOriginal, umbral);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
    public void actualizarImagenLineal() {
        Image imagenNueva = ModificarImagen.expansionLinal(this.imagenOriginal, umbral1, umbral2);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
    public void actualizarImagenLog() {
        Image imagenNueva = ModificarImagen.expansionLogaritmica(this.imagenOriginal);
        this.imagen = imagenNueva;
        etiqueta1.setIcon(new ImageIcon(this.imagen));
    }
    
}
