= Lab

____

*_NOTA:_* Al finalizar este laboratorio las búsquedas de clientes aun no estarán programadas. 
____

#### Objetivo: 
Aplicar conceptos de OO

#### Descripción general del proyecto:

Realizar la búsqueda de clientes de acuerdo a diferentes criterios


#### Instrucciones:

El proyecto esta definido con Java 17. Verifique que versión tiene instalada y actualice la configuración en el pom.xml

0.  Configuración de dependencias
   1. Incluya las dependencias de las librerias para la **generación de logs**
   2. Adicione un logger a la clase ApplicationRunner
   3. Adiccione un log al método run de la clase ApplicationRunner. Este log solo notifica que la aplicación ha sido ejecutada exitosamente.
   4. Incluya las dependencias de las librerias para **pruebas**
   5. Cree un caso de pruebas para el método run de la clase ApplicationRunner
   6. Ejecute el caso de prueba y confirme que el mensaje del log se muestra correctamente
   
1. Estructura de datos para clientes con los siguientes atributos
   1. Numero de cedula
   2. Nombres
   3. Apellidos
   4. Fecha de nacimiento
   5. Direccion
   6. Cupo maximo

3. Cree excepciones para los siguientes eventos 
   1. no se encontraron clientes que correspondan a nombres y apellidos
   2. no se encontraron clientes con cupos máximos al valor ingresado 
   3. no se encontró al cliente identificado con la cédula indicada 
   
4. Interfaz para el repositorio de clientes con los metodos para
   1. buscar clientes por nombres y apellidos
   2. buscar clientes con cupo maximo mayor o igual a un valor ingresado
   3. buscar al cliente segun el numero de identificación 


