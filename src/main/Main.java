/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.JFrameImagen;
import gui.JFrameMenu;
import gui.JFrameUmbral;
import gui.Seleccion;
import herramientas.AbrirImagen;
import herramientas.Histograma;
import herramientas.ModificarImagen;
import herramientas.UmbralAutomatico;
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
        Image imagenResultante = ModificarImagen.convertirEscalaGrises(imagenOriginal);
        JFrameImagen auxResultante = new JFrameImagen(imagenResultante);
        auxResultante.JFrameMenu();*/
        
        //Histograma de colores
        /*Image imagenOriginal = AbrirImagen.openImage();
        JFrameImagen original = new JFrameImagen(imagenOriginal);
        Histograma h = new Histograma(imagenOriginal);*/
        
        //Cambiar iluminación a una imagen
            //original
//        Image imagenOriginal = AbrirImagen.openImage();
//        JFrameImagen original = new JFrameImagen(imagenOriginal);
//        original.setTitle("Imagen Orignal");
//        Histograma.crear(imagenOriginal, "Imagen Original");
            //nueva
//        Image nuevaImagen = ModificarImagen.modificarIluminacion(imagenOriginal, 30);
//        JFrameImagen nueva = new JFrameImagen(nuevaImagen);
//        nueva.setTitle("Imagen Nueva");
//        Histograma.crear(nuevaImagen, "Imagen Nueva");
        

        //Ubralización de imagen
            /*original*/
        /*Image imagenOriginal = AbrirImagen.openImage();
        JFrameImagen original = new JFrameImagen(imagenOriginal);
        original.JFrame();
        original.setTitle("Imagen Orignal");
        Histograma.crear(imagenOriginal, "Imagen Original");*/
            /*nueva*/
        /*int u1=254, u2=255; //fruta
        Image nuevaImagen = ModificarImagen.umbralizacion(imagenOriginal, u1, u2);
        //int u=78;
        //Image nuevaImagen = ModificarImagen.umbralizacion(imagenOriginal, u);
        JFrameImagen nueva = new JFrameImagen(nuevaImagen);
        nueva.JFrame();
        nueva.setTitle("Imagen Nueva " + u1 +", " + u2);
        Histograma.crear(nuevaImagen, "Imagen Nueva"); */
        
        
        
//       Image imagen = AbrirImagen.openImage();
//        //JFrameImagen original = new JFrameImagen(imagen);
//        //original.JFrameMenu();
//        Image nuevaImagen1 = ModificarImagen.convertirBinaria(ModificarImagen.convertirEscalaGrises(imagen), 0, 255);
//        JFrameImagen nueva = new JFrameImagen(nuevaImagen1);
//        nueva.JFrame();

        Image imagen = AbrirImagen.openImage(); 
        JFrameMenu aux = new JFrameMenu(imagen);
//        int[] canal = Histograma.crearBN(imagen);
//        double[] nuevo = new double[canal.length];
//        for(int i=0; i<canal.length; i++){
//            nuevo[i] = canal[i];
//        }
//        int j= UmbralAutomatico.metodoIterativo(nuevo);
//        JFrameUmbral auxResultante = new JFrameUmbral(Seleccion.Umbralizacion, imagen, j, 255);
        //Image nueva = ModificarImagen.cambiarTemperatura(imagen, -50);
        //JFrameMenu auxResultante = new JFrameMenu(nueva);
//        int j = ModificarImagen.umbralizacionAuto2(Histograma.crearBN(imagen));
//        System.out.println(j);
//        Image nueva = ModificarImagen.umbralizacion(imagen, j, 255);
//        JFrameMenu auxResultante = new JFrameMenu(nueva);
//        
        
        //JFrameImagen aux = new JFrameImagen(imagen);
        //Image nueva = ModificarImagen.negativo(imagen);
        //JFrameImagen aux1 = new JFrameImagen(nueva);
        
        //int u1=0, u2=255;
       /*int u1=39, u2=255;
        Image imagen= AbrirImagen.openImage();
        //Image nuevaImagen = ModificarImagen.umbralizacion(imagen, u1, u2);
        JFrameImagen auxResultante = new JFrameImagen(imagen);
        auxResultante.JFumbral(u1, u2);
        auxResultante.setTitle("Imagen con umbrales");*/
        
        /*nueva*/
        /*int u11=255, u21=255; //fruta
        Image nuevaImagen1 = ModificarImagen.umbralizacion(imagen, u11, u21);
        JFrameImagen nueva = new JFrameImagen(nuevaImagen1);
        nueva.JFrame();*/
        
    }
}
