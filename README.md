📘 Conversor de Monedas — Proyecto Java

Este proyecto es un conversor de monedas en Java, desarrollado como parte del programa ONE.
El objetivo es aplicar conceptos de consumo de APIs, manejo de datos, estructuras de control, validación de entradas y diseño de una interfaz textual interactiva.

El conversor utiliza la API de ExchangeRate-API para obtener tasas de cambio actualizadas y permite al usuario realizar conversiones entre diversas monedas de forma sencilla y segura.

🧩 Funcionalidades Principales
🔹 1. Menú interactivo con loop

El usuario puede elegir entre varias opciones de conversión, ver el historial o salir del programa.
El menú se mantiene activo hasta que el usuario seleccione la opción Salir.

🔹 2. Consumo de API en tiempo real

El sistema obtiene las tasas de cambio desde:

https://v6.exchangerate-api.com/


Esto permite trabajar con valores actualizados para las principales monedas.

🔹 3. Conversión entre múltiples monedas

Incluye las siguientes operaciones:

USD → CLP

CLP → USD

USD → EUR

EUR → USD

USD → ARS

USD → BRL

GBP → USD

Cada operación utiliza las tasas entregadas por la API.

🔹 4. Validación de entrada numérica

Antes de procesar el monto, el sistema valida que sea un número válido.
Si el usuario escribe una letra u otro valor inválido, el programa muestra un mensaje y vuelve a pedir el dato sin detenerse.

🔹 5. Historial de conversiones

El programa guarda cada conversión realizada y permite al usuario consultar el historial mediante la opción 8 del menú.

Incluye:

Monto ingresado

Resultado de la conversión

Código de la opción usada

Si no hay historial, se informa al usuario.

🔹 6. Manejo de errores

El programa controla:

Errores en el consumo de la API

Entradas no válidas

Opción incorrecta del menú

Esto garantiza una experiencia segura y estable.

📌 Tecnologías Utilizadas

Java 17

HttpClient / HttpRequest (para consumo de API)

Gson (parseo JSON)

ExchangeRate-API (fuente de tasas de conversión)

Scanner (entrada desde consola)

▶️ Ejecución

Clona el repositorio.

Configura tu API Key en la clase Main.

Ejecuta el proyecto desde tu IDE (IntelliJ recomendado).

Selecciona las opciones del menú según la operación deseada.

📚 Objetivos de aprendizaje logrados

Consumo de APIs REST desde Java

Manejo de JSON mediante Gson

Validación de datos del usuario

Estructuras de control (while, switch, manejo de excepciones)

Diseño de menú interactivo en consola

Registro y lectura de historial

Buenas prácticas de legibilidad y estructura de código
