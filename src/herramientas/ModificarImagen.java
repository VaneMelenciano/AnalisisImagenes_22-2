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
                 Color nuevo = cambiarColorIlum(new Color(auxBuffed.getRGB(i, j)), valor);//color del pixel
                 auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
    }
    private static Color cambiarColorIlum(Color c, int v) {
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
        aux1 = ((aux1<umbral1) ? 255 : aux1);
        aux2 = ((aux1<umbral1) ? 255 : aux2);
        aux3 = ((aux1<umbral1) ? 255 : aux3);
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
    
    public static Image convertirBinaria(Image imagen, int umbral1, int umbral2){
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
    private static Color cambiarColorBinaria(Color c, int umbral1, int umbral2) {
        int aux1 = c.getRed(), aux2 = c.getGreen(), aux3 = c.getBlue();
        aux1 = (aux1>=umbral2 ? 255 : aux1); aux1 = (aux1<umbral1 ? 0 : aux1);
        aux2 = (aux2>=umbral2 ? 255 : aux2); aux2 = (aux2<umbral1 ? 0 : aux2);
        aux3 = (aux3>=umbral2 ? 255 : aux3); aux3 = (aux3<umbral1 ? 0 : aux3);
        return new Color(aux1, aux2, aux3); //nuevo color con el primedio en cada canal
    
    }
    
    public static Image negativo(Image imagen){
       BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){ 
                Color nuevo = calcularComplementario(new Color(auxBuffed.getRGB(i, j)));
                auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed);  
    }
    private static Color calcularComplementario(Color c) {
       /*
        r (rojo) = 255 – 106 = 149
        g (verde) = 255 - 177 = 78
        b (azul) = 255 – 80 = 175
        */
       return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
    }
   
    public static int umbralizacionAuto/*Automatica*/(int[] histo){
        int j=125, jaux=0;
        boolean bandera = false; 
        while(j!=jaux){
            //System.out.println("j: " + j + " jaux: " + jaux);
            if(bandera){ //solo actualiza j después de la primera vuelta
                j=jaux;
            }
            //mayor de cada mitad
            int may1 = 0, pos1 = 0, pos2=0, may2 = 0;
            for(int i=0, k=j; i<j && k<histo.length; i++, k++){
                if(histo[i]>may1){
                    may1=histo[i];
                    pos1=i;
                }
                if(histo[k]>may2){
                    may2=histo[k];
                    pos2=k;
                }
            }
            //actualizar j
            System.out.println( "  may1: " + may1 + " pos1: " + pos1);
            System.out.println( "  may2: " + may2 + " pos2: " + pos2);
            
            jaux=((pos2-pos1)/2)+pos1;
            bandera = true;
            
            System.out.println("   nueva j: " + jaux);
            
        }
        return j;
    }
    
    public static Image cambiarTemperatura(Image imagen, int valor){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        boolean bandera = (valor<0 ? false : true); //trues: calida, false: fria
        valor = Math.abs(valor);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                if(bandera){
                    Color nuevo = aCalido(new Color(auxBuffed.getRGB(i, j)), valor);
                    auxBuffed.setRGB(i, j, nuevo.getRGB());
                }
                else{
                    Color nuevo = aFrio(new Color(auxBuffed.getRGB(i, j)), valor);
                    auxBuffed.setRGB(i, j, nuevo.getRGB());
                }
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
    }
    private static Color aCalido(Color c, int valor){
        //R++ B--
        int aux1 = c.getRed()+valor, aux2 = c.getGreen(), aux3 = c.getBlue()-valor;
        aux1 = ((aux1>255) ? 255 : aux1);
        aux3 = ((aux3>255) ? 255 : aux3);
        
        aux1 = ((aux1<0) ? 0 : aux1);
        aux3 = ((aux3<0) ? 0 : aux3);
        return new Color(aux1, aux2, aux3);
    }
    private static Color aFrio(Color c, int valor){
        //R++ B--
        int aux1 = c.getRed()-valor, aux2 = c.getGreen(), aux3 = c.getBlue()+valor;
        aux1 = ((aux1>=255) ? 255 : aux1);
        aux3 = ((aux3>=255) ? 255 : aux3);
        
        aux1 = ((aux1<=0) ? 0 : aux1);
        aux3 = ((aux3<=0) ? 0 : aux3);
        return new Color(aux1, aux2, aux3);
    }
}
