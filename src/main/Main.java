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
import herramientas.Mascara;
import herramientas.ModificarImagen;
import herramientas.UmbralAutomatico;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.round;
import java.util.Formatter;
import static java.lang.String.valueOf;
import java.util.Arrays;

/**
 *
 * @author Vanessa
 */
public class Main {
    public static void main(String[] args){
        //Imagen RGB a escala de grises
        Image imagenOriginal = AbrirImagen.openImage();
        JFrameMenu original = new JFrameMenu(imagenOriginal);
        //JFrameMenu original = new JFrameMenu(imagenOriginal);
        
        
        /*Image imagenResultante = ModificarImagen.convertirEscalaGrises(imagenOriginal);
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
        
        //BORDES
        //
        /*int[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
        int[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
        int[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
        int[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
        int[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
        int[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
        int[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
        int[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
        int[][][] arregloMascaras = {kirsch1, kirsch2, kirsch3,
            kirsch4, kirsch5, kirsch6,
            kirsch7, kirsch8};*/
        //Detección de bordes: El operador de Sobel
        /*int[][] m1 = {{-1, 0, 1}, {-2, 0, 2}, {-1,0,1}};
        int[][] m2 = {{-1, -2, -1}, {0, 0, 0}, {1,2,1}};
        int[][][] arregloMascaras = {m1, m2};*/
        //Detección de bordes: El operador de Prewitt
        /*int[][] m1 = {{-1, 0, 1}, {-1, 0, 1}, {-1,0,1}};
        int[][] m2 = {{1, 1, 1}, {0, 0, 0}, {-1,-1,-1}};
        int[][][] arregloMascaras = {m1, m2};*/
       //Extensión de los operadores
        //int [][] m = {{-1, -1, -1, -2, -1, -1, -1}, {-1, -1, -1, -2, -1, -1, -1}, {-1, -1, -1, -2, -1, -1, -1}, {0,0,0,0,0,0,0}, {1, 1, 1, 2, 1, 1, 1}, {1, 1, 1, 2, 1, 1, 1}, {1, 1, 1, 2, 1, 1, 1}};
       //Enfoque
       //int[][] m = {{-2, -1, 0}, {-1,1,1},{0,1,2}}; //repujado
       //Image imagen = AbrirImagen.openImage();
        //JFrameMenu original = new JFrameMenu(imagen); original.setTitle("Original");
        //ModificarImagen.convolucion(imagen, arregloMascaras, 9);
        //ModificarImagen.convolucion(AbrirImagen.toBufferedImage(imagen), arregloMascaras, 9);
        /*Image imagen1 = ModificarImagen.convolucion(imagen, Mascara.prewitt1, 9);
        JFrameMenu nueva = new JFrameMenu(imagen1); nueva.setTitle("s1");
        Image imagen11 = ModificarImagen.convolucion(imagen, Mascara.prewitt2, 9);
        JFrameMenu nueva1 = new JFrameMenu(imagen11); nueva1.setTitle("s2");*/
        //ModificarImagen.convolucion(imagen, Mascara.kirsch, 15);
        //ModificarImagen.convolucion(imagen, Mascara.freichen1, 1/(2+round((float) Math.sqrt(2))));
//        //original.JFrameMenu();
//        Image nuevaImagen1 = ModificarImagen.convertirBinaria(ModificarImagen.convertirEscalaGrises(imagen), 0, 255);
//        JFrameImagen nueva = new JFrameImagen(nuevaImagen1);
//        nueva.JFrame();

        //Image imagen = AbrirImagen.openImage(); 
        //JFrameMenu aux = new JFrameMenu(imagen);
        //Image nueva1 = ModificarImagen.expansionLinal(imagen, 40, 200);
        //Image nueva = ModificarImagen.expansionExp(imagen, 1000000000);
        //Image nueva3 = ModificarImagen.expansionLogaritmica(imagen);
        
        //JFrameImagen aux1 = new JFrameMenu(nueva);
        //aux1.setTitle("lineal");
        
        
        //CONVOLUCION
        //Image nueva = AbrirImagen.openImage(); 
        //Image nueva = ModificarImagen.convertirEscalaGrises(imagen);
        //JFrameMenu aux = new JFrameMenu(nueva);
        //aux.setTitle("Original");
        /*int[][] mascara = new int[][]{{-1,-1,0},
                                      {-1,0,1},
                                      {0,1,1}};*/
        /*int[][] mascara = new int[][]{{-1,-1,0},
                                      {-1,0,1},
                                      {0,1,1}};*/
        /*int[][] mascara = new int[][]{{0,0,0},
                                      {0,2,0},
                                      {0,0,0}};*/
        /*int[][] mascara = new int[][]{{1,1,1},
                                      {1,1,1},
                                      {1,1,1}};*/
        /*int[][] mascara = new int[][]{{2,2,2},
                                      {2,2,2},
                                      {2,2,2}};*/
        /*int[][] mascara = new int[][]{{-1, -1, -1}, 
            {-1,  9, -1}, 
            {-1, -1, -1}};*/
        /*int[][] mascara = new int[][]{{1,  1,  1,  1,  1}, 
            {1,  4,  4,  4,  1}, 
            {1,  4, 12,  4,  1}, 
            {1,  4,  4,  4,  1}, 
            {1,  1,  1,  1,  1}};*/
        /*int[][] mascara = new int[][]{{0,0,0,0,0}, 
            {0,0,-1,0,0}, 
            {0,-1,5,-1,0}, 
            {0,0,-1,0,0}, 
            {0,0,0,0,0}};*/
        /*int[][] mascara = new int[][]{{1,0,-1}, //Gradiente este
                                      {2,0,-2},
                                      {1,0,-1}};*/ //NO SALE
        /*int[][] mascara = new int[][]{{1,2,1},
                                      {2,4,2},
                                      {1,2,1}};*/
        /*int[][] mascara = new int[][]{{-1, -3, -4, -3, -1}, //Nitidez 5x5
                {-3,  0,  6,  0, -3},
                {-4,  6, 21,  6, -4}, 
                {-3,  0,  6,  0, -3},
                {-1, -3, -4, -3, -1}};*/
        /*int[][] mascara = new int[][]{{-1, -1, -1}, 
            {-1,  9, -1}, 
            {-1, -1, -1}};*/
        /*int[][] mascara = new int[][]{{-1, -2, -1},
            { 0,  0,  0},
            { 1,  2,  1}};*/
        /*int[][] mascara = new int[][]{{0,1,0},
            {1,-4,1},
            {0,1,0}};*/
        /*int[][] mascara = new int[][]{{-2,-1,0}, //repujado
            {-1,1,1},
            {0,1,2}};*/
        /*int[][] mascara = new int[][]{{0,0,0,0,0},
            {0,-2,-1,0,0},
            {0,-1,1,1,0},
            {0,0,1,2,0},
            {0,0,0,0,0,}};*/
        /*int[][] mascara = new int[][]{{0,0,0,0,0}, //BORDES
            {0,0,0,0,0},
            {0,-1,1,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0,}};*/
        /*for(int i=0; i<mascara.length; i++){
            System.out.println(Arrays.toString(mascara[i]));
        }*/
        /*int[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
        int[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
        int[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
        int[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
        int[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
        int[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
        int[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
        int[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
        int[][][] arregloMascaras = {kirsch1, kirsch2, kirsch3,
            kirsch4, kirsch5, kirsch6,
            kirsch7, kirsch8};
        Image nueva1 = ModificarImagen.convolucion(nueva, kirsch1, 9);
        JFrameImagen aux1 = new JFrameMenu(nueva1); aux1.setTitle("kirsch1");
        Image nueva2 = ModificarImagen.convolucion(nueva, kirsch2, 9);
        JFrameImagen aux2 = new JFrameMenu(nueva2); aux1.setTitle("kirsch2");
        Image nueva3 = ModificarImagen.convolucion(nueva, kirsch3, 9);
        JFrameImagen aux3 = new JFrameMenu(nueva3); aux1.setTitle("kirsch3");
        Image nueva4 = ModificarImagen.convolucion(nueva, kirsch4, 9);
        JFrameImagen aux4 = new JFrameMenu(nueva4); aux1.setTitle("kirsch4");
        Image nueva5 = ModificarImagen.convolucion(nueva, kirsch5, 9);
        JFrameImagen aux5 = new JFrameMenu(nueva5); aux1.setTitle("kirsch5");
        Image nueva6 = ModificarImagen.convolucion(nueva, kirsch6, 9);
        JFrameImagen aux6 = new JFrameMenu(nueva6); aux1.setTitle("kirsch6");
        Image nueva7 = ModificarImagen.convolucion(nueva, kirsch7, 9);
        JFrameImagen aux7 = new JFrameMenu(nueva7); aux1.setTitle("kirsch7");
        Image nueva8 = ModificarImagen.convolucion(nueva, kirsch8, 9);
        JFrameImagen aux8 = new JFrameMenu(nueva8); aux1.setTitle("kirsch8");*/
        /*for(int i=1; i<30; i++){
          Image nueva1 = ModificarImagen.convolucion(imagen, mascara, i);
            JFrameImagen aux1 = new JFrameMenu(nueva1); 
            aux1.setTitle(i+"");
        }*/
        //JFrameImagen aux2 = new JFrameMenu(nueva2);
        //aux2.setTitle("Exponencial");
        //JFrameImagen aux3 = new JFrameMenu(nueva3);
        //aux3.setTitle("Logaritmica");
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
        
        
        //SISTEMA DE CAPTURA DE IMAGENES
        /*
        Preprocesamiento: 
            -Escala de grises
            -Mejorar el contraste -> mejor ecualizacion
            -Binarizacion automatica -Z segmentación 
        */
        /*Image imagen = AbrirImagen.openImage(); 
        JFrameMenu aux1 = new JFrameMenu(imagen); aux1.setTitle("Original");
        Image nueva = ModificarImagen.convertirEscalaGrises(imagen);
        JFrameMenu aux2 = new JFrameMenu(nueva); aux2.setTitle("Blanco y negro");
        Image nueva1 = ModificarImagen.ecualizacion1(nueva);
        JFrameMenu aux3 = new JFrameMenu(nueva1); aux3.setTitle("nueva");*/
        /*Image imagen44 = AbrirImagen.openImage(); 
        JFrameMenu aux1 = new JFrameMenu(imagen44); aux1.setTitle("Original");
        Image imagen45 = ModificarImagen.negativo(imagen44);
        JFrameMenu aux11 = new JFrameMenu(ModificarImagen.negativo(imagen45)); 
        aux1.setTitle("Original");*/
        //Histograma.crearCanales(imagen);
        //Image nueva = ModificarImagen.ecualizacion(imagen, Histograma.getR(), Histograma.getG(), Histograma.getB());
        //JFrameMenu aux12= new JFrameMenu(nueva); aux1.setTitle("Nueva");
        
        //String y = "5.754316264";
        //System.out.println(String.format("%3.3f", 5.56733D));
    }
}
