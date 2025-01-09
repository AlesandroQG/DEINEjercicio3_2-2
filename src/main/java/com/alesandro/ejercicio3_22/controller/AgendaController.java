package com.alesandro.ejercicio3_22.controller;

import com.alesandro.ejercicio3_22.AgendaApplication;
import com.alesandro.ejercicio3_22.dao.DaoPersona;
import com.alesandro.ejercicio3_22.db.DBConnect;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Clase que controla los eventos de la ventana principal
 */
public class AgendaController {
    @FXML // fx:id="rbInforme1"
    private RadioButton rbInforme1; // Value injected by FXMLLoader

    @FXML // fx:id="rbInforme2"
    private RadioButton rbInforme2; // Value injected by FXMLLoader

    @FXML // fx:id="rbInforme3"
    private RadioButton rbInforme3; // Value injected by FXMLLoader

    @FXML // fx:id="tgInforme"
    private ToggleGroup tgInforme; // Value injected by FXMLLoader

    /**
     * Función que es ejecuta cuando se pulsa el botón “Aceptar”. Abre el informe seleccionado
     *
     * @param event evento del usuario
     */
    @FXML
    void aceptar(ActionEvent event) {
        if (rbInforme1.isSelected()) {
            lanzarInformePersonas("InformePersonas1");
        } else if (rbInforme2.isSelected()) {
            lanzarInformePersonas("InformePersonas2");
        } else {
            lanzarSubinforme();
        }
    }

    /**
     * Función que es ejecuta cuando se pulsa el botón “Cancelar”. Cierra la aplicación
     *
     * @param event evento del usuario
     */
    @FXML
    void cancelar(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Función que carga y lanza el informe de JasperReport
     *
     * @param informe nombre del archivo del informe a lanzar
     */
    public void lanzarInformePersonas(String informe) {
        DBConnect connection;
        try {
            connection = new DBConnect(); // Instanciar la conexión con la base de datos
            HashMap<String, Object> parameters = DaoPersona.findAll(); // Cargar todos las personas de la base de datos para insertar en el informe
            JasperReport report = (JasperReport) JRLoader.loadObject(AgendaApplication.class.getResource("reports/" + informe + ".jasper")); // Obtener el fichero del informe
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, connection.getConnection()); // Cargar el informe con las personas
            JasperViewer viewer = new JasperViewer(jprint, false); // Instanciar la vista del informe para mostrar el informe
            viewer.setVisible(true); // Mostrar el informe al usuario
        } catch (JRException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Ha ocurrido un error cargando el informe");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Ha ocurrido un erros cargando los países de la base de datos");
        }
    }

    /**
     * Función que carga y lanza el informe de JasperReport
     */
    public void lanzarSubinforme() {
        DBConnect connection;
        try {
            connection = new DBConnect();
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("emailreport", compilar("InformePersonas3_Emails.jrxml"));
            parameters.put("telefonoreport", compilar("InformePersonas3_Telefonos.jrxml"));
            JasperReport report = (JasperReport) JRLoader.loadObject(AgendaApplication.class.getResource("reports/InformePersonas3.jasper")); // Obtener el fichero del informe
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, connection.getConnection()); // Cargar el informe
            JasperViewer viewer = new JasperViewer(jprint, false); // Instanciar la vista del informe para mostrar el informe
            viewer.setVisible(true); // Mostrar el informe al usuario
        } catch (JRException | SQLException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Ha ocurrido un error cargando el informe");
        }
    }

    /**
     * Función que compila un subinforme para su uso en un informe
     *
     * @param informe a compilar
     * @return informe compilado
     */
    public JasperReport compilar(String informe) {
        try {
            return JasperCompileManager.compileReport(AgendaApplication.class.getResourceAsStream("reports/" + informe)); // Compilar el informe
        } catch (JRException e) {
            System.err.println(e.getMessage());
            mostrarAlerta("Ha ocurrido un error cargando el informe");
            return null;
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