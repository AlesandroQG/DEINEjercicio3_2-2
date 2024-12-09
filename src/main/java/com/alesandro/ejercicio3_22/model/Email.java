package com.alesandro.ejercicio3_22.model;

import java.util.Objects;

/**
 * Clase Email
 */
public class Email {
    private int id;
    private Persona persona; // DNI
    private String email;

    /**
     * Constructor con parámetros de email
     *
     * @param id del email
     * @param persona del email
     * @param email email
     */
    public Email(int id, Persona persona, String email) {
        this.id = id;
        this.persona = persona;
        this.email = email;
    }

    /**
     * Constructor vacío de email
     */
    public Email() {}

    /**
     * Getter para el id de email
     *
     * @return id de email
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para el id del email
     *
     * @param id nuevo id del email
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para la persona del email
     *
     * @return persona del email
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Setter para la persona del email
     *
     * @param persona nueva persona del email
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Getter para el email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter para el email
     *
     * @param email nuevo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id == email.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
