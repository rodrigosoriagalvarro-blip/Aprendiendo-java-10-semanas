package servicio;

import modelo.Contacto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AgendaContactosTest {
    private AgendaContactos agenda;

    @BeforeEach
    void setUp() {
        agenda = new AgendaContactos();
    }

    @Test
    void testBuscarPorNombre() {
        Optional<Contacto> resultado = agenda.buscarPorNombre("NombreInexistente");
        assertFalse(resultado.isPresent());
    }

    @Test
    void testListarOrdenados() {
        List<Contacto> lista = agenda.listarOrdenados();
        assertNotNull(lista);
    }

    @Test
    void testObtenerNombres() {
        List<String> nombres = agenda.obtenerNombres();
        assertNotNull(nombres);
    }
}