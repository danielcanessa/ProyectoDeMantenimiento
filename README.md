# PSWE03 - Proyecto Final

## Aplicación de patrones de diseño y estrategias de mantenimiento

Este repositorio contiene el material inicial para el proyecto final de PSWE03. El proyecto se divide en dos fases independientes.

## Fase 1 - Aplicación de patrones de diseño

### Objetivo

Refactorizar cinco archivos Java aplicando correctamente el patrón de diseño adecuado en cada caso.

### Correspondencia de ejemplos y patrones

| Archivo inicial | Patrón esperado | Problema principal |
| --- | --- | --- |
| `Example1_IfElseCalculator.java` | Strategy | Selección de operaciones mediante condicionales. |
| `Example2_RepeatedFunctionalityLogger.java` | Decorator | Funcionalidad de registro repetida alrededor de operaciones. |
| `Example3_TightlyCoupledFacade.java` | Facade | Coordinación directa de varios subsistemas de viaje. |
| `Example4_SwitchState.java` | State | Comportamiento condicionado por un estado textual. |
| `Example5_TemplateMethodLike.java` | Template Method | Secuencia fija de pasos para preparar una bebida. |

## Pruebas unitarias de la Fase 1

Los cinco ejemplos tienen pruebas unitarias de caracterización escritas con JUnit 5. Estas pruebas documentan el comportamiento actual antes de aplicar los patrones de diseño.

 Casos cubiertos

| Prueba | Casos documentados |
| --- | --- |
| `Example1_IfElseCalculatorTest` | Suma, resta, multiplicación, división, operación desconocida y operación nula. |
| `Example2_RepeatedFunctionalityLoggerTest` | Mensajes de inicio y finalización de `process` y `validate`. |
| `Example3_TightlyCoupledFacadeTest` | Reserva de vuelo, hotel y automóvil en el orden esperado. |
| `Example4_SwitchStateTest` | Apertura en estado `CLOSED`, cierre en estado `OPEN` y transiciones inválidas. |
| `Example5_TemplateMethodLikeTest` | Ejecución ordenada de los cuatro pasos de `prepare`. |

La suite contiene **12 casos de prueba** en total.

### Ejecutar las pruebas

Desde la carpeta `PatronesDeDiseño`:

```bash
gradle test
```

El resultado esperado es una ejecución exitosa de los 12 casos, sin fallos ni errores.

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
