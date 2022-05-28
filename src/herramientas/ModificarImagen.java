/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import gui.JFrameImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        int aux1 = validarColores(c.getRed()+valor);
        int aux2 = c.getGreen();
        int aux3 = validarColores(c.getBlue()-valor);
        return new Color(aux1, aux2, aux3);
    }
    private static Color aFrio(Color c, int valor){
        //R++ B--
        int aux1 = validarColores(c.getRed()-valor);
        int aux2 = c.getGreen();
        int aux3 = validarColores(c.getBlue()+valor);
        /*int aux1 = c.getRed()-valor, aux2 = c.getGreen(), aux3 = c.getBlue()+valor;
        aux1 = ((aux1>=255) ? 255 : aux1);
        aux3 = ((aux3>=255) ? 255 : aux3);
        
        aux1 = ((aux1<=0) ? 0 : aux1);
        aux3 = ((aux3<=0) ? 0 : aux3);*/
        return new Color(aux1, aux2, aux3);
    }
    
    public static Image expansionLinal(Image imagen, int r1, int r2){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                    Color c = new Color(auxBuffed.getRGB(i, j));
                    int aux;
                    if(r2==r1) aux = 255/1;
                    else aux = 255/(r2-r1);
                    int r = validarColores((c.getRed() - r1) * aux);
                    int g = validarColores((c.getGreen()-r1)*aux);
                    int b = validarColores((c.getBlue() - r1)*aux);
                    Color nuevo = new Color (r, g, b);
                    auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
    }
    public static Image expansionLogaritmica(Image imagen){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                    Color c = new Color(auxBuffed.getRGB(i, j));
                    int aux = (int) (Math.log(1+255));
                    int r = validarColores((int) ((255*Math.log(1+c.getRed()))/aux));
                    int g = validarColores((int) ((255*Math.log(1+c.getGreen()))/aux));
                    int b = validarColores((int) ((255*Math.log(1+c.getBlue()))/aux));
                    Color nuevo = new Color (r, g, b);
                    auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
    }
    public static Image expansionExp(Image imagen, double z){
        if(z<=0) z=0.01;
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        int ancho = auxBuffed.getWidth();
        int alto = auxBuffed.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                    Color c = new Color(auxBuffed.getRGB(i, j));
                    int aux = (int) (Math.log(1+255));
                    //int r = validar((int) (Math.pow(1+z,c.getRed())/z));
                    //int r = validar((int) (Math.pow(c.getRed(), 1 + z) / z));
                    int r = validarColores((int) (Math.pow(c.getRed(), 1 + z) / z));
                    
                    int g = validarColores((int) (Math.pow(c.getGreen(), 1 + z) / z));
                    int b = validarColores((int) (Math.pow(c.getBlue(), 1 + z) / z));
                    Color nuevo = new Color (r, g, b);System.out.println(r + "  " + g + "  " + b +"  ");
                    auxBuffed.setRGB(i, j, nuevo.getRGB());
            }
        }
        return AbrirImagen.toImage(auxBuffed); 
    }
    
    public static int validarColores(int aux1){
        aux1 = Math.abs(aux1);
        aux1 = ((aux1>=255) ? 255 : aux1);
        aux1 = ((aux1<=0) ? 0 : aux1);
        return aux1;
    }
    
    public static BufferedImage convolucion(BufferedImage aux1, int[][] mascara, int c){ //BIEN
        BufferedImage auxBuffedNuevo = new BufferedImage(aux1.getWidth(), aux1.getHeight(), BufferedImage.TYPE_INT_BGR);//AbrirImagen.toBufferedImage(imagen);
        int[] centro = {((mascara.length-1)/2), ((mascara[0].length-1)/2)}; //posicion de la casilla central de la mascara
        int ancho = aux1.getWidth();
        int alto = aux1.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                    //System.out.println("i: "+ i + "  j: " + j);
                    int sumaR = 0; 
                    int sumaG = 0; 
                    int sumaB = 0; 
                    int peso = 0;
                    boolean bandera = false;
                    int[] distancia = {j-centro[0], i-centro[1]}; //distancia entre el pixel y casilla central de la mascara
                    for(int k=0; k<mascara.length; k++){ //recorre mascara
                        for(int p=0; p<mascara[0].length; p++){
                            int[] pos = {(p + distancia[1]), (k + distancia[0])}; //posicion en el buffered
                            //System.out.println("\timagen: " + pos[0] + " " + pos[1] + "  mascara: "+k+", "+p);
                            
                            if((pos[0]>=0) && (pos[0]<ancho)  && (pos[1]>=0) && (pos[1]<alto)){
                                Color cAux = new Color(aux1.getRGB(pos[0], pos[1]));
                                sumaR+=(cAux.getRed()*mascara[k][p]); 
                                sumaG+=(cAux.getGreen()*mascara[k][p]); 
                                sumaB+=(cAux.getBlue()*mascara[k][p]); 
                                peso += Math.abs(mascara[k][p]);
                                bandera = true;
                            }
                        }
                    }
                    if(bandera==true)auxBuffedNuevo.setRGB(i, j, new Color(validarColores(sumaR/c), validarColores(sumaG/c), validarColores(sumaB/c)).getRGB());
                    //if(bandera==true)auxBuffedNuevo.setRGB(i, j, new Color(validar(sumaR/peso), validar(sumaG/peso), validar(sumaB/peso)).getRGB());
            }
        }
        return auxBuffedNuevo;
    }
    public static Image convolucion(Image imagen, int[][] mascara, int c){ //BIEN
        BufferedImage aux1 = AbrirImagen.toBufferedImage(imagen);
        BufferedImage auxBuffedNuevo = new BufferedImage(aux1.getWidth(), aux1.getHeight(), BufferedImage.TYPE_INT_BGR);//AbrirImagen.toBufferedImage(imagen);
        int[] centro = {((mascara.length-1)/2), ((mascara[0].length-1)/2)}; //posicion de la casilla central de la mascara
        int ancho = aux1.getWidth();
        int alto = aux1.getHeight();
        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                    //System.out.println("i: "+ i + "  j: " + j);
                    int sumaR = 0; 
                    int sumaG = 0; 
                    int sumaB = 0; 
                    int peso = 0;
                    boolean bandera = false;
                    int[] distancia = {j-centro[0], i-centro[1]}; //distancia entre el pixel y casilla central de la mascara
                    for(int k=0; k<mascara.length; k++){ //recorre mascara
                        for(int p=0; p<mascara[0].length; p++){
                            int[] pos = {(p + distancia[1]), (k + distancia[0])}; //posicion en el buffered
                            //System.out.println("\timagen: " + pos[0] + " " + pos[1] + "  mascara: "+k+", "+p);
                            
                            if((pos[0]>=0) && (pos[0]<ancho)  && (pos[1]>=0) && (pos[1]<alto)){
                                Color cAux = new Color(aux1.getRGB(pos[0], pos[1]));
                                sumaR+=(cAux.getRed()*mascara[k][p]); 
                                sumaG+=(cAux.getGreen()*mascara[k][p]); 
                                sumaB+=(cAux.getBlue()*mascara[k][p]); 
                                peso += Math.abs(mascara[k][p]);
                                bandera = true;
                            }
                        }
                    }
                    if(bandera==true)auxBuffedNuevo.setRGB(i, j, new Color(validarColores(sumaR/c), validarColores(sumaG/c), validarColores(sumaB/c)).getRGB());
            }
        }
        return auxBuffedNuevo;
    }
    
    public static void convolucion(BufferedImage auxBuffed, int[][][] mascara, int c){
        //Muestra cada fase de las mascaras independientes
        for(int i=0; i<mascara.length; i++){
            System.out.println("i: " + i);
            int[][] m = mascara[i];
            BufferedImage auxBuffed1 = convolucion(auxBuffed, m, c);
            JFrameImagen ji = new JFrameImagen(AbrirImagen.toImage(auxBuffed1)); ji.setTitle(i+" ");
            try {
                AbrirImagen.saveImage(auxBuffed1, "Prewitt" + i);
            } catch (IOException ex) {
                Logger.getLogger(ModificarImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static Image convolucion(Image imagen, int[][][] mascara, int c){
        BufferedImage auxBuffed = AbrirImagen.toBufferedImage(imagen);
        for(int i=0; i<mascara.length; i++){
            int[][] m = mascara[i];
            auxBuffed = convolucion(auxBuffed, m, c);
            JFrameImagen ji = new JFrameImagen(AbrirImagen.toImage(auxBuffed)); ji.setTitle(i+" ");
        }
        
        return AbrirImagen.toImage(auxBuffed);
    }
    
  
    public static Image ecualizacion(Image imagen, int[] R, int[] G, int[] B){
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        //R =
        //G =
        //B = 
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
                color = new Color(bi.getRGB(x, y));
                int r = color.getRed();
                int g = color.getRed();
                int b = color.getRed();
                int r2 =ecualizacion1(imagen, R)[r];
                int g2 =ecualizacion1(imagen, G)[g];
                int b2 =ecualizacion1(imagen, B)[b];
                // 
                color = new Color(r2,g2,b2);     
                bi.setRGB(x,y,color.getRGB());
            }
        return AbrirImagen.toImage(bi);
    }
    private static int[] ecualizacion1(Image imagen, int[] canal){
        int nxm = imagen.getWidth(null)*imagen.getHeight(null);
        //Histograma.crear(imagen, "Ecualizar imagen");
        //int[] ho = Histograma.getR();
        int[] ho = canal;
        double[] daf = new double[256];
        int[] nt = new int[256];
        daf[0] = (int)ho[0];
        nt[0] = (int)Math.round((daf[0]/nxm)*255);
        // recorremos el histograma para acumular
        for(int x=1; x<ho.length;x++){
            daf[x] = (int)(ho[x]+daf[x-1]);
            double aux = daf[x]/nxm;
            int tmp = (int) Math.round(aux * 255);
            nt[x] = tmp;
        }
        return nt;
    }
    
    public static Image ecualizacion11(Image imagen, int[] canal)/*Original profe*/{
        int nxm = imagen.getWidth(null)*imagen.getHeight(null);
        //Histograma.crear(imagen, "Ecualizar imagen");
        //int[] ho = Histograma.getR();
        int[] ho = canal;
        double[] daf = new double[256];
        int[] nt = new int[256];
        daf[0] = (int)ho[0];
        nt[0] = (int)Math.round((daf[0]/nxm)*255);
        // recorremos el histograma para acumular
        for(int x=1; x<ho.length;x++){
            daf[x] = (int)(ho[x]+daf[x-1]);
            double aux = daf[x]/nxm;
            int tmp = (int) Math.round(aux * 255);
            nt[x] = tmp;
        }
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
                color = new Color(bi.getRGB(x, y));
                int t = color.getRed();
                int t2 =nt[t];
                color = new Color(t2,t2,t2);     
                bi.setRGB(x,y,color.getRGB());
            }
        return AbrirImagen.toImage(bi);
    }
    public static Image ecualizacion2(Image imagenOriginal)/*Original profe*/{
         Histograma.crear(imagenOriginal, "Ecualizar imagen");
        int[] histograma = Histograma.getR();
      // calculamos nxm
      int nxm = imagenOriginal.getHeight(null)*imagenOriginal.getWidth(null);
      // declaramos el nuevo histograma
      int[] ecualizacion= new int[256];
      for(int g=0; g<256;g++){
          double tmp = 0;
        for(int i=0; i <=g;i++)
            tmp+=histograma[i];
        
        tmp/=nxm;
        ecualizacion[g]= (int)Math.round(tmp*255);
      }
      // modificamos la imagen 
        BufferedImage bio = AbrirImagen.toBufferedImage(imagenOriginal);//ImageManager.toBufferedImage(imagenOriginal);
        BufferedImage nueva = new BufferedImage(imagenOriginal.getWidth(null)
                                  , imagenOriginal.getHeight(null),BufferedImage.TYPE_INT_RGB);
        for(int y=0; y<imagenOriginal.getHeight(null);y++)
            for(int x=0; x<imagenOriginal.getWidth(null);x++){
             // modificar el tono de la imagen en base al nuevo 
             // histograma
             Color color = new Color(bio.getRGB(x, y));
             int v = ecualizacion[color.getRed()];
             color = new Color(v, v, v);
             nueva.setRGB(x, y, color.getRGB());
            }
            
        return AbrirImagen.toImage(nueva);
    }
}
