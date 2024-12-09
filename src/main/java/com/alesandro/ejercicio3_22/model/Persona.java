package com.alesandro.ejercicio3_22.model;

import java.util.Objects;

/**
 * Clase Persona
 */
public class Persona {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    /**
     * Constructor con parámetros de la persona
     *
     * @param dni de la persona
     * @param nombre de la persona
     * @param apellido1 de la persona
     * @param apellido2 de la persona
     * @param edad de la persona
     */
    public Persona(String dni, String nombre, String apellido1, String apellido2, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

    /**
     * Constructor vacío de la persona
     */
    public Persona() {}

    /**
     * Getter para el dni de la persona
     *
     * @return dni de la persona
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter para el dni de la persona
     *
     * @param dni nuevo dni de la persona
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Getter para el nombre de la persona
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para el nombre de la persona
     *
     * @param nombre nuevo nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para el primer apellido de la persona
     *
     * @return primer apellido de la persona
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Setter para el primer apellido de la persona
     *
     * @param apellido1 nuevo primer apellido de la persona
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Getter para el segundo apellido de la persona
     *
     * @return segundo apellido de la persona
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Setter para el segundo apellido de la persona
     *
     * @param apellido2 nuevo segundo apellido de la persona
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Getter para la edad de la persona
     *
     * @return edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter para la edad de la persona
     *
     * @param edad nueva edad de la persona
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
