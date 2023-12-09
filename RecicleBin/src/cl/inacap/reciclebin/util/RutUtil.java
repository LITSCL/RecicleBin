package cl.inacap.reciclebin.util;

import java.util.Scanner;

public class RutUtil {
	static Scanner sc = new Scanner(System.in); //Se crea el objeto de tipo Scanner;
	static String compruebaNumeros[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; //Este Array se utiliza para comprobar los numeros del rut.
	
	public String verificaRutChileno() {
		int contador = 0;
		boolean validado = false;
		String rut;
		do {
			
			System.out.println("Ingrese el Rut (3.241.623-k / 21.421.502-3)");
			rut = sc.nextLine().toLowerCase().trim(); //Esta instrucción quita los posibles espacios y pasa todo a minusculas.
			contador = 0;
			
			
			if (rut.length() == 11) { //Este código solo se ejecuta si el largo del rut es igual a 11.
				
				for (int i = 0; i < rut.length(); i++) { //Aca se recorren todos los caracteres del rut.
					
					if (i == 0) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if(Character.toString(rut.charAt(0)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 1 && Character.toString(rut.charAt(1)).equalsIgnoreCase(".")) {
						contador++;
					}
					if (i == 2) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(2)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}		
					if (i == 3) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if(Character.toString(rut.charAt(3)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 4) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(4)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 5 && Character.toString(rut.charAt(5)).equalsIgnoreCase(".")) {
						contador++;
					}
					if (i == 6) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if(Character.toString(rut.charAt(6)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 7) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(7)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 8) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(8)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 9 && Character.toString(rut.charAt(9)).equalsIgnoreCase("-")) {
						contador++;
					}
					if (i == 10) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(10)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 10 && Character.toString(rut.charAt(10)).equalsIgnoreCase("k")) {
						contador++;
					}
				}
			}
			
			if (rut.length() == 12) { //Este código solo se ejecuta si el largo del rut es igual a 12.
				
				for (int i = 0; i < rut.length(); i++) { //Aca se recorren todos los caracteres del rut.
					
					if (i == 0) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(0)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 1) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(1)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 2 && Character.toString(rut.charAt(2)).equalsIgnoreCase(".")) {
						contador++;
					}
					if (i == 3) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if(Character.toString(rut.charAt(3)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 4) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if(Character.toString(rut.charAt(4)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 0) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if(Character.toString(rut.charAt(5)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 6 && Character.toString(rut.charAt(6)).equalsIgnoreCase(".")) {
						contador++;
					}
					if (i == 7) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(7)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 8) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(8)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 9) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(9)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 10 && Character.toString(rut.charAt(10)).equalsIgnoreCase("-")) {
						contador++;
					}
					if (i == 11) {
						for (int j = 0; j < compruebaNumeros.length; j++) {
							if (Character.toString(rut.charAt(11)).equalsIgnoreCase(compruebaNumeros[j])) { 
								contador++;		
							}
						}
					}
					if (i == 12 && Character.toString(rut.charAt(12)).equalsIgnoreCase("k")) {
						contador++;
					}
				}
			}
			
			if (contador == 11 && rut.length() == 11) {
				validado = true;
			}
			else if(contador == 12 && rut.length() == 12) {
				validado = true;
			}
			
			else {
				System.out.println("El rut ingresado no es valido, ingrese el rut nuevamente");
			}
		} while (validado == false);
		
		return rut; //Aca se retorna el rut ya validado.
	}
}
