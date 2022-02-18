/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart; //grafica
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries; //serie: por cada metodo de ordenamiento 
import org.jfree.data.xy.XYSeriesCollection; //coleccion de las series, en este caso 3 (bt, bo, in)
/**
 *
 * @author Vanessa
 */
public class Grafica {
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX, ejeY,titulo, titulo1;

    public Grafica(String ejeX, String ejeY, String titulo, String titulo1) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.titulo = titulo;
        this.titulo1=titulo1;
    }
    public void agregarSerie(String nombre){
        XYSeries serie = new XYSeries(nombre);
        this.series.addSeries(serie);
    }
    public void agregarDatoASerie(String nombre, XYDataItem dato){
       this.series.getSeries(nombre).add(dato);
    }
    public void agregarSerie(String nombre, double[] datos){
    
        XYSeries serie = new XYSeries(nombre);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
        }
        // agregamos la serie que se generó 
        this.series.addSeries(serie);
     
    }
    public void agregarSerie(String nombre, int datos[]){
    
        XYSeries serie = new XYSeries(nombre);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
        }
        // agregamos la serie que se generó 
        this.series.addSeries(serie);
     
    }
    
    public void crearYmostrarGrafica(){
    
        this.grafica = ChartFactory.createXYLineChart(titulo, ejeX, ejeY, series); //linea
        //this.grafica = ChartFactory.createScatterPlot(this.titulo, ejeX, ejeX, series); //puntos
        ChartFrame frame = new ChartFrame(titulo1, grafica);
        frame.setVisible(true);
        
        
    }
     /*public static void graficar(ArrayList<Patron> instancias, String tituloGrafica, String titulo){
        // 0,1,2,3
        // recorrer las instancias y verificar los datos para crear las series
        ArrayList<String> clusters = new ArrayList<>();
        Grafica grafica = new Grafica("ejex", "ejeY", tituloGrafica, titulo);
        clusters.add(instancias.get(0).getClaseResultante());
        grafica.agrearSerie(""+instancias.get(0).getClaseResultante());
        for(Patron aux: instancias){
            // verificar si ya existe en instancias un clase igual
         if(!clusters.contains(aux.getClaseResultante())){
             // se agrega
             clusters.add(aux.getClaseResultante());
             grafica.agrearSerie(""+aux.getClaseResultante());
         }
        }
        // agregar los datos a la serie con las clases involucradas
        for(Patron aux: instancias){
            double datos [] = aux.getVector();
            XYDataItem dato = new XYDataItem(datos[0], datos[1]);
            grafica.agregarDatoASerie(aux.getClaseResultante(),dato);
        }
        // generar la grafica

        grafica.crearYmostrarGrafica();
    }*/ 
}

