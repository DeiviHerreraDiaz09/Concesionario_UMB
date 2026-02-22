# 🚗 Sistema de Gestión de Concesionario de Vehículos

## 📚 Proyecto Académico
Este es un proyecto desarrollado para la universidad como parte de la asignatura de Programación Orientada a Objetos (POO) en Java. El objetivo es aplicar conceptos fundamentales de diseño de clases, atributos, métodos y capas de servicio.

---

## 📋 Descripción del Proyecto

El sistema permite gestionar un concesionario de vehículos con la capacidad de:
- **Registrar vehículos** clasificados por tipo (autos, camionetas, motocicletas)
- **Almacenar datos de ventas** realizadas con información del comprador
- **Consultar ventas por tipo** de vehículo

---

## ✅ Requisitos Cumplidos

### 1. Clasificación de Vehículos
Los vehículos se clasifican en tres categorías:
- ✓ Autos
- ✓ Camionetas
- ✓ Motocicletas

### 2. Atributos de Vehículos
Cada vehículo contiene:
- `code` (String) - Código único identificador
- `brand` (String) - Marca del vehículo
- `type` (VehicleType) - Tipo de clasificación
- `model` (String) - Modelo/año del vehículo
- `km` (Float) - Kilometraje

### 3. Registro de Ventas
Cada venta registra:
- `amount` (float) - Monto de la transacción
- `vehicleCode` (String) - Código del vehículo vendido
- `name` (String) - Nombre del comprador
- `surname` (String) - Apellido del comprador
- `dni` (String) - Documento de identidad del comprador

---

## 📁 Estructura del Proyecto

```
Concesionario/
├── src/
│   ├── main/
│   │   └── Main.java                    # Punto de entrada del programa
│   ├── model/
│   │   ├── Vehicle.java                 # Clase que representa un vehículo
│   │   ├── VehicleType.java            # Enum con tipos de vehículos
│   │   ├── Sale.java                    # Clase que representa una venta
│   │   └── Concesionario.java          # Clase que gestiona el concesionario
│   └── service/
│       ├── ConcesionarioService.java   # Lógica de registro de vehículos y ventas
│       ├── SaleService.java             # Lógica para consultar ventas por tipo
│       └── MainService.java             # Lógica de presentación en consola
├── out/                                 # Directorio de compilación
└── README.md                            # Este archivo
```

---

## 🏗️ Arquitectura en Capas

El proyecto utiliza **arquitectura de tres capas**:

### 📦 Capa de Modelo (`model/`)
Define las entidades del negocio:
- `Vehicle` - Datos del vehículo
- `Sale` - Datos de la venta
- `Concesionario` - Contenedor de vehículos y ventas
- `VehicleType` - Clasificación de tipos

### ⚙️ Capa de Servicio (`service/`)
Contiene la lógica de negocio:
- `ConcesionarioService` - Validaciones y registro de vehículos/ventas
- `SaleService` - Consultas y filtrado de ventas
- `MainService` - Presentación de datos en consola

### 🎯 Capa de Presentación (`main/`)
- `Main` - Interfaz de usuario que coordina el flujo

---

## 🚀 Cómo Compilar y Ejecutar

### Requisitos
- JDK 8 o superior instalado
- Windows, Linux o macOS

### Pasos

1. **Abre una terminal** en la carpeta del proyecto:
```bash
cd c:\Users\herre\Desktop\Concesionario
```

2. **Compila el proyecto**:
```bash
javac -d out src/main/Main.java src/model/*.java src/service/*.java
```

3. **Ejecuta el programa**:
```bash
java -cp out main.Main
```

---

## 💻 Ejemplo de Ejecución

```
***********************************************
***********  Concesionario: Chevrolet  **********
***********************************************
Dirección: CL 170 # 69 - 80 BOGOTA
Teléfono: 555-1234
Vehículos registrados:
***********************************************
* Codigo * Marca * Tipo * Modelo * Kilometraje
* A001 * Chevrolet * AUTO * Onix * 15000.0
* C001 * Chevrolet * CAMIONETA * S10 * 30000.0
* M001 * Chevrolet * MOTOCICLETA * Cruze * 20000.0
* A002 * Chevrolet * AUTO * Spark * 10000.0
* C002 * Chevrolet * MOTOCICLETA * Trailblazer * 40000.0
***********************************************
Digite un número para ver el registro de las ventas realizadas: 
1. Para autos
2. Para camionetas
3. Para motocicletas

Ventas de AUTO:
  - Monto: $2500000.0 | Comprador: Juan Perez (Doc: 12345678)
  - Monto: $4000000.0 | Comprador: Maria Garcia (Doc: 87654321)
```

---

## 📝 Explicación de Tipos de Datos

### En la clase `Vehicle`

| Atributo | Tipo | Razón |
|----------|------|-------|
| `id` | int | ID único secuencial |
| `code` | String | Código alfanumérico (ej: "A001") |
| `brand` | String | Nombre de marca (texto) |
| `model` | String | Año/modelo del vehículo (texto) |
| `km` | Float | Kilómetros (permite decimales) |
| `type` | VehicleType | Enum restringido a 3 opciones |

### En la clase `Sale`

| Atributo | Tipo | Razón |
|----------|------|-------|
| `id` | int | ID único de la venta |
| `amount` | float | Monto en moneda (decimales) |
| `vehicleCode` | String | Referencia al código del vehículo |
| `name` | String | Nombre del comprador |
| `surname` | String | Apellido del comprador |
| `dni` | String | Documento de identidad |

---

## 🎓 Conceptos POO Aplicados

- ✅ **Encapsulación**: Atributos privados con getters/setters
- ✅ **Herencia**: No aplicada (no necesaria en este proyecto)
- ✅ **Polimorfismo**: Métodos sobrecargados en servicios
- ✅ **Abstracción**: Separación de capas (modelo, servicio, presentación)
- ✅ **Enum**: Uso de VehicleType para tipificación segura
- ✅ **Collections**: ArrayList para almacenar vehículos y ventas
- ✅ **Validación**: Excepciones para datos inválidos

---

## ✍️ Autor
Proyecto desarrollado como trabajo académico para la universidad.

**Fecha**: Febrero 2026

---

## 📧 Notas Importantes

- El programa acepta entrada por consola (Scanner) para seleccionar el tipo de vehículo
- Las ventas se validan antes de registrarse (debe existir el vehículo)
- Los datos se almacenan en memoria (se pierden al cerrar el programa)

---

**¡Que disfrutes el proyecto! 🎉**
