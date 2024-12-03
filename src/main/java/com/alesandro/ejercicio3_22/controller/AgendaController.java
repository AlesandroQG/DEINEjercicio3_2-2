package com.alesandro.ejercicio3_22.controller;

import com.alesandro.ejercicio3_22.AgendaApplication;
import com.alesandro.ejercicio3_22.db.DBConnect;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Clase que controla los eventos de la ventana principal
 */
public class AgendaController implements Initializable {
    /**
     * Función que se ejecuta cuando se inicia la ventana
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }

    /**
     * Función que carga y lanza el informe de JasperReport
     *
     * @param event
     */
    @FXML
    void lanzarInforme(ActionEvent event) {
        DBConnect connection;
        try {
            connection = new DBConnect(); // Instanciar la conexión con la base de datos
            HashMap<String, Object> parameters = null; // Cargar todos los países de la base de datos para insertar en el informe
            JasperReport report = (JasperReport) JRLoader.loadObject(AgendaApplication.class.getResource("report/Agenda.jasper")); // Obtener el fichero del informe
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, connection.getConnection()); // Cargar el informe con los países
            JasperViewer viewer = new JasperViewer(jprint, false); // Instanciar la vista del informe para mostrar el informe
            viewer.setVisible(true); // Mostrar el informe al usuario
        } catch (JRException e) {
            e.printStackTrace();
            mostrarAlerta("Ha ocurrido un error cargando el informe");
            Platform.exit(); // Cerrar la aplicación
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("Ha ocurrido un erros cargando los países de la base de datos");
            Platform.exit(); // Cerrar la aplicación
        }
    }

    /**
     * Función que muestra un mensaje de alerta al usuario
     *
     * @param mensaje de error a mostrar
     */
    public void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}