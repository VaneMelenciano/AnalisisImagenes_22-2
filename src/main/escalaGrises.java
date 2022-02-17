/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.JFrameImagen;
import herramientas.AbrirImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Vanessa
 */
public class escalaGrises {
    public static void main(String[] args) {
        Image imagenOriginal = AbrirImagen.openImage();
        JFrameImagen original = new JFrameImagen(imagenOriginal);
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagenOriginal);
        //Editar imagen
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        System.out.println(ancho + "   " +alto);
        //da escala de azul :(
        Color color = new Color(230, 0, 38);
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                //System.out.println(i + "   " +j);
                Color c = new Color(auxBuffed.getRGB(i, j));
                int promedio = (c.getBlue()+c.getGreen()+c.getRed())/3;
                //System.out.println("   " +promedio);
                auxBuffed.setRGB(i, j, (promedio<=255 ? promedio : 255));
            }
        }
        
        Image imagenResultante = AbrirImagen.toImage(auxBuffed);
        JFrameImagen auxResultante = new JFrameImagen(imagenResultante);
    }
}
