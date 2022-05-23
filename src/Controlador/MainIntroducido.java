package Controlador;

import Clases.Alumno;

public class MainIntroducido {
    public static void main(String[] args) {


        //main para probar que el alumno se meta por parametros a gusto del usuario


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

