/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import herramientas.AbrirImagen;
import herramientas.Histograma;
import modificarImagen.ModificarImagen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
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

/**
 *
 * @author Vanessa
 */
public class JFrameMenu extends JFrameImagen{
    
    public JFrameMenu(Image imagen){
        super(imagen);
    }
    
    public void crear(){
        JLabel etiqueta = new JLabel(new ImageIcon(this.imagen));
        
        JPanel panelCentral = new JPanel();
        JMenuBar opciones = new JMenuBar(); //opciones
        JMenu menu1 = new JMenu(); //modificar imagen
        JMenu menu2 = new JMenu(); //contraste
        JMenu menu3 = new JMenu(); //mostrar
        /**/
        JMenu menu4 = new JMenu(); //Mostrar su
        JMenu menu5 = new JMenu(); //guardar
        JMenu menu6 = new JMenu(); //filtros
        JMenu menu7 = new JMenu(); //operaciones morfologicas
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //umbralizada
        JMenuItem item13 = new JMenuItem(); //binarizacion
        JMenuItem item14 = new JMenuItem(); //negativo
        JMenuItem item15 = new JMenuItem(); //ecualizacion
        JMenuItem item16 = new JMenuItem(); ///Preprocesamiento
        JMenuItem item21 = new JMenuItem(); //lineal
        JMenuItem item22 = new JMenuItem(); //logaritmico
        JMenuItem item23 = new JMenuItem(); //exponencial
        JMenuItem item41 = new JMenuItem(); //histograma
        JMenuItem item42 = new JMenuItem(); //espectro de frecuencia
        JMenuItem item61Bajas = new JMenuItem(); //filtro pasa bajas
        JMenuItem item62Altas = new JMenuItem(); //filtro pasa altas
        JMenuItem item71 = new JMenuItem(); //traslación
        JMenuItem item72 = new JMenuItem(); //rotacion
        JMenuItem item73 = new JMenuItem(); //escalamiento
        item11.setText("En escala de grises");
        item12.setText("Umbralizacion");
        item13.setText("Binarizacion");
        item14.setText("Negativo");
        item15.setText("Ecualizacion");
        item16.setText("Preprocesamiento");
        item21.setText("Lineal");
        item22.setText("Logaritmico");
        item23.setText("Exponencial");
        item41.setText("Histograma");
        item42.setText("Espectro de frecuencias");
        item61Bajas.setText("Filtros pasa bajas");
        item62Altas.setText("Filtros pasa altas");
        item71.setText("Traslación");
        item72.setText("Rotación");
        item73.setText("Escalamiento");
        menu1.setText("Modificar");
        menu2.setText("Contraste");
        menu3.setText("Preprocesamiento");
        menu5.setText("Guardar");
        menu4.setText("Mostrar");
        menu6.setText("Filtros");
        menu7.setText("Operaciones Morfologicas");
        
        item11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escalaGrisesMouseClicked(evt);
            }
        });
        item12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralizacionMouseClicked(evt);
            }
        });
        item13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binarizacionMouseClicked(evt);
            }
        });
        item14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativoMouseClicked(evt);
            }
        });
        item15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecualizacionMouseClicked(evt);
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
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expExpMouseClicked(evt); //expansion Exponencial
            }
        });
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
        item61Bajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroPasaBajasMouseClicked(evt); //espectro de frecuencias
            }
        });
        item62Altas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroPasaAltasMouseClicked(evt); //espectro de frecuencias
            }
        });
        
        item71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traslacionMouseClicked(evt); //traslación
            }
        });
        
        item72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionMouseClicked(evt); //rotación
            }
        });
        
        item73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escalamientoMouseClicked(evt); //escalamiento
            }
        });
        
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preprocesamiento1MouseClicked(evt);
            }
        });
        /*menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });*/
        menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    guardarMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(JFrameImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        menu1.add(item11);
        menu1.add(item12);
        menu1.add(item13);
        menu1.add(item14);
        menu1.add(item15);
        menu2.add(item21);
        menu2.add(item22);
        menu2.add(item23);
        menu4.add(item41);
        menu4.add(item42);
        menu6.add(item62Altas);
        menu6.add(item61Bajas);
        menu7.add(item71);
        menu7.add(item72);
        menu7.add(item73);
        opciones.add(menu1);
        opciones.add(menu2);
        opciones.add(menu3);
        opciones.add(menu4);
        opciones.add(menu5);
        opciones.add(menu6);
        opciones.add(menu7);
        opciones.setLocation(0, 0);
        panelCentral.setSize(new Dimension(580,27));
        panelCentral.add(opciones);
        add(panelCentral);
        add(etiqueta);
        //add(opciones);
        int n = (this.imagen.getWidth(null)<350) ? 350:this.imagen.getWidth(null)+100;
        setSize(new Dimension(n, this.imagen.getHeight(null)+100));
        setVisible(rootPaneCheckingEnabled);
    }
}
