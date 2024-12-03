module com.alesandro.ejercicio3_22 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens com.alesandro.ejercicio3_22 to javafx.fxml;
    exports com.alesandro.ejercicio3_22;
    exports com.alesandro.ejercicio3_22.controller;
    opens com.alesandro.ejercicio3_22.controller to javafx.fxml;
    exports com.alesandro.ejercicio3_22.db;
    opens com.alesandro.ejercicio3_22.db to javafx.fxml;
}