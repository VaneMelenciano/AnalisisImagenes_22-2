/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import herramientas.AbrirImagen;
import herramientas.Histograma;
import herramientas.ModificarImagen;
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
        JMenu menu2 = new JMenu(); //histograma
        JMenu menu3 = new JMenu(); //guardar
        JMenuItem item11 = new JMenuItem(); //escalaGrises
        JMenuItem item12 = new JMenuItem(); //umbralizada
        JMenuItem item13 = new JMenuItem(); //binarizacion
        JMenuItem item14 = new JMenuItem(); //negativo
        item11.setText("En escala de grises");
        item12.setText("Umbralizacion");
        item13.setText("Binarizacion");
        item14.setText("Negativo");
        menu1.setText("Modificar imagen");
        menu3.setText("Guardar");
        menu2.setText("Histograma");
        
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
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histogramaMouseClicked(evt);
            }
        });
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
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
        opciones.add(menu1);
        opciones.add(menu2);
        opciones.add(menu3);
        opciones.setLocation(0, 0);
        panelCentral.setSize(new Dimension(260,27));
        panelCentral.add(opciones);
        add(panelCentral);
        add(etiqueta);
        //add(opciones);
        
        setSize(new Dimension(this.imagen.getWidth(null), this.imagen.getWidth(null)));
        setVisible(rootPaneCheckingEnabled);
    }
}
