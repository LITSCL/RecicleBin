package cl.inacap.reciclebinmodelo.dto;

import java.util.List;
import java.util.ArrayList;

public class Proveedor {
	private String nombre;
	private String rut;
	private String tipoEmpresa;
	private boolean tieneConvenio;
	private List<Producto> productosAsociados = new ArrayList<Producto>(); //En esta lista se almacenan los productos que tiene el proveedor.
	
	public List<Producto> getProductosAsociados() {
		return productosAsociados;
	}
	public void setProductosAsociados(List<Producto> productosAsociados) {
		this.productosAsociados = productosAsociados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	public boolean isTieneConvenio() {
		return tieneConvenio;
	}
	public void setTieneConvenio(boolean tieneConvenio) {
		this.tieneConvenio = tieneConvenio;
	}

	public String toString() {
		String texto="";
		for (Producto p : productosAsociados) {
			texto+="\n" + p.toString(); //En esta instrucción no es necesario llamar al método toString.
		}
		return "[RUT]= " + this.rut + " [Nombre]= " + this.nombre + "\n[Productos asociados]: " + texto;
	}
	
}

