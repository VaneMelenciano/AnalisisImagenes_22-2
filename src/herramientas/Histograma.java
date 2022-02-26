/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Vanessa
 */
public class Histograma {
    public static void crear(Image imagen, String tituloVentana){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
    
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        int[] R = new int[256];
        int[] G = new int[256];
        int[] B = new int[256];
        
        //recorrer cada pixel de la imagen recibida
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                 Color c = new Color(auxBuffed.getRGB(i, j)); //color del pixel
                 R[c.getRed()]++;
                 G[c.getGreen()]++;
                 B[c.getBlue()]++;
            }
        }
        Grafica grafica = new Grafica("ejex", "ejeY", "Histograma de colores", tituloVentana);
        grafica.agregarSerie("Red", R);
        grafica.agregarSerie("Blue", B);
        grafica.agregarSerie("Green", G);
        
        grafica.crearYmostrarGrafica();
        
    }
    public static void crear(Image imagen){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
    
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        int[] R = new int[256];
        int[] G = new int[256];
        int[] B = new int[256];
        
        //recorrer cada pixel de la imagen recibida
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                 Color c = new Color(auxBuffed.getRGB(i, j)); //color del pixel
                 R[c.getRed()]++;
                 G[c.getGreen()]++;
                 B[c.getBlue()]++;
            }
        }
        Grafica grafica = new Grafica("ejex", "ejeY", "Histograma de colores", "");
        grafica.agregarSerie("Red", R);
        grafica.agregarSerie("Blue", B);
        grafica.agregarSerie("Green", G);
        
        grafica.crearYmostrarGrafica();
        
    }
}
