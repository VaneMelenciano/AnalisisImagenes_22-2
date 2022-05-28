/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.JFrameMenu;
import herramientas.AbrirImagen;
import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_BYTE_GRAY;

/**
 *
 * @author Vanessa
 */
public class mainExamen {
    public static void main(String[] args){
        int[][] matriz = {{23, 45, 220, 34}, {11, 30, 11, 34}, {6, 100, 89, 34}, {45, 100, 66, 33}};
        BufferedImage bi = new BufferedImage(4, 4, TYPE_BYTE_GRAY);
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                Color color = new Color(matriz[i][j], matriz[i][j], matriz[i][j]);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        JFrameMenu jm = new JFrameMenu(AbrirImagen.toImage(bi));
    }
}
