package Controlador;

import Clases.Alumno;

public class Main {
    public static void main(String[] args) {
        Alumno yo = new Alumno(1,"Daniel","Rivas Miguel",new int[]{5,7,5,6},0);
        System.out.println(yo.getNombre()+"|");
        System.out.println(yo.getApellidos()+"|");
        System.out.println(yo.getNotaMedia());
        System.out.println(yo);
        System.out.println(Alumno.SIZE);
        System.out.println(Character.SIZE/8);
        byte[] cadena = yo.getNombre().getBytes();

        System.out.println("cfgcgf");

        Alumno victor = new Alumno();
        victor = victor.leerAlumno();
        System.out.println(victor);
    }
    }

