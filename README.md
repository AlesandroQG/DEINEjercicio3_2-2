# Ejercicio 3_2 2 - Países
## DM2 DEIN 2024-2025
### Alesandro Quirós Gobbato

Esta es una aplicación hecha con JavaFX y JasperReports que muestra un informe con los países de la base de datos.

JasperReport está compilado en 7.0.1. La ejecución funciona en VSCode.

#### Estructura

La estructura del proyecto es la siguiente:
- `src > main`:
    - `java > com.alesandro.ejercicio3_22`:
        - `AgendaApplicacion.java`: Clase que lanza la aplicación
        - `controller`:
          - `AgendaController.java`: Clase que controla los eventos de la ventana principal de la aplicación
        - `dao`:
          - `DaoPersona.java`: Clase que realiza las operaciones con la base de datos del modelo Persona
          - `DaoEmail.java`: Clase que realiza las operaciones con la base de datos del modelo Email
          - `DaoTelefono.java`: Clase que realiza las operaciones con la base de datos del modelo Teléfono
        - `db`:
          - `DBConnect.java`: Clase que se conecta a la base de datos
        - `model`:
          - `Persona.java`: Clase que define el objeto Persona
          - `Email.java`: Clase que define el objeto Email
          - `Telefono.java`: Clase que define el objeto Teléfono
    - `resources > com.alesandro.ejercicio3_22`:
        - `fxml`:
          - `Agenda.fxml`: Ventana principal de la aplicación
        - `images`: Carpeta que contiene las imágenes de la aplicación
        - `reports`:
          - `Agenda.jasper`: Fichero del informe de JasperReport
          - `Agenda.jrxml`: Fichero para la edición del informe de JasperReport en JasperStudio
        - `sql`:
          - `agenda.sql`: Fichero para la creación de la base de datos
