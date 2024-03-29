/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Image;
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
public class JFrame1Umbral extends JFrameImagen{
    public JFrame1Umbral(Seleccion seleccion, Image imagen, Image imagenOriginal, int val){
        super(seleccion, imagen, imagenOriginal, val);
    }
    public JFrame1Umbral(Seleccion seleccion, Image imagen, int val){
        super(seleccion, imagen, val);
    }
    
    @Override
    public void crear(){
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu1 = new JMenu(); //modificar imagen
        JMenu menu2 = new JMenu(); //contraste
        /**/
        JMenu menu3 = new JMenu(); //mostrar
        JMenu menu4 = new JMenu(); //guardar
        //JMenu menu5 = new JMenu(); //filtros
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //umbralizada
        JMenuItem item13 = new JMenuItem(); //binarizacion
        JMenuItem item14 = new JMenuItem(); //Iluminación
        JMenuItem item21 = new JMenuItem(); //lineal
        JMenuItem item22 = new JMenuItem(); //logaritmico
        JMenuItem item23 = new JMenuItem(); //exponencial
        JMenuItem item31 = new JMenuItem(); //histograma
        JMenuItem item32 = new JMenuItem(); //espectro de frecuencia
        item11.setText("En escala de grises");
        item12.setText("Umbralizacion");
        item13.setText("Binarizacion");
        item14.setText("Iluminación");
        item21.setText("Lineal");
        item22.setText("Logaritmico");
        item23.setText("Exponencial");
        item31.setText("Histograma");
        item32.setText("Espectro de frecuencias");
        menu1.setText("Modificar");
        menu2.setText("Contraste");
        menu4.setText("Guardar");
        menu3.setText("Mostrar");
        int sliderMax = ((seleccion == Seleccion.PasaAltas || seleccion == Seleccion.PasaBajas)? 130 : 255);
        if(seleccion == Seleccion.Rotacion) sliderMax=360;
        JSlider slider1 = new JSlider(0,sliderMax,this.umbral1);
        slider1.setMajorTickSpacing((seleccion == Seleccion.PasaAltas || seleccion == Seleccion.PasaBajas)? 25 : 50);
        slider1.setMinorTickSpacing((seleccion == Seleccion.PasaAltas || seleccion == Seleccion.PasaBajas)? 5 : 10);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        JLabel txtValor1 = new JLabel(this.umbral1<10 ? "00"+String.valueOf(this.umbral1) : this.umbral1<100 ? "0"+String.valueOf(this.umbral1) : String.valueOf(this.umbral1));

        slider1.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider1.setValue(slider1.getValue() );
              int valor=slider1.getValue();
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor1.setText(b1);
                umbral1 = valor;
                    if(seleccion == Seleccion.PasaAltas) actualizarImagenPasaAltas();
                    else if(seleccion == Seleccion.PasaBajas) actualizarImagenPasaBajas();
                    else if(seleccion == Seleccion.Rotacion) actualizaImagenRotacion();
                    else if(seleccion == Seleccion.Escalamiento) actualizaImagenEscalamiento();
                    else actualizarImagenIluminacion();
            }
          } );
        
        
        item31.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 histogramaMouseClicked(evt); //histograma
            }
        });
        item32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espectroFrecienciasMouseClicked(evt, imagen); //espectro de frecuencias
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
                expLinMouseClicked(evt); //expansion Lineal
            }
        });
        item22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expLogMouseClicked(evt); //expansion Logaritmica
            }
        });
        item23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expExpMouseClicked(evt); //expansion Exponencial
            }
        });
        
        menu1.add(item11);
        menu1.add(item12);
        menu1.add(item13);
        menu2.add(item21);
        menu2.add(item22);
        menu2.add(item23);
        menu3.add(item31);
        menu3.add(item32);
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
        
        /*MenuBar menuBar = new MenuBar();
        menuBar.add(menu1);
        menuBar.add(menu2);
        setMenuBar(menuBar);*/
    }
}

