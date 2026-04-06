package servicio;
import exception.*;
import modelo.Contacto;
import util.ManejadorJSON;
import java.util.*;

public class AgendaContactos {
    private List<Contacto> lista;
    private int contador;

    public AgendaContactos() {
        this.lista = ManejadorJSON.cargar();
        this.contador = lista.stream().mapToInt(c -> Integer.parseInt(c.getId().substring(1))).max().orElse(0) + 1;
    }

    private void persistir() { ManejadorJSON.guardar(new ArrayList<>(lista)); }

    public void agregar(Contacto c) throws ContactoExistenteException {
        if (lista.stream().anyMatch(con -> con.getNombre().equalsIgnoreCase(c.getNombre()))) 
            throw new ContactoExistenteException("Contacto ya existe");
        lista.add(c);
        persistir();
    }

    public String proxId() { return String.format("C%03d", contador++); }
    public List<Contacto> listar() { return new ArrayList<>(lista); }
    public int total() { return lista.size(); }
}