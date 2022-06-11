/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modificarImagen;

import gui.JFrameMenu;
import herramientas.AbrirImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_BYTE_GRAY;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 *
 * @author Vanessa
 */
public class OperacionesMorfologicas {
    
    private Image imagenOriginal;
    private Image imagenNueva;
    private int ancho, alto;
    private int anchoOriginal, altoOriginal;
    private BufferedImage bufferedOriginal;
    
    public OperacionesMorfologicas(Image imagen){
        this.imagenOriginal = imagen;
        bufferedOriginal = AbrirImagen.toBufferedImage(imagenOriginal);
        ancho = bufferedOriginal.getWidth();
        anchoOriginal = bufferedOriginal.getWidth();
        alto = bufferedOriginal.getHeight();
        altoOriginal = bufferedOriginal.getHeight();
        //
        
        //crearFondo();
    }
    public Image traslacion(int moverHorizonatal, int moverVertical){
        //crearFondo();
        BufferedImage bufferedNuevo1 = new BufferedImage(ancho, alto, TYPE_INT_RGB);
        //System.out.println(valor+"\n");
        for(int i=0; i<ancho-moverHorizonatal; i++){
            for(int j=0; j<alto-moverVertical; j++){
                 bufferedNuevo1.setRGB(i+moverHorizonatal, j+moverVertical, getBufferedOriginal().getRGB(i, j));
            }
        }
        return AbrirImagen.toImage(bufferedNuevo1);
    }

    public Image editar(Image imagen){
        BufferedImage bufferedNuevo1 = new BufferedImage(ancho+300, alto+300, TYPE_INT_RGB);
        //System.out.println(valor+"\n");
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                 bufferedNuevo1.setRGB(i, j, getBufferedOriginal().getRGB(i, j));
            }
        }
        return AbrirImagen.toImage(bufferedNuevo1);
    }
    
    public void crearFondo() {
        BufferedImage bi = new BufferedImage(ancho+300, alto+300, TYPE_INT_RGB);
        int mitadAlto = (alto/2)+150; 
        int mitadAncho = (ancho/2)+150; 
        boolean bandera = false;
        for(int i=0, iAux=0; i<ancho+300 && iAux<ancho; i++){
            for(int j=0, jAux=0; j<alto+300 && jAux<alto; j++){
                /*if(i>=150){
                  System.out.println("i: " + i +"  j: " + j);
                System.out.println("iAux: " + iAux +"  jAux: " + jAux);
                // + (i<150) + (j<150) + (j<(alto+150))
                System.out.println((i>(ancho+150)) + " "+ (i<150) + " " + (j<150) + " " + (j>(alto+150)) );
                   
                }*/ 
                if(i<150 | i>ancho+150 | j<150 | j>alto+150){
                    //if(i==mitadAncho || j== mitadAlto) bi.setRGB(i, j, new Color(250, 250, 250).getRGB());
                    //else 
                    bi.setRGB(i, j, new Color(0, 0, 0).getRGB());
                }
                else{
                    bi.setRGB(i, j, getBufferedOriginal().getRGB(iAux, jAux++));
                    bandera = true;
                } 
            }
            if(bandera==true)iAux++;
            //bandera = true;
        }
        bufferedOriginal = bi;
        ancho = getBufferedOriginal().getWidth();
        alto = getBufferedOriginal().getHeight();
        //JFrameMenu nuevo = new JFrameMenu(AbrirImagen.toImage(bi)); nuevo.setTitle("jeje");
    }
    
    public Image rotacion(int angulo){
        // creamos un nuevo Buffered Image para poder procesar la imagen

        BufferedImage aux = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        aux.createGraphics().drawImage(imagenOriginal, 0, 0, null);
        int valorMaximo = 0;
        // comparamos las dimensiones y vemos cual es la mayor para de ahi crear el nuevo tamaño de la imagen
        if (aux.getHeight() > aux.getWidth()) {
            valorMaximo = aux.getHeight();
        } else if (aux.getHeight() < aux.getWidth()) {
            valorMaximo = aux.getWidth();
        } else if (aux.getHeight() == aux.getWidth()) {
            valorMaximo = aux.getHeight();
        }
        // declaramos las nuevas coordenadas del doble del tamaño de cada dimension
        int nuevaCoordenadaX = (int) aux.getWidth()*3;
        int nuevaCoordenadaY = (int) aux.getHeight()*3;

        BufferedImage imagenModificada = new BufferedImage(valorMaximo * 5, valorMaximo * 5, BufferedImage.TYPE_4BYTE_ABGR);

        
        // obtenemos los radianes dependiendo del angulo

        double anguloRadianes = Math.toRadians(angulo);

        for (int y = 0; y < aux.getHeight(); y++) {
            for (int x = 0; x < aux.getWidth(); x++) {
                int promedio =0;
                // obtenemos los valores de las nuevas coordenadas utlizando la formula
                int newPositionX = (int) (x * Math.cos(anguloRadianes) - y * Math.sin(anguloRadianes))+nuevaCoordenadaX;
                int newPositionY = (int) (x * Math.sin(anguloRadianes) + y * Math.cos(anguloRadianes))+nuevaCoordenadaY;

                // a la imagen nueva le damos el mismo valor de rgb en la nueva posicion claculada segun la formula
                imagenModificada.setRGB(newPositionX, newPositionY, aux.getRGB(x, y));
            }
        }
        int paro = 0;
        
        // mejoramos la imagen 2 vecess
        do {
             for (int y = 0; y < imagenModificada.getWidth()-1; y++) {
            for (int x = 0; x < imagenModificada.getHeight()-1; x++) {

               if (imagenModificada.getRGB(x, y)== 0) {
                  imagenModificada.setRGB(x, y, imagenModificada.getRGB(x+1, y+1));
               }

            }
        }
            paro++;
        } while(paro <2);
        
         
        // convertimos a Image
        Image modificada = imagenModificada.getScaledInstance(imagenModificada.getWidth(), imagenModificada.getHeight(), Image.SCALE_DEFAULT);
        // retornamos el image
        return modificada;
    }

    public Image escalamiento(int zoom) {
        if(zoom>0){
            int valX =  (int) (anchoOriginal * (zoom/100f) );
            int valY =  (int) (this.altoOriginal * (zoom/100f) );
           this.imagenNueva = this.imagenOriginal.getScaledInstance(valX, valY, this.getBufferedOriginal().SCALE_SMOOTH);
           return this.imagenNueva;
        }
        return this.imagenOriginal;
    }

    /**
     * @return the bufferedOriginal
     */
    public BufferedImage getBufferedOriginal() {
        return bufferedOriginal;
    }
    
    
    
}
