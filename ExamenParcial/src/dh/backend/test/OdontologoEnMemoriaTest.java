package dh.backend.test;

import dh.backend.dao.impl.OdontologoEnMemoria;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoEnMemoriaTest {
    private static final Logger LOGGER = Logger.getLogger(OdontologoEnMemoriaTest.class);
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoEnMemoria());

    @Test
    @DisplayName("Registrar y listar todos los odontólogos en memoria")
    public void testRegistrarYListarOdontologos() {
        Odontologo odontologo1 = new Odontologo("54321", "Alice", "Johnson");
        Odontologo odontologo2 = new Odontologo("98765", "Bob", "Brown");
        odontologoService.registrarOdontologo(odontologo1);
        odontologoService.registrarOdontologo(odontologo2);
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertEquals(2, odontologos.size());
        LOGGER.info("Test de registrar y listar odontólogos en memoria completado.");
    }
}
