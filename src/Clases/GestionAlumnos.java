package Clases;

import java.io.*;
import java.util.*;


public class GestionAlumnos {

	/*Interfaz
	 * Comentario: inserta un registro de tipo Alumno en un ficherio de texto
	 * Prototipo: void escribeAlumno(String fichero, alumno)
	 * Entradas: una cadena y un objeto de tipo alumno
	 * Precondiciones: el fichero debe existir
	 * Salidas: ninguna
	 * Postcondiciones: el fichero tendra un registro mas
	 * */
	public static void escribeAlumno(String rutaFichero, Alumno nuevo){
		File fichero = null;
		RandomAccessFile raf = null;
		int[] notas = nuevo.getNotas();				
		
		try{
			fichero = new File(rutaFichero);
			raf = new RandomAccessFile(fichero, "rw");
			raf.seek(raf.length());
			raf.writeInt(nuevo.getMatricula());
			raf.writeBytes(nuevo.getApellidos()+"\n");
			raf.writeBytes(nuevo.getNombre()+"\n");
			for (int nota : notas) {
				raf.writeInt(nota);
			}
		} catch(NullPointerException | IOException npe){
			npe.printStackTrace();
		} finally{
			try{
				if(fichero!=null) {
					assert raf != null;
					raf.close();
				}
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	/*Interfaz
	 * Comentario: lee un registro de un alumno segun su posicion
	 * Prototipo Alumno leeAlumno(String  rutaFichero,int pos)
	 * Entradas: una cadena y un entero
	 * Precondiciones: la ruta del fichero debe existir
	 * Salida: un objeto de tipo Alumno
	 * Postcondiciones: Asociado al nombre se devuelve el objeto leido del registro indicado*/
	public static Alumno leeAlumno(String rutaFichero,int pos){
				
		File fichero;
		RandomAccessFile raf = null;
		
		int matricula=0;
		int[] notas = {0,0,0,0};
		double notaMedia = 0;
		String nombre="";
		String apellidos="";
		
		try{
			fichero = new File(rutaFichero);
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(0); //apunta al principio del fichero
			raf.seek((long) (Alumno.SIZE + 2) *(pos)); //+2 por los dos caracteres de salto de linea
			matricula=raf.readInt();
			apellidos=raf.readLine();
			nombre=raf.readLine();
			for (int i = 0; i < notas.length; i++) {
				notas[i]=raf.readInt();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(raf!=null)
					raf.close();
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		
		return (new Alumno(matricula,nombre,apellidos,notas,notaMedia));
	}
	
	/*Interfaz
	 * Comentario: devuelve una lista de tipo Alumno buscados en el fichero
	 * Prototipo List <Alumno> buscaAlumnosPorNombre(String  rutaFichero, String nombre)
	 * Entradas: dos cadenas
	 * Precondiciones: la ruta del fichero debe existir
	 * Salida: una lista de alumnos
	 * Postcondiciones: Asociado al nombre se devuelve una lista con los alumnos que coincidan en el nombre pasado por parametro*/
	
	public static List <Alumno> buscaAlumnosPorNombre(String path,String nombreBusqueda){
		File fichero;
		RandomAccessFile raf = null;
		long tamanoFichero;
		int matricula;
		int[] notas = {0,0,0,0};
		String nombre;
		String apellidos;
		double notaMedia=0;
		List <Alumno> aux = new ArrayList<>();
		
		try{
			fichero = new File(path);
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(0);
			tamanoFichero=raf.length(); //calculo el tama�o del fichero EOF
			while(raf.getFilePointer()<tamanoFichero){
				
				matricula=raf.readInt(); //lectura de la matricula
				apellidos=raf.readLine(); //lectura del apellido
				nombre=raf.readLine();//lectura del nombre
				for (int i = 0; i < notas.length; i++)//lectura de notas
				{
					notas[i]=raf.readInt();
				}
				if(nombre.contains(nombreBusqueda)){
					aux.add(new Alumno(matricula,nombre,apellidos,notas,notaMedia)); //inserto el alumno en la lista
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(raf!=null)
					raf.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return aux;
	}
}
