# ClinicaVeterinaria

Proyecto Java Maven para practicar refactoring con principios SOLID en un taller colaborativo.

El sistema funciona desde el inicio, pero contiene violaciones intencionales de SRP, OCP, LSP, ISP y DIP. La idea es que cada integrante refactorice una zona del código sin romper la ejecución.

## Setup en 5 minutos


Compilar con Maven. Salida esperada:

```text
=== ClinicaVeterinaria funcionando ===
```

## Estructura del proyecto

```text
src/main/java/clinicaveterinaria/
├── Main.java
├── interfaces/
│   ├── IAnimal.java
│   ├── IBaseDatos.java
│   ├── IServicioClinica.java
│   ├── ITratamiento.java
│   └── IVeterinarioService.java
├── model/
│   ├── Mascota.java
│   ├── Veterinario.java
│   ├── Cita.java
│   ├── Tratamiento.java
│   ├── Factura.java
│   └── clases auxiliares para animales y enums
├── repository/
│   ├── BaseDatos.java
│   └── DirectoBaseDatos.java
└── service/
    ├── ReservaService.java
    ├── DiagnosticoService.java
    ├── FacturacionService.java
    ├── ReporteService.java
    └── servicios CRUD y clases con violaciones intencionales
```

## Trabajo del taller

-Ariana Moreira: refactorizar SRP.
Checklist de validación:

| Criterio | Sí/No |
| --- | --- |
| El proyecto compila |No |
| `Veterinario` ya no reserva, diagnostica, factura ni reporta | Si|
| La funcionalidad del `Main` se mantiene |Si |
| Los nombres de servicios son claros |Si |

Preguntas de discusión:

- ¿Cuántas razones para cambiar tenía `Veterinario` antes del refactoring?
Tenia cuatro y eran razones a comabiar porque no estaba conservando solo los datos de veterinario sino que tambien contenia metodos que no le pertenecian como los eran reservar citas y demas metodos, es decir estba haciendo más de una cosa. 
- ¿Qué ganamos al separar modelo y servicios?
Conocer donde estan las clases que son de modelado, es decir, que no conlleven la logica del negocio mientras que en servicios ya contenemos las acciones o implementos que podemos realizar en la clinica veterinaria. En conclusion, saber de manera mas simple donde se encuentra cada cosa y lo que hace
- ¿Qué clase debería cambiar si mañana cambia el formato del reporte?
Con reporte se refiere al modelo? lo que se presenta, si es asi, a futuro solo se cambiaria la clase veterinario ya que tiene en cuanta los datos de el y lo que se presenta, mientras que mis clases pertenecientes a service solo conllevan la logica no deberia haber razon para tocarlas o cambiarlas
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: refactorizar ISP y DIP.