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
public class testMain {
    public static void main(String[] args) {
        Image imagenOriginal = AbrirImagen.openImage();
        JFrameImagen original = new JFrameImagen(imagenOriginal);
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagenOriginal);
        Color amarillo = new Color(250, 250, 0);
        Color rojo = new Color(250, 0, 0);
        Color verde = new Color(81, 221, 67);
        Color azul = new Color(78, 147, 220);
        //i = vertical, j=horizonatal
        
        /*V*/
        for(int i=80, j=50; i<180 && j<100; i+=2, j+=1)
            auxBuffed.setRGB(j, i, amarillo.getRGB());
        int i1; double j1;
        for(i1=180, j1=100; i1>80 && j1<190; i1--, j1+=0.5)
            auxBuffed.setRGB((int) j1, i1, amarillo.getRGB());
            
        /*A*/
        int i2; double j2;
        for(i2=180, j2=170; i2>80 && j2<220; i2--, j2+=0.4)
            auxBuffed.setRGB((int) j2, i2, rojo.getRGB());

        for(i2=80, j2=210; i2<180 && j2<320; i2+=3.1, j2+=1)
            auxBuffed.setRGB((int) j2, i2, rojo.getRGB());
        for(int j=190; j<228; j++)
            auxBuffed.setRGB(j, 130, rojo.getRGB());
        
        /*N*/
        for(int i=80; i<180; i++)
            auxBuffed.setRGB(280, i, verde.getRGB());
        for(i2=80, j2=280; i2<180 && j2<350; i2+=2.7, j2+=1)
            auxBuffed.setRGB((int) j2, i2, verde.getRGB());
        for(int i=80; i<180; i++)
            auxBuffed.setRGB(330, i, verde.getRGB());
        
        /*E*/
        for(int i=80; i<180; i++)
            auxBuffed.setRGB(370, i, azul.getRGB());
        for(int j=370; j<420; j++)
            auxBuffed.setRGB(j, 80, azul.getRGB());
        for(int j=370; j<400; j++)
            auxBuffed.setRGB(j, 130, azul.getRGB());
        for(int j=370; j<420; j++)
            auxBuffed.setRGB(j, 180, azul.getRGB());
        
        Image imagenResultante = AbrirImagen.toImage(auxBuffed);
        JFrameImagen auxResultante = new JFrameImagen(imagenResultante);
    }
}
