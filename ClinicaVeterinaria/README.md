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

- Integrante 1: refactorizar SRP.
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: refactorizar ISP y DIP.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.


## REFACTORIZACION OSP INTEGRANTE 2
Checklist de validación:


| Criterio | Sí/No |
| --- | --- |
| El proyecto compila | NO |
| No hay condicional gigante por tipo en la lógica nueva | NO |
| Cada tratamiento conoce su propio costo e indicaciones | SI |
| Agregar un nuevo tratamiento requiere crear una clase, no editar todas | SI|

- ¿Por qué los condicionales repetidos hacen más caro el cambio?
Lo que pasa es que al tener toda las condiciones en un solo archivo,lo que provocara es que si se realizara una modificacion lo que provocara es que se compile de nuevo todo el archivo haciendo mas pesado y mas costo los cambios, al tener separados lo que hara es que si se realiza o se agrega un nuevo en este caso tratamiento solo va a modificar lo que realicemos no todo el archivo completo 

- ¿Qué pasaría si agregamos Odontologia como tratamiento?
Lo que pasaria es que se deberia crear su respectiva clase de odontologia, donde en el caso que implementamos OSP podemos agregar una funcionalidad totalemente nueva escribiendo unicamente codigo nuevo. En la cual sin modificar TratamientoServices, ni las otras clases

- ¿Cuándo una interfaz ayuda a extender el sistema?
Al utilizar interfaz lo que nos permite construir un software como si fuera una estructura general, por decir al resto del programa que operaciones estan disponibles pero no le permito como se hace.






