/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.JFrameMenu;
import herramientas.AbrirImagen;
import herramientas.ImagenRuido;
import herramientas.Mascara;
import herramientas.ModificarImagen;
import java.awt.Image;

/**
 *
 * @author Vanessa
 */
public class MainRuido {
    public static void main(String[] args){
        //Image original = AbrirImagen.openImage();
        //JFrameMenu jm = new JFrameMenu(original);
        Image ruido = ImagenRuido.crearImagen(0, 400, 500, 0.01F);
        JFrameMenu jm = new JFrameMenu(ruido); jm.setTitle("Con ruido");
        Image sinRuido = ModificarImagen.convolucion(ruido, Mascara.quitarRuido1, 2);
        JFrameMenu jm1 = new JFrameMenu(sinRuido); jm1.setTitle("Sin ruido");
    }
}
