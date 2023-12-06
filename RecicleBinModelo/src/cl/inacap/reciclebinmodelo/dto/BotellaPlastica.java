package cl.inacap.reciclebinmodelo.dto;

public class BotellaPlastica extends Producto { //Significa que esta clase hereda de la clase Producto.
	private int espesor;
	private String capacidad;
	
	public int getEspesor() {
		return espesor;
	}
	public void setEspesor(int espesor) {
		this.espesor = espesor;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String toString() {
		String espesorString = Integer.toString(this.espesor);
		String valorString = Integer.toString(this.valorMercado);
		return "[Botella] " + "[Nombre]= " + this.nombre + " [Espesor]= " + espesorString+" [Capacidad]= " + this.capacidad + " [Valor]= " + valorString;
	}
	
	
}
