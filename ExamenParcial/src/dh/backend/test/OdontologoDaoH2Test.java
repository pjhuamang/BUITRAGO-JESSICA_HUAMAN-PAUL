package dh.backend.test;

import dh.backend.dao.impl.OdontologoDaoH2;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoDaoH2Test {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2Test.class);
    private static OdontologoService odontologoService;

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/examen;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
    //public static Logger LOGGER = Logger.getLogger(OdontologoDaoH2Test.class);

    @Test
    @DisplayName("Testear que se pueden listar todos los odontólogos guardados en la base de datos")
    void testListarTodosOdontologos() {
        // Crear el servicio de odontólogos utilizando el DAO de H2
        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        // Obtener la lista de todos los odontólogos guardados en la base de datos
        List<Odontologo> odontologos = odontologoService.buscarTodos();

        // Verificar que la lista no sea nula y que contenga al menos un odontólogo
        assertNotNull(odontologos);
        assertFalse(odontologos.isEmpty());
    }

}
