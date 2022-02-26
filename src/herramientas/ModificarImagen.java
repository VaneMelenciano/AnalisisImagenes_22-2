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
public class ModificarImagen {
    public static Image modificarIluminacion(Image imagen, int valor){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        //System.out.println(valor+"\n");
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                //System.out.println("\t" + i + "  " + j);
                 Color nuevo = cambiarColor(new Color(auxBuffed.getRGB(i, j)), valor);//color del pixel
                 auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
    }

    private static Color cambiarColor(Color c, int v) {
        //Recibe un color, y le suma a cada uno de sus valor el entero recibido, y revisa

        int aux1 = c.getRed()+v, aux2 = c.getGreen()+v, aux3 = c.getBlue()+v;
        aux1 = (aux1>=255 ? 255 : aux1); aux1 = (aux1<0 ? 0 : aux1);
        aux2 = (aux2>=255 ? 255 : aux2); aux2 = (aux2<0 ? 0 : aux2);
        aux3 = (aux3>=255 ? 255 : aux3); aux3 = (aux3<0 ? 0 : aux3);
        return new Color(aux1, aux2, aux3); //nuevo color con el primedio en cada canal
    }
    
    public static Image umbralizacion(Image imagen, int umbral1){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                Color nuevo = verificar1umbrales(new Color(auxBuffed.getRGB(i, j)), umbral1);
                auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
    }
    
    public static Image umbralizacion(Image imagen, int umbral1, int umbral2){
        if(umbral1<=umbral2){
             BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                Color nuevo = verificar2umbrales(new Color(auxBuffed.getRGB(i, j)), umbral1, umbral2);
                auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
        }
        return imagen;
    }
    

    private static Color verificar2umbrales(Color c, int umbral1, int umbral2) {
        int aux1 = c.getRed(), aux2 = c.getGreen(), aux3 = c.getBlue();
        aux1 = ((aux1>=umbral2 || aux1<=umbral1) ? 255 : aux1);
        aux2 = ((aux1>=umbral2 || aux1<=umbral1) ? 255 : aux2);
        aux3 = ((aux1>=umbral2 || aux1<=umbral1) ? 255 : aux3);
        return new Color(aux1, aux2, aux3); //nuevo color con el primedio en cada canal
    
    }
    private static Color verificar1umbrales(Color c, int umbral1) {
        int aux1 = c.getRed(), aux2 = c.getGreen(), aux3 = c.getBlue();
        aux1 = ((aux1>umbral1) ? aux1 : 255);
        aux2 = ((aux1>umbral1) ? aux2 : 255);
        aux3 = ((aux1>umbral1) ? aux3 : 255);
        return new Color(aux1, aux2, aux3); //nuevo color con el primedio en cada canal
    
    }
    
    public static Image convertirEscalaGrises(Image imagen){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        
        //Editar imagen
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        System.out.println(ancho + "   " +alto);
        
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                Color c = new Color(auxBuffed.getRGB(i, j)); //color del pixel
                int promedio = (c.getBlue()+c.getGreen()+c.getRed())/3; //promedio de los 3 canales
                Color nuevo = new Color(promedio, promedio, promedio); //nuevo color con el primedio en cada canal
                auxBuffed.setRGB(i, j, nuevo.getRGB()); //dar el nuevo color en escala de grises, al pixel
            }
        }
        
        return AbrirImagen.toImage(auxBuffed); 
    }
}
