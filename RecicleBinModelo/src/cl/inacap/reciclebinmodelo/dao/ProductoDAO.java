package cl.inacap.reciclebinmodelo.dao;

import java.util.ArrayList;
import java.util.List;
import cl.inacap.reciclebinmodelo.dto.Producto;

public class ProductoDAO {
private static List<Producto> productos = new ArrayList<>(); //Lista de tipo Producto llamada proveedores.
	
	public void save(Producto p) { //Este m�todo al ser llamado recibe por default una variable de tipo Producto llamada p.
		productos.add(p); //A�ade a la lista llamada productos lo que se le entrega en el par�metro.
	}
	
	public List<Producto> getAll(){ //Este m�todo retorna la lista llamada productos.
		return productos;
	}
}
