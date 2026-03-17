package modelo;
public class Auto extends Vehiculo {
    public Auto(String marca, String modelo, int anio) { super(marca, modelo, anio); }
    @Override
    public void acelerar() { System.out.println("El auto " + marca + " acelera suavemente."); }
}