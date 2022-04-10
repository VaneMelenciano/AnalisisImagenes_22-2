/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import static java.lang.Math.round;

/**
 *
 * @author Vanessa
 */
//https://programmerclick.com/article/5690865983/
//http://support.ptc.com/help/mathcad/es/index.html#page/PTC_Mathcad_Help/example_convolution_edge_finders.html

//Mascaras para coonvolucion

public class Mascara {
    //BORDES
            //Extensión de los operadores anteior
    public static int [][] extensionOp = {{-1, -1, -1, -2, -1, -1, -1}, {-1, -1, -1, -2, -1, -1, -1}, {-1, -1, -1, -2, -1, -1, -1}, {0,0,0,0,0,0,0}, {1, 1, 1, 2, 1, 1, 1}, {1, 1, 1, 2, 1, 1, 1}, {1, 1, 1, 2, 1, 1, 1}};   
            //Kirsch
    public static int[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
    public static int[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
    public static int[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
    public static int[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
    public static int[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
    public static int[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
    public static int[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
    public static int[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
    public static int[][][] kirsch = {kirsch1, kirsch2, kirsch3,
            kirsch4, kirsch5, kirsch6,
            kirsch7, kirsch8};
        //Detección de bordes: El operador de Sobel
    public static int[][] sobel1 = {{-1, 0, 1}, {-2, 0, 2}, {-1,0,1}};
    public static int[][] sobel2 = {{-1, -2, -1}, {0, 0, 0}, {1,2,1}};
    public static int[][][] sobel = {sobel1, sobel2};
        //Detección de bordes: El operador de Prewitt
    public static int[][] prewitt1 = {{-1, 0, 1}, {-1, 0, 1}, {-1,0,1}};
    public static int[][] prewitt2 = {{1, 1, 1}, {0, 0, 0}, {-1,-1,-1}};
    public static int[][][] prewitt = {prewitt1, prewitt2};
    
    public static int[][] freichen1 = {{1,0,-1},
                            {round((float) Math.sqrt(2)),0,round((float) (Math.sqrt(2)*(-1)))},
                            {1,0,-1}};
    public static int[][] freichen2 = {{-1,round((float) (Math.sqrt(2)*(-1))),-1},
                            {0,0,0},
                            {1,round((float) Math.sqrt(2)),1}};
    //EFECTOS
    public static int[][] repujado = {{-2, -1, 0}, {-1,1,1},{0,1,2}}; //repujado
    
    public static int[][] nitidez = new int[][]{{-1, -3, -4, -3, -1}, //Nitidez 5x5
                {-3,  0,  6,  0, -3},
                {-4,  6, 21,  6, -4}, 
                {-3,  0,  6,  0, -3},
                {-1, -3, -4, -3, -1}};
    
    public static int[][] n={{1,1,1},
                            {1,-7,1},
                            {1,1,1}};
    
    //filtro de grabación en relieve
        //filtro de alivio de 45 grados.
    public static int[][] alivio={{-1,-1,0},
                            {-1,0,1},
                            {0,1,1}};
    
    //QUITAR RUIDO
    public static int[][] quitarRuido1 = {{0,1,0}, //funciona dividiendo de 70 para arriba
                                        {1,0,1},
                                        {0,1,0}};
}
