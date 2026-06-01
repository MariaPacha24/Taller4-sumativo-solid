package clinicaveterinaria.service;

import clinicaveterinaria.repository.BaseDatos;


public class GestorReportesClinica {
    private final IBaseDatos baseDatos = new IBaseDatos();

    public void imprimirResumenOperaciones() {
        System.out.println("Resumen interno: " + baseDatos.getAuditoria());
    }
}
