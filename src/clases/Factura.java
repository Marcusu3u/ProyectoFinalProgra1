package clases;

import java.util.Objects;


public class Factura {
	//Atributos privados 
	private String numeroFactura;
	private Tiquete tiquete;
	private double subTotal;
	private double impuestos;
	private double total;
	private Pasajero pasajero;
	private String fecha;

	//Constructor
	public Factura(String numeroFactura, Tiquete tiquete, double subTotal, double impuestos, double total, String fecha, Pasajero pasajero) {
		
		this.numeroFactura = numeroFactura;
		this.tiquete = Objects.requireNonNull(tiquete, "El tiquete de la factura no puede ser null");;
		this.subTotal = subTotal;
		this.impuestos = impuestos;
		this.total = total;
		this.fecha=fecha;
	    this.pasajero = pasajero;

	}
	//Respectivos getters y setters para utilizar los atributos privados
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Tiquete getTiquete() {
		return tiquete;
	}
	public void setTiquete(Tiquete tiquete) {
		this.tiquete = tiquete;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
    
	//Respectivos métodos para calcular el total y mostrar la factura
	public void calcularTotal() {
		this.impuestos = this.subTotal * 0.13;
		this.total = this.subTotal + this.impuestos;
	}
	
	public void mostrarFactura() {
		System.out.println("\n--- Factura ---");
		System.out.println("Numero de Factura: " + numeroFactura);
		System.out.println(tiquete.toString());
		System.out.printf("Subtotal: €%.2f\n", subTotal);
		System.out.printf("Impuestos (13%%): €%.2f\n", impuestos);
		System.out.printf("Total: €%.2f\n", total);
	}
	
	@Override
	public String toString() {
	    return "--- Factura ---\n"
	         + "Numero: " + numeroFactura + "\n"
	         +"Pasajero: " + pasajero.getNombre() + " " + pasajero.getApellido() + "\n" 
              + "Identificacion: " + pasajero.getCedula() + "\n" 
	         + "Subtotal: ₡" + String.format("%,.2f", subTotal) + "\n"
	         + "Impuestos: ₡" + String.format("%,.2f", impuestos) + "\n"
	         + "Total: ₡" + String.format("%,.2f", total) + "\n"
	         + "Fecha:"+fecha;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	
	
	
	
}
