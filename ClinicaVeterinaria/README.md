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

---------------NTEGRANT 3 Maria Jose PACHA ------- 
VIOLACIONES LSP
sE BUSCO que ningun animal implemente acciones que no necesita o realiza , para asi evitar lanzar excepciones innecesearias y que exista una mala implementacion
Esto se realizo quitando los datos innecesarios en la class Animal como la implementacion de IAnimal una interface que englobaba , las accione volar, nadar , caminar. A Estas mismas acciones se crearon interfaces individuales para que asi cada animal pueda implementar la que necesite y asi mismo para futuros animales diferentes a los que ya se tienen 

Preguntas de discusión:

- ¿Por qué lanzar `UnsupportedOperationException` puede ser señal de mal diseño?
 
 Porque UnsupportedOperationException es una excepcion unchecked , es decir el tipo de excepciones que se dan por errores del programador  y se solucionan corrigiendo el codigo se colocan para evitar  un mal funcionamiente o logica en nuestro codigo como en el caso de lo Animales , existian ciertos tipos de animales que no podian implementa ciertas acciones 


- ¿Qué contrato estaba prometiendo `Animal`?
La class animal en globaba todos los tipos de animales implementandoles a todos las acciones de caminar , volar , nadar 
- ¿Cómo cambia el diseño cuando modelamos capacidades en lugar de herencia amplia?

Se evitan problemas y jerarquias rigidas que obligan a implementar accioens innecesarias, se evitan metodos vacios lanzando excepciones  , codigos mas legibles .





Integrante 4 DIP/ISP Barbara-Covena
Preguntas de discusión:
•
¿Qué problema causa una interfaz gigante en equipos grandes?
• Al usar una interfaz con tantos metodos estamos obligando a las clases que la implementan a establecer el contrato de usar todos sus metodos
aunque enrealidad no la necesiten haciendo que lanzen exepciones para manejar estos metodos que no necesita usar, para resolver esto lo que debemos hacer es dividir esa interfaz 
en interfaces mas pequenas con metodos acordes para poder implementar estas interfaces en las clases que necesitan solo de esos metodos.
¿Por qué new DirectoBaseDatos() dificulta cambiar o probar la clase?

• El uso de new DirectoBaseDatos() viola el princiipo DIP por que crea una dependencia directa con una clase concreta en lugar de una abstracion.
Esto aumenta el acoplamiento lo cual dificulta cambiar la implemntacion y complica las pruebas unitarias al impidir sustituir facilmente la dependencia por una implemntacion de prueba.


¿Qué dependencia debería conocer el código de alto nivel: interfaz o clase concreta?
• Segun el rpincipio de inversion de dependencias (DIP) el codigo de alto nivel debe conocer la interfaz (abstraccion), no la clase concreta.

PASOS PARA REFACTORIZAR:
ISP:
Se detecto que la clase recepcion service estaba siendo obligada a hacer uso de los metodos 
actualizar veterianrio 
eliminar veterinario 
metodos de reporte 
metodos de facturacion
y estaba lanzando exepciones para controlarlos, por lo tanto lo que se hizo fue dividir la interfaz principal en pequenas interfaces con sus metodos adecuados. 
IcitaService (metodos relacionados a citas)
IFactura Service (metodos relacionados a facturacion)
IReporteService (metodos relacionados a repotes)
IMascotaService (metodos relacionados a mascotas)
ItratamietnoService (metodos relacionados a los tratamientos)
IVetacService (actualizacion y eliminacion de veterinario)
De esta manera hicimos que Recepcion Service solo implemente las interfaces
IMascotaService,ICitaService
mientras que ServicioClinicaCompleto implementaria 
IMascotaService, ICitaService, IReporteService,IFacturaService,IVetacservice,ITratamientoService

DIP 
En la clase Clinica se detecto que se estaba refiriendo a directobasedatos y a directoveterinario 
y esto rompe el Dip por que estaba haciendo que la clase se refiera a otra clase concreta cuando deberia de referirse a una abstraccion, 
ademas de esto estabamos instanciando con new 
En base a esto notamos que tenemos una interfaz IBaseDatos qu estaba siendo implementada por la clase base de datos la cual estaba siendo herenciada por DirectoBaseDatos, 
Como ya teniamos toda la logica necesaria lo unico que tuvimos que hacer es cambiar el tipo DirectoBaseDatos a IBaseDatos, lo mismo con DirectoVeterinario ya que tambien tenia su interfaz de la que podiamos tomar la abstraccion 
y eliminamos las instancias new como se nos presento en la guia. 
por ultimo lo que hicimos en el main fue cambiar la linea 12 para que tambien se refiera a IbaseDatos





