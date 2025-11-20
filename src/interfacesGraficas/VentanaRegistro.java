package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Calendar;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import clases.Avion;
import clases.Botone;
import clases.Factura;
import clases.Pasajero;
import clases.Reservacion;
import clases.Tiquete;
import clases.Vuelo;

public class VentanaRegistro implements ActionListener {
	
	VentanaPrincipal principal;
	Avion avion;
	Vuelo vuelo;
	JFrame frame;
	JLabel etqorigen, etqdestino, etqclase, etqnombre, etqapellido, etqcedula, etqtelefono, etqcorreo, etqFechaYHora, lblavion;
	JCalendar calendario;
	JTextField txtnombre, txtapellidos, txtcedula, txtelefono, txtcorreo;
	JSpinner hora;
	Botone btnGenerar, btnVerificarr, btnVolver, btnpoliticas;
	JComboBox<String>cmbclase, cmborigen, cmbdestino;
	JSeparator separador;
	JTextArea areaResultado, areaTiquete, areafactura;
	
	
	

	public VentanaRegistro(VentanaPrincipal principal, Avion avion) {
		
		this.principal = principal;
		this.avion = avion;
		
		
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
        cmborigen = new JComboBox<>(origenes);
        cmborigen.setBounds(510, 70, 300, 30);
        frame.add(cmborigen);
	    
	    etqdestino = new JLabel ("Destino:");
	    etqdestino.setForeground(new Color(96, 52, 52));
	    etqdestino.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqdestino.setBounds(420, 130, 600, 30);
	    frame.add(etqdestino);
	    
	    String[] destinos = { "Guanacaste", "Limon", "Puntarenas", "Heredia", "Alajuela", "Cartago", "San Jose"};
	    cmbdestino = new JComboBox<>(destinos);
	    cmbdestino.setBounds(510, 130, 300, 30);
        frame.add(cmbdestino);
	    
	    etqclase = new JLabel ("Clase:");
	    etqclase.setForeground(new Color(96, 52, 52));
	    etqclase.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqclase.setBounds(420, 190, 600, 30);
	    frame.add(etqclase);
	    
	    String[] clases = { "Economica", "Ejecutiva"};
	    cmbclase = new JComboBox<>(clases);
	    cmbclase.setBounds(510, 190, 300, 30);
        frame.add(cmbclase);
	    
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
	    
	    txtcorreo = new JTextField();
	    txtcorreo.setBounds(910, 310, 200, 30);
        frame.add(txtcorreo);
	    
	    etqFechaYHora = new JLabel ("Fecha y hora: (se seleccionan en el cuadro de la derecha)");
	    etqFechaYHora.setForeground(new Color(96, 52, 52));
	    etqFechaYHora.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	    etqFechaYHora.setBounds(500, 350, 810, 30);
	    frame.add(etqFechaYHora);
	    
	    btnGenerar = new Botone ("Generar"); 
	    btnGenerar.setCelesteCorporativo();
	    btnGenerar.setBounds(510, 410, 150, 50);
	    btnGenerar.addActionListener(this);
        frame.add(btnGenerar);
        
        btnVerificarr = new Botone ("Verificar"); 
        btnVerificarr.setCelesteCorporativo();
        btnVerificarr.setBounds(710, 410, 150, 50);
        btnVerificarr.addActionListener(this);
        frame.add(btnVerificarr);
        
        btnVolver = new Botone ("Volver"); 
        btnVolver.setBounds(910, 410, 150, 50);
        btnVolver.addActionListener(this);
        frame.add(btnVolver);
		
		btnpoliticas = new Botone ("Politicas"); 
		btnpoliticas.setBounds(135,700, 100, 30);
		btnpoliticas.addActionListener(this);
        frame.add(btnpoliticas);
        
        areaResultado = new JTextArea();
        areaResultado.setEditable(false); 
        JScrollPane scroll = new JScrollPane(areaResultado);
        areaResultado.setFont(new Font("Consolas", Font.PLAIN, 15));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(840, 40, 300, 200);
        frame.add(scroll);
        
        areaTiquete = new JTextArea();
        areaTiquete.setEditable(false); 
        JScrollPane scroll1 = new JScrollPane(areaTiquete);
        areaTiquete.setFont(new Font("Consolas", Font.PLAIN, 15));
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(790, 500, 300, 200); //(790, 500, 300, 200);
        frame.add(scroll1);
        
        areafactura = new JTextArea();
        areafactura.setEditable(false); 
        JScrollPane scroll2 = new JScrollPane(areafactura);
        areafactura.setFont(new Font("Consolas", Font.PLAIN, 15));
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setBounds(470, 500, 300, 200);
        frame.add(scroll2);

	    
		frame.setVisible(true);
		
	}
	
	public void limpiarCampos() {
		txtnombre.setText("");
		txtapellidos.setText("");
		txtcedula.setText("");
		txtelefono.setText("");
		txtcorreo.setText("");
		cmbclase.setSelectedIndex(0); 
		cmborigen.setSelectedIndex(0);
		cmbdestino.setSelectedIndex(0);
	}
	
	private void generarTiqueteYFactura() {

		
	    String nombre = txtnombre.getText();
	    String apellidos = txtapellidos.getText();
	    String cedula = txtcedula.getText();
	    String telefono = txtelefono.getText();
	    String correo = txtcorreo.getText();

	    Pasajero pasajero = new Pasajero(nombre, apellidos, cedula, telefono, correo);

	    Date fechaSeleccionada = calendario.getDate();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    String fechaFormateada = sdf.format(fechaSeleccionada);


	    Date horaSeleccionada = (Date) hora.getValue();

	    Calendar fechaHora = Calendar.getInstance();
	    fechaHora.setTime(fechaSeleccionada);

	    Calendar horaCal = Calendar.getInstance();
	    horaCal.setTime(horaSeleccionada);

	    fechaHora.set(Calendar.HOUR_OF_DAY, horaCal.get(Calendar.HOUR_OF_DAY));
	    fechaHora.set(Calendar.MINUTE, horaCal.get(Calendar.MINUTE));


	    String origen = cmborigen.getSelectedItem().toString();
	    String destino = cmbdestino.getSelectedItem().toString();
	    String clase = cmbclase.getSelectedItem().toString();

	    Vuelo vuelo = new Vuelo("V-01", origen, destino, 35000, 70000);


	    if (!avion.verificarDisponibilidad(clase)) {
	        JOptionPane.showMessageDialog(null, "No hay asientos disponibles en esta clase " + clase);
	        return;
	    }


	    if (clase.equalsIgnoreCase("Economica")) {
	        avion.setAsientosDisponiblesEconomicos(
	            avion.getAsientosDisponiblesEconomicos() - 1
	        );
	    } else {
	        avion.setAsientosDisponiblesEjecutivos(
	            avion.getAsientosDisponiblesEjecutivos() - 1
	        );
	    }

	    Tiquete tiquete = new Tiquete( new Random().nextInt(10000),
							            pasajero,
							            vuelo,
							            clase,
							            fechaFormateada
	    );


	    //CREAR FACTURA
	    double precio = clase.equalsIgnoreCase("Economica") ? vuelo.getPrecioEconomica() : vuelo.getPrecioEjecutiva();

	    double subtotal = precio;
	    double impuestos = subtotal * 0.13;
	    double total = subtotal + impuestos;

	    Factura factura = new Factura(	"#F:" + new Random().nextInt(10000),
							            tiquete,
							            subtotal,
							            impuestos,
							            total,
							            fechaFormateada,
							            pasajero
	    );


	    //RESERVACION
	    Reservacion reservacion = Reservacion.crearReservacion(	pasajero,
													            avion,
													            factura,
													            tiquete,
													            vuelo,
													            fechaHora
	    );

	    areaTiquete.setText(tiquete.toString());
	    areafactura.setText(factura.toString());

	    JOptionPane.showMessageDialog(null, "¡Reservación generada con éxito!");
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnVolver) {
			new VentanaPrincipal();
			 frame.dispose();
		}
		
		if (e.getSource() == btnpoliticas) {
			
			String texto = "1. Aceptación de los términos\r\n"
					+ "\r\n"
					+ "Al acceder, utilizar o registrarse en el sistema de boletería aérea (en adelante “el Sistema”), el usuario acepta cumplir íntegramente con los presentes Términos y Condiciones. Si el usuario no está de acuerdo, debe abstenerse de utilizar el Sistema.\r\n"
					+ "\r\n"
					+ "2. Uso del sistema\r\n"
					+ "\r\n"
					+ "2.1. El Sistema permite consultar disponibilidad de vuelos, tarifas, políticas y realizar la compra de boletos aéreos.\r\n"
					+ "2.2. El usuario se compromete a utilizar el Sistema únicamente para fines legítimos y personales.\r\n"
					+ "2.3. El uso fraudulento, la manipulación de precios, la reserva automatizada sin consentimiento o cualquier intento de acceso no autorizado podrá resultar en la suspensión o cancelación inmediata de la cuenta.\r\n"
					+ "\r\n"
					+ "3. Información proporcionada por el usuario\r\n"
					+ "\r\n"
					+ "3.1. El usuario garantiza que toda la información suministrada durante la compra (nombre completo, documento de identidad, contacto, etc.) es verídica y corresponde exactamente a lo que figura en sus documentos oficiales.\r\n"
					+ "3.2. La aerolínea o agencia no se hace responsable por errores originados por información incorrecta ingresada por el usuario.\r\n"
					+ "\r\n"
					+ "4. Reserva y compra de boletos\r\n"
					+ "\r\n"
					+ "4.1. Todas las reservas están sujetas a disponibilidad en el momento de la compra.\r\n"
					+ "4.2. La tarifa final solo se garantiza una vez completado el pago.\r\n"
					+ "4.3. Los boletos son personales e intransferibles salvo que la política tarifaria indique lo contrario.\r\n"
					+ "4.4. Cambios de fecha, hora, ruta o nombre dependen de las reglas específicas de la tarifa adquirida.\r\n"
					+ "\r\n"
					+ "5. Pagos\r\n"
					+ "\r\n"
					+ "5.1. El usuario es responsable de verificar los montos antes de confirmar la compra.\r\n"
					+ "5.2. El Sistema podrá utilizar plataformas de pago externas, por lo que el usuario acepta los términos de dichas plataformas.\r\n"
					+ "5.3. En caso de rechazo del pago, la reserva quedará automáticamente anulada.\r\n"
					+ "\r\n"
					+ "6. Cancelaciones y reembolsos\r\n"
					+ "\r\n"
					+ "6.1. Las políticas de cancelación dependen estrictamente de la tarifa seleccionada.\r\n"
					+ "6.2. Boletos clasificados como no reembolsables no aplican para devolución.\r\n"
					+ "6.3. En tarifas reembolsables, el monto devuelto podrá estar sujeto a penalidades o cargos administrativos.\r\n"
					+ "6.4. El reembolso se realizará por el mismo método de pago utilizado originalmente.\r\n"
					+ "\r\n"
					+ "7. Check-in y documentación\r\n"
					+ "\r\n"
					+ "7.1. Es responsabilidad del pasajero cumplir con los requisitos migratorios, sanitarios y aduaneros del país de origen, destino o escala.\r\n"
					+ "7.2. El no presentar la documentación correcta podrá causar la negación de embarque sin derecho a reembolso.\r\n"
					+ "\r\n"
					+ "8. Responsabilidad del sistema\r\n"
					+ "\r\n"
					+ "8.1. El Sistema actúa como plataforma intermediaria entre el usuario y las aerolíneas.\r\n"
					+ "8.2. La aerolínea es responsable final del transporte, equipaje, retrasos y modificaciones del vuelo.\r\n"
					+ "8.3. El Sistema no garantiza disponibilidad continua; podrían existir interrupciones por mantenimiento o fallos técnicos.\r\n"
					+ "\r\n"
					+ "9. Protección de datos\r\n"
					+ "\r\n"
					+ "9.1. Los datos personales se tratarán conforme a la legislación vigente y se utilizarán únicamente para fines operativos, de seguridad y de servicio.\r\n"
					+ "9.2. El usuario autoriza el uso de sus datos para la emisión del boleto, notificaciones de vuelo y procesos relacionados.\r\n"
					+ "\r\n"
					+ "10. Modificaciones del servicio\r\n"
					+ "\r\n"
					+ "10.1. La empresa podrá modificar estos Términos y Condiciones en cualquier momento.\r\n"
					+ "10.2. Las actualizaciones entrarán en vigor desde su publicación en el Sistema.\r\n"
					+ "\r\n"
					+ "11. Propiedad intelectual\r\n"
					+ "\r\n"
					+ "Todo el contenido del Sistema (software, logos, interfaz, bases de datos, textos) está protegido por derechos de autor y no puede ser copiado, alterado ni distribuido sin autorización.\r\n"
					+ "\r\n"
					+ "12. Legislación aplicable\r\n"
					+ "\r\n"
					+ "Los presentes Términos y Condiciones se regirán por la legislación del país donde opere la plataforma o donde se formalice la compra del boleto.\n".repeat(50);

			JTextArea area = new JTextArea(15, 30);
			area.setText(texto);
			area.setEditable(false);
			area.setLineWrap(true);
			area.setWrapStyleWord(true);

			JScrollPane scroll = new JScrollPane(area);

			JOptionPane.showMessageDialog(null, scroll, "Politicas de la pagina", JOptionPane.WARNING_MESSAGE);
			
		}
		
		if (e.getSource() == btnGenerar) {

			generarTiqueteYFactura();
			limpiarCampos();
		    
		    
		}
		
		if (e.getSource() == btnVerificarr) {
			
			String origen = (String) cmborigen.getSelectedItem();
	        String destino = (String) cmbdestino.getSelectedItem();
	        String clase = (String) cmbclase.getSelectedItem();

	        StringBuilder msg = new StringBuilder();

	        msg.append("🔎 VERIFICACION DEL ESTADO DEL VUELO\n");
	        msg.append("--------------------------------------------------\n");
	        msg.append("Origen: ").append(origen).append("\n");
	        msg.append("Destino: ").append(destino).append("\n");
	        msg.append("Clase seleccionada: ").append(clase).append("\n\n");

	        msg.append("INFORMACIÓN DEL AVION\n");
	        msg.append("Codigo: ").append(avion.getCodigoAvion()).append("\n");
	        msg.append("Modelo: ").append(avion.getModelo()).append("\n");
	        msg.append("Capacidad Ejecutiva: ").append(avion.getCapacidadEjecutiva()).append("\n");
	        msg.append("Capacidad Economica: ").append(avion.getCapacidadEconomica()).append("\n\n");

	        msg.append("DISPONIBILIDAD DE ASIENTOS\n");


	        areaResultado.setText(msg.toString()+"Disponibilidad de campos\n" +
	        	    "Economicos: " + avion.getAsientosDisponiblesEconomicos() + "\n" +
	        	    "Ejecutivos: " + avion.getAsientosDisponiblesEjecutivos());
	    }
	}

}
