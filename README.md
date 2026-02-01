# Buscador de Submatrices Booleanas

Este proyecto constituye la **evaluación final** de la asignatura **Introducción a la Programación (IP)** de la carrera **Ingeniería Informática** en la **Universidad de Pinar del Río "Hermanos Saíz Montes de Oca"**.

**Autor:** Pedro L. Sarmiento

## Descripción
El programa permite definir una matriz base y buscar dentro de ella una submatriz específica de forma lógica. Está diseñado para procesar valores booleanos (0 y 1) y localizar coincidencias espaciales dentro de un arreglo bidimensional.

## Funcionalidades
* **Validación de Datos:** Control de entradas para evitar errores por caracteres no numéricos o dimensiones fuera de rango (máximo 30x30).
* **Interfaz Visual:** Uso de la clase `Colors` para mensajes en consola mediante códigos ANSI.
* **Flexibilidad:** El sistema interpreta múltiples tipos de entrada para representar valores booleanos gracias a un parser personalizado.

## Ejecución
Para compilar y correr el proyecto desde la consola (**CMD**), asegúrate de estar dentro de la carpeta donde se encuentran los archivos `.java` y ejecuta el siguiente comando:

```cmd
cls & javac *.java & java Main
