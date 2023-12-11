package cl.inacap.reciclebinmodelo.dto;

public class Lata extends Producto{ //Significa que esta clase hereda de la clase Producto.
	private String tipo;
	private int resistencia;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getResistencia() {
		return resistencia;
	}
	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	public String toString() {
		String anchoString = Integer.toString(this.ancho);
		String altoString = Integer.toString(this.alto);
		String valorString = Integer.toString(this.valorMercado);
		return "[Lata] " + "[Nombre]= " + this.nombre + " [Tipo]= " + this.tipo + " [Ancho]= " + anchoString + " [Alto]= " + altoString + " [Valor]= " + valorString;
	}
}
