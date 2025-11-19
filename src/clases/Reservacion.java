package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

public class Reservacion {

    // Relaciones
    private Pasajero persona;
    private Avion avion;
    private Factura factura;
    private Tiquete tiquete;
    private Vuelo vuelo;

    // Atributos propios de la reservación
    private int codigo;
    private String estadoReservacion;
    private Calendar fechaHora;

    // Constructor principal (solo inicializa sus propios datos)
    public Reservacion(int codigo, String estadoReservacion, Calendar fechaHora) {
        this.codigo = codigo;
        this.estadoReservacion = estadoReservacion;
        this.fechaHora = fechaHora;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEstadoReservacion() {
        return estadoReservacion;
    }

    public void setEstadoReservacion(String estadoReservacion) {
        this.estadoReservacion = estadoReservacion;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Pasajero getPersona() {
        return persona;
    }

    public Avion getAvion() {
        return avion;
    }

    public Factura getFactura() {
        return factura;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String formatearFechaHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(fechaHora.getTime());
    }
    
 // --------- MÉTODO FACTORY (RECOMENDADO) ---------
    public static Reservacion crearReservacion(
            Pasajero persona,
            Avion avion,
            Factura factura,
            Tiquete tiquete,
            Vuelo vuelo,
            Calendar fechaHora
    ) {
        // Validaciones de null
        Objects.requireNonNull(persona, "El pasajero no puede estar vacio");
        Objects.requireNonNull(avion, "El avion no puede estar vacio");
        Objects.requireNonNull(factura, "La factura no puede estar vacio");
        Objects.requireNonNull(tiquete, "El tiquete no puede estar vacio");
        Objects.requireNonNull(vuelo, "El vuelo no puede estar vacio");
        Objects.requireNonNull(fechaHora, "La fecha no puede estar vacio");

        // Código aleatorio
        int codigo = new Random().nextInt(100_000);

        // Crear la reservación
        Reservacion r = new Reservacion(
                codigo,
                "ACTIVA",
                fechaHora
                
        );

        // Asignar relaciones
        r.persona = persona;
        r.avion = avion;
        r.factura = factura;
        r.tiquete = tiquete;
        r.vuelo = vuelo;

        return r;
    }

    @Override
    public String toString() {
        return "\n--- Reservacion ---" +
                "\nCodigo: " + codigo +
                "\nEstado: " + estadoReservacion +
                "\nFecha/Hora: " + formatearFechaHora() +
                "\n\nPasajero: " + persona +
                "\nVuelo: " + vuelo +
                "\nAvion: " + avion +
                "\nTiquete: " + tiquete +
                "\nFactura: " + factura;
    }
}
