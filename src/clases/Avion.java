package clases;

public class Avion {
	//Sus respectivos atributos .|.
	private String codigoAvion;
	private String modelo;
	private int capacidadEjecutiva = 2;
	private int capacidadEconomica = 2;
	private int asientosDisponiblesEjecutivos;
	private int asientosDisponiblesEconomicos;
	
	/*Su respectivo constructor lleno
	 * (Si en algun momento se necesita algun constructor que solo valida y o dos atributos, se crea)
	 
	 */
	public Avion(String codigoAvion, String modelo, int capacidadEjecutiva, int capacidadEconomica,
			int asientosDisponiblesEjecutivos, int asientosDisponiblesEconomicos) {
		this.codigoAvion = codigoAvion;
		this.modelo = modelo;
		this.capacidadEjecutiva = capacidadEjecutiva;
		this.capacidadEconomica = capacidadEconomica;
		this.asientosDisponiblesEjecutivos = asientosDisponiblesEjecutivos;
		this.asientosDisponiblesEconomicos = asientosDisponiblesEconomicos;
	}
	
	
	//Sus respectivos setters and getters
	public String getCodigoAvion() {
		return codigoAvion;
	}
	public void setCodigoAvion(String codigoAvion) {
		this.codigoAvion = codigoAvion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCapacidadEjecutiva() {
		return capacidadEjecutiva;
	}
	public void setCapacidadEjecutiva(int capacidadEjecutiva) {
		this.capacidadEjecutiva = capacidadEjecutiva;
	}
	public int getCapacidadEconomica() {
		return capacidadEconomica;
	}
	public void setCapacidadEconomica(int capacidadEconomica) {
		this.capacidadEconomica = capacidadEconomica;
	}
	public int getAsientosDisponiblesEjecutivos() {
		return asientosDisponiblesEjecutivos;
	}
	public void setAsientosDisponiblesEjecutivos(int asientosDisponiblesEjecutivos) {
		this.asientosDisponiblesEjecutivos = asientosDisponiblesEjecutivos;
	}
	public int getAsientosDisponiblesEconomicos() {
		return asientosDisponiblesEconomicos;
	}
	public void setAsientosDisponiblesEconomicos(int asientosDisponiblesEconomicos) {
		this.asientosDisponiblesEconomicos = asientosDisponiblesEconomicos;
	}
	
	//Metodos en funcion :/
	
	public boolean verificarDisponibilidad(String clase) {
		if (clase.equalsIgnoreCase("Ejecutiva")) {
			if (asientosDisponiblesEjecutivos <= 0) {
				return false;
			}
		} else if (clase.equalsIgnoreCase("Economica")) {
			if (asientosDisponiblesEconomicos <= 0) {
				return false;
			}
		} else {
			return false; // Clase no valida
		}
		
		return true;
	}

}
