package com.alesandro.ejercicio3_22.dao;

import com.alesandro.ejercicio3_22.db.DBConnect;
import com.alesandro.ejercicio3_22.model.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Dao del objeto persona
 */
public class DaoPersona {
    /**
     * Función que carga los datos de la tabla Persona y los devuelve para usarlos en un mapa
     *
     * @return mapa de personas para cargar en un informe
     */
    public static HashMap<String, Object> findAll() {
        HashMap<String, Object> personas = new HashMap<>();
        try {
            DBConnect connection = new DBConnect();
            String sql = "SELECT dni,nombre,apellido1,apellido2,edad FROM persona";
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                int edad = rs.getInt("edad");
                Persona persona = new Persona(dni, nombre, apellido1, apellido2, edad);
                personas.put(dni, persona);
            }
            rs.close();
            connection.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return personas;
    }

    /**
     * Función que busca una persona a partir de su dni
     *
     * @param dni de la persona
     * @return persona o null
     */
    public static Persona obtenerPorDni(String dni) {
        Persona persona = null;
        try {
            DBConnect connection = new DBConnect();
            String sql = "SELECT dni,nombre,apellido1,apellido2,edad FROM persona WHERE dni = ?";
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dni_db = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                int edad = rs.getInt("edad");
                persona = new Persona(dni_db, nombre, apellido1, apellido2, edad);
            }
            rs.close();
            connection.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return persona;
    }
}
