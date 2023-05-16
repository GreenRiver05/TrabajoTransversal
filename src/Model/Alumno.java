package Model;

import java.time.LocalDate;

public class Alumno {

    private int id_Alumno;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private boolean estado;

    public Alumno(int dni, String nombre, String apellido, LocalDate nacimiento, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.estado = estado;
    }

    public Alumno(int id_Alumno, int dni, String nombre, String apellido, LocalDate nacimiento, boolean estado) {
        this.id_Alumno = id_Alumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.estado = estado;
    }

    public Alumno() {
    }

    public int getId_Alumno() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int setId_Alumno(int id_Alumno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDni() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int setDni(int dni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String setNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getApellido() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String setApellido(String apellido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public LocalDate getNacimiento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public LocalDate setNacimiento(LocalDate nacimiento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getEstado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean setEstado(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
