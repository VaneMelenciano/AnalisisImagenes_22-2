/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.JFrameImagen;
import herramientas.AbrirImagen;
import herramientas.HistogramaColores;
import java.awt.Image;
import java.io.IOException;

/**
 *
 * @author Vanessa
 */
public class Main {
    public static void main(String[] args){
        //Imagen RGB a escala de grises
        /*Image imagenOriginal = AbrirImagen.openImage();
        JFrameImagen original = new JFrameImagen(imagenOriginal);
        Image imagenResultante = RGBaEscalaGrises.convertir(imagenOriginal);
        JFrameImagen auxResultante = new JFrameImagen(imagenResultante, 1);*/
        
        Image imagenOriginal = AbrirImagen.openImage();
        JFrameImagen original = new JFrameImagen(imagenOriginal);
        HistogramaColores h = new HistogramaColores(imagenOriginal);
        
    }
}
