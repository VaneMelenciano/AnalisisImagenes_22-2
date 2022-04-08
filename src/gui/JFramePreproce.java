/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
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
 * 
 * JFrame para Preprocesamiento
 */
public class JFramePreproce extends JFrameImagen{
    public JFramePreproce(Image imagen, int proc){
        super(imagen, proc);
    }

    JFramePreproce(Image imagen, int umbral1, int umbral2, int proc) {
        super(imagen, umbral1, umbral2, proc);
    }
    
    @Override
    public void crear(){
        /*-Escala de grises
            -Mejorar el contraste
            -Binarizacion automatica*/
        if(this.proc==1) escalaGrises();
        //else if(this.proc==2) ecualizacion();//contraste();
        else if(this.proc==2) contraste();
        else binarizacion();
    }

    private void ecualizacion() {
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        
        JPanel panelCentral1 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu2 = new JMenu(); //Siguiente
        JMenu menu3 = new JMenu(); //histograma
        JMenu menu4 = new JMenu(); //guardar
        menu2.setText("Siguiente");
        menu4.setText("Guardar");
        menu3.setText("Histograma");
        
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proc3MouseClicked(evt, getImagen());
            }
        });
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt, "Prepro1");
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        opciones.add(menu2);
        opciones.add(menu3);
        opciones.add(menu4);
        
        panelCentral1.setSize(new Dimension(320,29));
        panelCentral1.add(opciones);
        
        add(panelCentral1);
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

    private void escalaGrises() {
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        
        JPanel panelCentral1 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu2 = new JMenu(); //Siguiente
        JMenu menu3 = new JMenu(); //histograma
        JMenu menu4 = new JMenu(); //guardar
        menu2.setText("Siguiente");
        menu4.setText("Guardar");
        menu3.setText("Histograma");
        
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proc2MouseClicked(evt);
                //proc2MouseClickedEcualizacion(evt);
            }
        });
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt, "Prepro1");
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        opciones.add(menu2);
        opciones.add(menu3);
        opciones.add(menu4);
        
        panelCentral1.setSize(new Dimension(320,29));
        panelCentral1.add(opciones);
        
        add(panelCentral1);
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
    
    private void contraste() {
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        actualizarImagenLineal();
        
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu2 = new JMenu(); //siguiente
        JMenu menu3 = new JMenu(); //histograma
        JMenu menu4 = new JMenu(); //guardar
        menu2.setText("Siguiente");
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
        
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proc3MouseClicked(evt, getImagen());
            }
        });
        
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt, "Prepro12");
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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

    private void binarizacion() {
        etiqueta1 = new JLabel(new ImageIcon(this.imagen));
        actualizarImagenBinaria();
        
        JPanel panelCentral1 = new JPanel();
        JPanel panelCentral2 = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu3 = new JMenu(); //histograma
        JMenu menu4 = new JMenu(); //guardar
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
                proc3MouseClicked(evt, getImagen());
            }
        });
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt,"Prepro3");
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
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
}
