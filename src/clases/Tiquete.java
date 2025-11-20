package clases;



public class Tiquete {
    
    private int numeroTiquete;
    private Pasajero pasajero;
    private Vuelo vuelo;     
    private String clase;     
    private double montoTotal;
    private String fecha;


    //Constructor
    public Tiquete(int numeroTiquete, Pasajero pasajero, Vuelo vuelo, String clase, String fecha) {
        this.numeroTiquete = numeroTiquete;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.clase = clase;
        this.setFecha(fecha);
        
        //Calcular el monto total
        if (clase.equalsIgnoreCase("ejecutiva")) {
            this.montoTotal = vuelo.getPrecioEjecutiva();
        } else if (clase.equalsIgnoreCase("economica")) {
            this.montoTotal = vuelo.getPrecioEconomica();
        } else {
            this.montoTotal = 0.0;
        }
    }

    //Getters
    public int getNumeroTiquete() {
        return numeroTiquete;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String getClase() {
        return clase;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
    
 
    //Método toString
    @Override
    public String toString() {
        return "\n--- Tiquete de Vuelo ---\n" +
               "Numero de Tiquete: " + numeroTiquete + "\n" +
               "Vuelo: " + vuelo.getOrigen() + " -> " + vuelo.getDestino() + "\n" +
               "Clase: " + clase + "\n" +
               "Pasajero: " + pasajero.getNombre() + " " + pasajero.getApellido() + "\n" +
               "Identificacion: " + pasajero.getCedula() + "\n" +
               "Correo: "+pasajero.getCorreo()+"\n"+
               "Costo: ₡" + String.format("%.2f", montoTotal) + "\n"
  	         + "Fecha:"+fecha;

    }

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}