package servicio;

import exception.*;
import modelo.Contacto;
import util.ManejadorJSON;
import java.util.*;
import java.util.stream.Collectors;

public class AgendaContactos {
    private List<Contacto> lista;
    private int contador;

    public AgendaContactos() {
        this.lista = ManejadorJSON.cargar();
        this.contador = lista.stream()
                .mapToInt(c -> Integer.parseInt(c.getId().substring(1)))
                .max().orElse(0) + 1;
    }

    private void persistir() {
        ManejadorJSON.guardar(new ArrayList<>(lista));
    }

    public void agregar(Contacto c) throws ContactoExistenteException {
        if (lista.stream().anyMatch(con -> con.getNombre().equalsIgnoreCase(c.getNombre()))) {
            throw new ContactoExistenteException("Contacto ya existe");
        }
        lista.add(c);
        persistir();
    }

    public Optional<Contacto> buscarPorNombre(String nombre) {
        return lista.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();
    }

    public List<Contacto> listarTodos() {
        return new ArrayList<>(lista);
    }

    public List<Contacto> listarOrdenados() {
        return lista.stream()
                .sorted(Comparator.comparing(Contacto::getNombre))
                .collect(Collectors.toList());
    }

    public List<Contacto> filtrarPorCategoria(String cat) {
        return lista.stream()
                .filter(c -> c.getDireccion().equalsIgnoreCase(cat))
                .collect(Collectors.toList());
    }

    public List<String> obtenerNombres() {
        return lista.stream()
                .map(Contacto::getNombre)
                .collect(Collectors.toList());
    }

    public String proxId() {
        return String.format("C%03d", contador++);
    }

    public int total() {
        return lista.size();
    }
}