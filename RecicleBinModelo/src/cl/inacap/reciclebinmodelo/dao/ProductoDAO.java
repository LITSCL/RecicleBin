package cl.inacap.reciclebinmodelo.dao;

import java.util.ArrayList;
import java.util.List;
import cl.inacap.reciclebinmodelo.dto.Producto;

public class ProductoDAO {
private static List<Producto> productos = new ArrayList<>(); //Lista de tipo Producto llamada proveedores.
	
	public void save(Producto p) { //Este método al ser llamado recibe por default una variable de tipo Producto llamada p.
		productos.add(p); //Añade a la lista llamada productos lo que se le entrega en el parámetro.
	}
	
	public List<Producto> getAll() { //Este método retorna la lista llamada productos.
		return productos;
	}
}
