package dh.backend.dao.impl;

import dh.backend.dao.IDao;
import dh.backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoEnMemoria implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        odontologo.setId(odontologos.size() + 1);
        odontologos.add(odontologo);
        LOGGER.info("Odontólogo registrado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        LOGGER.info("Lista de odontólogos: " + odontologos);
        return odontologos;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
