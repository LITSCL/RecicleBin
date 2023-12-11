package cl.inacap.reciclebinmodelo.dto;

public class Producto {
	protected String nombre;
	protected int valorMercado;
	protected int ancho;
	protected int alto;
	protected double peso;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(int valorMercado) {
		this.valorMercado = valorMercado;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
