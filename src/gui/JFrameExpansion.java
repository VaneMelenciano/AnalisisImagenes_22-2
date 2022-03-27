/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import herramientas.ModificarImagen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Vanessa
 */
public class JFrameExpansion extends JFrameImagen{
    public JFrameExpansion(Seleccion seleccion, Image imagen, int val1, int val2){
       
        super(seleccion, imagen, val1, val2); 
        //System.out.println("Creo frame");
        //lineal: dos paametros
        //exponencial : 1 double
        //logaritmica: 0 parametros
    }
    public JFrameExpansion(Seleccion seleccion, Image imagen, int val1){
        super(seleccion, imagen, val1);
    }
    public JFrameExpansion(Seleccion seleccion, Image imagen, double val1){
        super(seleccion, imagen, val1);
    }
    public JFrameExpansion(Seleccion seleccion, Image imagen){
        super(seleccion, imagen);
    }
    @Override
    public void crear(){
        if(seleccion.equals(seleccion.Lineal)) crearLineal();
        else if(seleccion.equals(seleccion.Exponencial)) crearExponenecial();
        else if(seleccion.equals(seleccion.Logaritmica)){
            JFrameMenu j = new JFrameMenu(this.imagen);
            j.setTitle("Expansion Logaritmica");
        }
        else System.out.println("Buuu");
        //else if(seleccion.equals("Exponencial")) crearExp();
        //else crearLog();
    }
    public void crearLineal(){
        System.out.println("Entro a crear Lineal");
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        actualizarImagenLineal();
        
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu1 = new JMenu(); //modificar imagen
        JMenu menu2 = new JMenu(); //contraste
        JMenu menu3 = new JMenu(); //histograma
        JMenu menu4 = new JMenu(); //guardar
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //umbralizada
        JMenuItem item13 = new JMenuItem(); //binarizacion
        JMenuItem item21 = new JMenuItem(); //lineal
        JMenuItem item22 = new JMenuItem(); //logaritmico
        JMenuItem item23 = new JMenuItem(); //exponencial
        item11.setText("En escala de grises");
        item12.setText("Umbralizacion");
        item13.setText("Binarizacion");
        item21.setText("Lineal");
        item22.setText("Logaritmico");
        item23.setText("Exponencial");
        menu1.setText("Modificar imagen");
        menu2.setText("Contraste");
        menu4.setText("Guardar");
        menu3.setText("Histograma");
        //slider
        JSlider slider1 = new JSlider(0,255,this.umbral1);
        JSlider slider2 = new JSlider(0,255,this.umbral2);
        slider1.setMajorTickSpacing(50);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        slider2.setMajorTickSpacing(50);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintLabels(true);
        slider2.setPaintTicks(true);
        //poner los valores de los slider con 3 digitos
        JLabel txtValor1 = new JLabel(this.umbral1<10 ? "00"+String.valueOf(this.umbral1) : this.umbral1<100 ? "0"+String.valueOf(this.umbral1) : String.valueOf(this.umbral1));
        JLabel txtValor2 = new JLabel(this.umbral2<10 ? "00"+String.valueOf(this.umbral2) : this.umbral2<100 ? "0"+String.valueOf(this.umbral2) : String.valueOf(this.umbral2));
        
        slider1.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider1.setValue(slider1.getValue() );
              int valor=slider1.getValue();
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor1.setText(b1);
                umbral1 = valor;
                actualizarImagenLineal();
            }
          } );
        slider2.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider2.setValue(slider2.getValue());
              int valor=slider2.getValue();
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor2.setText(b1);
              umbral2 = valor;
                actualizarImagenLineal();
            }
          } );
        
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        item11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escalaGrisesMouseClicked(evt, getImagen());
            }
        });
        item12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralizacionMouseClicked(evt, getImagen());
            }
        });
        item13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binarizacionMouseClicked(evt, getImagen());
            }
        });
        item21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expLinMouseClicked(evt, getImagen()); //expansion Lineal
            }
        });
        item22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativoMouseClicked(evt, getImagen());
            }
        });
        item23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativoMouseClicked(evt, getImagen());
            }
        });
        
        menu1.add(item11);
        menu1.add(item12);
        menu1.add(item13);
        menu2.add(item21);
        menu2.add(item22);
        menu2.add(item23);
        opciones.add(menu1);
        opciones.add(menu2);
        opciones.add(menu3);
        opciones.add(menu4);
        
        panelCentral1.setSize(new Dimension(320,29));
        panelCentral1.add(opciones);
        slider1.setLocation(0, 0);
        
        panelCentral2.add(slider1);
        panelCentral2.add(txtValor1);
        panelCentral2.add(slider2);
        panelCentral2.add(txtValor2);
        
        panelCentral2.setSize(new Dimension(480,56));
        panelCentral2.setLocation(0, 30);
        
        add(panelCentral1);
        add(panelCentral2);
        etiqueta1.setLocation(0, 87);
        add(etiqueta1);
        //acomodar tamaño de ventana
        int x = this.imagen.getWidth(null)>=480 ? this.imagen.getWidth(null) : 480;
        setSize(new Dimension(x, this.imagen.getHeight(null) + 200));
        setVisible(rootPaneCheckingEnabled);
    }
    public void crearExponenecial(){
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        actualizarImagenExponencial();
        
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu1 = new JMenu(); //modificar imagen
        JMenu menu2 = new JMenu(); //contraste
        JMenu menu3 = new JMenu(); //histograma
        JMenu menu4 = new JMenu(); //guardar
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //umbralizada
        JMenuItem item13 = new JMenuItem(); //binarizacion
        JMenuItem item21 = new JMenuItem(); //lineal
        JMenuItem item22 = new JMenuItem(); //logaritmico
        JMenuItem item23 = new JMenuItem(); //exponencial
        item11.setText("En escala de grises");
        item12.setText("Umbralizacion");
        item13.setText("Binarizacion");
        item21.setText("Lineal");
        item22.setText("Logaritmico");
        item23.setText("Exponencial");
        menu1.setText("Modificar imagen");
        menu2.setText("Contraste");
        menu4.setText("Guardar");
        menu3.setText("Histograma");
        //slider
        int valor1 = (int) (this.umbral*10); //0.5 = 5
        JSlider slider1 = new JSlider(0,350,valor1);
        slider1.setMajorTickSpacing(50);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        //poner los valores de los slider con 3 digitos
        
        JLabel txtValor1 = new JLabel(String.valueOf(this.umbral));
        //JLabel txtValor1 = new JLabel(this.umbral1<10 ? "00"+String.valueOf(this.umbral1) : this.umbral1<100 ? "0"+String.valueOf(this.umbral1) : String.valueOf(this.umbral1));
        //JLabel txtValor2 = new JLabel(String.valueOf(this.umbral2));
        //JLabel txtValor2 = new JLabel(this.umbral2<10 ? "00"+String.valueOf(this.umbral2) : this.umbral2<100 ? "0"+String.valueOf(this.umbral2) : String.valueOf(this.umbral2));
        
        slider1.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider1.setValue(slider1.getValue() );
              umbral = (double)slider1.getValue()/10; //19 = 19/10 = 1.9
              System.out.println("\t" + umbral);
              double valor = umbral;
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor1.setText(String.valueOf(valor));
                actualizarImagenExponencial();
            }
          } );
        
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        item11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escalaGrisesMouseClicked(evt, getImagen());
            }
        });
        item12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralizacionMouseClicked(evt, getImagen());
            }
        });
        item13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binarizacionMouseClicked(evt, getImagen());
            }
        });
        item21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expLinMouseClicked(evt, getImagen()); //expansion Lineal
            }
        });
        item22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativoMouseClicked(evt, getImagen());
            }
        });
        item23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativoMouseClicked(evt, getImagen());
            }
        });
        
        menu1.add(item11);
        menu1.add(item12);
        menu1.add(item13);
        menu2.add(item21);
        menu2.add(item22);
        menu2.add(item23);
        opciones.add(menu1);
        opciones.add(menu2);
        opciones.add(menu3);
        opciones.add(menu4);
        
        panelCentral1.setSize(new Dimension(320,29));
        panelCentral1.add(opciones);
        slider1.setLocation(0, 0);
        
        panelCentral2.add(slider1);
        panelCentral2.add(txtValor1);
        
        panelCentral2.setSize(new Dimension(480,56));
        panelCentral2.setLocation(0, 30);
        
        add(panelCentral1);
        add(panelCentral2);
        etiqueta1.setLocation(0, 87);
        add(etiqueta1);
        //acomodar tamaño de ventana
        int x = this.imagen.getWidth(null)>=480 ? this.imagen.getWidth(null) : 480;
        setSize(new Dimension(x, this.imagen.getHeight(null) + 200));
        setVisible(rootPaneCheckingEnabled);
    }
}
