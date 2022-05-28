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
public class JFrameUmbral extends JFrameImagen{
    public JFrameUmbral(Seleccion seleccion, Image imagen, int val1, int val2){
        super(seleccion, imagen, val1, val2);
    }
    
    public void crear(){
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        
        if(seleccion.equals(seleccion.Umbralizacion))
            actualizarImagen();
        else if(seleccion.equals(seleccion.Binarizacion))
            actualizarImagenBinaria();
        
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu1 = new JMenu(); //modificar imagen
        JMenu menu2 = new JMenu(); //contraste
        /**/
        JMenu menu3 = new JMenu(); //mostrar
        JMenu menu4 = new JMenu(); //guardar
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //umbralizada
        JMenuItem item13 = new JMenuItem(); //binarizacion
        JMenuItem item14 = new JMenuItem(); //ecualizacion
        JMenuItem item21 = new JMenuItem(); //lineal
        JMenuItem item22 = new JMenuItem(); //logaritmico
        JMenuItem item23 = new JMenuItem(); //exponencial
        JMenuItem item41 = new JMenuItem(); //histograma
        JMenuItem item42 = new JMenuItem(); //espectro de frecuencia
        item11.setText("En escala de grises");
        item12.setText("Umbralizacion");
        item13.setText("Binarizacion");
        item14.setText("Ecualización");
        item21.setText("Lineal");
        item22.setText("Logaritmico");
        item23.setText("Exponencial");
        item41.setText("Histograma");
        item42.setText("Espectro de frecuencias");
        menu1.setText("Modificar");
        menu2.setText("Contraste");
        menu4.setText("Guardar");
        menu3.setText("Histograma");
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
        JLabel txtValor1 = new JLabel(this.umbral1<10 ? "00"+String.valueOf(this.umbral1) : this.umbral1<100 ? "0"+String.valueOf(this.umbral1) : String.valueOf(this.umbral1));
        JLabel txtValor2 = new JLabel(this.umbral2<10 ? "00"+String.valueOf(this.umbral2) : this.umbral2<100 ? "0"+String.valueOf(this.umbral2) : String.valueOf(this.umbral2));
        
        slider1.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider1.setValue(slider1.getValue() );
              int valor=slider1.getValue();
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor1.setText(b1);
                umbral1 = valor;
                if(seleccion.equals("Umbralizacion")) actualizarImagen();
                else actualizarImagenBinaria();
            }
          } );
        slider2.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              slider2.setValue(slider2.getValue());
              int valor=slider2.getValue();
              String b1 = (valor<10 ? "00"+String.valueOf(valor) : valor<100 ? "0"+String.valueOf(valor) : String.valueOf(valor));
              txtValor2.setText(b1);
              umbral2 = valor;
                if(seleccion.equals("Umbralizacion")) actualizarImagen();
                else actualizarImagenBinaria();
            }
          } );
        
        
        item41.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 histogramaMouseClicked(evt); //histograma
            }
        });
        item42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espectroFrecienciasMouseClicked(evt); //espectro de frecuencias
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
        item14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecualizacionMouseClicked(evt, getImagen());
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
        menu1.add(item14);
        menu2.add(item21);
        menu2.add(item22);
        menu2.add(item23);
        menu4.add(item41);
        menu4.add(item42);
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
        
        /*MenuBar menuBar = new MenuBar();
        menuBar.add(menu1);
        menuBar.add(menu2);
        setMenuBar(menuBar);*/
    }
}
