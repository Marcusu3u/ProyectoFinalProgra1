package clases;
import java.awt.*;
import javax.swing.*;

public class Botone extends JButton {

    private Color colorSuperior = new Color(96, 52, 52);   // rojo oscuro
    private Color colorInferior = new Color(140, 70, 70);  // un poco más claro
    private Color colorHoverSuperior = new Color(120, 60, 60);
    private Color colorHoverInferior = new Color(170, 85, 85);

    private boolean hover = false;

    public Botone(String texto) {
        super(texto);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setContentAreaFilled(false);

        // --- Opcional: Hover suave ---
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover = true;
                repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Colores según hover
        Color arriba = hover ? colorHoverSuperior : colorSuperior;
        Color abajo = hover ? colorHoverInferior : colorInferior;

        // Degradado vertical suave
        GradientPaint gp = new GradientPaint(0, 0, arriba, 0, h, abajo);

        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, w, h, 10, 10); // bordes redondeados

        // Borde suave estilo Swing
        g2.setColor(new Color(60, 30, 30));
        g2.drawRoundRect(0, 0, w - 1, h - 1, 10, 10);

        g2.dispose();
        super.paintComponent(g);
    }
    
    public void setCelesteCorporativo() {
        colorSuperior = new Color(185, 215, 245);  // celeste suave superior
        colorInferior = new Color(140, 175, 220);  // celeste corporativo inferior

        colorHoverSuperior = new Color(200, 230, 255); // hover claro
        colorHoverInferior = new Color(160, 190, 230); // hover intermedio

        setForeground(Color.BLACK);  // más legible sobre celestes
        repaint();
    }
}
