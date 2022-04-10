/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_BYTE_GRAY;

/**
 *
 * @author Vanessa
 */
public class ImagenRuido {
    //private int n; // 1: fondo negro, 0: fondo blanco
    public static Image crearImagen(int n, int ancho, int alto, float porcentaje){ //tipo ruido, ancho, alto
        BufferedImage bi = new BufferedImage(ancho, alto, TYPE_BYTE_GRAY);
        int blanco = new Color(255, 255, 255).getRGB();
        int negro = new Color(0, 0, 0).getRGB();
        //int cantidad = (int) ((ancho*alto)*porcentaje); //cantidad de pixeles con ruido
        
        if(n==1){ //fondo negro
           for(int i=0; i<ancho; i++){
                for(int j=0; j<alto; j++){ 
                    if(ruido(porcentaje)){
                       bi.setRGB(i, j, blanco); 
                    }else{
                       bi.setRGB(i, j, negro);  
                    }
                }
            } 
        }else{ // fondo blanco
            for(int i=0; i<ancho; i++){
                for(int j=0; j<alto; j++){ 
                    if(ruido(porcentaje)){
                       bi.setRGB(i, j, negro); 
                    }else{
                       bi.setRGB(i, j, blanco);  
                    }
                }
            }
        }
        
        return AbrirImagen.toImage(bi);
    }
    public static boolean ruido(double prob) {
        return Math.random()<=prob;
    }
}
