package Controlador;

import Clases.Alumno;

import java.util.List;

import static Clases.GestionAlumnos.*;

public class MainGestion {
    public static void main(String[] args) {
        Alumno uno = new Alumno(1,"Daniel","Rivas Miguel",new int[]{1,1,1,1},1);
        Alumno dos = new Alumno(2,"Maikel","Lopez Garcia",new int[]{2,2,2,2},1);
        Alumno tres = new Alumno(3,"Roberto","Gonzalez Serna",new int[]{3,3,3,3},1);
        Alumno cuatro = new Alumno(4,"Roberto","Somet Laurinho",new int[]{4,4,4,4},1);
        Alumno cinco = new Alumno(5,"Francisco","Gutierrez Rodriguez",new int[]{5,5,5,5},1);

        escribeAlumno("Alumnos.dat",uno);
        escribeAlumno("Alumnos.dat",dos);
        escribeAlumno("Alumnos.dat",tres);
        escribeAlumno("Alumnos.dat",cuatro);
        escribeAlumno("Alumnos.dat",cinco);

        System.out.println(leeAlumno("Alumnos.dat",1));
        System.out.println(leeAlumno("Alumnos.dat",3));


        List<Alumno> alumnos = buscaAlumnosPorNombre("Alumnos.dat", "Roberto");

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}
