package com.organizacion.agenda.service;

import com.organizacion.agenda.modelo.Contacto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactoService {
    private final ManejadorJSON<Contacto> manejador = new ManejadorJSON<>(Contacto.class, "contactos.json");

    public List<Contacto> obtenerTodos() {
        return manejador.cargar();
    }

    public void guardar(Contacto c) {
        List<Contacto> lista = obtenerTodos();
        lista.removeIf(item -> item.getNombre().equalsIgnoreCase(c.getNombre()));
        lista.add(c);
        manejador.guardar(lista);
    }

    public void eliminar(Contacto c) {
        List<Contacto> lista = obtenerTodos();
        lista.removeIf(item -> item.getNombre().equalsIgnoreCase(c.getNombre()));
        manejador.guardar(lista);
    }
}