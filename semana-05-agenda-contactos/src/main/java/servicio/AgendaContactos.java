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
                .max()
                .orElse(0) + 1;
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

    public List<Contacto> buscarPorNombre(String fragmento) {
        return lista.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(fragmento.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Contacto buscarPorId(String id) throws ContactoNoEncontradoException {
        return lista.stream()
                .filter(c -> c.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new ContactoNoEncontradoException("ID no encontrado"));
    }

    public void editar(String id, String nuevoTel, String nuevoEmail) throws ContactoNoEncontradoException {
        Contacto c = buscarPorId(id);
        c.setTelefono(nuevoTel);
        c.setEmail(nuevoEmail);
        persistir();
    }

    public void eliminar(String id) throws ContactoNoEncontradoException {
        Contacto c = buscarPorId(id);
        lista.remove(c);
        persistir();
    }

    public String proxId() {
        return String.format("C%03d", contador++);
    }

    public List<Contacto> listarTodos() {
        return new ArrayList<>(lista);
    }

    public int total() {
        return lista.size();
    }

    public long totalConEmail() {
        return lista.stream()
                .filter(c -> c.getEmail() != null && !c.getEmail().contains("@") == false && !c.getEmail().isEmpty())
                .count();
    }
}