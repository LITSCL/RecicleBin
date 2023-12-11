package cl.inacap.reciclebinmodelo.dto;

import java.util.ArrayList;
import java.util.List;

public class Reciclaje {
	String fecha;
	int valorPagado;
	private List<Producto> productosReciclaje = new ArrayList<Producto>(); //En esta lista se almacenan los productos que se van a reciclar.

	public List<Producto> getProductosReciclaje() {
		return productosReciclaje;
	}

	public void setProductosReciclaje(List<Producto> productosReciclaje) {
		this.productosReciclaje = productosReciclaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getValorPagado() {
		return valorPagado;
	}
	
	public void setValorPagado(int valorPagado) {
		this.valorPagado = valorPagado;
	}
	
	public String toString() {
		String texto = "";
		for (Producto p : productosReciclaje) {
			texto+="\n" + p.toString(); //En esta instrucción no es necesario llamar al método toString.
		}
		return "[Fecha]= " + this.fecha + " [Valor pagado]= " + this.valorPagado + "\n[Productos reciclados]:" + texto;
	}
}

