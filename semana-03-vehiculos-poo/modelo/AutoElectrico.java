package modelo;
public class AutoElectrico extends Auto implements Electrico {
    private int bateria;
    public AutoElectrico(String marca, String modelo, int anio, int bateria) {
        super(marca, modelo, anio);
        this.bateria = bateria;
    }
    @Override public void cargarBateria() { this.bateria = 100; }
    @Override public int getNivelBateria() { return bateria; }
    @Override public boolean necesitaCarga() { return bateria < 20; }
    @Override public String toString() { return super.toString() + " | Batería: " + bateria + "%"; }
}