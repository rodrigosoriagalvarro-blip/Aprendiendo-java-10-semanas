package modelo;
public class Moto extends Vehiculo {
    public Moto(String marca, String modelo, int anio) { super(marca, modelo, anio); }
    @Override
    public void acelerar() { System.out.println("La moto " + marca + " acelera rápidamente."); }
}