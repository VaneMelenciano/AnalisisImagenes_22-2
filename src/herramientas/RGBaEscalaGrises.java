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
public class RGBaEscalaGrises {
    
    public static Image convertir(Image imagen){
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
