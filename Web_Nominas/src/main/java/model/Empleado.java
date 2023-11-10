package model;

import laboral.DatosNoCorrectosException;
import laboral.Persona;

public class Empleado extends Persona {

    private int categoria = 1;
    public int anyos = 0;
    public double sueldo = 0;

    /**
     * Crea un nuevo objeto Empleado.
     *
     * @param dni       El DNI del empleado.
     * @param nombre    El nombre del empleado.
     * @param sexo      El sexo del empleado.
     * @param categoria La categoría laboral del empleado (de 1 a 10).
     * @param anyos     Los años de servicio del empleado.
     * @throws DatosNoCorrectosException Si los datos proporcionados no son válidos.
     */
    public Empleado(String dni, String nombre, String sexo, int categoria, int anyos) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
        if (categoria >= 1 && categoria <= 10) {
            this.categoria = categoria;
            this.anyos = anyos;
        } else {
            throw new DatosNoCorrectosException("DATOS no correctos");
        }
    }

    /**
     * Crea un nuevo objeto Empleado.
     *
     * @param dni    El DNI del empleado.
     * @param nombre El nombre del empleado.
     * @param sexo   El sexo del empleado.
     * @throws DatosNoCorrectosException Si los datos proporcionados no son válidos.
     */
    public Empleado(String dni, String nombre, String sexo) throws DatosNoCorrectosException {
        super(dni, nombre, sexo);
    }

    public Empleado() {

    }

    /**
     * Establece el sueldo del empleado.
     *
     * @param sueldo El sueldo del empleado.
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Obtiene el sueldo del empleado.
     *
     * @return El sueldo del empleado.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Establece la cantidad de años de servicio del empleado.
     *
     * @param anyos Los años de servicio del empleado.
     */
    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }

    /**
     * Establece la categoría laboral del empleado.
     *
     * @param categoria La nueva categoría laboral del empleado (de 1 a 10).
     * @throws DatosNoCorrectosException Si la categoría proporcionada no es válida.
     */
    public void setCategoria(int categoria) throws DatosNoCorrectosException {
        if (categoria >= 1 && categoria <= 10) {
            this.categoria = categoria;
        } else {
            throw new DatosNoCorrectosException("Categoria incorrecta");
        }
    }

    /**
     * Incrementa en uno la cantidad de años de servicio del empleado.
     */
    public void incrAnyo() {
        anyos++;
    }

    /**
     * Imprime información sobre el empleado, incluyendo sus datos personales, categoría laboral y años.
     *
     * @param p Persona del empleado a imprimir.
     */
    public void imprime(Persona p) {
        p.imprime();
        System.out.println("Categoria: " + categoria + " Años: " + anyos);
    }

    /**
     * Obtiene el DNI del empleado.
     *
     * @return El DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el sexo del empleado.
     *
     * @return El sexo del empleado.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Obtiene la cantidad de años de servicio del empleado.
     *
     * @return Los años de servicio del empleado.
     */
    public int getAnyos() {
        return anyos;
    }

    /**
     * Obtiene la categoría laboral del empleado.
     *
     * @return La categoría laboral del empleado.
     */
    public int getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "DNI del empleado: " + dni + "\nNombre del empleado: " + nombre + "\nSexo del empleado: " + sexo
                + "\nCategoría del empleado: " + categoria + "\nAños en la empresa: " + anyos;
    }
}
