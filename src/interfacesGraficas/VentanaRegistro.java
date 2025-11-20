package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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
	JFrame frame;
	JLabel etqorigen, etqdestino, etqclase, etqnombre, etqapellido, etqcedula, etqtelefono, etqcorreo, etqFechaYHora, lblavion;
	JCalendar calendario;
	JTextField txtnombre, txtapellidos, txtcedula, txtelefono, txtcorreo;
	JSpinner hora;
	Botone btnGenerar, btnVerificarr, btnVolver, btnpoliticas;
	JComboBox<String>cmbclase, cmborigen, cmbdestino;
	JSeparator separador;
	JTextArea areaResultado;
	

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
        cmborigen = new JComboBox<>(origenes);
        cmborigen.setBounds(510, 70, 400, 30);
        frame.add(cmborigen);
	    
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
	    cmbclase = new JComboBox<>(clases);
	    cmbclase.setBounds(510, 190, 400, 30);
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
	    
	    txtelefono = new JTextField();
	    txtelefono.setBounds(910, 310, 200, 30);
        frame.add(txtelefono);
	    
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
	    
		frame.setVisible(true);
		
		btnpoliticas = new Botone ("Politicas"); 
		btnpoliticas.setBounds(135,700, 100, 30);
		btnpoliticas.addActionListener(this);
        frame.add(btnpoliticas);
        
        areaResultado = new JTextArea();
        areaResultado.setEditable(false); // para que solo muestre texto

        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Coordenadas recomendadas
        scroll.setBounds(470, 500, 300, 330);

        frame.add(scroll);

	    
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
	
	private void generarReporte() {

	    // Limpia el texto anterior
	    areaResultado.setText("");

	    // Datos base del avión
	    String claseSeleccionada = (String) cmbclase.getSelectedItem().toString();
	    int disponiblesEj = avion.getAsientosDisponiblesEjecutivos();
	    int disponiblesEco = avion.getAsientosDisponiblesEconomicos();
	    int capacidadEj = avion.getCapacidadEjecutiva();
	    int capacidadEco = avion.getCapacidadEconomica();

	    // Construimos el texto línea por línea
	    String mensaje = "";

	    mensaje += "===== REPORTE DEL AVIÓN =====\n\n";

	    mensaje += "Clase seleccionada: " + claseSeleccionada + "\n\n";

	    mensaje += "Capacidad Ejecutiva: " + capacidadEj + "\n";
	    mensaje += "Espacios disponibles Ejecutiva: " + disponiblesEj + "\n\n";

	    mensaje += "Capacidad Económica: " + capacidadEco + "\n";
	    mensaje += "Espacios disponibles Económica: " + disponiblesEco + "\n\n";

	    // Si quieres mostrar asiento por asiento en modo simple:
	    mensaje += "Listado simple de asientos Ejecutiva:\n";
	    for (int i = 1; i <= capacidadEj; i++) {
	        if (i <= capacidadEj - disponiblesEj) {
	            mensaje += "Asiento " + i + ": OCUPADO\n";
	        } else {
	            mensaje += "Asiento " + i + ": LIBRE\n";
	        }
	    }

	    mensaje += "\n\nListado simple de asientos Económica:\n";
	    for (int i = 1; i <= capacidadEco; i++) {
	        if (i <= capacidadEco - disponiblesEco) {
	            mensaje += "Asiento " + i + ": OCUPADO\n";
	        } else {
	            mensaje += "Asiento " + i + ": LIBRE\n";
	        }
	    }

	    // Ya construido → lo mostramos en el textarea
	    areaResultado.setText(mensaje);
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

		    try {
		        // 1️⃣ Datos del pasajero
		        String nombre = txtnombre.getText().trim();
		        String apellido = txtapellidos.getText().trim();
		        String cedula = txtcedula.getText().trim();
		        String telefono = txtelefono.getText().trim();
		        String correo = txtcorreo.getText().trim();

		        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty()) {
		            JOptionPane.showMessageDialog(null,
		                    "Complete todos los campos obligatorios");
		            return;
		        }

		        Pasajero pasajero = new Pasajero(nombre, apellido, cedula, telefono, correo);


		        // 2️⃣ Datos de origen – destino – clase
		        String origen = (String) cmborigen.getSelectedItem();
		        String destino = (String) cmbdestino.getSelectedItem();
		        String clase = (String) cmbclase.getSelectedItem();


		        // 3️⃣ Fecha y hora unidas en un Calendar
		        Calendar fecha = Calendar.getInstance();
		        fecha.setTime(calendario.getDate()); // fecha del JCalendar

		        java.util.Date horaSeleccionada = (java.util.Date) hora.getValue();
		        Calendar aux = Calendar.getInstance();
		        aux.setTime(horaSeleccionada);

		        fecha.set(Calendar.HOUR_OF_DAY, aux.get(Calendar.HOUR_OF_DAY));
		        fecha.set(Calendar.MINUTE, aux.get(Calendar.MINUTE));


		        // 4️⃣ Crear vuelo según tu modelo
		        Vuelo vuelo = new Vuelo(
		                "V-" + new Random().nextInt(99999),
		                origen,
		                destino,
		                200, // precio económica
		                450  // precio ejecutiva
		        );


		        // 5️⃣ Verificar espacio disponible
		        if (!vuelo.verificarDisponibilidad(clase)) {
		            JOptionPane.showMessageDialog(null,
		                    "No hay asientos disponibles en clase " + clase);
		            return;
		        }

		        vuelo.reservarAsiento(clase);


		        // 6️⃣ Crear tiquete
		        double precioTiquete = clase.equalsIgnoreCase("Ejecutiva")
		                ? vuelo.getPrecioEjecutiva()
		                : vuelo.getPrecioEconomica();

		        Tiquete tiquete = new Tiquete(
		                new Random().nextInt(1000),
		                pasajero,
		                vuelo,
		                clase
		 
		        );


		        // 7️⃣ Crear factura
		        Factura factura = new Factura(
		                "F-" + new Random().nextInt(99999),
		                tiquete,
		                precioTiquete,
		                precioTiquete * 0.13,
		                precioTiquete * 1.13
		        );


		        // 8️⃣ Crear reservación final
		        Reservacion reserva = Reservacion.crearReservacion(
		                pasajero,
		                null,   // Aquí va Avion si luego lo agregas
		                factura,
		                tiquete,
		                vuelo,
		                fecha
		        );


		        // 9️⃣ Mensaje final
		        JOptionPane.showMessageDialog(null,
		                "Reservación generada!\n\n" +
		                "Código: " + reserva.getCodigo() + "\n" +
		                "Tiquete: " + tiquete.getNumeroTiquete() + "\n" +
		                "Total: " + factura.getTotal());

		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(null,
		                "Ocurrió un error: " + ex.getMessage());
		    }
		    
		    generarReporte();
		}
		
	}
		
		
	public static void main (String[]args) {
		
		new VentanaRegistro(null);
		
	}

}
