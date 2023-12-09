package cl.inacap.reciclebinmodelo.dao;

import java.util.ArrayList;
import java.util.List;
import cl.inacap.reciclebinmodelo.dto.Proveedor;

public class ProveedorDAO {
	private static List<Proveedor> proveedores = new ArrayList<>(); //Lista de tipo Proveedor llamada proveedores.
	
	public void save(Proveedor p) { //Este método al ser llamado recibe por default una variable de tipo Proveedor llamada p.
		proveedores.add(p); //Añade a la lista llamada proveedores lo que se le entrega en el parámetro.
	}
	
	public List<Proveedor> getAll() { //Este método retorna la lista llamada proveedores.
		return proveedores;
	}
}
