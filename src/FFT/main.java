/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFT;

import Filtros.FiltroIdealPasaAltas;
import Filtros.FiltroIdealPasaBajas;
import gui.JFrameMenu;
import herramientas.AbrirImagen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Vanessa
 */
public class main {
    public static void main(String[] args) {

       Image imagenO = AbrirImagen.openImage();
      JFrameMenu frame1 = new JFrameMenu(imagenO); //Original
      frame1.setTitle("Imagen original");
      Gestor gestor = new Gestor(AbrirImagen.toBufferedImage(imagenO));
      BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
      JFrameMenu frame2 = new JFrameMenu(AbrirImagen.toImage(iFre)); //Frecuancias de original
      frame2.setTitle("Espectro de frecuencia original");
     
        // creamos el filtro
        FiltroIdealPasaAltas fipb = new FiltroIdealPasaAltas(22,new Dimension(256, 256));
        //FiltroIdealPasaBajas fipb = new FiltroIdealPasaBajas(74,new Dimension(256, 256));
        fipb.crearFiltro();
        NumeroComplejo[][] filtro = fipb.getFiltroEspacial(); 
        
        //
        JFrameMenu frameFil = new JFrameMenu(fipb.getImagen()); //Filtrado
        frameFil.setTitle("filtrado");
        
        gestor.aplicarFiltro(filtro);
        
        //BufferedImage iFre1 = gestor.obtenerImagenFrecuencias(true);
      //JFrameMenu frame11 = new JFrameMenu(AbrirImagen.toImage(iFre1));
        //Frecuancias con filtrado
        //gestor.obtenerImagenFrecuencias(true);
      
      BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
       JFrameMenu frame = new JFrameMenu(AbrirImagen.toImage(imagenEspacial));  //resultantes
       frame.setTitle("Imagen resultante");
       
       //NO EN SLIDER!!!!!!
      BufferedImage iFre1 = gestor.obtenerImagenFrecuencias(true);
      JFrameMenu frame11 = new JFrameMenu(AbrirImagen.toImage(iFre1));
     frame11.setTitle("Espectro de frecuencia resultante");
    
    }
}
