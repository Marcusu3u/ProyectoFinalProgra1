package clases;

public class Vuelo {

 private String codigoVuelo;
 private String origen;
 private String destino;
 private double precioEconomica;
 private double precioEjecutiva;
 
 private int asientosDisponiblesEjecutiva; 
 private int asientosDisponiblesEconomica; 

 //Constructor
 public Vuelo(String codigoVuelo, String origen, String destino, double precioEconomica, double precioEjecutiva) {
     this.codigoVuelo = codigoVuelo;
     this.origen = origen;
     this.destino = destino;
     this.precioEconomica = precioEconomica;
     this.precioEjecutiva = precioEjecutiva;
 //Inicializar 
     this.asientosDisponiblesEjecutiva = 2;
     this.asientosDisponiblesEconomica = 2;
 }

 //Getters
 public String getCodigoVuelo() {
     return codigoVuelo;
 }

 public String getOrigen() {
     return origen;
 }

 public String getDestino() {
     return destino;
 }

 public double getPrecioEconomica() {
     return precioEconomica;
 }

 public double getPrecioEjecutiva() {
     return precioEjecutiva;
 }
 
 public int getAsientosDisponiblesEjecutiva() {
     return asientosDisponiblesEjecutiva;
 }

 public int getAsientosDisponiblesEconomica() {
     return asientosDisponiblesEconomica;
 }

 //Setters
 public void setAsientosDisponiblesEjecutiva(int asientosDisponiblesEjecutiva) {
     this.asientosDisponiblesEjecutiva = asientosDisponiblesEjecutiva;
 }

 public void setAsientosDisponiblesEconomica(int asientosDisponiblesEconomica) {
     this.asientosDisponiblesEconomica = asientosDisponiblesEconomica;
 }


 public boolean verificarDisponibilidad(String clase) {
     if (clase.equalsIgnoreCase("ejecutiva")) {
         return this.asientosDisponiblesEjecutiva > 0;
     } else if (clase.equalsIgnoreCase("economica")) { 
         return this.asientosDisponiblesEconomica > 0;
     }
     return false;
 }
 
 public boolean reservarAsiento(String clase) {
     if (verificarDisponibilidad(clase)) {
          if (clase.equalsIgnoreCase("ejecutiva")) {
             this.asientosDisponiblesEjecutiva--;
             return true;
         } else if (clase.equalsIgnoreCase("economica")) {
             this.asientosDisponiblesEconomica--;
             return true;
         }
     }
     return false;
 }
 
 //Método toString
 @Override
 public String toString() {
     return "Vuelo: " + codigoVuelo + 
            " | Origen: " + origen + 
            " | Destino: " + destino +
            " | Disp. Ejecutiva: " + asientosDisponiblesEjecutiva +
            " | Disp. Economica: " + asientosDisponiblesEconomica;
 }
}