package modelo;
public class Camion extends Vehiculo {
    public Camion(String marca, String modelo, int anio) { super(marca, modelo, anio); }
    @Override
    public void acelerar() { System.out.println("El camion " + marca + " acelera con fuerza."); }
}