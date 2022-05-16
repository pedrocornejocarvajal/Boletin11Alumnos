package Clases;

public class Alumno {
    private int matricula;
    private String nombre;
    private String apellidos;
    private int[] notas = new int[4];
    private double notaMedia;

    public Alumno(int matricula, String nombre, String apellidos, int[] notas) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notas = notas;
        this.notaMedia = calcularNotaMedia();
    }

    public Alumno() {
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public double calcularNotaMedia(){
        double aux = 0;
        for (int nota : notas) {
            aux += nota;
        }
        return aux/4;
    }
}
