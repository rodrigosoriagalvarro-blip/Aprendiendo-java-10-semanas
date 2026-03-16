package modelo;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private String estado;

    public Tarea(int id, String titulo, String descripcion) {
        this.id = id;
        setTitulo(titulo);
        setDescripcion(descripcion);
        this.estado = "PENDIENTE";
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }

    // Setters con validaciones (RT4)
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        this.descripcion = descripcion;
    }

    public void completar() {
        this.estado = "COMPLETADA";
    }

    public boolean estaCompletada() {
        return "COMPLETADA".equals(this.estado);
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | " + estado);
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("--------------------------");
    }
}