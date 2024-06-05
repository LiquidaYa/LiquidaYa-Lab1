Documentación del Proyecto

1. Descripción del Proyecto
Nombre del Proyecto: LiquidaYa

Propósito:
La aplicación de escritorio "LiquidaYa" está diseñada para facilitar a los conductores de vehículos de transporte de mercancías el registro y la liquidación de los gastos generados en cada viaje. Esta herramienta digitaliza el proceso tradicionalmente llevado a cabo en papel, simplificando la presentación de los gastos a las empresas contratantes.

Problema que Resuelve:
El proceso manual de registro de gastos es propenso a errores, pérdidas de información y dificultad para la presentación y verificación de los datos. La aplicación proporciona una solución digital, permitiendo un registro más preciso, organizado y fácilmente accesible de los gastos, lo que mejora la eficiencia y la transparencia en el proceso de liquidación.

Público Objetivo:
El público objetivo de esta aplicación son los conductores y administradores de empresas de transporte de mercancías, incluyendo camiones, tractomulas y otros vehículos de carga.

2. Herramientas utilizadas
   
Lenguajes de Programación:
Frontend: HTML, CSS, JavaScript
Backend: Java

IDE utilizado:
Visual Studio Code

Dependencias y Librerías:
JUnit:
junit.jupiter
mockito-junit-jupiter
junit-jupiter-engine
Log4j:
log4j-api
log4j-core
Spring Boot:
spring-boot-starter-web

Control de Versiones y Repositorio:
GitHub: El proyecto está alojado en GitHub para el control de versiones y la colaboración.

3. Instalación y Configuración
Requisitos Previos:
Java Development Kit (JDK) 8 o superior
Node.js (para el manejo de dependencias del frontend)
Git (para clonar el repositorio)
Maven (para manejar las dependencias de Java)
Visual Studio Code (o cualquier IDE de tu preferencia)

Pasos de Instalación:
1.	Clonar el Repositorio
2.	Instalar Dependencias requeridas
3.	Configurar el Entorno:
Asegúrate de tener configuradas las variables de entorno necesarias para conectar la aplicación con la base de datos y otros servicios.
4.	Ejecutar la Aplicación

4. Diagrama de Clases:
El diagrama de clases del proyecto se presenta a continuación:
![image](https://github.com/LiquidaYa/LiquidaYa-Lab1/assets/159569102/966d1110-0298-489d-804b-e106712a458b)
Descripción de las clases:

Vehicle
Atributos:
          +String plate
          +String responsible
          +String company
          +String mark

VehicleRepositoryImpl
Métodos:
          + vehicles: List<Vehicle> 
          + find(String plate): List<Vehicle>
          + getAll(): List<Vehicle> 
          + add(Vehicle vehicle): Vehicle
  
VehicleRepository
Métodos:
          + find(String plate): List<Vehicle>
          + getAll(): List<Vehicle> 
          + add(Vehicle vehicle): Vehicle
  
LiquidaYaService
Métodos: 
	        + getAll() throws ListVehicleException: List<Vehicle> 
          + find(String plate) throws PlateException: List<Vehicle>
          + add(Vehicle vehicle): Vehicle

LiquidaYaServiceImpl
Métodos: 
	        + vehicleRepository: VehicleRepository
        	+ getAll() throws ListVehicleException: List<Vehicle>
        	+ find(String plate) throws PlateException: List<Vehicle>
        	+ add(Vehicle vehicle): Vehicle
         
Exception
Subclases:

VehicleException 
          + VehiclesException(String message)

ListaVehiculoExeption
          + ListVehicleException()

PlateException
          + PlateException(String placa)

Este diagrama y la descripción de las clases proporcionan una visión clara de la estructura y las interacciones principales en la aplicación.

5. Diagrama de despliegue
   ![image](https://github.com/LiquidaYa/LiquidaYa-Lab1/assets/159569102/48ee4010-eb1e-4809-8e93-fe668b6377a5)

6. Generación de ingresos
El modelo de generación de ingresos para LiquidaYa se basa en el licenciamiento del software. Este modelo permite al propietario del proyecto obtener ingresos a través de la venta de licencias para el uso del software.

7. Licencia
LiquidaYa está bajo un licenciamiento de propietario. Esto significa que todos los derechos sobre el código fuente y la documentación asociada están reservados por el autor o la organización propietaria. Cualquier uso, distribución, o modificación del código está estrictamente prohibido sin el permiso explícito del propietario.

8. Tareas y Responsabilidades
Brayan Florez: encargado del frontend
Ángel Simón Yepes: código backend
Santiago Ávila Mazo: documentación del proyecto






