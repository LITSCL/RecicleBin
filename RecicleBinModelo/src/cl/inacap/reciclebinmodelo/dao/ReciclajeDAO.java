package cl.inacap.reciclebinmodelo.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.reciclebinmodelo.dto.Reciclaje;

public class ReciclajeDAO {
	private static List<Reciclaje> reciclajes = new ArrayList<>(); //Lista de tipo Reciclaje llamada reciclajes.
	
	public void save(Reciclaje p) {
		reciclajes.add(p); //Añade a la lista llamada reciclajes lo que se le entrega en el parámetro.
	}
	
	public List<Reciclaje> getAll() { //Este método retorna la lista llamada reciclajes.
		return reciclajes;
	}
}
