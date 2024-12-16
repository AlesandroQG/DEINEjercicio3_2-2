package com.alesandro.ejercicio3_22.dao;

import com.alesandro.ejercicio3_22.db.*;
import com.alesandro.ejercicio3_22.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao del objeto Email
 */
public class DaoEmail {
    /**
     * Función que obtiene todos los emails de la base de datos
     *
     * @return lista de emails
     */
    public static List<Email> todosEmails() {
        List<Email> emails = new ArrayList<>();
        try {
            DBConnect connection = new DBConnect();
            String sql = "SELECT id,dni,email FROM email";
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String dni = rs.getString("dni");
                Persona persona_db = DaoPersona.obtenerPorDni(dni);
                String email_db = rs.getString("email");
                Email email = new Email(id, persona_db, email_db);
                emails.add(email);
            }
            connection.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return emails;
    }

    /**
     * Función que obtiene el email de una persona
     *
     * @param persona a buscar el email
     * @return email de la persona o null
     */
    public static Email emailDePersona(Persona persona) {
        Email email = null;
        try {
            DBConnect connection = new DBConnect();
            String sql = "SELECT id,dni,email FROM email WHERE dni = ?";
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            ps.setString(1, persona.getDni());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String dni = rs.getString("dni");
                Persona persona_db = DaoPersona.obtenerPorDni(dni);
                String email_db = rs.getString("email");
                email = new Email(id, persona_db, email_db);
            }
            connection.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return email;
    }
}
