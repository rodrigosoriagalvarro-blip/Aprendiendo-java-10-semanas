package modelo;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anio;
    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    public abstract void acelerar();
    @Override
    public String toString() {
        return String.format("Tipo: %-15s | Marca: %-10s | Modelo: %-10s | Año: %d", 
                getClass().getSimpleName(), marca, modelo, anio);
    }
}