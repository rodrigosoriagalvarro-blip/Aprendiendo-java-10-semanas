package com.organizacion.agenda.service;

import com.organizacion.agenda.modelo.Evento;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {
    private final ManejadorJSON<Evento> manejador = new ManejadorJSON<>(Evento.class, "eventos.json");

    public List<Evento> obtenerTodos() {
        return manejador.cargar();
    }

    public void guardar(Evento e) {
        List<Evento> lista = obtenerTodos();
        lista.removeIf(item -> item.getTitulo().equalsIgnoreCase(e.getTitulo()) && item.getFecha().equals(e.getFecha()));
        lista.add(e);
        manejador.guardar(lista);
    }

    public void eliminar(Evento e) {
        List<Evento> lista = obtenerTodos();
        lista.removeIf(item -> item.getTitulo().equalsIgnoreCase(e.getTitulo()) && item.getFecha().equals(e.getFecha()));
        manejador.guardar(lista);
    }
}