/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgeneticos;

import java.awt.Color;
import java.awt.Scrollbar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Vanessa
 */
public class FramePanel extends JFrame{
    private static int b1, b2, b3;
    Color color;
    JPanel panel;
    JLabel R, G, B;
    public FramePanel(){
        
        setSize(400, 400);
        panel  = new JPanel();
        R = new JLabel("R");
        G = new JLabel("G");
        B = new JLabel("B");
        
        
        JSlider bar1 = new JSlider(0,255,0);  // desde x valor, , valor inicial
        JSlider bar2 = new JSlider(0,255,0);
        JSlider bar3 = new JSlider(0,255,0);
        //agregar marcas y numeros
        bar1.setMajorTickSpacing(50);
        bar1.setMinorTickSpacing(10);
        bar1.setPaintLabels(true);
        bar1.setPaintTicks(true);
        bar2.setMajorTickSpacing(50);
        bar2.setMinorTickSpacing(10);
        bar2.setPaintLabels(true);
        bar2.setPaintTicks(true);
        bar3.setMajorTickSpacing(50);
        bar3.setMinorTickSpacing(10);
        bar3.setPaintLabels(true);
        bar3.setPaintTicks(true);
        
        bar1.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              bar1.setValue(bar1.getValue() );
              b1 = bar1.getValue();
              //System.out.println("hola " + b1);
              enviarColor1(b1);
            }
          } );
        bar2.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              bar2.setValue(bar2.getValue() );
              b2 = bar2.getValue();
              enviarColor2(b2);
            }
          } );
        bar3.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
              bar3.setValue(bar3.getValue() );
              b3 = bar3.getValue();
              enviarColor3(b3);
            }
          } );
        
        panel.add(bar1);
        panel.add(R);
        panel.add(bar2);
        panel.add(G);
        panel.add(bar3);
        panel.add(B);
        panel.setBackground(color);
        
        
        
        add(panel);
        setBackground(Color.CYAN);
        setVisible(true);
        
        
    }
    public void enviarColor1 (int b){
       color = new Color(b, b2, b3);
       panel.setBackground(color);
       String n = String.valueOf(b);
       R.setText(n);
    }
    public void enviarColor2 (int b){
       color = new Color(b1, b,b3);
       panel.setBackground(color);
       String n = String.valueOf(b);
       G.setText(n);
       
    }
    public void enviarColor3 (int b){
       color = new Color(b1, b2, b);
       panel.setBackground(color);
       String n = String.valueOf(b);
       B.setText(n);
    }
}
