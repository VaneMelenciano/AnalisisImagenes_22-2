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
    private static int[] R, G, B;
    public static void crear(Image imagen, String tituloVentana){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
    
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        R = new int[256];
        G = new int[256];
        B = new int[256];
        
        //recorrer cada pixel de la imagen recibida
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                 Color c = new Color(auxBuffed.getRGB(i, j)); //color del pixel
                 getR()[c.getRed()]++;
                 getG()[c.getGreen()]++;
                 getB()[c.getBlue()]++;
            }
        }
        Grafica grafica = new Grafica("ejex", "ejeY", "Histograma de colores", tituloVentana);
        grafica.agregarSerie("Red", getR());
        grafica.agregarSerie("Blue", getB());
        grafica.agregarSerie("Green", getG());
        
        grafica.crearYmostrarGrafica();
        
    }
    public static void crear(Image imagen){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
    
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        R = new int[256];
        G = new int[256];
        B = new int[256];
        
        //recorrer cada pixel de la imagen recibida
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                 Color c = new Color(auxBuffed.getRGB(i, j)); //color del pixel
                 getR()[c.getRed()]++;
                 getG()[c.getGreen()]++;
                 getB()[c.getBlue()]++;
            }
        }
        Grafica grafica = new Grafica("ejex", "ejeY", "Histograma de colores", "");
        grafica.agregarSerie("Red", getR());
        grafica.agregarSerie("Blue", getB());
        grafica.agregarSerie("Green", getG());
        
        grafica.crearYmostrarGrafica();
        
    }
    public static void crearCanales(Image imagen){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
    
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        R = new int[256];
        G = new int[256];
        B = new int[256];
        
        //recorrer cada pixel de la imagen recibida
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                 Color c = new Color(auxBuffed.getRGB(i, j)); //color del pixel
                 getR()[c.getRed()]++;
                 getG()[c.getGreen()]++;
                 getB()[c.getBlue()]++;
            }
        }
        
    }
    public static int[] crearBN(Image imagen){ //blanco y negro
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
    
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        int[] canal = new int[256];
        
        //recorrer cada pixel de la imagen recibida
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                 Color c = new Color(auxBuffed.getRGB(i, j)); //color del pixel
                 canal[c.getRed()]++;
            }
        }
        return canal;
    }
    
    /*
    //CLASE DEL PROFE
    public static Image ecualizarImagen(Image imagen){
    
        int nxm = imagen.getWidth(null)*imagen.getHeight(null); //pixeles de la imagen
        Histogramas h = new Histogramas(imagen); //histograma
        double[] ho = h.getHRed(); //arreglo del histograma
        double[] daf = new double[256];
        int[] nt = new int[256];
        daf[0] = (int)ho[0]; //primer valor del histograma
        nt[0] = (int)Math.round((daf[0]/nxm)*255); 
        // recorremos el histograma para acumular
        for(int x=1; x<ho.length;x++){
            daf[x] = (int)(ho[x]+daf[x-1]);
            double aux = daf[x]/nxm;
            int tmp = (int) Math.round(aux * 255);
            nt[x] = tmp;
        }

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int t = color.getRed();
            int t2 =nt[t];
            color = new Color(t2,t2,t2);     
            bi.setRGB(x,y,color.getRGB());
        }

        
        return AbrirImagen.toImage(bi);

    }*/

    /**
     * @return the R
     */
    public static int[] getR() {
        return R;
    }

    /**
     * @return the G
     */
    public static int[] getG() {
        return G;
    }

    /**
     * @return the B
     */
    public static int[] getB() {
        return B;
    }
}
