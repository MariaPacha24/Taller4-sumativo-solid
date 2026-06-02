package clinicaveterinaria.model;
import clinicaveterinaria.interfaces.ITratamiento;
public class CirugiaTratamiento implements ITratamiento   {
    private final double costo;
    private int id;
    private String descripcion;

    public CirugiaTratamiento(int id, String descripcion, double costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    
    public CirugiaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo *1.25 +80;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Ayuno previo y control postoperatorio.";
    }
}