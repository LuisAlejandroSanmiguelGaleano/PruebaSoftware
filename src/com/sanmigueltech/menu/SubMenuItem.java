package com.sanmigueltech.menu;


import com.sanmigueltech.form.ingresarClientePanel;
import com.sanmigueltech.form.ingresarClientePanel1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class SubMenuItem extends JButton {

    private final RippleEffect rippleEffect = new RippleEffect(this);

    private MainForm mainForm;
    
    public SubMenuItem(String text) {
        super(text);
        setContentAreaFilled(false);
        setHorizontalAlignment(SwingConstants.LEFT);
        initStyle();
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Determinar qué panel mostrar basándose en el texto del botón
                JPanel panelToShow = null;
                switch (text) {
                    case "Registro de entrada":
                        System.out.println("Boton presionado!");
                        panelToShow = new ingresarClientePanel();
                        
                        break;
                    // Puedes agregar más casos si tienes más botones
                }

                if (panelToShow != null) {
                    MainForm main = MainForm.getInstance();
                    if (main != null) {
                        main.setLayout(new BorderLayout());
                        main.removeAll();  // Limpia el contenido actual de mainForm
                        main.add(panelToShow, BorderLayout.CENTER);
                        main.revalidate();
                        main.repaint();
                    } else {
                        // Maneja el caso cuando main es null
                        System.err.println("MainForm no está inicializado.");
                    }
                }
            }
        });
    }

    private void initStyle() {
        setBackground(new Color(7, 40, 33));
        setForeground(Color.WHITE);
        Font currentFont = getFont();
        float newSize = currentFont.getSize() + 4f;  // Aumenta el tamaño en 10 puntos
        setFont(currentFont.deriveFont(newSize));

    }

    @Override
    public void updateUI() {
        super.updateUI();
        if (rippleEffect != null) {
            initStyle();
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        rippleEffect.reder(grphcs, new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }
    
    
}
