package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import clases.Botone;

public class VentanaRegistro implements ActionListener {
	
	VentanaPrincipal principal;
	JFrame frame;
	JLabel etqorigen, etqdestino, etqclase, etqnombre, etqapellido, etqcedula, etqtelefono, etqcorreo, etqFechaYHora, lblavion;
	JCalendar calendario;
	JTextField txtnombre, txtapellidos, txtcedula, txtelefono, txtcorreo;
	JSpinner hora;
	Botone btnGenerar, btnVerificarr, btnVolver, btnpoliticas;
	JComboBox<String>cmbclase, cmborigen, cmbdestino;
	JSeparator separador;

	public VentanaRegistro(VentanaPrincipal principal) {
		
		this.principal = principal;
		
		frame = new JFrame("Ventana: Gestion de tandas");
		frame.setSize(1200,800);
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        etqFechaYHora = new JLabel ("Fecha y hora, con el calendario de");
        etqFechaYHora.setForeground(new Color(96, 52, 52));
        etqFechaYHora.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        etqFechaYHora.setBounds(70, 10, 600, 30);
        frame.add(etqFechaYHora);
        
        etqFechaYHora = new JLabel (" arriba escoge la fecha y con el");
        etqFechaYHora.setForeground(new Color(96, 52, 52));
        etqFechaYHora.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        etqFechaYHora.setBounds(70, 30, 600, 30);
        frame.add(etqFechaYHora);
        
        etqFechaYHora = new JLabel ("cuadrado de abajo escoge la hora");
        etqFechaYHora.setForeground(new Color(96, 52, 52));
        etqFechaYHora.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        etqFechaYHora.setBounds(70, 50, 600, 30);
        frame.add(etqFechaYHora);
        
        calendario = new JCalendar ();
		calendario.setBounds(70, 100, 250, 250);
		frame.add(calendario);
		
		hora = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(hora, "HH:mm");
		editor.getTextField().setEditable(false);
		hora.setEditor(editor);
		hora.setBounds(140, 370, 100, 25);
		frame.add(hora);
		
		lblavion = new JLabel (new ImageIcon(getClass().getResource("/image/avioncito.gif")));
		lblavion.setBounds(50,450,240,240);
		frame.add(lblavion);
		
		separador = new JSeparator(SwingConstants.VERTICAL);
		separador.setBounds(385, 1, 5, 1600); 
		separador.setBackground(new Color(96, 52, 52));
		frame.add(separador);
		
		etqorigen = new JLabel ("Origen:");
		etqorigen.setForeground(new Color(96, 52, 52));
		etqorigen.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		etqorigen.setBounds(420, 70, 600, 30);
	    frame.add(etqorigen);
	    
        String[] origenes = { "Guanacaste", "Limon", "Puntarenas", "Heredia", "Alajuela", "Cartago", "San Jose"};
        cmbclase = new JComboBox<>(origenes);
        cmbclase.setBounds(510, 70, 400, 30);
        frame.add(cmbclase);
	    
	    etqdestino = new JLabel ("Destino:");
	    etqdestino.setForeground(new Color(96, 52, 52));
	    etqdestino.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqdestino.setBounds(420, 130, 600, 30);
	    frame.add(etqdestino);
	    
	    String[] destinos = { "Guanacaste", "Limon", "Puntarenas", "Heredia", "Alajuela", "Cartago", "San Jose"};
	    cmbdestino = new JComboBox<>(destinos);
	    cmbdestino.setBounds(510, 130, 400, 30);
        frame.add(cmbdestino);
	    
	    etqclase = new JLabel ("Clase:");
	    etqclase.setForeground(new Color(96, 52, 52));
	    etqclase.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqclase.setBounds(420, 190, 600, 30);
	    frame.add(etqclase);
	    
	    String[] clases = { "Economica", "Ejecutiva"};
	    cmbdestino = new JComboBox<>(clases);
	    cmbdestino.setBounds(510, 190, 400, 30);
        frame.add(cmbdestino);
	    
	    etqnombre = new JLabel ("Nombre:");
	    etqnombre.setForeground(new Color(96, 52, 52));
	    etqnombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqnombre.setBounds(420, 250, 600, 30);
	    frame.add(etqnombre);
	    
	    txtnombre = new JTextField();
	    txtnombre.setBounds(420, 310, 80, 30);
        frame.add(txtnombre);
	    
	    etqapellido = new JLabel ("Apellido:");
	    etqapellido.setForeground(new Color(96, 52, 52));
	    etqapellido.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqapellido.setBounds(550, 250, 600, 30);
	    frame.add(etqapellido);
	    
	    txtapellidos = new JTextField();
	    txtapellidos.setBounds(535, 310, 100, 30);
        frame.add(txtapellidos);
	    
	    etqcedula = new JLabel ("Cedula:");
	    etqcedula.setForeground(new Color(96, 52, 52));
	    etqcedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqcedula.setBounds(680, 250, 600, 30);
	    frame.add(etqcedula);
	    
	    txtcedula = new JTextField();
	    txtcedula.setBounds(660, 310, 100, 30);
        frame.add(txtcedula);
	    
	    etqtelefono = new JLabel ("Telefono:");
	    etqtelefono.setForeground(new Color(96, 52, 52));
	    etqtelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqtelefono.setBounds(800, 250, 600, 30);
	    frame.add(etqtelefono);
	    
	    txtelefono = new JTextField();
	    txtelefono.setBounds(795, 310, 90, 30);
        frame.add(txtelefono);
	    
	    etqcorreo = new JLabel ("Correo:@");
	    etqcorreo.setForeground(new Color(96, 52, 52));
	    etqcorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqcorreo.setBounds(960, 250, 600, 30);
	    frame.add(etqcorreo);
	    
	    txtelefono = new JTextField();
	    txtelefono.setBounds(910, 310, 200, 30);
        frame.add(txtelefono);
	    
	    etqFechaYHora = new JLabel ("Fecha y hora: (se seleccionan en el cuadro de la derecha)");
	    etqFechaYHora.setForeground(new Color(96, 52, 52));
	    etqFechaYHora.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqFechaYHora.setBounds(500, 350, 810, 30);
	    frame.add(etqFechaYHora);
	    
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	public static void main (String[]args) {
		
		new VentanaRegistro(null);
		
	}

}
