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

## REFACTORIZACION OSP Elkin Salazar
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

---------------INTEGRANTE 3 Maria Jose PACHA ------- 
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





