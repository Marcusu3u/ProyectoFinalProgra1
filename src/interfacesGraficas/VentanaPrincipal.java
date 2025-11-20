package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import clases.Botone;

public class VentanaPrincipal implements ActionListener {
	
	JFrame frame;
	JLabel titulo, subtitulo, lblImagen, lblavion;
	Botone btnCerrar, btnRegistro;
	JSeparator separador;
	


	public VentanaPrincipal() {

		
		frame = new JFrame("Ventana Principal");
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        lblImagen = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/image/si2.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
        lblImagen.setBounds(200, 10, 400, 400);
        frame.add(lblImagen);
       
        titulo = new JLabel ("¡Bienvenido a Vuelo Ya! ");
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 30)); 
        titulo.setForeground(new Color(20, 50, 70));
        titulo.setBounds(220, 410, 400, 30);
        frame.add(titulo);
        subtitulo = new JLabel ("Espero tenga buen dia,");
        subtitulo.setForeground(new Color(20, 50, 70));
        subtitulo.setBounds(200, 450, 400, 30);
        subtitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); 
        frame.add(subtitulo);
        subtitulo = new JLabel ("¿Que accion desea realizar?");
        subtitulo.setForeground(new Color(20, 50, 70));
        subtitulo.setBounds(310, 480, 400, 30);
        subtitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); 
        frame.add(subtitulo);
        
        btnRegistro = new Botone ("Registro"); 
        btnRegistro.setCelesteCorporativo();
        btnRegistro.setBounds(140, 550, 250, 60);
        btnRegistro.addActionListener(this);
        frame.add(btnRegistro);

        btnCerrar = new Botone("Salir");
        btnCerrar.setBounds(410, 550, 250, 60);
        btnCerrar.addActionListener(this);
        frame.add(btnCerrar);
        
        separador = new JSeparator(SwingConstants.VERTICAL);
		separador.setBounds(70, 1, 5, 1600); 
		separador.setBackground(new Color(80, 120, 150));
		frame.add(separador);
		
		separador = new JSeparator(SwingConstants.VERTICAL);
		separador.setBounds(730, 1, 5, 1600); 
		separador.setBackground(new Color(80, 120, 150));
		frame.add(separador);
		
        
        frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnCerrar) {
			JOptionPane.showMessageDialog(frame, "Programa cerrado, gracias por usarlo.");
			System.exit(3);
		}
		
		if (e.getSource() == btnRegistro) {
			
			VentanaRegistro ventana = new VentanaRegistro(this);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		new VentanaPrincipal();

	}

}
