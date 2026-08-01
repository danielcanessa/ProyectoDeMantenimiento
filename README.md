# PSWE03 - Proyecto Final

## Aplicación de patrones de diseño y estrategias de mantenimiento

Este repositorio contiene el material inicial para el proyecto final de PSWE03. El proyecto se divide en dos fases independientes.

## Fase 1 - Aplicación de patrones de diseño

### Objetivo

Refactorizar cinco archivos Java aplicando correctamente el patrón de diseño adecuado en cada caso.

### Correspondencia de código y patrones

| Archivo inicial | Patrón seleccionado | Problema principal | Estado o mejora lograda |
| --- | --- | --- | --- |
| `Example1_IfElseCalculator.java` | Strategy | Selección de operaciones mediante condicionales. | Aplicado: cada operación está encapsulada en una estrategia y las entradas inválidas producen una excepción explícita. |
| `Example2_RepeatedFunctionalityLogger.java` | Decorator | Funcionalidad de registro repetida alrededor de operaciones. | Aplicado: el logging se agrega por composición sin mezclarlo con la lógica principal del servicio. |
| `Example3_TightlyCoupledFacade.java` | Facade | Coordinación directa de varios subsistemas de viaje. | Aplicado: una fachada ofrece una operación única y oculta la coordinación de las reservas. |
| `Example4_SwitchState.java` | State | Comportamiento condicionado por un estado textual. | Pendiente de refactorización. |
| `Example5_TemplateMethodLike.java` | Template Method | Secuencia fija de pasos para preparar una bebida. | Pendiente de refactorización. |

### Ejemplo 1 - Strategy

La calculadora delega cada operación en una implementación de `OperationStrategy`. El registro de estrategias reemplaza la cadena de condicionales y permite que cada algoritmo pueda cambiar y probarse de forma independiente.

Las operaciones disponibles mantienen sus identificadores originales: `sum`, `sub`, `mul` y `div`.

Siguiendo el principio Boy Scout (dejar el código un poco mejor de como se encontró), también se fortaleció el manejo de errores. Cuando el identificador de una operación es desconocido o nulo, `Calculator` lanza `IllegalArgumentException` en vez de devolver `0`. De esta manera, una entrada inválida no puede confundirse con un resultado legítimo y el problema se comunica inmediatamente al código que utiliza la calculadora.

### Ejemplo 2 - Decorator

`BasicService` contiene la lógica principal de `process` y `validate`. `LoggingServiceDecorator` implementa el mismo contrato `Service`, envuelve otro servicio y agrega los mensajes de inicio y finalización antes y después de delegar cada operación.

La composición `new LoggingServiceDecorator(new BasicService())` permite activar el logging sin modificar `BasicService`. Además, el método `executeWithLogging` centraliza el comportamiento repetido y deja abierta la posibilidad de combinar el servicio con otros decoradores.

### Ejemplo 3 - Facade

`TravelSystem` actúa como fachada y conserva `book()` como una entrada única para reservar el vuelo, el hotel y el automóvil. El cliente no necesita conocer los subsistemas ni el orden en que deben ejecutarse; esa coordinación queda encapsulada en la fachada.

El constructor sin argumentos conserva la API original `new TravelSystem().book()`. Un segundo constructor permite recibir los subsistemas desde fuera, lo que reduce el acoplamiento y facilita verificar la coordinación de manera aislada sin obligar a modificar las referencias existentes.

## Pruebas unitarias de la Fase 1

Los cinco ejemplos tienen pruebas unitarias escritas con JUnit 5. Estas pruebas documentan el comportamiento esperado y protegen cada refactorización contra regresiones.

### Casos cubiertos

| Prueba | Casos documentados |
| --- | --- |
| `Example1_IfElseCalculatorTest` | Suma, resta, multiplicación, división y rechazo mediante `IllegalArgumentException` de operaciones desconocidas o nulas. |
| `Example2_RepeatedFunctionalityLoggerTest` | Delegación al servicio envuelto y mensajes de inicio y finalización de `process` y `validate`. |
| `Example3_TightlyCoupledFacadeTest` | Compatibilidad de la API original y delegación de la fachada a vuelo, hotel y automóvil en el orden esperado. |
| `Example4_SwitchStateTest` | Apertura en estado `CLOSED`, cierre en estado `OPEN` y transiciones inválidas. |
| `Example5_TemplateMethodLikeTest` | Ejecución ordenada de los cuatro pasos de `prepare`. |

La suite contiene **13 casos de prueba** en total.

### Ejecutar las pruebas

Desde la carpeta `PatronesDeDiseño`:

```bash
gradle test
```

El resultado esperado es una ejecución exitosa de los 13 casos, sin fallos ni errores.

## Fase 2 - Estrategias de mantenimiento de software

### Objetivo

Analizar el MiniCRUD desde el punto de vista de la mantenibilidad y proponer una estrategia de mantenimiento basada en los conceptos aprendidos.

### Actividades requeridas

1. Analizar el código existente y diagnosticar sus problemas de mantenibilidad.
2. Clasificar los problemas según el tipo de mantenimiento involucrado:
   - Correctivo.
   - Adaptativo.
   - Perfectivo.
   - Preventivo.
   - Evolutivo.
3. Elaborar un plan de mantenimiento dividido en tres fases, indicando qué cambios se realizarían, cuándo y por qué.
4. Proponer al menos tres métricas de mantenibilidad, por ejemplo complejidad ciclomática, deuda técnica y MTTR, y explicar cómo mejorarían.

## Referencia

Las instrucciones completas del proyecto se encuentran en [PSWE03-Proyecto-Final-Primero.pdf](PSWE03-Proyecto-Final-Primero.pdf).
