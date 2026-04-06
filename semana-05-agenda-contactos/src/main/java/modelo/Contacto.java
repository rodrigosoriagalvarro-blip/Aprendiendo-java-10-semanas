package modelo;
import exception.DatoInvalidoException;

public class Contacto {
    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String id, String nombre, String telefono, String email, String direccion) {
        this.id = id;
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        this.direccion = direccion;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new DatoInvalidoException("Nombre no puede estar vacio");
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{7,8}")) throw new DatoInvalidoException("Telefono debe tener 7 u 8 digitos");
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && !email.contains("@")) throw new DatoInvalidoException("Email debe contener @");
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-15s | %-10s | %s", id, nombre, telefono, email);
    }
}