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
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }

    public void setTelefono(String telefono) {
        if (telefono.length() < 7 || telefono.length() > 8) {
            throw new DatoInvalidoException("telefono: debe tener entre 7 y 8 digitos");
        }
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new DatoInvalidoException("email: debe contener @");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-20s | %-10s | %s", id, nombre, telefono, email);
    }
}