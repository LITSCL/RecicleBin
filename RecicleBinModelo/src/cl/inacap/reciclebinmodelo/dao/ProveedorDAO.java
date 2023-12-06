package cl.inacap.reciclebinmodelo.dao;

import java.util.ArrayList;
import java.util.List;
import cl.inacap.reciclebinmodelo.dto.Proveedor;

public class ProveedorDAO {
	private static List<Proveedor> proveedores = new ArrayList<>(); //Lista de tipo Proveedor llamada proveedores.
	
	public void save(Proveedor p) { //Este m�todo al ser llamado recibe por default una variable de tipo Proveedor llamada p.
		proveedores.add(p); //A�ade a la lista llamada proveedores lo que se le entrega en el par�metro.
	}
	
	public List<Proveedor> getAll(){ //Este m�todo retorna la lista llamada proveedores.
		return proveedores;
	}
}
