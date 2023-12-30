package cl.inacap.reciclebin;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.reciclebin.util.ConsolaUtil;
import cl.inacap.reciclebinmodelo.dao.ProductoDAO;
import cl.inacap.reciclebinmodelo.dao.ProveedorDAO;
import cl.inacap.reciclebinmodelo.dao.ReciclajeDAO;
import cl.inacap.reciclebinmodelo.dto.BotellaPlastica;
import cl.inacap.reciclebinmodelo.dto.Lata;
import cl.inacap.reciclebinmodelo.dto.Producto;
import cl.inacap.reciclebinmodelo.dto.Proveedor;
import cl.inacap.reciclebinmodelo.dto.Reciclaje;
import cl.inacap.reciclebin.util.RutUtil;

public class Start {
	static ConsolaUtil cu = new ConsolaUtil(); //Se crea el objeto de tipo ConsolaUtils (Utilizado para el ingreso y validación de datos).
	static RutUtil ru = new RutUtil(); //Se crea el objeto de tipo RutUtils (Utilizado para validar ruts chilenos).
	static ProductoDAO daoProducto = new ProductoDAO(); //Creación de objeto de tipo ProductosDAO.
	static ProveedorDAO daoProveedor = new ProveedorDAO(); //Creación de objeto de tipo ProveedoresDAO.
	static ReciclajeDAO daoReciclaje = new ReciclajeDAO(); //Creación de objeto de tipo ReciclajesDAO.
	static String compruebaNumeros[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; //Este Array se utiliza para comprobar los numeros de la fecha.
		
	//Menu de navegación.
	public static boolean menu() { 
		boolean continuar = true;
		System.out.println("a. Ingresar Proveedor");
		System.out.println("b. Ingresar Producto");
		System.out.println("c. Ver Proveedores");
		System.out.println("d. Ver Latas");
		System.out.println("e. Ver Botellas");
		System.out.println("f. Ver todos los productos");
		System.out.println("g. Agregar producto a proveedor");
		System.out.println("h. Reciclar");
		System.out.println("i. Revisar reciclajes");
		System.out.println("j. Salir");
		switch (cu.validarString().toLowerCase()) {
			case "a":
				ingresarProveedor();
				break;
			case "b":
				ingresarProducto();
				break;
			case "c":
				verProveedores();
					break;
			case "d":
				verLatas();
				break;
			case "e":
				verBotellas();
				break;
			case "f":
				verTodosLosProductos();
				break;
			case "g":
				agregarProductoAProveedor();
				break;
			case "h":
				reciclar();
				break;
			case "i":
				revisarReciclajes();
				break;
			case "j":
				continuar = false;
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
		}
		return continuar;
	}
	
	//Proceso de ingreso de proveedores.
	public static void ingresarProveedor() {
		
		//Proceso de ingreso de nombre de proveedor con su respectiva validación.
		String nombre;
		do {
			
			System.out.println("Ingrese el nombre del proveedeor");
			nombre = cu.validarString();
			if (nombre.length() < 3) {
				System.out.println("El nombre del proveedor es demasiado corto, ingreselo nuevamente");
			}
			
		} while (nombre.length() < 3);

		
		//Proceso de ingreso de rut del proveedor.
		System.out.println("Ingrese el rut del proveedor");
		String rut = ru.verificaRutChileno();
		
		String tipoEmpresa = null; //En esta variable se almacenará el tipo de empresa.
		boolean salir = false;
		while (salir == false) {
			System.out.println("Selecione el tipo de empresa");
			System.out.println("1. Pequeña");
			System.out.println("2. Mediana");
			System.out.println("3. Grande");
			switch (cu.validarString()) {
				case "1":
					tipoEmpresa = "Pequeña";
					salir = true;
					break;
				case "2":
					tipoEmpresa = "Mediana";
					salir = true;
					break;
				case "3":
					tipoEmpresa = "Grande";
					salir = true;
					break;
				default:
					System.out.println("Opcion incorrecta, seleccione el tipo de empresa nuevamente");
			}
		}
		
		boolean tieneConvenio = false;
		String respuesta;
		//Proceso de ingreso de convenio son su respectiva validación.
		do {
			System.out.println("¿Su empresa tiene convenio de reciclaje? (Si/No)");
			respuesta = cu.validarString();
			if (respuesta.equalsIgnoreCase("Si")) { //Si la condición se cumple se ejecuta el código y el flujo de ejecución sale del bucle.
				tieneConvenio = true;
				break;
			}
			if (respuesta.equalsIgnoreCase("No")) { //Si la condición se cumple se ejecuta el código y el flujo de ejecución sale del bucle.
				tieneConvenio = false;
				break;
			}
			System.out.println("Su respuesta no fue valida, responda nuevamente");
		} while (respuesta.equalsIgnoreCase("Si") == false && !respuesta.equalsIgnoreCase("No")); //Repite mientras la condición se cumpla.
		
		//Proceso de creación del objeto de tipo Proveedor.
		Proveedor p = new Proveedor();
		p.setNombre(nombre);
		p.setRut(rut);
		p.setTieneConvenio(tieneConvenio);
		p.setTipoEmpresa(tipoEmpresa);
		daoProveedor.save(p); //Este método añade el objeto de tipo Proveedor a su respectiva lista.
		
	}
	
	//Proceso de ingreso de los productos.
	public static void ingresarProducto() {
		
		//Proceso de ingreso del nombre del producto con su respectiva validación.
		System.out.println("Ingrese el nombre del producto");
		String nombre = cu.validarString();
		
		//Proceso de ingreso del valor del producto con su respectiva validación.
		System.out.println("Ingrese el valor del producto");
		int valorMercado = cu.validarInt();
		while (valorMercado <= 0) {
			System.out.println("El valor no puede ser menor o igual que 0, ingrese el valor del producto nuevamente");
			System.out.println("Ingrese el valor del producto");
			valorMercado = cu.validarInt();
		}
		
		//Proceso de ingreso del ancho del producto con su respectiva validación.
		System.out.println("Ingrese el ancho del producto");
		int ancho = cu.validarInt();
		while (ancho <= 5) {
			System.out.println("El ancho no puede ser menor o igual que 5, ingrese el ancho del producto nuevamente ");
			System.out.println("Ingrese el ancho del producto");
			ancho = cu.validarInt();
		}
		
		//Proceso de ingreso del alto del producto con su respectiva validación.
		int alto;
		do {
			System.out.println("Ingrese el alto del producto");
			alto = cu.validarInt();
			if (alto <= 5) {
				System.out.println("El alto no puede ser menor o igual que 5, ingrese el alto del producto nuevamente");
			}
		} while (alto <= 5);
		
		//Proceso de ingreso del peso del producto con su respectiva validación.
		System.out.println("Ingrese el peso del producto");
		double peso = cu.validarDouble();
		while (peso < 10 || peso > 100) {
			System.out.println("El peso debe ser entre 10 y 100, ingrese el peso del producto nuevamente");
			System.out.println("Ingrese el peso del producto");
			peso = cu.validarDouble();
		}
		
		//Proceso de ingreso del tipo de producto con su respectiva validación.
		String tipoProducto;
		do {
			
			System.out.println("Escriba el tipo de producto (Botella plastica; Lata)");
			tipoProducto = cu.validarString();
			
		} while (!tipoProducto.equalsIgnoreCase("Botella plastica") && tipoProducto.equalsIgnoreCase("Lata") == false); //El simbolo ! y == false son lo mismo.
		
		if (tipoProducto.equalsIgnoreCase("Botella plastica")) { //Código a ejecutar si el producto es una botella plastica.
			System.out.println("Ingrese el espesor de la botella plastica");
			int espesor = cu.validarInt();
			while (espesor <= 0) {
				System.out.println("El espesor de la botella es menor o igual que 0, ingrese el espesor nuevamente");
				System.out.println("Ingrese el espesor de la botella plastica");
				espesor = cu.validarInt();
			}
			
			String capacidad = "";
			boolean salir = false;
			while (salir == false) {
				System.out.println("Seleccione la capacidad de la botella plastica");
				System.out.println("a. 350 ml");
				System.out.println("b. 500 ml");
				System.out.println("c. 1 Litro");
				System.out.println("d. 2 Litros");
				System.out.println("e. 2.5 Litros");
				System.out.println("f. 3 Litros");
				switch (cu.validarString().toLowerCase()) {
					case "a":
						capacidad = "350 ml";
						salir = true;
						break;
					case "b":
						capacidad = "500 ml";
						salir = true;
						break;
					case "c":
						capacidad = "1 Litro";
						salir = true;
						break;
					case "d":
						capacidad = "2 Litros";
						salir = true;
						break;
					case "e":
						capacidad = "2.5 Litros";
						salir = true;
						break;
					case "f":
						capacidad = "3 Litros";
						salir = true;
						break;
					default:
						System.out.println("Opcion incorrecta, seleccione la capacidad de la botella nuevamente");
				}
			}
			
			//Proceso de creación del objeto de tipo BotellaPlastica.
			BotellaPlastica b = new BotellaPlastica(); 
			b.setAlto(alto);
			b.setAncho(ancho);
			b.setCapacidad(capacidad);
			b.setEspesor(espesor);
			b.setNombre(nombre);
			b.setPeso(peso);
			b.setValorMercado(valorMercado);
			
			Producto p = new Producto();
			p = b; //Variable de tipo Producto que almacena objeto de tipo BotellaPlastica (Esto puede suceder porque la clase BotellaPlastica hereda de la clase Producto).
			daoProducto.save(p); //Este método añade el objeto de tipo BotellaPlastica a su respectiva lista.
			
		}
		else {
			String tipo = "";
			boolean salir = false;
			while (salir == false) {
				System.out.println("Seleccione el tipo de contenido que almacena la lata");
				System.out.println("a. Bebida");
				System.out.println("b. Conserva");
				switch (cu.validarString().toLowerCase()) {
					case "a":
						tipo = "Bebida";
						salir = true;
						break;
					case "b":
						tipo = "Conserva";
						salir = true;
						break;
					default:
						System.out.println("Opcion incorrecta, seleccione el tipo de contenido que almacena la lata nuevamente");
				}
			}
			int resistencia;
			do {
				System.out.println("Ingrese la resistencia de la lata");
				resistencia = cu.validarInt();
				if (resistencia <= 0) {
					System.out.println("La resistencia de la lata es menor o igual a 0, ingrese la resistencia de la nuevamente");
				}
				if (resistencia >= 200) {
					System.out.println("La resistencia de la lata es mayor o igual a 200, ingrese la resistencia de la lata nuevamente");
				}
			} while(resistencia <= 0 || resistencia >= 200);
			
			//Proceso de creación del objeto de tipo Lata.
			Lata l = new Lata();
			l.setAlto(alto);
			l.setAncho(ancho);
			l.setNombre(nombre);
			l.setPeso(peso);
			l.setResistencia(resistencia);
			l.setTipo(tipo);
			l.setValorMercado(valorMercado);
			
			Producto p = new Producto();
			p = l; //Variable de tipo Producto que almacena objeto de tipo Lata (Esto puede suceder porque la clase Lata hereda de la clase Producto).
			daoProducto.save(p); //Este método añade el objeto de tipo Lata a su respectiva lista.
		}
	}

	
	public static void verProveedores() {
		
		List<Proveedor> proveedoresExistentes = daoProveedor.getAll(); //En esta instrucción se trae la lista con los proveedores agregados.
		
		try {
			if (proveedoresExistentes.get(0) == null) {

			}
			else {
				proveedoresExistentes.forEach(System.out::println);
			}
		} catch (Exception ex) {
			System.out.println("No hay proveedores ingresados en el sistema");
		}
	}
	
	public static void verLatas() {
		
		List<Producto> productosExistentes = daoProducto.getAll(); //En esta instrucción se crea una lista y en ella se almacenan todos los procutos.
		
		try {
			if (productosExistentes.get(0) == null) {

			}
			else {
				productosExistentes.forEach(p -> { //Aca se esta recorriendo la lista de productos.
					if (p instanceof Lata) { //Aqui pregunta si la variable p es una instancia de la clase Lata.
						Lata l = (Lata) p; //Casting, DownCasting (El Producto se convierte a Lata).
						System.out.println(l.toString());
					}
				});
			}
		} catch (Exception ex) {
			System.out.println("No hay latas ingresadas en el sistema");
		}
	}
	
	
	public static void verBotellas() {
		
		List<Producto> productosExistentes = daoProducto.getAll(); //En esta instrucción se crea una lista y en ella se almacenan todos los procutos.
		
		try {
			if (productosExistentes.get(0) == null) {
				
			}
			else {
				productosExistentes.forEach(p -> { //Aca se esta recorriendo la lista de productos.
					if (p instanceof BotellaPlastica) { //Aqui pregunta si la variable p es una instancia de la clase BotellaPlastica.
						BotellaPlastica b = (BotellaPlastica) p; //Casting, DownCasting (El Producto se convierte a BotellaPlastica).
						System.out.println(b.toString());
					}
				});
			}
		} catch (Exception ex) {
			System.out.println("No hay botellas ingresadas en el sistema");
		}

	}
		
	//Proceso de muestreo de todos los productos ingresados.
	public static void verTodosLosProductos() {
		
		List<Producto> productosExistentes = daoProducto.getAll(); //En esta instrucción se crea una lista y en ella se almacenan todos los procutos.
		
		try {
			if (productosExistentes.get(0) == null) {
				
			}
			else {
				productosExistentes.forEach(p -> { //Aca se esta recorriendo la lista de productos.
					if (p instanceof BotellaPlastica) { //Aqui pregunta si la variable p es una instancia de la clase BotellaPlastica.
						BotellaPlastica b = (BotellaPlastica) p; //Casting, DownCasting (El Producto se convierte a BotellaPlastica).
						System.out.println(b.toString());
					}
					if (p instanceof Lata) { //Aqui pregunta si la variable p es una instancia de la clase Lata.
						Lata l = (Lata) p; //Casting, DownCasting (El Producto se convierte a Lata).
						System.out.println(l.toString());
					}
				});
			}
		} catch (Exception ex) {
			System.out.println("No hay ningún producto ingresado en el sistema");
		}
	}
	
	//Proceso de agrecación de productos al proveedor (Los productos forman parte del atributo del proveedor).
	public static void agregarProductoAProveedor() {
		List<Proveedor> proveedoresExistentes = daoProveedor.getAll(); //En esta instrucción se trae la lista con los proveedores agregados.
		List<Producto> productosExistentes = daoProducto.getAll(); //En esta instrucción se trae una lista y en ella se almacenan todos los procutos.
		
		boolean validado = false;
		int posicionProveedor;
		Proveedor proveedorSeleccionado = null;
		
		if (productosExistentes.size() >= 1 && proveedoresExistentes.size() >= 1) { //Si en ambas listas hay uno o más elementos se ejecuta el código.
			
			do {
				
				for (int i = 0; i < proveedoresExistentes.size(); i++) { //Proceso de muestreo de los proveedores y seleccion (Tiene que ser un bucle for proque el usuario tiene que acceder al indice).
					System.out.print(i+"- ");
					Proveedor p = proveedoresExistentes.get(i);
					System.out.println(p);
				}
				
				System.out.println("¿Que proveedor quiere elegir?");
				try {
					posicionProveedor = cu.validarInt();
					proveedorSeleccionado = proveedoresExistentes.get(posicionProveedor); //En la variable proveedorSeleccionado se almacena el proveedor.
					validado = true; //La lectura de esta linea es necesaria para que el flujo pueda salir del bucle.
				} catch (Exception ex) {
					System.out.println("Posicion inexistente");
				}
					
			} while (validado == false); //Se repite hasta que el usuario ingrese una posición valida.
			
			int posicionProducto;
			String respuesta;
			validado = false;
			do {
				
				for (int i = 0; i < productosExistentes.size(); i++) { //Proceso de muestreo de los productos y seleccion (Tiene que ser un bucle for proque el usuario tiene que acceder al indice).
					Producto p = productosExistentes.get(i);
					System.out.print(i + "- ");
					if (p instanceof BotellaPlastica) { //Aqui pregunta si la variable p es una instancia de la clase BotellaPlastica.
						BotellaPlastica b = (BotellaPlastica) p; //Casting, DownCasting (El Producto se convierte a BotellaPlastica).
						System.out.println(b.toString());
					}
					if (p instanceof Lata) { //Aqui pregunta si la variable p es una instancia de la clase Lata.
						Lata l = (Lata) p; //Casting, DownCasting (El Producto se convierte a Lata).
						System.out.println(l.toString());
					}
				}
				System.out.println("¿Que producto desea agregar al proveedor?");
				try {
					posicionProducto = cu.validarInt();
					Producto productoSeleccionado = productosExistentes.get(posicionProducto); //En la variable productoSeleccionado se almacena el producto.
					proveedorSeleccionado.getProductosAsociados().add(productoSeleccionado); //Al proveedor que el usuario seleccionó se le llama a la lista y se le añade el producto.

				} catch (Exception ex) {
					System.out.println("Posicion inexistente");
				}
				System.out.println("¿Desea seguir agregando productos al proveedor? (Si/No)");
				
				respuesta = cu.validarString();
				while (respuesta.equalsIgnoreCase("Si") == false && respuesta.equalsIgnoreCase("No") == false) { //Repite mientras la condición se cumpla.
					System.out.println("Su respuesta no fue valida, responda nuevamente");
					System.out.println("¿Desea seguir agregando productos al proveedor? (Si/No)");
					respuesta=cu.validarString();
				}
			
			} while (respuesta.equalsIgnoreCase("Si"));
			
		}

		if (productosExistentes.size() == 0 || proveedoresExistentes.size() == 0) {
			System.out.println("No puede acceder a este menu porque deben haber almenos un proveedor y un producto en el sistema");
		}
	}
	
	//Proceso de reciclaje.
	public static void reciclar() {
		int total = 0;
		List<Producto> productosExistentes = daoProducto.getAll(); //En esta instrucción se crea una lista y en ella se almacenan todos los procutos.
		List<Producto> reciclar = new ArrayList<>();
		
		int posicionProducto;
		String respuesta;
		String fechaReciclaje = null;
		int contador = 0;
		if (productosExistentes.size() >= 1) { //Si en la lista hay uno o más elementos se ejecuta el código.
				//Proceso de ingreso y validacion de la fecha del reciclaje.
				do {
					
					System.out.println("Ingrese la fecha del reciclaje (yyyy-MM-dd HH:mm:ss)"); 
					fechaReciclaje = cu.validarString(); //Aca el usuario ingresa la fecha del reciclaje.
					contador = 0;
					
					for (int i = 0; i < fechaReciclaje.length(); i++) { //Se recorre la fecha que ingresó el usuario.
						
						if (i == 0) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(0)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el primer caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 1) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(1)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el segundo caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 2) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(2)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el tercer caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 3) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(3)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el cuarto caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 4) {
							if(Character.toString(fechaReciclaje.charAt(4)).equalsIgnoreCase("-")) { //Aca se pregunta si el quinto caracter de la fecha es un guión.
								contador++;
							}
						}
						if (i == 5) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(5)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el sexto caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 6) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if(Character.toString(fechaReciclaje.charAt(6)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el el sexto caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 7) {
							if (Character.toString(fechaReciclaje.charAt(7)).equalsIgnoreCase("-")) { //Aca se pregunta si el octavo caracter de la fecha es un guión.
								contador++;
							}
						}
						if (i == 8) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(8)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el el noveno caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 9) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(9)).equalsIgnoreCase(compruebaNumeros[j])) { //Aca se pregunta si el el decimo caracter de la fecha esta contenido en el array con numeros.
									contador++;
								}
							}
						}
						if (i == 10) {
							if (Character.toString(fechaReciclaje.charAt(10)).equalsIgnoreCase(" ")) { //Aca se pregunta si el onceavo caracter de la fecha es un espacio.
								contador++;
							}
						}
						if (i == 11) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(11)).equalsIgnoreCase(compruebaNumeros[j])) {
									contador++;
								}
							}
						}
						if (i == 12) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(12)).equalsIgnoreCase(compruebaNumeros[j])) { 
									contador++;
								}
							}
						}
						if (i == 13) {
							if(Character.toString(fechaReciclaje.charAt(13)).equalsIgnoreCase(":")) { //Aca se pregunta si el onceavo caracter de la fecha es un doble punto.
								contador++;
							}
						}
						if (i == 14) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(14)).equalsIgnoreCase(compruebaNumeros[j])) { 
									contador++;
								}
							}
						}
						if (i == 15) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(15)).equalsIgnoreCase(compruebaNumeros[j])) { 
									contador++;
								}
							}
						}
						if (i == 16) {
							if (Character.toString(fechaReciclaje.charAt(16)).equalsIgnoreCase(":")) { //Aca se pregunta si el onceavo caracter de la fecha es un doble punto.
								contador++;
							}
						}
						if (i == 17) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(17)).equalsIgnoreCase(compruebaNumeros[j])) { 
									contador++;
								}
							}
						}
						if (i == 18) {
							for (int j = 0; j < compruebaNumeros.length; j++) { //Si i es igual a 0 se recorre la lista que almacena los numeros.
								if (Character.toString(fechaReciclaje.charAt(18)).equalsIgnoreCase(compruebaNumeros[j])) { 
									contador++;
								}
							}
						}
					}
					if (contador != 19) {
						System.out.println("La fecha ingresada no cumple con el formato, ingrese la fecha nuevamente");
					}
					
				} while (contador != 19); //Si el formato sde la fecha se ingresó correctamente el flujo sale del bucle.
				
			do {	
				
				for (int i = 0; i < productosExistentes.size(); i++) { //Proceso de muestreo de los productos y seleccion (Tiene que ser un bucle for proque el usuario tiene que acceder al indice).
					Producto p = productosExistentes.get(i);
					System.out.print(i + "- ");
						if (p instanceof BotellaPlastica) { //Aqui pregunta si la variable p es una instancia de la clase BotellaPlastica.
							BotellaPlastica b = (BotellaPlastica)p; //Casting, DownCasting (El Producto se convierte a BotellaPlastica).
							System.out.println(b.toString());
						}
						if (p instanceof Lata) { //Aqui pregunta si la variable p es una instancia de la clase Lata.
							Lata l = (Lata)p; //Casting, DownCasting (El Producto se convierte a Lata).
							System.out.println(l.toString());
						}
					
				}
				System.out.println("¿Que producto desea agregar al reciclaje?");
				try {
					posicionProducto = cu.validarInt();
					Producto productoSeleccionado = productosExistentes.get(posicionProducto); //En la variable productoSeleccionado se almacena el producto.
					reciclar.add(productoSeleccionado); //El producto que el usuario seleccionó se añade a la lista de reciclajes.
				} catch (Exception ex) {
					System.out.println("Posicion inexistente");
				}
				System.out.println("¿Desea seguir agregando productos para reciclar? (Si/No)");
				
				respuesta = cu.validarString();
				while (respuesta.equalsIgnoreCase("Si") == false && respuesta.equalsIgnoreCase("No") == false) { //Repite mientras la condición se cumpla.
					System.out.println("Su respuesta no fue valida, responda nuevamente");
					System.out.println("¿Desea seguir agregando productos para reciclar? (Si/No)");
					respuesta = cu.validarString();
				}
			
			} while (respuesta.equalsIgnoreCase("Si"));
			
			
			for (int i = 0; i < reciclar.size(); i++) { //Se recorre la lista de productos reciclados.
				total+=reciclar.get(i).getValorMercado(); //Aca se suman los precios de los productos que el usuario seleccionó.
			}
			
			//Proceso de creación del objeto de tipo Reciclaje.
			Reciclaje r = new Reciclaje();
			r.setProductosReciclaje(reciclar);
			r.setFecha(fechaReciclaje);
			r.setValorPagado(total);
			
			daoReciclaje.save(r); //Se añade el objeto de tipo Reciclaje a su respectiva lista.
		}
		else {
			System.out.println("No hay productos para existentes en el sistema para reciclar");
		}
	}

	//Proceso de muestreo de los reciclajes.
	public static void revisarReciclajes() {
		boolean fecha = false;
		System.out.println("Ingrese la fecha del reciclaje (yyyy-MM-dd HH:mm:ss)");
		String fechaReciclaje = cu.validarString();
				
		for (int i = 0; i < daoReciclaje.getAll().size(); i++) { //Aca se está recorriendo la lista con los reciclajes.
			if (daoReciclaje.getAll().get(i).getFecha().equalsIgnoreCase(fechaReciclaje)) { //Aca se trae la lista con los reciclajes, luego se trae el indice y finalmente se trae el atributo fecha para compararlo con la fecha que ingreso el usuario.
				System.out.println(daoReciclaje.getAll().get(i).toString()); //En esta instrucción se imprimen los reciclajes que posean la fecha que ingresó el usuario.
				fecha = true;
			}
		}
		if (fecha == false) {
			System.out.println("No se efectuó ningún reciclaje en la fecha que usted ingresó");
		}
	}

	public static void main(String[] args) {
		while (menu());
	}
}





