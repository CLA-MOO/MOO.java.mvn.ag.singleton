# Proyecto (Maven) : Figuras Geométricas (Singleton)

Transforma el proyecto de calculadoras Geométricas para que cada una de ellas se implemente como un objeto Singleton.

El proyecto, por tanto, implementaría las calculadoras haciendo uso de los patrones **Factory Method** y **Singleton**.

## Diagrama de clases
[Editor en línea](https://mermaid.live/)
```mermaid
---
title: Clase
---
classDiagram
      class Clase
      Clase: -x
      Clase: -y
      Clase: +op1()
      Clase: +op2()
      Clase: +op3()
      Clase: +op4()
```
[Referencia-Mermaid](https://mermaid.js.org/syntax/classDiagram.html)

## Diagrama de clases UML con draw.io
El repositorio está configurado para crear Diagramas de clases UML con ```draw.io```. Para usarlo simplemente agrega un archivo con extensión ```.drawio.png```, das doble clic sobre el mismo y se activará el editor ```draw.io``` incrustado en ```VSCode``` para edición. Asegúrate de agregar las formas UML en el menú de formas del lado izquierdo (opción ```+Más formas```).

## Uso del proyecto con Maven

### Compilar
```
mvn -f app compile
```
### Probar N tests
```
mvn -f app test
```
### Probar 1 test
```
mvn -f app test -Dtest="AppTest#testCircle"
mvn -f app test -Dtest="AppTest#testElipse"
mvn -f app test -Dtest="AppTest#testCuadrado"
mvn -f app test -Dtest="AppTest#testRectangulo"
```
### Ejecutar App
```
java -cp app/target/classes miPrincipal.App
```
### Empacar App
```
mvn -f app package
```
### Limpiar binarios
```
mvn -f app clean
```
## Comandos Git-Cambios y envío a Autograding

### Por cada cambio importante que haga, actualice su historia usando los comandos:
```
git add .
git commit -m "Descripción del cambio"
```
### Envíe sus actualizaciones a GitHub para Autograding con el comando:
```
git push origin main
```
