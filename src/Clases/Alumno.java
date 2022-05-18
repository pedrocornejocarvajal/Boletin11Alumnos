package Clases;/*
 * Clase Alumno
 * -----------------------------
 * 
 * 	Propiedades:
 * 		- Matricula: entero
 * 		- Nombre: cadena		
 * 		- Apellidos: cadena		
 * 		- Notas: array de enteros (tama�o 4)
 * 		- NotaMedia: propiedad derivada
 * 
 * 	Metodos:
 * 		- int getMatricula()
 * 		- String getNombre()
 * 		- String getApellidos()
 * 		- int[] getNotas()
 * 		- double getNotaMedia()
 * 		- void setNotas(int[] notas)
 * 		- void preparaNombre()
 * 		- void preparaApellidos()
 * */

//package alumno;

import java.util.Scanner;

public class Alumno {

	//variables de clase
	private static int MAXNOMBRE= 15;
	private static int MAXAPELLIDOS= 30;
	public static int SIZE = 45+(4*5);
	
	//Variables de instancia
	private int matricula;
	private String nombre;
	private String apellidos;
	private int[] notas;
	private double notaMedia;
			
	
	//constructor por defecto
	public Alumno() {
		matricula=0;
		nombre="indefinido";
		apellidos="indefinido";
		notas = new int[4];
		notaMedia = calcularNotaMedia();
	}
	
	//constructor con parametros
	public Alumno (int matricula,String nombre,String apellidos,int[] notas, double notaMedia){
		
		try
		{
			if(notas.length!=4)
				throw new Exception("Error en la longitud del array notas");
			else
			{
				this.notas=notas;
				this.notaMedia = calcularNotaMedia();
				this.matricula=matricula;
				this.nombre=nombre;
				this.apellidos=apellidos;
				preparaCadena();
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//Getters
	public int getMatricula(){
		return this.matricula;
	}
	 
	public String getNombre(){
		return this.nombre;
	}
	 
	public String getApellidos(){
		return this.apellidos;
	}
	 
	public  int[] getNotas(){
		return this.notas;
	}
	 
	public double getNotaMedia(){
		int suma = 0;
		for (int i = 0; i < notas.length; i++) {
			suma = suma + notas[i];
		}
		return ((double)suma/notas.length);
	}
	 
	//Setters
	public void setNotas(int[] notas) {
		
		try{
			if(notas.length!=4)
				throw new Exception("Error en la longitud del array notas");
			this.notas = notas;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/*Interfaz
	 * Comentario: prepara el nombre para que siempre tenga como tama�o fijo lo que indique MAXNOMBRE
	 * Prototipo: void preparaNombre()
	 * Precondiciones: ninguna
	 * Entradas: ninguna
	 * Salida: ninguna
	 * Postcondiciones: ninguna*/
	private void preparaCadena(){
		
		if(nombre.length()>MAXNOMBRE){
			nombre.substring(0, MAXNOMBRE);
		}
		else{
			for (int i = nombre.length(); i < MAXNOMBRE; i++) {
				nombre=nombre+" ";
			}
		}
		
		if(apellidos.length()>MAXAPELLIDOS){
			apellidos.substring(0, MAXAPELLIDOS);
		}
		else{
			for (int i = apellidos.length(); i < MAXAPELLIDOS; i++) {
				apellidos=apellidos+" ";
			}
		}
		
		
	}
	
	/*Interfaz
	 * Comentario: Devuelve una cadena representativa del objeto
	 * Prototipo: String toString()
	 * Precondiciones: ninguna
	 * Entradas: ninguna
	 * Salida: una cadena
	 * Postcondiciones: Asociado al nombre se devuelve una cadena representativa del objeto*/	
	public String toString(){
		
		String cadena;

		cadena ="Su matricula es: "+ matricula+"\nSus apellidos son: "+apellidos+"\nSu nombre es: "+nombre+"\nSu nota Media es: "+notaMedia+"\nSus notas son: ";
		for (int i = 0; i < notas.length; i++) {
			cadena=cadena+"|"+notas[i];
		}
		
		return cadena+"|";
		
	}
	
	/*Interfaz
	 * Comentario: lee los datos de un objeto de teclado
	 * Prototipo: Empleado leerAlumno(void)
	 * Precondiciones: ninguna
	 * Entradas: ninguna
	 * Salidas: un objeto de tipo alumno
	 * Postcondiciones: Asociado al nombre se devuelve un objeto de tipo Alumno*/
	public Alumno leerAlumno(){
		
		Scanner teclado = new Scanner(System.in);
		int matricula;
		String nombre="";
		String apellidos="";
		int[] notas = new int[4];
		
		System.out.print("Introduzca matricula: ");
		matricula = teclado.nextInt();
		
		System.out.print("Introduzca nombre: ");
		nombre = teclado.next();
		
		System.out.print("Introduzca apellidos: ");
		apellidos = teclado.next();
		
		for(int i=0; i<notas.length;i++){
			System.out.print("Introduzca nota["+(i+1)+"]: ");
			notas[i] = teclado.nextInt();
		}
		
		return new Alumno(matricula,nombre,apellidos,notas, notaMedia);
	}
	public double calcularNotaMedia(){
		double aux = 0;
		for (int nota : notas) {
			aux += nota;
		}
		return aux/4;
	}
}//clase alumno
