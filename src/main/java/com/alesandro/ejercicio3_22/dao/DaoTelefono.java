package com.alesandro.ejercicio3_22.dao;

import com.alesandro.ejercicio3_22.db.*;
import com.alesandro.ejercicio3_22.model.*;

import java.sql.*;

/**
 * Dao del objeto Teléfono
 */
public class DaoTelefono {
    /**
     * Función que obtiene el teléfono de una persona
     *
     * @param persona a buscar el teléfono
     * @return teléfono de la persona o null
     */
    public static Telefono telefonoDePersona(Persona persona) {
        Telefono telefono = null;
        try {
            DBConnect connection = new DBConnect();
            String sql = "SELECT id,dni,telefono FROM telefono WHERE dni = ?";
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            ps.setString(1, persona.getDni());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String dni = rs.getString("dni");
                Persona persona_db = DaoPersona.obtenerPorDni(dni);
                String telefono_db = rs.getString("telefono");
                telefono = new Telefono(id, persona_db, telefono_db);
            }
            connection.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return telefono;
    }
}
