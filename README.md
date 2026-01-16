# Sistema de Gestión de Ventas (CRUD en Java)

Este proyecto es una aplicación de escritorio desarrollada en **Java** que implementa un sistema completo de gestión de ventas. Utiliza el patrón de arquitectura **MVC (Modelo-Vista-Controlador)** para organizar el código y **MySQL** como base de datos relacional.

El sistema permite realizar operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) sobre las entidades principales del negocio: Clientes, Productos y Proveedores.

## 📋 Características

- **Gestión de Clientes:** Registro, consulta, modificación y eliminación de datos de clientes.
- **Gestión de Productos:** Administración del inventario de productos.
- **Gestión de Proveedores:** Mantenimiento de la información de proveedores.
- **Arquitectura MVC:** Separación clara entre la lógica de negocio (Modelo), la interfaz de usuario (Vista) y la gestión de eventos (Controlador).
- **Interfaz Gráfica:** Desarrollada con **Java Swing** para una experiencia de usuario amigable.
- **Conexión a Base de Datos:** Integración con MySQL mediante JDBC.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 8 o superior).
- **Base de Datos:** MySQL.
- **Interfaz Gráfica:** Java Swing / AWT.
- **Driver JDBC:** MySQL Connector/J (versión 9.0.0 incluida).
- **Entorno de Desarrollo (IDE):** Compatible con NetBeans, IntelliJ IDEA, Eclipse, etc.

## 📂 Estructura del Proyecto

El código fuente se encuentra organizado en el directorio `src/` siguiendo el patrón MVC:

- **`Modelo/`**: Contiene las clases que representan las entidades (`Clientes`, `Producto`, `Proveedores`), la lógica de acceso a datos (`ConsultasClientes`, `ConsultasProducto`, etc.) y la clase `Conexion`.
- **`Vista/`**: Contiene los formularios y ventanas de la aplicación (`frmClientes`, `frmProducto`, `Menu`, etc.).
- **`Controlador/`**: Contiene las clases que actúan como intermediarias entre la Vista y el Modelo (`ControlClientes`, `ControlMenu`, etc.).
- **`mainCRUD/`**: Contiene la clase principal `mainCRUD` que inicia la aplicación.
- **`Recursos/`**: Imágenes e iconos utilizados en la interfaz gráfica.

## 🚀 Instalación y Configuración

Sigue estos pasos para ejecutar el proyecto en tu entorno local:

### 1. Configurar la Base de Datos

1. Asegúrate de tener **MySQL Server** instalado y ejecutándose.
2. Abre tu gestor de base de datos favorito (phpMyAdmin, MySQL Workbench, DBeaver, etc.).
3. Ejecuta el script SQL proporcionado en el archivo:
   `BD_GestionVentas.sql`
   _Este script creará la base de datos `GESTION_VENTAS` y las tablas necesarias._

### 2. Configurar la Conexión en Java

1. Abre el proyecto en tu IDE.
2. Navega al archivo `src/Modelo/Conexion.java`.
3. Verifica y modifica las credenciales de conexión si es necesario (usuario, contraseña y puerto):

```java
// Ejemplo de lo que podrías encontrar/editar
this.url = "jdbc:mysql://localhost:3306/GESTION_VENTAS";
this.user = "root"; // Tu usuario de MySQL
this.password = ""; // Tu contraseña de MySQL

```

### 3. Agregar Librerías

Asegúrate de que la librería `mysql-connector-j-9.0.0.jar` (ubicada en la carpeta del proyecto) esté agregada al **Classpath** o a las **Librerías** de tu proyecto en el IDE.

### 4. Ejecutar la Aplicación

Ejecuta el archivo principal:

- `src/mainCRUD/mainCRUD.java`

## 📸 Uso

Una vez iniciada la aplicación, verás un **Menú Principal** desde el cual podrás navegar a los diferentes módulos:

- Selecciona **Clientes** para gestionar la cartera de compradores.
- Selecciona **Productos** para agregar o editar ítems del inventario.
- Selecciona **Proveedores** para administrar la cadena de suministro.

En cada formulario, utiliza los botones **Guardar**, **Modificar**, **Eliminar**, **Buscar** y **Limpiar** para interactuar con los datos.

## ✒️ Autores

- **urjos** - _Trabajo Inicial / Desarrollo_

---

_Este proyecto fue desarrollado con fines educativos para demostrar la implementación de sistemas CRUD en Java con conexión a bases de datos._
